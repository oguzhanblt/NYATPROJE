package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SQL {
    public static SQL data;

    private SQL() {

    }

    public static SQL Nesne() {
        if (data == null) {
            data = new SQL();
        }
        return data;
    }

    public boolean UserAuthentication(String Username, String Password) {
        try {
            Connection concect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NYATPROJE", "postgres", "blt1999514");
            //if (concect != null) {
                String UserSQL = "SELECT * FROM public.\"User\"";
                Statement stmt = concect.createStatement();
                ResultSet result = stmt.executeQuery(UserSQL);
                concect.close();
                String kullaniciAdi = "";
                String sifre = "";
                while (result.next()) {
                    kullaniciAdi = result.getString("kullaniciAdi1");
                    sifre = result.getString("sifre1");
                //}
                if (kullaniciAdi.equals(kullaniciAdi) && sifre.equals(sifre)) {
                    System.out.println("Tebrikler Giriş Başarlı ");
                    return true;
                } else {
                    System.out.println("     Giriş Yanlış Lütfen Tekrar Eden   ");
                    return false;
                }
            } //else {
                //System.out.println("Veritabanina Baglanilaması Başarsız||Database Connect Failed");
               // return false;
           // }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }
}
