package com.ofam.cur3sem5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ofam.cur3sem5.adaptadores.AdapterMascota;
import com.ofam.cur3sem5.entidades.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment {
    private RecyclerView rvMascota;

    public MascotasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mascotas, container, false);
        rvMascota = view.findViewById(R.id.rvMascota);
        loadRecyclerView();
        return view;
    }

    //load Recyclerview
    private void loadRecyclerView() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota(1, "Perrito 1", R.drawable.perro1, false));
        mascotas.add(new Mascota(2, "Perrito 2", R.drawable.perro2, false));
        mascotas.add(new Mascota(3, "Perrito 3", R.drawable.perro3, false));
        mascotas.add(new Mascota(4, "Perrito 4", R.drawable.perro4, false));
        mascotas.add(new Mascota(5, "Perrito 5", R.drawable.perro5, false));
        mascotas.add(new Mascota(6, "Perrito 6", R.drawable.perro6, false));
        mascotas.add(new Mascota(7, "Perrito 7", R.drawable.perro7, false));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascota.setLayoutManager(linearLayoutManager);
        rvMascota.setAdapter(new AdapterMascota(mascotas, getActivity()));
    }
}
