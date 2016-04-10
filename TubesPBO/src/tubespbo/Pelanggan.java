package tubespbo;

import java.util.*;
public class Pelanggan extends Orang {
    private Pesanan pesanan;
    private long totalHarga;
    private String alamat; //alamat pelanggan memesan
    private String nama;
    private Pengemudi p2;

    public Pelanggan(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setTotalHarga(long totalHarga) {
        this.totalHarga = totalHarga;
    }

    public long getTotalHarga() {
        return totalHarga;
    }
    
    public void setNama(String nama){
       this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void pesan(String tipePesanan) { //create pesanan
        Pesanan ps = new Pesanan(tipePesanan);
        this.pesanan = ps;
    }

    public void addBarang(String barang) {
            this.pesanan.addBarang(barang);
    }
    
    public void removeBarang(int i){
            this.pesanan.removeBarang(i);
    }
    
    public Pesanan getPesanan(){
        return pesanan;
    }

    @Override
    public void kirimPesanan() { //remove pesanan
        
    }
}
