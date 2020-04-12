package com.ofam.cur3sem5.entidades;

public class Mascota {

    private int id;
    private String nombre;
    private int foto;
    private boolean voto;
    private int cantidadVotos;

    public Mascota(int id, String nombre, int foto, boolean voto) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.voto = voto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFoto() {
        return foto;
    }

    public boolean isVoto() {
        return voto;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }
}
