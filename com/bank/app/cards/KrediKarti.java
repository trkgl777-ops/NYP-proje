package com.bank.app.cards;
import java.util.Random;

public class KrediKarti {
    private String kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;

    public KrediKarti(double limit, double guncelBorc) {
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        this.kartNumarasi = String.valueOf(new Random().nextLong(900000000000L) + 100000000000L); // kart numarasi random üretilier.
        updateKullanilabilirLimit();
    }

    private void updateKullanilabilirLimit() {
        this.kullanilabilirLimit = this.limit - this.guncelBorc;
    }

    public double getGuncelBorc() { return guncelBorc; }
    public void setGuncelBorc(double guncelBorc) { 
        this.guncelBorc = guncelBorc; 
        updateKullanilabilirLimit();
    }

    @Override
    public String toString() {
        return "Kart No: " + kartNumarasi + ", Borç: " + guncelBorc + ", Limit: " + limit;
    }
}