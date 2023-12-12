package com.curso.android.app.practica.parcial_1_am_acn4bv_colmann_cruz;

public class Juegos {
    private String titulo;
    private int img;

    public Juegos (String titulo, int img) {
        this.titulo = titulo;
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getImg() {
        return img;
    }
}