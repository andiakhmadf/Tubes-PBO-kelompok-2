package tubespbo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hariz
 */
public class Kurir {
    private String namaBrg;
    private int jumlahBrg;
    private double beratBrg;

    public Kurir(String namaBrg, int jumlahBrg, double beratBrg) {
        this.namaBrg = namaBrg;
        this.jumlahBrg = jumlahBrg;
        this.beratBrg = beratBrg;
    }
	
	public void setNamaBrg(String namaBrg){
		this.namaBrg = namaBrg;
	}
	public String getNamaBrg(){
		return namaBrg;
	}
	public void setJumlahBrg(int jumlahBrg){
		this.jumlahBrg = jumlahBrg;
	}
	public int getJumlahBrg(){
		return jumlahBrg;
	}
	public void setBeratBrg(double beratBrg){
		this.beratBrg = beratBrg;
	}
	public double getBeratBrg(){
		return beratBrg;
	}
}
