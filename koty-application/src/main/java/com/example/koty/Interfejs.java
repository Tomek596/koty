package com.example.koty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interfejs {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Kot kot = new Kot();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Pattern patternData = Pattern.compile("[0-9]{4}\\.[0-2]{2}\\.[0-31]{2}");
        Pattern patternWeigth = Pattern.compile("[0-9]{1,}\\.[0-9]{0,6}");
        Matcher matcher;
        String data, wagaKota;
        KotDAO kotDAO = new KotDAO();
        char x;

        do {
            printMenu();
            x = sc.next().charAt(0);
            switch (x) {
                case '1':
                    System.out.println("Podaj imie kota");
                    kot.setImie(sc.next().trim());
                    System.out.println("Podaj imie opiekuna");
                    kot.setImieOpiekuna(sc.next().trim());

                    do {
                        System.out.println("Podaj date narodzin kota");
                        try {
                            data = sc.next().trim();
                            matcher = patternData.matcher(data);
                            if (matcher.matches()) {
                                kot.setDataUrodzenia(simpleDateFormat.parse(data));
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                            System.out.println("Blad daty");
                        }
                    } while (kot.getDataUrodzenia() == null);
                    do {
                        System.out.println("Podaj wage kota");
                        try {
                            wagaKota = sc.next().trim();
                            matcher = patternWeigth.matcher(wagaKota);
                            if (matcher.matches()) {
                                kot.setWaga(Float.parseFloat(wagaKota));
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Zły format wagi");
                            e.printStackTrace();
                        }
                    } while (kot.getWaga() == null);

                    break;
                case '2':
                    header();
                    int i;
                    for (int k = 0; k < kotDAO.rozmiarListy(); k++) {
                        System.out.println(k + ':' + kotDAO.listaKotow.get(k).getImie());
                    }
                    System.out.println(kotDAO.listaKotow.size());
                    do {
                        System.out.println("Wybierz kota ktorego chcesz poznac");
                        i = sc.nextInt();
                        if (i < kotDAO.rozmiarListy()) {
                            System.out.println(kotDAO.listaKotow.get(i).przedstawSie());
                        } else {
                            System.out.println("Nie ma takiego kota na liscie");
                        }
                    } while (i > kotDAO.rozmiarListy());
                    break;
                case 'x':
                    System.exit(2);
                    break;
            }


        } while (true);
    }

    public static void printMenu() {
        System.out.println("1-dodaj kota");
        System.out.println("2-pokaz koty");
        System.out.println("x-zamknij program");
    }

    public static void header() {
        System.out.println("##########################");
        System.out.println("########## LISTA #########");
        System.out.println("##########################");
    }
}
