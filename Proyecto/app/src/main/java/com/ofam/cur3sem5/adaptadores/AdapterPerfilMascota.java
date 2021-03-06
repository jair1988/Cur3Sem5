package com.ofam.cur3sem5.adaptadores;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ofam.cur3sem5.R;
import com.ofam.cur3sem5.entidades.Mascota;

import java.util.List;

public class AdapterPerfilMascota extends RecyclerView.Adapter<AdapterPerfilMascota.ViewHolderMascota> {

    private final List<Mascota> mascotas;

    public AdapterPerfilMascota(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public ViewHolderMascota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mascota_mini, parent, false);
        return new ViewHolderMascota(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMascota holder, int position) {
        try {
            Mascota mascota = mascotas.get(position);
            holder.foto.setImageResource(mascota.getFoto());
            holder.votos.setText(String.valueOf(mascota.getCantidadVotos()));
        } catch (Exception e) {
            Log.e("error;", e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    static class ViewHolderMascota extends RecyclerView.ViewHolder {
        private ImageView foto;
        private TextView votos;

        ViewHolderMascota(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.imgFoto);
            votos = itemView.findViewById(R.id.txtVotos);
        }
    }
}
