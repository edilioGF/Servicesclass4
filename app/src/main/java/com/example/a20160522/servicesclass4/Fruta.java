package com.example.a20160522.servicesclass4;

import android.media.Image;
import android.widget.ImageView;

public class Fruta {
    private int id;
    private String name;
    private String description;
    private String image_url;

    public Fruta() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
