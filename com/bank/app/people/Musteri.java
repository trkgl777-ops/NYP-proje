package com.bank.app.people;
import com.bank.app.accounts.*;
import com.bank.app.cards.KrediKarti;
import java.util.ArrayList;
import java.util.Random;

public class Musteri extends Kisi {
    private String musteriNumarasi;
    private ArrayList<BankaHesabi> hesaplar; // hesapları saklamak için arraylist
    private ArrayList<KrediKarti> krediKartlari; // kredi kartlarını saklamak için arraylist

    public Musteri(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
        this.musteriNumarasi = String.valueOf(new Random().nextInt(9000000) + 1000000); // rastgele müsteri numarası olusturma
    }

    public void hesapEkle(String hesapTuru) { // alınan parametreye gore hesap nesnesi olusturur
        if (hesapTuru.equalsIgnoreCase("Vadesiz")) {
            hesaplar.add(new VadesizHesap(0));
        } else if (hesapTuru.equalsIgnoreCase("Yatirim")) {
            hesaplar.add(new YatirimHesabi(0));
        }
    }

    public void krediKartiEkle(double limit) { // alınan parametrelere göre ilgili sınıftan nesne üretip listeye eklemek icin
        krediKartlari.add(new KrediKarti(limit, 0));
    }

    public void hesapSil(BankaHesabi hesap) { // hesapta bakiye 0 ise hesap silinir,degilse uyarı verilir 
        if (hesap.getBakiye() > 0) {
            System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
        } else {
            hesaplar.remove(hesap);
            System.out.println("Hesap başarıyla silindi.");
        }
    }

    public void krediKartiSil(KrediKarti kart) { // kredi kartı silme metodu kartın silinebilmesi için borcun 0 olması durumunu kontrol eder.
        if (kart.getGuncelBorc() == 0) {
            krediKartlari.remove(kart);
            System.out.println("Kredi kartı iptal edildi.");
        } else {
            System.out.println("Lütfen öncelikle borç ödemesi yapınız.");
        }
    }

    // getter metodları
    public String getMusteriNumarasi() { return musteriNumarasi; }
    public ArrayList<BankaHesabi> getHesaplar() { return hesaplar; }
    public ArrayList<KrediKarti> getKrediKartlari() { return krediKartlari; }

    @Override
    public String toString() {
        return super.toString() + ", Müşteri No: " + musteriNumarasi;
    }
}