package com.fluvigal.mob.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fluvigal.connectivity.MariaDBConnector;
import com.fluvigal.mob.EstacionActivity;
import com.fluvigal.mob.R;
import com.fluvigal.mob.RioActivity;
import com.fluvigal.model.Rio;

import java.util.List;

public class RioAdapter extends RecyclerView.Adapter<RioAdapter.RioViewHolder>{
    private List<Rio> rios;

    public RioAdapter(List<Rio> rios){
        this.rios = rios;
    }

    @NonNull
    @Override
    public RioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_rios,viewGroup, false);
        return new RioViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RioViewHolder repositoryViewHolder, int i) {
        Rio rio = rios.get(i);
        repositoryViewHolder.tvRio.setText(rio.getNome());
        repositoryViewHolder.tvEmptyRio.setText(String.valueOf(rio.getIdRio()));
    }

    @Override
    public int getItemCount() {
        return rios.size();
    }

    public void setData(List<Rio> rios){
        this.rios = rios;
        notifyDataSetChanged();
    }


    public class RioViewHolder extends RecyclerView.ViewHolder{
        private TextView tvRio;
        private TextView tvEmptyRio;

        private RioViewHolder(@NonNull View itemView){
            super(itemView);
            tvRio = itemView.findViewById(R.id.tvRio);
            tvEmptyRio = itemView.findViewById(R.id.tvEmptyRio);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), RioActivity.class);
                intent.putExtra("ide",Integer.parseInt(tvEmptyRio.getText().toString()));
                itemView.getContext().startActivity(intent);
            });
        }
    }

}