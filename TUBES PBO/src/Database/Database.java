/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import Model.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author AGUNG
 */
public class Database {
    private ArrayList<Pelanggan> listPesan = new ArrayList<Pelanggan>();
    private ArrayList<Pelanggan> listUserPelanggan = new ArrayList<Pelanggan>();
    private ArrayList<Pengemudi> listUserPengemudi = new ArrayList<Pengemudi>();

    public ArrayList<Pelanggan> getListPesan() {
        return listPesan;
    }

    public ArrayList<Pelanggan> getListUserPelanggan() {
        return listUserPelanggan;
    }

    public ArrayList<Pengemudi> getListUserPengemudi() {
        return listUserPengemudi;
    }
        
   
    public void writeAkunPelanggan(ArrayList<Pelanggan> p) throws IOException {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("DataPelanggan.txt"));
            writer.writeObject(p);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        }
    }

    public void writeAkunPengemudi(ArrayList<Pengemudi> p) throws IOException {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("DataPengemudi.txt"));
            writer.writeObject(p);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        }
    }
    
    public void writeDaftarPesanan(ArrayList<Pelanggan> p) throws IOException {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("DataPesanan.txt"));
            writer.writeObject(p);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        }
    }

    public ArrayList<Pelanggan> readAkunPelanggan() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("DataPelanggan.txt");
            ObjectInputStream reader = new ObjectInputStream(fis);
            Object p = reader.readObject();
            return (ArrayList<Pelanggan>) p;
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        }
        return null;
    }
    
    public ArrayList<Pengemudi> readAkunPengemudi() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("DataPengemudi.txt");
            ObjectInputStream reader = new ObjectInputStream(fis);
            Object p = reader.readObject();
            return (ArrayList<Pengemudi>) p;
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        }
        return null;
    }
    
    public ArrayList<Pelanggan> readDaftarPesanan() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("DataPesanan.txt");
            ObjectInputStream reader = new ObjectInputStream(fis);
            Object p = reader.readObject();
            return (ArrayList<Pelanggan>) p;
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        }
        return null;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Database database = new Database();
        Aplikasi apd = new Aplikasi();
        //database.writeAkunPelanggan(database.getListUserPelanggan());
        //database.writeAkunPengemudi(database.getListUserPengemudi());
        
        database.getListUserPelanggan().add(new Pelanggan("Fikiri Zaenal","Cibaduyut"));        //Data User Pelanggan
        database.getListUserPelanggan().add(new Pelanggan("Agung Suhendar","Bojongsoang"));
        database.getListUserPelanggan().add(new Pelanggan("Ida Rodiyah","Angkrek"));
        database.getListUserPelanggan().add(new Pelanggan("Rahmansyah","Tanjungsari"));
        database.getListUserPelanggan().add(new Pelanggan("Galih Perdana","Jatihurip"));
        database.getListUserPelanggan().add(new Pelanggan("Fadhlan A.","Jatihurip"));
        database.getListUserPelanggan().add(new Pelanggan("Rafif Hilmy","Cipada"));
        database.getListUserPelanggan().add(new Pelanggan("Andi Akhmad Fauzi","Cibaduyut"));
        database.getListUserPelanggan().add(new Pelanggan("Erica Natasya","Cibaduyut"));
        database.getListUserPelanggan().add(new Pelanggan("Reno Reynaldy","Bojongsoang"));
        database.getListUserPelanggan().add(new Pelanggan("Hariz Mulya W.","Bojongsoang"));
        database.getListUserPelanggan().add(new Pelanggan("Lisanna E.","Buahbatu"));
        database.getListUserPelanggan().add(new Pelanggan("Eqi Syahputra","Dago"));
        
        database.getListUserPengemudi().add(new Pengemudi("Alfy","Jupiter x"));                 //Data User Pengemudi
        database.getListUserPengemudi().add(new Pengemudi("Fauzy","Honda Vario"));
        database.getListUserPengemudi().add(new Pengemudi("Alfarisy","Jupiter x"));
        database.getListUserPengemudi().add(new Pengemudi("Egi","Vixion"));
        
        apd.pilihPesan(database.getListUserPelanggan().get(0),"Ojek");                          //Data Pemesanan Ojek
        apd.isiPesan(database.getListUserPelanggan().get(0),"Cibaduyut","Dago");
        
        apd.pilihPesan(database.getListUserPelanggan().get(1),"Ojek");                          
        apd.isiPesan(database.getListUserPelanggan().get(1),"Sumedang","Telkom University");
        
        apd.pilihPesan(database.getListUserPelanggan().get(4),"Ojek");                          
        apd.isiPesan(database.getListUserPelanggan().get(4),"Tanjung Sari","Jatihurip");
        
        apd.pilihPesan(database.getListUserPelanggan().get(3),"Ojek");                          
        apd.isiPesan(database.getListUserPelanggan().get(3),"Tanjung Sari","Sumedang");
        
        apd.pilihPesan(database.getListUserPelanggan().get(6),"Ojek");                          
        apd.isiPesan(database.getListUserPelanggan().get(6),"Cipada","Cileunyi");
        
        
        
        apd.pilihPesan(database.getListUserPelanggan().get(2),"Kurir");                         //Data Pemesanan Kurir
        apd.isiPesan(database.getListUserPelanggan().get(2),"Angkrek", "Cimahi");
        apd.tambahBarang(database.getListUserPelanggan().get(2).getPesanan(),"Sepatu");
        apd.tambahBarang(database.getListUserPelanggan().get(2).getPesanan(),"Baju");
        
        apd.pilihPesan(database.getListUserPelanggan().get(10),"Kurir");
        apd.isiPesan(database.getListUserPelanggan().get(10),"Bojongsoang", "Dago");
        apd.tambahBarang(database.getListUserPelanggan().get(10).getPesanan(),"Racket");
        apd.tambahBarang(database.getListUserPelanggan().get(10).getPesanan(),"Tas");
        
        apd.pilihPesan(database.getListUserPelanggan().get(7),"Kurir");
        apd.isiPesan(database.getListUserPelanggan().get(7),"Telkom University", "Cibaduyut");
        apd.tambahBarang(database.getListUserPelanggan().get(7).getPesanan(),"Headset");
        apd.tambahBarang(database.getListUserPelanggan().get(7).getPesanan(),"Buku Tulis");
        
        
        
        
        
        database.getListPesan().add(database.getListUserPelanggan().get(0));                    //Data Pesanan Total
        database.getListPesan().add(database.getListUserPelanggan().get(1));
        database.getListPesan().add(database.getListUserPelanggan().get(4));
        database.getListPesan().add(database.getListUserPelanggan().get(7));
        database.getListPesan().add(database.getListUserPelanggan().get(2));
        database.getListPesan().add(database.getListUserPelanggan().get(10));
        database.getListPesan().add(database.getListUserPelanggan().get(3));
        database.getListPesan().add(database.getListUserPelanggan().get(6));
        
        database.writeDaftarPesanan(database.getListPesan());
        database.writeAkunPelanggan(database.getListUserPelanggan());
        database.writeAkunPengemudi(database.getListUserPengemudi());
    }  
}
