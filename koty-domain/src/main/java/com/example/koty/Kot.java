package com.example.koty;

import java.util.Date;

public class Kot {
    private String imie;
    private Date dataUrodzenia;
    private Float waga;
    private String imieOpiekuna;

    public Kot() {
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public Float getWaga() {
        return waga;
    }

    public void setWaga(Float waga) {
        this.waga = waga;
    }

    public String getImieOpiekuna() {
        return imieOpiekuna;
    }

    public void setImieOpiekuna(String imieOpiekuna) {
        this.imieOpiekuna = imieOpiekuna;
    }

    public String przedstawSie() {
        return"Kot{" +
                "imie='" + imie + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", waga=" + waga +
                ", imieOpiekuna='" + imieOpiekuna + '\'' +
                '}';
    }
}
