/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author user
 */
public class Pengemudi {
    private Pesanan pesanan[];
    private String nama;
    private String kendaraan;
    private String alamatKirim;
    private int jumlahPesanan;
    
    public Pengemudi(String nama,String kendaraan){
        this.nama = nama;
        this.kendaraan = kendaraan;
    }
    public addPesanan(Pesanan p){
        pesanan[jumlahPesanan] = p;
        jumlahPesanan++;
    }
    public String getNama(){
        return nama;
    }
    public String getKendaraan(){
        return kendaraan;
    }
    public void setAlamatkirim(String ak){
        this.alamatKirim = ak;
    }
    public String getAlamatkirim(){
       return alamatKirim;
    }  
}
