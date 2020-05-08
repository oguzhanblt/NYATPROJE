package com.company;

public class Islem implements IIslem {
    IAgArayuz agArayuzu = new AgArayuz();
    IEyleyiciVeAlgilayici sAlgilayici = new EyleyiciVeAlgilayici();
    IEyleyiciVeAlgilayici eyleyici = new EyleyiciVeAlgilayici();

    @Override
    public int SistemOperation() {
        return agArayuzu.Secim();
    }
    private static final int sicaklikI = 1;
    private static final int fanAc = 2;
    private static final int fanKapa = 3;
    private static final int cikis = 4;
    @Override
    public boolean Giris() {
        return agArayuzu.kullaniciGiris();
    }
    @Override
    public void Operation() {
        if (Giris()){
            int operation=0;
            while(operation!=5) {
                operation = SistemOperation();
                switch (operation) {
                    case sicaklikI:
                        SicaklikOku();
                        break;
                    case fanAc:
                        SogutucuAc();
                        break;
                    case fanKapa:
                        SogutucuKapa();
                        break;
                    case cikis:
                        Cikis();
                        break;
                    default:
                        messageShow("Yanlış Bilgi Lütfen Tekrrar Eden | Please Repeat Wrong Information");
                        break;
                }
            }
        }else {
            messageShow("             Erişim Iptal Edildi       ||      Access Cancelled");
        }
    }

    @Override
    public void messageShow(String mes) {
        System.out.println(mes);
    }

    @Override
    public void SicaklikOku() {
        agArayuzu.Sicaklik(sAlgilayici);
    }

    @Override
    public void SogutucuAc() {
        agArayuzu.SogutucuAc(eyleyici);

    }

    @Override
    public void SogutucuKapa() {
        agArayuzu.SogutucuKapa(eyleyici);
    }


    @Override
    public void Cikis() {
        agArayuzu.Cikis();
    }

}
