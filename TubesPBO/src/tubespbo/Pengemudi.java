package tubespbo;

import java.util.*;
public class Pengemudi extends Orang {
    private Pesanan pesanan;
    private String nama;
    private String kendaraan;
    private String alamatPemesan;

    public Pengemudi(String nama, String kendaraan) {
        this.nama = nama;
        this.kendaraan = kendaraan;
    }

    public void addPesanan(Pesanan p) {
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

    public Pesanan getPesanan() {
        return pesanan;
    }

    public void setHarga(long harga) {
        pesanan.setHarga(harga);
    }

    @Override
    public void kirimPesanan() {
        pesanan = null;
    }
}
