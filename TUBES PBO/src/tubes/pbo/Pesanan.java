/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.pbo;

/**
 *
 * @author AGUNG
 */
public class Pesanan {
    private String barang[];
    private String tipePesanan;
    private long harga;
    private int jumlahBarang;
    private String alamatPemesan;
    private String alamatTujuan;

    public Pesanan(String tipePesanan) {
        this.tipePesanan = tipePesanan;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setTipePesanan(String tipePesanan) {
        this.tipePesanan = tipePesanan;
    }

    public String getTipePesanan() {
        return tipePesanan;
    }

    public void addBarang(String barang) {
        this.barang[jumlahBarang] = barang;
        jumlahBarang++;
    }

    public String getBarang(int i) {
        return barang[i];
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
