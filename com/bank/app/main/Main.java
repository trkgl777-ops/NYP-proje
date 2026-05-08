package com.bank.app.main;
import com.bank.app.people.*;
import com.bank.app.accounts.*;

public class Main {
    public static void main(String[] args) {
        //  Müşteri oluşturma 
        Musteri m1 = new Musteri("Ahmet", "Yılmaz", "ahmet@mail.com", 5551234);
        System.out.println(m1);

        // 2. Müşteri adına hesap açma 
        m1.hesapEkle("Vadesiz");
        m1.hesapEkle("Yatirim");
        VadesizHesap vHesap = (VadesizHesap) m1.getHesaplar().get(0);
        YatirimHesabi yHesap = (YatirimHesabi) m1.getHesaplar().get(1);

        // Hesaba para yatırma 
        yHesap.paraEkle(5000);
        System.out.println("Yatırım Hesabı Bakiye: " + yHesap.getBakiye());

        //  Hesaplar arası transfer 
        vHesap.setBakiye(1000);
        vHesap.paraTransferi(yHesap, vHesap, 500);
        System.out.println("Transfer Sonrası Vadesiz: " + vHesap.getBakiye());
        System.out.println("Transfer Sonrası Yatırım: " + yHesap.getBakiye());

        //  Kredi kartı tanımlama 
        m1.krediKartiEkle(10000);
        m1.getKrediKartlari().get(0).setGuncelBorc(200);
        System.out.println(m1.getKrediKartlari().get(0));

        //  Kredi kartı borç ödeme 
        vHesap.krediKartiBorcOdeme(m1.getKrediKartlari().get(0), 200);
        System.out.println("Borç Ödeme Sonrası: " + m1.getKrediKartlari().get(0));

        //  Hesap silme 
        m1.hesapSil(vHesap); // Bakiyesi olduğu için uyarı verecek
        vHesap.setBakiye(0);
        m1.hesapSil(vHesap); // Başarıyla silecek
    }
}