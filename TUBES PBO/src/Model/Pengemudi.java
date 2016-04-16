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
public class Pengemudi extends Orang implements Serializable{
    private Pelanggan pesanan;
    private String nama;
    private String kendaraan;
    private String alamatPemesan;

    public Pengemudi(String nama, String kendaraan) {
        this.nama = nama;
        this.kendaraan = kendaraan;
    }

    public void addPesanan(Pelanggan p) {
        this.pesanan = p;
    }

    public String getNama() {
        return nama;
    }

    public String getKendaraan() {
        return kendaraan;
    }

    public void setAlamatPemesan(String ak) {
        this.alamatPemesan = ak;
    }

    public String getAlamatPemesan() {
        return alamatPemesan;
    }

    public Pelanggan getPesanan() {
        return pesanan;
    }

    public void setHarga(long harga) {
        pesanan.getPesanan().setHarga(harga);
    }

    @Override
    public void kirimPesanan() {
        pesanan = null;
    }
}
