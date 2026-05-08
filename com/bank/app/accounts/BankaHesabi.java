package com.bank.app.accounts;
import java.util.Random;

public abstract class BankaHesabi {
    private String iban;
    private double bakiye;

    public BankaHesabi(double bakiye) {
        this.bakiye = bakiye;
        this.iban = "TR" + (new Random().nextInt(90000000) + 10000000); // rastgele iban olusturuldu.
    }

    public String getIban() { return iban; }
    public double getBakiye() { return bakiye; }
    public void setBakiye(double bakiye) { this.bakiye = bakiye; }

    @Override
    public String toString() {
        return "IBAN: " + iban + ", Bakiye: " + bakiye;
    }
}