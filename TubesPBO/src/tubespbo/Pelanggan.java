package tubespbo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AGUNG & Andi
 */
public class Pelanggan extends Orang {
    private Pesanan pesanan[];
	private long totalHarga;
	private String alamat;
	private String nama;
	private int totalPesanan;
	
	public Pelanggan(String nama, String alamat, int totalPesanan){
		this.nama = nama;
		this.alamat = alamat;
		pesanan = new Pesanan[totalPesanan];
	}
	public void setAlamat(String alamat){
		this.alamat = alamat;
	}
	public String getAlamat(){
		return alamat;
	}
	public void setTotalHarga(long totalHarga){
		this.totalHarga = totalHarga;
	}
	public long getTotalHarga(){
		return totalHarga;
	}
	public String getNama(){
		return nama;
	}
	public void pesan(Pesanan pesanan){ //create pesanan
                pesanan = new Pesanan(pesanan.getJumlahBarang(),pesanan.getTipepesanan());
		this.pesanan[totalPesanan] = pesanan;
		totalPesanan++;
	}
    @Override
        public void kirimPesanan(){ //remove pesanan
		for (int i=0; i<=totalPesanan; i++){	
                    pesanan[i] = null;
		}
		totalPesanan = 0;
    }
}
