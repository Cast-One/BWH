package com.castillo.breathewithme.Menu.Models;

public class ItemMusic {
    String image_URL;
    String title;
    String description;

    public ItemMusic(String image_URL, String title, String description) {
        this.image_URL = image_URL;
        this.title = title;
        this.description = description;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
