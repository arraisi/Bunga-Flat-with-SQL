/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.training.bungaflatsql.bungaflatsql;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MainBungaFlatSQL {

    public static Connection getKoneksiKeDB() throws SQLException {
        String username = "sa";
        String URL = "jdbc:sqlserver://localhost;databaseName=JBDC_BungaFlat;instanceName=SQLEXPRESS2017";
        String password = "16agustus1994";
        return DriverManager.getConnection(URL, username, password);
    }
    
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        BungaFlat bunga = new BungaFlat();
        NasabahService serviceNasabah = new NasabahService();
        
        //Input data nasabah
        System.out.println("Masukan Nama Nasabah : ");
        bunga.setNamaNasabah(input.next());
        System.out.println("Masukan Jumlah Pinjaman : ");
        bunga.setPinjaman(input.nextInt());
        System.out.println("Masukan Lama Angsuran : ");
        bunga.setKali(input.nextInt());
        System.out.println("Masukan Suku Bunga : ");
        bunga.setSukuBunga(input.nextInt());
        serviceNasabah.saveData(bunga);
        serviceNasabah.hitungData(bunga);
        
        

    }

}
