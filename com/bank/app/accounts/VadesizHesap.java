package com.bank.app.accounts;
import com.bank.app.cards.KrediKarti;

public class VadesizHesap extends BankaHesabi {
    private String hesapTuru = "Vadesiz";

    public VadesizHesap(double bakiye) {
        super(bakiye);
    }

    public void paraTransferi(BankaHesabi alici, BankaHesabi gonderen, double miktar) { //alıcı ve gonderıcı hesaplar BankaHesabi tipinden nesneler olmalı
        if (gonderen.getBakiye() >= miktar) {
            gonderen.setBakiye(gonderen.getBakiye() - miktar); // miktar,gonderenden düşülür 
            alici.setBakiye(alici.getBakiye() + miktar); // alıcı hesaba eklenir.
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }

    public void krediKartiBorcOdeme(KrediKarti kart, double miktar) { // kart bilgisi ve odenecek borc miktarını parametre olarak alır
        if (this.getBakiye() >= miktar) {
            this.setBakiye(this.getBakiye() - miktar); // belirlenen miktar bakiyeden duusulur
            kart.setGuncelBorc(kart.getGuncelBorc() - miktar); // toplam borc, odenen miktar kadar azalir.
        }
    }
}