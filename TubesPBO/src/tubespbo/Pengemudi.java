/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author Andi
 */
public class Pengemudi extends Orang {
    private Pesanan pesanan[];
    private String nama;
    private String kendaraan;
    private String alamatKirim;
    private int jumlahPesanan;
    
    public Pengemudi(String nama,String kendaraan){
        this.nama = nama;
        this.kendaraan = kendaraan;
    }
    public void addPesanan(Pesanan p){
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
    public Pesanan getPesanan(int i){
        return pesanan[i];
    }
    @Override
    public void kirimPesanan(){
		for (int i=0; i<=jumlahPesanan; i++){	
                    pesanan[i] = null;
		}
		jumlahPesanan = 0;
    }
}
