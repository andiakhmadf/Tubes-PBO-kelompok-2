package tubespbo;
import java.util.*;
public class Aplikasi {
    private ArrayList<Pelanggan> listPesan = new ArrayList<Pelanggan>();
    private Pelanggan pelanggan;
    private Pengemudi pengemudi;
    private Kurir kurir;
    int i,a,x;
    Scanner user = new Scanner(System.in); //Scanner String
    
    public void editProfil(Pelanggan p, String nama, String alamat){
        p.setNama(nama);
        p.setAlamat(alamat);
    }
    
    public void pilihPesan(Pelanggan p, String tipePesanan){
        p.pesan(tipePesanan);
    }
    
    public void isiPesan(Pelanggan p, String lokasiPesan,String tujuan){
        p.getPesanan().setAlamatPemesan(lokasiPesan);
        p.getPesanan().setAlamatPemesan(tujuan);
    }
    
    public void tambahBarang(Pesanan p, String barang){
        p.addBarang(barang);
    }
    
    public void removeBaranag(Pesanan p, int c){
       p.removeBarang(c);
    }
        
    public void kirimPesan(Pelanggan p){
       listPesan.add(p);
       p.kirimPesanan();
    }
    
    public void lihatDaftarPesan(){
       for (Pelanggan i : listPesan){
           System.out.println(i);
       } 
    }
    
    public void viewDetailPesanan(int g){
       System.out.println(listPesan.get(g).getNama());
       System.out.println(listPesan.get(g).getPesanan().getAlamatPemesan());
       System.out.println(listPesan.get(g).getPesanan().getAlamatTujuan());
       for (int j=0;j<listPesan.get(g).getPesanan().getJumlahBarang();j++){
           System.out.println(listPesan.get(g).getPesanan().getBarang(j));
       }
    }
    
    public void pilihPesanan(int i){
        listPesan.remove(i);
    }
    
    public void MainMenu(){
        System.out.println("=====TRANSPORTASI OJEK ONLINE=====");
        System.out.println("TIPE LOGIN:");
        System.out.println("1.Pelanggan");
        System.out.println("2.Pengemudi");
        System.out.print("Pilihan: ");
        switch(i){
            case 1: System.out.println("=====Login Pelanggan=====");
                    System.out.print("Username: ");
                    String u = user.nextLine();
                    System.out.print("Password: ");
                    u = user.nextLine();
                    MenuPelanggan();
                    break;
                    }
        }
    
    public void MenuPelanggan(){
        System.out.println("=====TRANSPORTASI OJEK ONLINE=====");
        System.out.println("1.Edit Profile");
        System.out.println("2.Pilih Pesanan");
        System.out.println("3.Isi Lokasi");
        System.out.println("4.Tambah barang pesanan");
        System.out.println("5.Hapus barang pesanan");
        System.out.println("6.Kirim Pesanan");
        System.out.print("Pilihan: ");
        switch(a){
            case 1: System.out.print("Masukan nama user: ");
                    String nm = user.nextLine();
                    System.out.print("Masukan alamat user: ");
                    String am = user.nextLine();
                    editProfil(pelanggan, nm, am);
                    System.out.println("Profil berhasil di ubah");
    }
}
}
