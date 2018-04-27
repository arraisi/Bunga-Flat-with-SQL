/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.training.bungaflatsql.bungaflatsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class NasabahService {
    public BungaFlat saveData (BungaFlat bungaflat) throws SQLException {
        Connection koneksi = MainBungaFlatSQL.getKoneksiKeDB();
        
        PreparedStatement perintah = koneksi.prepareStatement("INSERT INTO Nasabah (Nama_Nasabah, Pinjaman, Waktu_Angsuran)\n"
                + "VALUES (?, ?, ?);");
        perintah.setString(1, bungaflat.getNamaNasabah() );
        perintah.setInt(2, (int) bungaflat.getPinjaman());
        perintah.setInt(3, (int) bungaflat.getKali());
       
        perintah.executeUpdate();
        perintah.close();
        koneksi.close();
        return bungaflat;
    }
    public BungaFlat hitungData (BungaFlat bungaflat) throws SQLException{
        Connection koneksi = MainBungaFlatSQL.getKoneksiKeDB();
        for(Integer i = 0 ; i < bungaflat.getKali() ; i++){
            
            bungaflat.setPinjaman(bungaflat.getPinjaman());
            bungaflat.setKali(bungaflat.getKali());
            bungaflat.setSukuBunga(bungaflat.getSukuBunga());
            bungaflat.JumlahAngsuran();
            bungaflat.Angsuran();
            bungaflat.Bunga();
            bungaflat.setPokokAngs();
            bungaflat.inSisa();
            bungaflat.setSisa();
        
        PreparedStatement perintah = koneksi.prepareStatement("INSERT INTO Angsuran (Sisa_Pinjaman, Angsuran_Pokok, Bunga, Total_Angsuran)\n"
                + "VALUES (?, ?, ?, ?);");
        perintah.setLong(1, bungaflat.getSisa());
        perintah.setLong(2, (long) bungaflat.getPokokAngsuran());
        perintah.setLong(3, (int) bungaflat.getBunga());
        perintah.setLong(3, (int) bungaflat.getAngsuran());
            }
        return bungaflat;
    }
    
}
