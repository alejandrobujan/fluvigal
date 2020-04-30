package com.fluvigal.mob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.fluvigal.connectivity.MariaDBConnector;
import com.fluvigal.mob.adapter.EstacionAdapter;
import com.fluvigal.model.Estacion;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RioActivity extends AppCompatActivity {
    public ProgressBar pbRio;
    private int ide;
    private RecyclerView recyclerView;
    private EstacionAdapter adapter;
    private List<Estacion> estacions;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rio);
        ide = getIntent().getExtras().getInt("ide");
        pbRio = findViewById(R.id.pbRio);
        setUpView();
        setUpRX();
    }

    private List<Estacion> getEstacionsFiltradas() throws Exception{
        MariaDBConnector.openConnection();
        List<Estacion> list = MariaDBConnector.estacionsAsList(MariaDBConnector.rioQuery(ide));
        MariaDBConnector.closeConnection();
        return list;
    }

    private void setUpRX() {
        compositeDisposable.add(Single.create(emitter -> emitter.onSuccess(getEstacionsFiltradas()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        e -> {adapter.setData((List<Estacion>) e);
                        pbRio.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);},
                        error -> error.printStackTrace()
                ));
    }

    private void setUpView(){
        compositeDisposable = new CompositeDisposable();
        estacions = new ArrayList<>();
        adapter = new EstacionAdapter(estacions);
        recyclerView = findViewById(R.id.recyclerViewRioActivity);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
