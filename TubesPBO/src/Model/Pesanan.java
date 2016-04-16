/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author AGUNG
 */
import java.io.Serializable;
import java.util.*;
public class Pesanan implements Serializable{
    private List<String> barang = new ArrayList<String>();
    private String tipePesanan;
    private long harga;
    private String alamatPemesan;
    private String alamatTujuan;
    private String status;

    public Pesanan(String tipePesanan) {
        this.tipePesanan = tipePesanan;
    }
    
    
    public int getJumlahBarang() {
        return barang.size();
    }

    public void setTipePesanan(String tipePesanan) {
        this.tipePesanan = tipePesanan;
    }

    public String getTipePesanan() {
        return tipePesanan;
    }

    public void addBarang(String barang) {
        this.barang.add(barang);
    }
    
    public void removeBarang(int i){
        barang.remove(i);
    }
    
    public String getBarang(int i) {
        return barang.get(i);
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public long getHarga() {
        return harga;
    }

    public void setAlamatPemesan(String alamatPemesan) {
        this.alamatPemesan = alamatPemesan;
    }

    public void setAlamatTujuan(String alamatTujuan) {
        this.alamatTujuan = alamatTujuan;
    }

    public String getAlamatPemesan() {
        return alamatPemesan;
    }

    public String getAlamatTujuan() {
        return alamatTujuan;
    }
    
    public String[] getListBarang(){
        return (String[]) barang.toArray(new String[0]);
    }
    
    public void setStatus(int i){
        switch(i){
            case 1 : this.status = "Belum memesan";break;
            case 2 : this.status = "Menunggu Diterima";break;
            case 3 : this.status = "Pesanan Diterima";break;
        }
    }
    
    public String getStatus(int i){
        if (i == 1){
            return "Belum memesan";
        }else if(i==2){
            return "Belum memesan";
        }else if(i==3){
            return "Pesanan Diterima";
        }else{
            return "";
        }
    }
    
}
