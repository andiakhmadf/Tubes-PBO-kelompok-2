/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import Model.Aplikasi;
import Database.Database;
import Model.*;

/**
 *
 * @author AGUNG
 */
public class Controller implements ActionListener{
    private Aplikasi app;
    private LoginPelanggan vwLoginPelanggan;
    private MenuUtamaPelanggan vwMenuPelanggan;
    private Profil vwEditProfil;
    private PesanKurir vwPesanKurir;
    private PesanOjek vwPesanOjek;
    private ViewBarang vwListBarang;
    private StatusPesanan vwStatusPesanan;
    private DetailPesanan vwDetailPesanan;
    private MenuLogin vwMenuLogin;
    private PengemudiMenuUtama vwPengemudiMenuUtama;
    private LoginPengemudi vwLoginPengemudi;
    //private Database database;
    //private ArrayList<Pelanggan> listPesan;
    //private ArrayList<Pelanggan> listUserPelanggan;
    //private ArrayList<Pengemudi> listUserPengemudi;
    //private Pelanggan pelanggan;
    private Pengemudi pengemudi;
    private int onLogin; // 0 = Pelanggan, 1 = Pengemudi
    
    
    private int uC;   //Indeks Pelanggan yang sedang login
    private int uR;   //Indeks Pengemudi yang sedang login
    private String username;
    private String password = "tubes";
    
    public Controller() throws IOException, ClassNotFoundException{
        app = new Aplikasi();
        //database = new Database();
        //listPesan = new ArrayList<Pelanggan>();
        //listUserPelanggan = new ArrayList<Pelanggan>();
        //listUserPengemudi = new ArrayList<Pengemudi>(); 
        
        vwLoginPelanggan = new LoginPelanggan();
        vwMenuPelanggan = new MenuUtamaPelanggan();
        vwEditProfil = new Profil();
        vwPesanKurir = new PesanKurir();
        vwPesanOjek = new PesanOjek();
        vwListBarang = new ViewBarang();
        vwStatusPesanan = new StatusPesanan();
        vwDetailPesanan = new DetailPesanan();
        vwMenuLogin = new MenuLogin();
        vwPengemudiMenuUtama = new PengemudiMenuUtama();
        vwLoginPengemudi = new LoginPengemudi();
        
        vwLoginPelanggan.addListener(this);
        vwMenuPelanggan.addListener(this);
        vwEditProfil.addListener(this);
        vwPesanKurir.addListener(this);
        vwPesanOjek.addListener(this);
        vwListBarang.addListener(this);
        vwStatusPesanan.addListener(this);
        vwDetailPesanan.addListener(this);
        vwMenuLogin.addListener(this);
        vwPengemudiMenuUtama.addListener(this);
        vwLoginPengemudi.addListener(this);
        
        //listUserPelanggan = database.readAkunPelanggan();
        //listUserPengemudi = database.readAkunPengemudi();
        //listPesan = database.readDaftarPesanan();
        
        vwMenuLogin.setVisible(true);
    }
    
    public int cekAkun(String username){
        int x = -1;
        for(int i=0; i<app.getListUserPelanggan().size(); i++){
            if (app.getListUserPelanggan().get(i).getNama().equals(username)){
                x = i;
            }
        } return x;
    }
    
    public int cekPesananOnListPesanan(String username){
        int x = 0;
        for(int i=0; i<app.getListPesan().size(); i++){
            if (app.getListPesan().get(i).getNama().equals(username)){
                x = i;
            }
        } return x;
    }
    
    public int cekPesananOnPengemudi(String username){
        int x = 0;
        for(int i=0; i<app.getListUserPengemudi().size(); i++){
            if (app.getListUserPengemudi().get(i).getPesanan() != null) {
                if (app.getListUserPengemudi().get(i).getPesanan().getNama().equals(username)) {
                    x = i;
                }
            }
        } return x;
    }
    
    public int pesananToIndex(Pelanggan p){
        int x = 0;
        if (p.getPesanan() != null) {
            for (int i = 0; i < app.getListPesan().size(); i++) {
                if (app.getListPesan().get(i).getNama().equals(p.getNama())) {
                    x = i;
                }
            }
        }
         return x;
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        try{
        
  //====================================================================== 
 //============================CONTROLLER PELANGGAN=======================        
  //====================================================================== 
            
            
            if (source.equals(vwLoginPelanggan.getBtnLogin())) {                
                //if(a.equals(a1)){
                                                                                //Frame Login Pelanggan
                        username = vwLoginPelanggan.getTfUsernamePelanggan();
                        int g = cekAkun(username);
                        onLogin = 0;
                        
                        vwLoginPelanggan.setVisible(false);             
                        vwMenuPelanggan.setVisible(true);
                        uC = 4;
                        
                        app.getListUserPelanggan().get(uC);
                        vwMenuPelanggan.setTfNama(app.getListUserPelanggan().get(uC).getNama());
                        
                    
                //if(a == b){
                //vwLoginPelanggan.setVisible(false);
                //vwMenuPelanggan.setVisible(true);
               // }
            } 
            
            //====================================================================== 
            
            else if (source.equals(vwMenuPelanggan.getBtnEdit())) {
                vwMenuPelanggan.setVisible(false);
                vwEditProfil.setVisible(true);
                vwEditProfil.setTfNama(app.getListUserPelanggan().get(uC).getNama());
                vwEditProfil.setTfAlamat(app.getListUserPelanggan().get(uC).getAlamat());
            } else if (source.equals(vwEditProfil.getBtnBack())) {              //Frame Edit Profil Pelanggan
                    vwEditProfil.setVisible(false);
                    vwMenuPelanggan.setVisible(true);
            } else if (source.equals(vwEditProfil.getBtnSave())) {
                    vwEditProfil.setVisible(false);
                    vwMenuPelanggan.setVisible(true);
                    app.editProfil(app.getListUserPelanggan().get(uC), vwEditProfil.getTfNama(), 
                            vwEditProfil.getTfAlamat());
                    vwMenuPelanggan.setTfNama(app.getListUserPelanggan().get(uC).getNama());
            } 
            
            //====================================================================== 
            
            else if (source.equals(vwMenuPelanggan.getBtnRiderOrder())) {
                vwMenuPelanggan.setVisible(false);
                vwPesanOjek.setVisible(true);
                vwPesanOjek.setTfLokasi("");
                vwPesanOjek.setTfTujuan("");
            } else if (source.equals(vwPesanOjek.getBtnSend())){                //Frame Pesan Ojek Pelanggan
                   
                    vwMenuPelanggan.setVisible(true);
                    vwPesanOjek.setVisible(false);
                    app.pilihPesan(app.getListUserPelanggan().get(uC),"Ojek");
                    app.isiPesan(app.getListUserPelanggan().get(uC),vwPesanOjek.getTfLokasi(),
                            vwPesanOjek.getTfTujuan());
                    app.kirimPesan(app.getListUserPelanggan().get(uC));
                    
                   JOptionPane.showMessageDialog(vwPesanOjek, "Pesan Terkirim");
            } else if (source.equals(vwPesanOjek.getBtnBack())){
                    vwMenuPelanggan.setVisible(true);
                    vwPesanOjek.setVisible(false);
            }
            
            //====================================================================== 
            
            else if (source.equals(vwMenuPelanggan.getBtnKurirOrder())) {
                vwMenuPelanggan.setVisible(false);
                vwPesanKurir.setVisible(true);  
                vwPesanKurir.setTfLokasi("");
                vwPesanKurir.setTfTujuan("");
                vwPesanKurir.setTfNamaBarang("");
                app.pilihPesan(app.getListUserPelanggan().get(uC),"Kurir");
                vwListBarang.setListItem(app.getListUserPelanggan().get(uC).getPesanan().getListBarang());
                
            } else if (source.equals(vwPesanKurir.getBtnSend())){
                    vwMenuPelanggan.setVisible(true);                           //Frame Pesan Kurir Pelanggan
                    vwPesanKurir.setVisible(false);
                    app.isiPesan(app.getListUserPelanggan().get(uC),vwPesanKurir.getTfLokasi(),
                            vwPesanKurir.getTfTujuan());
                    app.kirimPesan(app.getListUserPelanggan().get(uC));
                    JOptionPane.showMessageDialog(vwPesanOjek, "Pesan Terkirim");
                    
            } else if (source.equals(vwPesanKurir.getBtnBack())){
                    vwMenuPelanggan.setVisible(true);
                    vwPesanKurir.setVisible(false);
                    app.getListUserPelanggan().get(uC).removePesanan();
                    
            } else if (source.equals(vwPesanKurir.getBtnAdd())){
                    String a = vwPesanKurir.getTfNamaBarang();
                    if (a!=""){
                        app.tambahBarang(app.getListUserPelanggan().get(uC).getPesanan(), a);
                    }
                    if (app.getListUserPelanggan().get(uC).getPesanan().getJumlahBarang() != 0){  
                        vwListBarang.setListItem(app.getListUserPelanggan().get(uC).getPesanan().getListBarang());
                    }
                    vwPesanKurir.setTfNamaBarang("");
            //====================================================================== 
                
            } else if (source.equals(vwPesanKurir.getBtnView())){
                    vwListBarang.setVisible(true);
                    vwPesanKurir.setVisible(false);                             //Frame List Barang Pelanggan
            } else if (source.equals(vwListBarang.getBtnAdd())){
                        String b = vwListBarang.getTfNamaBarang();
                        if (b!=""){
                            app.tambahBarang(app.getListUserPelanggan().get(uC).getPesanan(), b);
                        }
                        if (app.getListUserPelanggan().get(uC).getPesanan().getJumlahBarang() != 0){  
                            vwListBarang.setListItem(app.getListUserPelanggan().get(uC).getPesanan().getListBarang());
                        }
                        vwListBarang.setTfNamaBarang("");
            } else if (source.equals(vwListBarang.getBtnBack())){
                        vwListBarang.setVisible(false);
                        vwPesanKurir.setVisible(true);
                        vwListBarang.setTfNamaBarang("");
            } else if (source.equals(vwListBarang.getBtnRemove())){
                        int selected = vwListBarang.getSelectedBarang();
                        app.removeBarang(app.getListUserPelanggan().get(uC).getPesanan(), selected+1);
                        vwListBarang.setListItem(app.getListUserPelanggan().get(uC).getPesanan().getListBarang());
            }
            
           //====================================================================== 
            
            else if (source.equals(vwMenuPelanggan.getBtnStatus())){
                        vwMenuPelanggan.setVisible(false);
                        vwStatusPesanan.setVisible(true);                                   //Frame Status Pesanan
                        vwStatusPesanan.setTfStatus("");
                        vwStatusPesanan.setTfKendaraan("");
                        vwStatusPesanan.setTfPenerima("");
                        
                            if (app.getListUserPelanggan().get(uC).getPesanan()==null){
                                vwStatusPesanan.setTfStatus("Belum memesan");
                            } else if (cekPesananOnListPesanan(app.getListUserPelanggan().get(uC).getNama())!=0){
                                vwStatusPesanan.setTfStatus("Menunggu Diterima");
                            } else if (cekPesananOnPengemudi(app.getListUserPelanggan().get(uC).getNama())!=0){
                                int z = cekPesananOnPengemudi(app.getListUserPelanggan().get(uC).getNama());
                                vwStatusPesanan.setTfStatus("Pesanan Diterima");
                                vwStatusPesanan.setTfPenerima(app.getListUserPengemudi().get(z).
                                        getNama());
                                vwStatusPesanan.setTfKendaraan(app.getListUserPengemudi().get(z).
                                        getKendaraan());
                            }
                        
            } else if (source.equals(vwStatusPesanan.getBtnView())){
                            vwStatusPesanan.setVisible(false);
                            vwDetailPesanan.setVisible(true);
                            if(app.getListUserPelanggan().get(uC).getPesanan()==null){
                                JOptionPane.showMessageDialog(vwDetailPesanan, "Belum ada Pesanan");
                            } else {
                                vwDetailPesanan.setTfCostumer(app.getListUserPelanggan().get(uC).getNama());
                                vwDetailPesanan.setTfLokasi(app.getListUserPelanggan().
                                        get(uC).getPesanan().getAlamatPemesan());
                                vwDetailPesanan.setTfTujuan(app.getListUserPelanggan().
                                        get(uC).getPesanan().getAlamatTujuan());
                                vwDetailPesanan.setTfTipe(app.getListUserPelanggan().
                                        get(uC).getPesanan().getTipePesanan());
                                if(app.getListUserPelanggan().get(uC).getPesanan().
                                        getTipePesanan().equals("Kurir")){
                                    
                                    int c = pesananToIndex(app.getListUserPelanggan().get(uC));
                                    System.out.println(c);
                                    vwDetailPesanan.setListBarang(app.getListPesan().get(c)
                                            .getPesanan().getListBarang());
                                }
                            }
                            
                            
            } else if (source.equals(vwStatusPesanan.getBtnBack())){
                            vwStatusPesanan.setVisible(false);
                            vwMenuPelanggan.setVisible(true);
                            
            } else if (source.equals(vwDetailPesanan.getBtnBack())){
                        if (onLogin == 0){
                            vwStatusPesanan.setVisible(true);
                            vwDetailPesanan.setVisible(false);
                        } else{
                            vwPengemudiMenuUtama.setVisible(true);
                            vwDetailPesanan.setVisible(false);
                        }
            } 
            
            
           //====================================================================== 
            
            else if (source.equals(vwMenuPelanggan.getBtnLogout())){
                vwMenuPelanggan.setVisible(false);
                vwMenuLogin.setVisible(true);
            }
            
            
        //======================================================================        
        //======================================================================
            
        //====================================================================== 
        //========================CONTROLLER PENGEMUDI==========================        
        //======================================================================
            
            else if (source.equals(vwLoginPengemudi.getBtnLoginPengemudi())){
                vwPengemudiMenuUtama.setVisible(true);
                vwLoginPengemudi.setVisible(false);
                uR = 2;
                vwPengemudiMenuUtama.setTfDriverNama(app.getListUserPengemudi().get(uR).getNama());
                vwPengemudiMenuUtama.setListPesanan(app.lihatDaftarPesanGui());
                onLogin = 1;
            }
            else if(source.equals(vwPengemudiMenuUtama.getBtnView())){
               int s = vwPengemudiMenuUtama.getSelectedPesanan();
               vwDetailPesanan.setVisible(true);
               vwPengemudiMenuUtama.setVisible(false);
                vwDetailPesanan.setTfCostumer(app.getListPesan().get(s).getNama());
                vwDetailPesanan.setTfLokasi(app.getListPesan().
                        get(s).getPesanan().getAlamatPemesan());
                vwDetailPesanan.setTfTujuan(app.getListPesan().
                        get(s).getPesanan().getAlamatTujuan());
                vwDetailPesanan.setTfTipe(app.getListPesan().
                        get(s).getPesanan().getTipePesanan());
                if (app.getListPesan().get(s).getPesanan().
                        getTipePesanan().equals("Kurir")) {

                    vwDetailPesanan.setListBarang(app.getListPesan().get(s)
                            .getPesanan().getListBarang());
                }
            }
            else if(source.equals(vwPengemudiMenuUtama.getBtnGet())){
                int s = vwPengemudiMenuUtama.getSelectedPesanan();
                app.ambilPesanan(app.getListUserPengemudi().get(uR),s+1);
                vwPengemudiMenuUtama.setListPesanan(app.lihatDaftarPesanGui());
            }
            else if (source.equals(vwPengemudiMenuUtama.getBtnLogoutPengemudi())){
                vwPengemudiMenuUtama.setVisible(false);
                vwMenuLogin.setVisible(true);
            }
            
            
            
            
            
        //======================================================================        
        //====================================================================== 
            else if (source.equals(vwMenuLogin.getBtnPelanggan())){
                vwMenuLogin.setVisible(false);
                vwLoginPelanggan.setVisible(true);
            }
            
            else if (source.equals(vwMenuLogin.getBtnPengemudi())){
                vwMenuLogin.setVisible(false);
                vwLoginPengemudi.setVisible(true);
            }
            
            
            
        //======================================================================        
        //====================================================================== 
            
       } catch(Exception e){
           JOptionPane.showMessageDialog(vwLoginPelanggan, "Salah");
       }
    }
}
