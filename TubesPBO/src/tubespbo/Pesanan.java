package tubespbo;

// author Hariz

public class Pesanan
{
	private Kurir brg[] ;
	private String tipePesanan ;
	private long harga ;
	private int jumlahBarang ;
        private String nB;
        private int jB;
        private double bB;

	public Pesanan (int jumlahBarang,String tipePesanan)
	{
		brg = new Kurir[jumlahBarang] ;
		this.tipePesanan = tipePesanan ;	
	}
	
	public Pesanan (String tipePesanan)
	{
		this.tipePesanan = tipePesanan ;	
	}
	public int getJumlahBarang(){
            return jumlahBarang;
        }
	public void setTipepesanan(String tipePesanan )
	{
		this.tipePesanan = tipePesanan ;
	}
	
	public String getTipepesanan ()
	{
		return tipePesanan ;
	}
	
	public void setHarga (long harga)
	{
		this.harga = harga ;
	}
	
	public long getHarga ()
	{
		return harga ;
	}
	
	public void addBarang(Kurir brg)
	{
          nB = brg.getNamaBrg();
          jB = brg.getJumlahBrg();
          bB = brg.getBeratBrg();
          brg = new Kurir(nB,jB,bB);
	  this.brg[jumlahBarang] = brg ;
	  jumlahBarang++;
	}
}