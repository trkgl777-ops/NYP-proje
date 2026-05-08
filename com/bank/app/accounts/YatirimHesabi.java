package com.bank.app.accounts;

public class YatirimHesabi extends BankaHesabi {
    private String hesapTuru = "Yatırım";

    public YatirimHesabi(double bakiye) {
        super(bakiye);
    }

    public void paraEkle(double miktar) { //hesaba para eklenir miktar kadar
        setBakiye(getBakiye() + miktar);
    }

    public void paraCek(double miktar) { //cekilecek para bakiyeden az ise bakiye miktar kadar azaltılır.
        if (getBakiye() >= miktar) {
            setBakiye(getBakiye() - miktar);
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }
}
