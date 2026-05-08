package com.bank.app.people;
import java.util.ArrayList;
import java.util.Random;

public class BankaPersoneli extends Kisi {
    private String personelID;
    private ArrayList<Musteri> musteriler; // musterileri saklamak için arraylist

    public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        this.musteriler = new ArrayList<>();
        this.personelID = String.valueOf(new Random().nextInt(900000) + 100000); // personal ıd random üretilir
    }

    public String getPersonelID() { return personelID; }
    public ArrayList<Musteri> getMusteriler() { return musteriler; }

    @Override
    public String toString() {
        return super.toString() + ", Personel ID: " + personelID;
    }
}