
package com.tabeldata.training.bungaflatsql.bungaflatsql;

public class BungaFlat {
    private Integer id;
    private String namaNasabah;
    private long Pinjaman;
    private long Sisa;
    private long JumlahAngsuran ;
    private long JumlahBunga;
    private long JumlahPokok;
    private float Angsuran;
    private float Bunga;
    private float PokokAngsuran;
    private float kali;
    private float sukuBunga;
    
    
    
    //PERHITUNGAN
    public void JumlahAngsuran() {
        JumlahAngsuran += Angsuran;
    }

    public void JumlahPokok() {
        JumlahPokok = (long) (PokokAngsuran * kali);
    }

    public void JumlahBunga() {
        JumlahBunga += Bunga;
    }

    public void setPinjaman(long Pinjaman) {
        this.Pinjaman = Pinjaman;
    }

    public void inSisa() {
        this.Sisa = Pinjaman;
    }

    public void setKali(float kali) {
        this.kali = kali;
    }

    public void setSukuBunga(float sukuBunga) {
        this.sukuBunga = sukuBunga;
    }

    public void setSisa() {
        Sisa = (long) (Sisa - (Pinjaman / kali));
    }

    public void Bunga() {
        Bunga = Sisa * (((float) sukuBunga / 100) / 12);
    }

    public void Angsuran() {
        Angsuran = Bunga + (Pinjaman / kali);
    }

    public void setPokokAngs() {
        PokokAngsuran = Pinjaman / kali;
    }
    //-----------------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    
    public long getPinjaman() {
        return Pinjaman;
    }



    public long getSisa() {
        return Sisa;
    }

    public void setSisa(long Sisa) {
        this.Sisa = Sisa;
    }

    public long getJumlahAngsuran() {
        return JumlahAngsuran;
    }

    public void setJumlahAngsuran(long JumlahAngsuran) {
        this.JumlahAngsuran = JumlahAngsuran;
    }

    public long getJumlahBunga() {
        return JumlahBunga;
    }

    public void setJumlahBunga(long JumlahBunga) {
        this.JumlahBunga = JumlahBunga;
    }

    public long getJumlahPokok() {
        return JumlahPokok;
    }

    public void setJumlahPokok(long JumlahPokok) {
        this.JumlahPokok = JumlahPokok;
    }

    public float getAngsuran() {
        return Angsuran;
    }

    public void setAngsuran(float Angsuran) {
        this.Angsuran = Angsuran;
    }

    public float getBunga() {
        return Bunga;
    }

    public void setBunga(float Bunga) {
        this.Bunga = Bunga;
    }

    public float getPokokAngsuran() {
        return PokokAngsuran;
    }

    public void setPokokAngsuran(float PokokAngsuran) {
        this.PokokAngsuran = PokokAngsuran;
    }

    public float getKali() {
        return kali;
    }



    public float getSukuBunga() {
        return sukuBunga;
    }

 

    
}
