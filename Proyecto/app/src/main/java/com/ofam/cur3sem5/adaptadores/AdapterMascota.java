package com.ofam.cur3sem5.adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ofam.cur3sem5.DataBase;
import com.ofam.cur3sem5.R;
import com.ofam.cur3sem5.entidades.LikeMascota;
import com.ofam.cur3sem5.entidades.Mascota;

import java.util.List;

public class AdapterMascota extends RecyclerView.Adapter<AdapterMascota.ViewHolderMascota> {

    private final List<Mascota> mascotas;
    private final Context context;
    final DataBase dataBase;

    public AdapterMascota(List<Mascota> mascotas, Context context) {
        this.mascotas = mascotas;
        this.context = context;
        dataBase = new DataBase(context);
    }

    @NonNull
    @Override
    public ViewHolderMascota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mascota, parent, false);
        return new ViewHolderMascota(v);
    }

    @Override
    public void onBindViewHolder(final @NonNull ViewHolderMascota holder, int position) {
        try {
            final Mascota mascota = mascotas.get(position);
            holder.foto.setImageResource(mascota.getFoto());
            holder.nombre.setText(mascota.getNombre());
            holder.votos.setText(String.valueOf(dataBase.readLikes(mascota).getCantidadVotos()));
            holder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataBase.insertLike(new LikeMascota(mascota.getId(), 1));
                    holder.votos.setText(String.valueOf(dataBase.readLikes(mascota).getCantidadVotos()));
                    Toast.makeText(context, "Has votado por este Perro.", Toast.LENGTH_SHORT).show();
                }
            });


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
        private TextView nombre;
        private TextView votos;
        private ImageView imgHuesoBlanco;

        ViewHolderMascota(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.imgFoto);
            nombre = itemView.findViewById(R.id.txtNombre);
            votos = itemView.findViewById(R.id.txtVotos);
            imgHuesoBlanco = itemView.findViewById(R.id.imgHuesoBlanco);
        }
    }
}
