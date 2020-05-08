package com.company;
import java.util.Scanner;
public class AgArayuz implements IAgArayuz, observer{
    Scanner input=new Scanner(System.in);
    @Override
    public boolean kullaniciGiris(){
        int sayici=0;
        while(sayici!=3)
        {
            SQL User=SQL.Nesne();
            String kullaniciAdi="";
            String sifre="";
            messageShow("Lutfen Kullanici Adi Girin");
            messageShow("Kullanici Adi: ");
            kullaniciAdi=input.next();
            messageShow("Lutfen Sifre giriniz..:");
            messageShow("Sifre..:");
            sifre=input.next();
            boolean result=User.UserAuthentication(kullaniciAdi,sifre);
            if(result){
                return true;
            }
            sayici++;
        }
        return false;
    }
    @Override
    public void messageShow(String mes){
        System.out.println(mes);
    }
    @Override
    public int Secim(){
        int operation=0;
        messageShow("<<<<****>>>>");
        messageShow("||||MENU||||");
        messageShow("1)Sicaklik Goster..");
        messageShow("2)Sogutucu Calistir..");
        messageShow("3)Sogutucu Kapat");
        messageShow("4)Cikis");

        operation=input.nextInt();
        if(operation==0){
            messageShow("Lutfen Secim Yapiniz..");
        }
        return operation;
    }

    @Override
    public void Sicaklik(IEyleyiciVeAlgilayici sicaklikAlgilayici) {
        sicaklikAlgilayici.SicaklikGonder();
    }

    @Override
    public void SogutucuAc(IEyleyiciVeAlgilayici eyleyici) {
        eyleyici.SogutucuAc();
    }

    @Override
    public void SogutucuKapa(IEyleyiciVeAlgilayici eyleyici) {
        eyleyici.SogutucuKapa();
    }


    @Override
    public void Cikis(){
        messageShow("Cikis Yapildi... :)");
    }
    @Override
    public void update(int sicaklik){
        messageShow("Sicaklik Güncellendi..");
    }
}
