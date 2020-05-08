package com.company;
import java.util.Random;
import java.util.ArrayList;
public class EyleyiciVeAlgilayici implements IEyleyiciVeAlgilayici{
    private ArrayList List = new ArrayList();
    @Override
    public void SogutucuAc() {
        messageShow(" Sogutucu Acildi ");
    }

    @Override
    public void SogutucuKapa() {
        messageShow("Sogutucu kapatildi ");
    }

    @Override
    public int SicaklikOku() {
        Random rand = new Random();
        int sayi = rand.nextInt(100);
        return sayi;
    }

    int sicaklik;
    @Override
    public int SicaklikGonder() {
        sicaklik=SicaklikOku();
        messageShow("Sicaklik    : "+ sicaklik+"°C");
        return SicaklikOku();
    }

    @Override
    public void messageShow(String mes) {
        System.out.println(mes);
    }

    public void regObserver(observer i) {
        List.add(i);
    }

    public void deleteObserver(observer i) {
        int j = List.indexOf(i);
        if (j >= 0) {
            List.remove(i);
        }
    }

    public void notObservers() {
        for (int j = 0; j < List.size(); j++) {
            observer observer = (com.company.observer) List.get(j);
            observer.update(SicaklikGonder());
        }
    }
}
