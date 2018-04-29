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
        
        PreparedStatement perintah = koneksi.prepareStatement("INSERT INTO Nasabah (ID_Nasabah, Nama_Nasabah, Pinjaman, Waktu_Angsuran)\n"
                + "VALUES (?, ?, ?, ?);");
        perintah.setInt(1, bungaflat.getIdNasabah());
        perintah.setString(2, bungaflat.getNamaNasabah() );
        perintah.setInt(3, (int) bungaflat.getPinjaman());
        perintah.setInt(4, (int) bungaflat.getKali());
       
        perintah.executeUpdate();
        
        return bungaflat;
    }
    public BungaFlat hitungData (BungaFlat bungaflat) throws SQLException{
        Connection koneksi = MainBungaFlatSQL.getKoneksiKeDB();
        PreparedStatement perintah = koneksi.prepareStatement("INSERT INTO Angsuran (ID_Nasabah, WaktuAngsuran, Sisa_Pinjaman, Angsuran_Pokok, Bunga, Total_Angusran)\n"
                + "VALUES (?, ?, ?, ?, ?, ?);");
        bungaflat.inSisa();
        for(Integer i = 1 ; i <= bungaflat.getKali() ; i++){
            
            bungaflat.setPinjaman(bungaflat.getPinjaman());
            bungaflat.setKali(bungaflat.getKali());
            bungaflat.setSukuBunga(bungaflat.getSukuBunga());
            bungaflat.Bunga();
            bungaflat.setPokokAngs();
            bungaflat.setSisa();
            bungaflat.Angsuran();
            
        perintah.setLong(1, bungaflat.getIdNasabah());
        perintah.setInt(2, i);
        perintah.setLong(3, bungaflat.getSisa());
        perintah.setLong(4, (long) bungaflat.getPokokAngsuran());
        perintah.setLong(5, (int) bungaflat.getBunga());
        perintah.setLong(6, (int) bungaflat.getAngsuran());
        perintah.executeUpdate();
        
        }
        perintah.close();
        koneksi.close();
        return bungaflat;
    }
    
}
