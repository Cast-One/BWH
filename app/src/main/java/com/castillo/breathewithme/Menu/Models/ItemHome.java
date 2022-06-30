package com.castillo.breathewithme.Menu.Models;

import android.graphics.drawable.Drawable;

public class ItemHome {
    public String titulo;
    public Integer imagen;

    public ItemHome(String titulo, Integer imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getImagen() {
        return imagen;
    }
}
