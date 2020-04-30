package com.fluvigal.mob;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fluvigal.connectivity.MariaDBConnector;
import com.fluvigal.mob.adapter.EstacionAdapter;
import com.fluvigal.model.Estacion;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class EstacionsFragment extends Fragment {
    private RecyclerView recyclerView;
    private EstacionAdapter adapter;
    private List<Estacion> estacions;
    private CompositeDisposable compositeDisposable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estacions, container, false);
        setUpView(view);
        setUpRX();
        // Inflate the layout for this fragment
        return view;

    }

    private List<Estacion> getEstacions() throws Exception{
        MariaDBConnector.openConnection();
        List<Estacion> list = MariaDBConnector.estacionsAsList();
        MariaDBConnector.closeConnection();
        return list;
    }

    private void setUpRX() {
        compositeDisposable.add(Single.create(emitter -> emitter.onSuccess(getEstacions()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        e -> {adapter.setData((List<Estacion>) e);
                            ((FluvigalMain)getActivity()).pb.setVisibility(View.GONE);},
                        error -> error.printStackTrace()
                        ));
    }

    private void setUpView(View view){
        compositeDisposable = new CompositeDisposable();
        estacions = new ArrayList<>();
        adapter = new EstacionAdapter(estacions);
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager lim = new LinearLayoutManager(getContext());
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
