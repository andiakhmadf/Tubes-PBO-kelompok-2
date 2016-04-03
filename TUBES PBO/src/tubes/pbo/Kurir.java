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
public class Kurir extends Pengemudi{
    private String barang[];
    private int jumlahBrg;

    public Kurir(String nama, String kendaraan, int jumlahBrg) {
        super(nama, kendaraan);
        this.jumlahBrg = jumlahBrg;
        this.barang = new String[jumlahBrg];
    }

    public void setBarang(Pesanan pesanan) {
        for (int i = 0; i <= jumlahBrg; i++) {
            this.barang[i] = pesanan.getBarang(i);
        }
    }

    public void setJumlahBrg(int jumlahBrg) {
        this.jumlahBrg = jumlahBrg;
    }

    public int getJumlahBrg() {
        return jumlahBrg;
    }
}
