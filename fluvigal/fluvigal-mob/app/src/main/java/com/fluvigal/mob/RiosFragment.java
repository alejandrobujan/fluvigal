package com.fluvigal.mob;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fluvigal.connectivity.MariaDBConnector;
import com.fluvigal.mob.adapter.RioAdapter;
import com.fluvigal.model.Estacion;
import com.fluvigal.model.Rio;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class RiosFragment extends Fragment {
    private RecyclerView recyclerView;
    private RioAdapter adapter;
    private List<Rio> rios;
    private CompositeDisposable compositeDisposable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rios, container, false);
        setUpView(view);
        setUpRX();
        // Inflate the layout for this fragment
        return view;

    }

    private List<Rio> getRios() throws Exception{
        MariaDBConnector.openConnection();
        List<Rio> list = MariaDBConnector.riosAsList();
        MariaDBConnector.closeConnection();
        return list;
    }

    private void setUpRX() {
        compositeDisposable.add(Single.create(emitter -> emitter.onSuccess(getRios()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        e -> adapter.setData((List<Rio>) e),
                        error -> error.printStackTrace()
                ));
    }

    private void setUpView(View view){
        compositeDisposable = new CompositeDisposable();
        rios = new ArrayList<>();
        adapter = new RioAdapter(rios);
        recyclerView = view.findViewById(R.id.recyclerViewRio);
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
