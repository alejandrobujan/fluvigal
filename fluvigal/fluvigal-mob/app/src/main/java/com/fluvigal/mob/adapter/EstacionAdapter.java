package com.fluvigal.mob.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fluvigal.mob.EstacionActivity;
import com.fluvigal.mob.FluvigalMain;
import com.fluvigal.mob.R;
import com.fluvigal.model.Estacion;

import java.util.List;

public class EstacionAdapter extends RecyclerView.Adapter<EstacionAdapter.EstacionViewHolder>{

    private List<Estacion> estacions;

    public EstacionAdapter(List<Estacion> estacions){
        this.estacions = estacions;
    }

    @NonNull
    @Override
    public EstacionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_estacions,viewGroup, false);
        return new EstacionViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull EstacionViewHolder repositoryViewHolder, int i) {
        Estacion estacion = estacions.get(i);
        repositoryViewHolder.tvEstacion.setText(estacion.getNome());
        repositoryViewHolder.tvConcello.setText(estacion.getConcello());
        repositoryViewHolder.tvRioEstacion.setText(estacion.getRio().getNome());
        repositoryViewHolder.tvEmptyRioEstacion.setText(String.valueOf(estacion.getIdEstacion()));
    }

    @Override
    public int getItemCount() {
        return estacions.size();
    }

    public void setData(List<Estacion> estacions){
        this.estacions = estacions;
        notifyDataSetChanged();
    }


    public class EstacionViewHolder extends RecyclerView.ViewHolder{
        private TextView tvEstacion;
        private TextView tvConcello;
        private TextView tvRioEstacion;
        private TextView tvEmptyRioEstacion;

        private EstacionViewHolder(@NonNull View itemView){
            super(itemView);
            tvEstacion = itemView.findViewById(R.id.tvEstacion);
            tvConcello = itemView.findViewById(R.id.tvConcello);
            tvRioEstacion = itemView.findViewById(R.id.tvRioEstacion);
            tvEmptyRioEstacion = itemView.findViewById(R.id.tvEmptyRioEstacion);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), EstacionActivity.class);
                intent.putExtra("ide",Integer.parseInt(tvEmptyRioEstacion.getText().toString()));
                itemView.getContext().startActivity(intent);
            });
        }
    }

}
