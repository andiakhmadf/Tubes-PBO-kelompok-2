package tubespbo;
import java.util.*;
public class Pesanan {
    private ArrayList<String> barang = new ArrayList<String>();
    private String tipePesanan;
    private long harga;
    private String alamatPemesan;
    private String alamatTujuan;

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
    
}
