/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Database.*;
/**
 *
 * @author AGUNG
 */
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplikasi {
    
    Database database = new Database();
    private ArrayList<Pelanggan> listPesan;
    private Pelanggan pelanggan;
    private Pengemudi pengemudi;
    private ArrayList<Pelanggan> listUserPelanggan;
    private ArrayList<Pengemudi> listUserPengemudi;
    private Kurir kurir;
    
    
    Scanner user = new Scanner(System.in); //Scanner String
    Scanner userInt = new Scanner(System.in); //Scanner Integer

    public Aplikasi() throws IOException, ClassNotFoundException {
        pelanggan = new Pelanggan("Andi Agung Wibawa", "Bojongsoang");
        pengemudi = new Pengemudi("Fauzi A.", "Honda Vario");
        listPesan = database.readDaftarPesanan();
        listUserPelanggan = database.readAkunPelanggan();
        listUserPengemudi = database.readAkunPengemudi();
    }

    public void editProfil(Pelanggan p, String nama, String alamat) {
        p.setNama(nama);
        p.setAlamat(alamat);
    }

    public void pilihPesan(Pelanggan p, String tipePesanan) {
        p.pesan(tipePesanan);
    }

    public void isiPesan(Pelanggan p, String lokasiPesan, String tujuan) {
        p.getPesanan().setAlamatPemesan(lokasiPesan);
        p.getPesanan().setAlamatTujuan(tujuan);
    }

    public void tambahBarang(Pesanan p, String barang) {
        p.addBarang(barang);
    }

    public void removeBarang(Pesanan p, int c) {
        p.removeBarang(c - 1);
    }

    public void viewDaftarBarang(Pelanggan p) {
        int i = 1;
        for (String s : p.getPesanan().getListBarang()) {
            System.out.println(i + ". " + s);
            i++;
        }
    }

    public void kirimPesan(Pelanggan p) {
        listPesan.add(p);
        p.kirimPesanan();
    }

    public void lihatDaftarPesan() {
        int x = 1;
        for (Pelanggan i : listPesan) {
            System.out.println(x + ". " + i.getNama() + "/ " + "Pesanan " + 
                    i.getPesanan().getTipePesanan());
            x++;
        }
    }

    public void viewDetailPesanan(int g) {
        System.out.println("Jenis Pesanan   : " + listPesan.get(g - 1).getPesanan().getTipePesanan());
        System.out.println("Nama            : " + listPesan.get(g - 1).getNama());
        System.out.println("Alamat          : " + listPesan.get(g - 1).getPesanan().getAlamatPemesan());
        System.out.println("Tujuan          : " + listPesan.get(g - 1).getPesanan().getAlamatTujuan());
        System.out.println("==List Barang==");
        for (int j = 0; j < listPesan.get(g - 1).getPesanan().getJumlahBarang(); j++) {
            System.out.println("  " + (j+1) + ". " + listPesan.get(g - 1).getPesanan().getBarang(j));
        }
    }

    public void ambilPesanan(Pengemudi p, int i) {
        p.addPesanan(listPesan.get(i - 1));
        listPesan.remove(i - 1);
    }

    public void pesananSelesai(Pengemudi p) {
        p.kirimPesanan();
    }

    public void MainMenuLogin() throws IOException {
        int i = 0;
        try{
        while (i != 9) {
            System.out.println("");
            System.out.println("=====TRANSPORTASI OJEK ONLINE=====");
            System.out.println("TIPE LOGIN:");
            System.out.println("1.Pelanggan");
            System.out.println("2.Pengemudi");
            System.out.print("Pilihan: ");
            
                i = userInt.nextInt();
                switch (i) {
                    case 1:
                        String pu;
                        String pp;
                        System.out.println("");
                        System.out.println("=====Login Pelanggan=====");
                        System.out.print("Username: ");
                        pu = user.next();
                        System.out.print("Password: ");
                        pp = user.next();
                        MenuPelanggan();
                        break;
                    case 2:
                        String ppu;
                        String pps;
                        System.out.println("");
                        System.out.println("=====Login Pengemudi=====");
                        System.out.print("Username: ");
                        ppu = user.next();
                        System.out.print("Password: ");
                        pps = user.next();
                        MenuPengemudi();
                        break;
                }
            }
        }catch(java.util.InputMismatchException e){
                System.out.println("aa");
            } 
    }

    public void MenuPesanOjek() {
        int i = 9;
        while (i != 5 || 1 != 0) {
            System.out.println("");
            System.out.println("==================================");
            System.out.println("===========PESAN OJEK=============");
            System.out.println("1.Isi Lokasi");
            System.out.println("5.Kirim Pesan");
            System.out.println("0.Batal Pesan");
            System.out.println("Pilih : ");
            i = userInt.nextInt();
            switch (i) {
                case 1:
                    System.out.println("");
                    System.out.print("Lokasi Pemesan : ");
                    String lp = user.next();
                    System.out.print("Lokasi Tujuan : ");
                    String lt = user.next();
                    isiPesan(pelanggan, lp, lt);
                    break;
                case 5:
                    System.out.println("");
                    kirimPesan(pelanggan);
                    System.out.println("==========Pesan terkirim==========");
                    break;
            }
        }
    }

    public void MenuPesanKurir() {
        int i = 9;
        while (i != 5 || i != 0) {
            System.out.println("");
            System.out.println("==================================");
            System.out.println("==========PESAN KURIR=============");
            System.out.println("1.Isi Lokasi");
            System.out.println("2.Add Barang");
            System.out.println("3.Remove Barang");
            System.out.println("4.View Daftar Barang");
            System.out.println("5.Kirim Pesan");
            System.out.println("0.Batal Pesan");
            System.out.println("Pilih : ");
            i = userInt.nextInt();
            switch (i) {
                case 1:
                    System.out.println("");
                    System.out.print("Lokasi Pemesan : ");
                    String lp = user.next();
                    System.out.print("Lokasi Tujuan : ");
                    String lt = user.next();
                    isiPesan(pelanggan, lp, lt);
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("Masukkan barang : ");
                    String b = user.next();
                    tambahBarang(pelanggan.getPesanan(), b);
                    break;
                case 3:
                    System.out.println("");
                    System.out.print("Remove barang ke : ");
                    int x = userInt.nextInt();
                    removeBarang(pelanggan.getPesanan(), x);
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("==================================");
                    System.out.println("==========DAFTAR BARANG===========");
                    viewDaftarBarang(pelanggan);
                    break;
                case 5:
                    System.out.println("");
                    kirimPesan(pelanggan);
                    System.out.println("==========Pesan terkirim==========");
                    break;
            }
        }
    }

    public void MenuPelanggan() {
        int a = 0;
        while (a != 9) {
            System.out.println("");
            System.out.println("==================================");
            System.out.println("=====TRANSPORTASI OJEK ONLINE=====");
            System.out.println("Nama   :" + pelanggan.getNama());
            System.out.println("Alamat : " + pelanggan.getAlamat());
            System.out.println("1.Edit Profile");
            System.out.println("2.Pilih Pesanan");
            System.out.println("9.Logout");
            System.out.print("Pilihan: ");
            a = userInt.nextInt();
            switch (a) {
                case 1:
                    System.out.println("");
                    System.out.print("Masukan nama user: ");
                    String nm = user.nextLine();
                    System.out.print("Masukan alamat user: ");
                    String am = user.nextLine();
                    editProfil(pelanggan, nm, am);
                    System.out.println("Profil berhasil di ubah");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("1.Pesan Ojek");
                    System.out.println("2.Pesan Kurir");
                    System.out.print("Pilih jenis pesanan: ");
                    int jenis = userInt.nextInt();
                    if (jenis == 1) {
                        pilihPesan(pelanggan, "Ojek");
                        MenuPesanOjek();
                    } else if (jenis == 2) {
                        pilihPesan(pelanggan, "Kurir");
                        MenuPesanKurir();
                    }
                    break;
            }
        }
    }

    public void MenuPengemudi() {
        int a = 0;
        while (a != 9) {
            System.out.println("==================================");
            System.out.println("=====TRANSPORTASI OJEK ONLINE=====");
            System.out.println("");
            System.out.println("==========LIST PESANAN============");
            lihatDaftarPesan();
            System.out.println("");
            System.out.println("Nama                : " + pengemudi.getNama());
            System.out.println("Kendaraan           : " + pengemudi.getKendaraan());
            System.out.print("Pesanan dijalani    : ");
            if(pengemudi.getPesanan()==null){
                System.out.println("-");
            } else{
                System.out.println(pengemudi.getPesanan().getNama() + "/ " + 
                        "pesanan " + pengemudi.getPesanan().getPesanan().getTipePesanan());
            }
            System.out.println("1.Ambil Pesanan");
            System.out.println("2.View Detail Pesanan");
            System.out.println("3.Selesai Pesanan");
            System.out.println("9.Logout");
            System.out.print("Pilihan: ");
            a = userInt.nextInt();
            switch (a) {
                case 1:
                    System.out.print("Masukkan No Pesanan : ");
                    int i1 = userInt.nextInt();
                    ambilPesanan(pengemudi, i1);
                    System.out.println("======PESANAN DIAMBIL========");
                    break;
                case 2:
                    System.out.print("Masukkan No Pesanan : ");
                    int i2 = userInt.nextInt();
                    System.out.println("=============================");
                    System.out.println("=======DETAIL PESANAN========");
                    int i3 = 1;
                    while(i3!=0){
                        viewDetailPesanan(i2);
                        System.out.println("===Tekan 0 untuk kembali===");
                        i3 = userInt.nextInt();
                    }
                    break;
                case 3:
                    System.out.println("==PESANAN SELESAI DIJALANKAN==");
                    pesananSelesai(pengemudi);
            }
        }
    }

    public void MainMenu() throws IOException {
        MainMenuLogin();
    }
}
