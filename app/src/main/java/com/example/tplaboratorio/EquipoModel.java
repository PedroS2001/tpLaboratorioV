package com.example.tplaboratorio;

public class EquipoModel {
    private String nombre;
    private String pais;
    private String liga;
    private String urlImagen;

    private byte[] imgByte;
    private boolean buscandoImagen;

    public EquipoModel() {
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public byte[] getImgByte() {
        return imgByte;
    }

    public void setImgByte(byte[] imgByte) {
        this.imgByte = imgByte;
    }

    public boolean isBuscandoImagen() {
        return buscandoImagen;
    }

    public void setBuscandoImagen(boolean buscandoImagen) {
        this.buscandoImagen = buscandoImagen;
    }

}
