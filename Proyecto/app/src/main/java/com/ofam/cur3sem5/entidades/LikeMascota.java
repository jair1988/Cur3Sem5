package com.ofam.cur3sem5.entidades;

public class LikeMascota {

    private int idMascota;
    private int voto;

    public LikeMascota(int idMascota, int voto) {
        this.idMascota = idMascota;
        this.voto = voto;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public int getVoto() {
        return voto;
    }
}
