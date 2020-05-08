package com.company;

public interface IAgArayuz {
    public boolean kullaniciGiris();
    public int Secim();
    public void Sicaklik(IEyleyiciVeAlgilayici sicaklikAlgilayici);
    public void SogutucuAc(IEyleyiciVeAlgilayici eyleyici);
    public void SogutucuKapa(IEyleyiciVeAlgilayici eyleyici);
    public void Cikis();
    public void messageShow(String mes);
}
