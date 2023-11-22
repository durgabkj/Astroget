package com.example.astroget.Model;

public class AstroModel {

    private String astroName;
    private int imgid;

    public AstroModel(String astro_name, int imgid) {
        this.astroName = astro_name;
        this.imgid = imgid;
    }

    public String getAstroName() {
        return astroName;
    }

    public void setAstroName(String astroName) {
        this.astroName = astroName;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}

