package com.example.koty;

import java.util.ArrayList;
import java.util.List;

public class KotDAO {
    public List<Kot> listaKotow = new ArrayList<Kot>();

    public KotDAO() {
    }

    public void addCat(Kot cat) {
        this.listaKotow.add(cat);
    }

    public int rozmiarListy() {
        return listaKotow.size();
    }

    public List<Kot> getListaKotow() {
        return listaKotow;
    }
}
