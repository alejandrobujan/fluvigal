package com.fluvigal.mob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fluvigal.connectivity.MariaDBConnector;
import com.fluvigal.model.Estacion;
import com.fluvigal.model.Medicion;
import com.fluvigal.util.Formatter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class EstacionActivity extends AppCompatActivity {
    public ProgressBar pbEstacion;
    public LinearLayout linearLayoutEstacion;
    private int ide;
    private CompositeDisposable compositeDisposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacion);
        ide = getIntent().getExtras().getInt("ide");
        TextView tvIdeEstacion = findViewById(R.id.tvIdeEstacion);
        tvIdeEstacion.setText(tvIdeEstacion.getText().toString()+ide);
        compositeDisposable = new CompositeDisposable();
        linearLayoutEstacion = findViewById(R.id.linearLayoutEstacion);
        linearLayoutEstacion.setVisibility(View.INVISIBLE);
        pbEstacion = findViewById(R.id.pbEstacion);
        setUpRX();
    }

    private void setUpRX() {
        compositeDisposable.add(Single.create(emitter -> emitter.onSuccess(getEstacion()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        e -> {
                            TextView tvEstacionNome = findViewById(R.id.tvEstacionNome);
                            tvEstacionNome.setText(tvEstacionNome.getText()+((Estacion) e).getNome());
                            TextView tvEstacionProvincia = findViewById(R.id.tvEstacionProvincia);
                            tvEstacionProvincia.setText(tvEstacionProvincia.getText()+((Estacion) e).getProvincia().getNome());
                            TextView tvEstacionConcello = findViewById(R.id.tvEstacionConcello);
                            tvEstacionConcello.setText(tvEstacionConcello.getText()+((Estacion) e).getConcello());
                            Button btnUbicacion = findViewById(R.id.btnUbicacion);
                            btnUbicacion.setOnClickListener(v->{
                                Intent intent = new Intent(EstacionActivity.this,MapsActivity.class);
                                intent.putExtra("lat",((Estacion)e).getLatitude());
                                intent.putExtra("lon",((Estacion)e).getLonxitude());
                                intent.putExtra("nome",((Estacion)e).getNome());
                                startActivity(intent);
                            });
                        },
                        error -> error.printStackTrace()
                ));
        compositeDisposable.add(Single.create(emitter -> emitter.onSuccess(getMedicions()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        e->{
                            ListView lvEstacionMedicions = findViewById(R.id.lvEstacionMedicions);
                            ArrayList<String> medicions = new ArrayList<>();
                            for(Medicion m: (List<Medicion>)e){
                                medicions.add(m.getTipoMedicion().getNome()+": "+m.getValor()+" "+m.getUnidade());
                            }
                            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, medicions);
                            lvEstacionMedicions.setAdapter(adaptador);
                            TextView tvActualizadoA = findViewById(R.id.tvActualizadoA);
                            tvActualizadoA.setText(tvActualizadoA.getText().toString()+ Formatter.formatDate(((((List<Medicion>) e).get(0).getData()))));
                            pbEstacion.setVisibility(View.GONE);
                            linearLayoutEstacion.setVisibility(View.VISIBLE);
                        }
                )
        );
    }

    private Estacion getEstacion() throws Exception{
        MariaDBConnector.openConnection();
        Estacion estacion = MariaDBConnector.estacionQuery(ide);
        MariaDBConnector.closeConnection();
        return estacion;
    }

    private List<Medicion> getMedicions() throws Exception{
        MariaDBConnector.openConnection();
        List<Medicion> medicions = MariaDBConnector.medicionsAsList(ide);
        MariaDBConnector.closeConnection();
        return medicions;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
