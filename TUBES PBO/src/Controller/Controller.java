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
    private Database database;
    private ArrayList<Pelanggan> listPesan;
    private ArrayList<Pelanggan> listUserPelanggan;
    private ArrayList<Pengemudi> listUserPengemudi;
    private Pelanggan pelanggan;
    private Pengemudi pengemudi;
    
    private int uC;   //Indeks Pelanggan yang sedang login
    private int uR;   //Indeks Pengemudi yang sedang login
    private String username;
    private String password = "tubes";
    
    public Controller() throws IOException, ClassNotFoundException{
        app = new Aplikasi();
        database = new Database();
        listPesan = new ArrayList<Pelanggan>();
        listUserPelanggan = new ArrayList<Pelanggan>();
        listUserPengemudi = new ArrayList<Pengemudi>(); 
        
        vwLoginPelanggan = new LoginPelanggan();
        vwMenuPelanggan = new MenuUtamaPelanggan();
        vwEditProfil = new Profil();
        vwPesanKurir = new PesanKurir();
        vwPesanOjek = new PesanOjek();
        vwListBarang = new ViewBarang();
        vwStatusPesanan = new StatusPesanan();
        vwDetailPesanan = new DetailPesanan();
        
        vwLoginPelanggan.addListener(this);
        vwMenuPelanggan.addListener(this);
        vwEditProfil.addListener(this);
        vwPesanKurir.addListener(this);
        vwPesanOjek.addListener(this);
        vwListBarang.addListener(this);
        vwStatusPesanan.addListener(this);
        vwDetailPesanan.addListener(this);
        
        listUserPelanggan = database.readAkunPelanggan();
        listUserPengemudi = database.readAkunPengemudi();
        listPesan = database.readDaftarPesanan();
        
        vwLoginPelanggan.setVisible(true);
    }
    
    public int cekAkun(String username){
        int x = 0;
        for(int i=0; i<listUserPelanggan.size(); i++){
            if (listUserPelanggan.get(i).getNama().equals(username)){
                x = i;
            }
        } return x;
    }
    
    public int cekPesananOnListPesanan(String username){
        int x = 0;
        for(int i=0; i<listPesan.size(); i++){
            if (listPesan.get(i).getNama().equals(username)){
                x = i;
            }
        } return x;
    }
    
    public int cekPesananOnPengemudi(String username){
        int x = 0;
        for(int i=0; i<listUserPengemudi.size(); i++){
            if (listUserPengemudi.get(i).getPesanan().getNama().equals(username)){
                x = i;
            }
        } return x;
    }
    
    public int pesananToIndex(Pelanggan p){
        int x = 0;
        if (p.getPesanan() != null) {
            for (int i = 0; i < listPesan.size(); i++) {
                if (listPesan.get(i).getNama().equals(p.getNama())) {
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
                        vwLoginPelanggan.setVisible(false);             
                        vwMenuPelanggan.setVisible(true);
                        uC = 7;
                        uR = 2;
                        listUserPelanggan.get(uC);
                        vwMenuPelanggan.setTfNama(listUserPelanggan.get(uC).getNama());
                    
                //if(a == b){
                //vwLoginPelanggan.setVisible(false);
                //vwMenuPelanggan.setVisible(true);
               // }
            } 
            
            //====================================================================== 
            
            else if (source.equals(vwMenuPelanggan.getBtnEdit())) {
                vwMenuPelanggan.setVisible(false);
                vwEditProfil.setVisible(true);
                vwEditProfil.setTfNama(listUserPelanggan.get(uC).getNama());
                vwEditProfil.setTfAlamat(listUserPelanggan.get(uC).getAlamat());
            } else if (source.equals(vwEditProfil.getBtnBack())) {              //Frame Edit Profil Pelanggan
                    vwEditProfil.setVisible(false);
                    vwMenuPelanggan.setVisible(true);
            } else if (source.equals(vwEditProfil.getBtnSave())) {
                    vwEditProfil.setVisible(false);
                    vwMenuPelanggan.setVisible(true);
                    app.editProfil(listUserPelanggan.get(uC), vwEditProfil.getTfNama(), 
                            vwEditProfil.getTfAlamat());
                    vwMenuPelanggan.setTfNama(listUserPelanggan.get(uC).getNama());
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
                    app.pilihPesan(listUserPelanggan.get(uC),"Ojek");
                    app.isiPesan(listUserPelanggan.get(uC),vwPesanOjek.getTfLokasi(),
                            vwPesanOjek.getTfTujuan());
                    app.kirimPesan(listUserPelanggan.get(uC));
                    
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
                app.pilihPesan(listUserPelanggan.get(uC),"Kurir");
                vwListBarang.setListItem(listUserPelanggan.get(uC).getPesanan().getListBarang());
                
            } else if (source.equals(vwPesanKurir.getBtnSend())){
                    vwMenuPelanggan.setVisible(true);                           //Frame Pesan Kurir Pelanggan
                    vwPesanKurir.setVisible(false);
                    app.isiPesan(listUserPelanggan.get(uC),vwPesanKurir.getTfLokasi(),
                            vwPesanKurir.getTfTujuan());
                    app.kirimPesan(listUserPelanggan.get(uC));
                    JOptionPane.showMessageDialog(vwPesanOjek, "Pesan Terkirim");
                    
            } else if (source.equals(vwPesanKurir.getBtnBack())){
                    vwMenuPelanggan.setVisible(true);
                    vwPesanKurir.setVisible(false);
                    listUserPelanggan.get(uC).removePesanan();
                    
            } else if (source.equals(vwPesanKurir.getBtnAdd())){
                    String a = vwPesanKurir.getTfNamaBarang();
                    if (a!=""){
                        app.tambahBarang(listUserPelanggan.get(uC).getPesanan(), a);
                    }
                    if (listUserPelanggan.get(uC).getPesanan().getJumlahBarang() != 0){  
                        vwListBarang.setListItem(listUserPelanggan.get(uC).getPesanan().getListBarang());
                    }
                    vwPesanKurir.setTfNamaBarang("");
            //====================================================================== 
                
            } else if (source.equals(vwPesanKurir.getBtnView())){
                    vwListBarang.setVisible(true);
                    vwPesanKurir.setVisible(false);                             //Frame List Barang Pelanggan
            } else if (source.equals(vwListBarang.getBtnAdd())){
                        String b = vwListBarang.getTfNamaBarang();
                        if (b!=""){
                            app.tambahBarang(listUserPelanggan.get(uC).getPesanan(), b);
                        }
                        if (listUserPelanggan.get(uC).getPesanan().getJumlahBarang() != 0){  
                            vwListBarang.setListItem(listUserPelanggan.get(uC).getPesanan().getListBarang());
                        }
                        vwListBarang.setTfNamaBarang("");
            } else if (source.equals(vwListBarang.getBtnBack())){
                        vwListBarang.setVisible(false);
                        vwPesanKurir.setVisible(true);
                        vwListBarang.setTfNamaBarang("");
            } else if (source.equals(vwListBarang.getBtnRemove())){
                        int selected = vwListBarang.getSelectedBarang();
                        app.removeBarang(listUserPelanggan.get(uC).getPesanan(), selected+1);
                        vwListBarang.setListItem(listUserPelanggan.get(uC).getPesanan().getListBarang());
            }
            
           //====================================================================== 
            
            else if (source.equals(vwMenuPelanggan.getBtnStatus())){
                        vwMenuPelanggan.setVisible(false);
                        vwStatusPesanan.setVisible(true);                                   //Frame Status Pesanan
                        vwStatusPesanan.setTfStatus("");
                        vwStatusPesanan.setTfKendaraan("");
                        vwStatusPesanan.setTfPenerima("");
                        
                            if (listUserPelanggan.get(uC).getPesanan()==null){
                                vwStatusPesanan.setTfStatus("Belum memesan");
                            } else if (cekPesananOnListPesanan(listUserPelanggan.get(uC).getNama())!=0){
                                vwStatusPesanan.setTfStatus("Menunggu Diterima");
                            } else if (cekPesananOnPengemudi(listUserPelanggan.get(uC).getNama())!=0){
                                int z = cekPesananOnPengemudi(listUserPelanggan.get(uC).getNama());
                                vwStatusPesanan.setTfStatus("Pesanan Diterima");
                                vwStatusPesanan.setTfPenerima(listUserPengemudi.get(z).
                                        getNama());
                                vwStatusPesanan.setTfKendaraan(listUserPengemudi.get(z).
                                        getKendaraan());
                            }
                        
            } else if (source.equals(vwStatusPesanan.getBtnView())){
                            vwStatusPesanan.setVisible(false);
                            vwDetailPesanan.setVisible(true);
                            if(listUserPelanggan.get(uC).getPesanan()==null){
                                JOptionPane.showMessageDialog(vwDetailPesanan, "Belum ada Pesanan");
                            } else {
                                vwDetailPesanan.setTfCostumer(listUserPelanggan.get(uC).getNama());
                                vwDetailPesanan.setTfLokasi(listUserPelanggan.
                                        get(uC).getPesanan().getAlamatPemesan());
                                vwDetailPesanan.setTfTujuan(listUserPelanggan.
                                        get(uC).getPesanan().getAlamatTujuan());
                                vwDetailPesanan.setTfTipe(listUserPelanggan.
                                        get(uC).getPesanan().getTipePesanan());
                                if(listUserPelanggan.get(uC).getPesanan().
                                        getTipePesanan().equals("Kurir")){
                                    
                                    int c = pesananToIndex(listUserPelanggan.get(uC));
                                    System.out.println(c);
                                    vwDetailPesanan.setListBarang(listPesan.get(c)
                                            .getPesanan().getListBarang());
                                }
                            }
                            
                            
            } else if (source.equals(vwStatusPesanan.getBtnBack())){
                            vwStatusPesanan.setVisible(false);
                            vwMenuPelanggan.setVisible(true);
                            
            } else if (source.equals(vwDetailPesanan.getBtnBack())){
                            vwStatusPesanan.setVisible(true);
                            vwDetailPesanan.setVisible(false);
            } 
            
            
           //====================================================================== 
            
            else if (source.equals(vwMenuPelanggan.getBtnLogout())){
                vwMenuPelanggan.setVisible(false);
                vwLoginPelanggan.setVisible(true);
            }
            
            
        //======================================================================        
        //======================================================================
            
        //====================================================================== 
        //========================CONTROLLER PENGEMUDI==========================        
        //======================================================================
            
           
            
            
            
            
            
        //======================================================================        
        //====================================================================== 
       } catch(Exception e){
           JOptionPane.showMessageDialog(vwLoginPelanggan, "Salah");
       }
    }
}
