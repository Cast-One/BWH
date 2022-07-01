package com.castillo.breathewithme.Menu.Models;

public class ItemContacto {

    String name;
    String phone;

    public ItemContacto(String name, String telefono) {
        this.name = name;
        this.phone = telefono;
    }

    public String getName() { return name; }

    public String getTelefono() { return phone; }
}
