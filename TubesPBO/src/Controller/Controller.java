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
    
    String username;
    String password;
    
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
    
    
    
    public int cekAkun(Pesanan p){
        int x = 0;
        for(int i=0; i<=listPesan.size(); i++){
            if (listPesan.get(i).getPesanan().equals(p)){
                x = 1;
            }
        } return x;
    }
    
    public int cekPesananOnPengemudi(Pesanan p){
        int x = 0;
        for(int i=0; i<=listUserPengemudi.size(); i++){
            if (listUserPengemudi.get(i).getPesanan().getPesanan().equals(p)){
                x = 1;
            }
        } return x;
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
                        pelanggan = listUserPelanggan.get(4);
                        vwMenuPelanggan.setTfNama(pelanggan.getNama());
                    
                //if(a == b){
                //vwLoginPelanggan.setVisible(false);
                //vwMenuPelanggan.setVisible(true);
               // }
            } 
            
            //====================================================================== 
            
            else if (source.equals(vwMenuPelanggan.getBtnEdit())) {
                vwMenuPelanggan.setVisible(false);
                vwEditProfil.setVisible(true);
                vwEditProfil.setTfNama(pelanggan.getNama());
                vwEditProfil.setTfAlamat(pelanggan.getAlamat());
            } else if (source.equals(vwEditProfil.getBtnBack())) {              //Frame Edit Profil Pelanggan
                    vwEditProfil.setVisible(false);
                    vwMenuPelanggan.setVisible(true);
            } else if (source.equals(vwEditProfil.getBtnSave())) {
                    vwEditProfil.setVisible(false);
                    vwMenuPelanggan.setVisible(true);
                    app.editProfil(pelanggan, vwEditProfil.getTfNama(), 
                            vwEditProfil.getTfAlamat());
                    vwMenuPelanggan.setTfNama(pelanggan.getNama());
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
                    app.pilihPesan(pelanggan,"Ojek");
                    app.isiPesan(pelanggan,vwPesanOjek.getTfLokasi(),
                            vwPesanOjek.getTfTujuan());
                    app.kirimPesan(pelanggan);
                    
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
                app.pilihPesan(pelanggan,"Kurir");
                vwListBarang.setListItem(pelanggan.getPesanan().getListBarang());
                
            } else if (source.equals(vwPesanKurir.getBtnSend())){
                    vwMenuPelanggan.setVisible(true);                           //Frame Pesan Kurir Pelanggan
                    vwPesanKurir.setVisible(false);
                    app.isiPesan(pelanggan,vwPesanKurir.getTfLokasi(),
                            vwPesanKurir.getTfTujuan());
                    app.kirimPesan(pelanggan);
                    JOptionPane.showMessageDialog(vwPesanOjek, "Pesan Terkirim");
                    
            } else if (source.equals(vwPesanKurir.getBtnBack())){
                    vwMenuPelanggan.setVisible(true);
                    vwPesanKurir.setVisible(false);
                    pelanggan.removePesanan();
                    
            } else if (source.equals(vwPesanKurir.getBtnAdd())){
                    String a = vwPesanKurir.getTfNamaBarang();
                    if (a!=""){
                        app.tambahBarang(pelanggan.getPesanan(), a);
                    }
                    if (pelanggan.getPesanan().getJumlahBarang() != 0){  
                        vwListBarang.setListItem(pelanggan.getPesanan().getListBarang());
                    }
                    vwPesanKurir.setTfNamaBarang("");
            //====================================================================== 
                
            } else if (source.equals(vwPesanKurir.getBtnView())){
                    vwListBarang.setVisible(true);
                    vwPesanKurir.setVisible(false);                             //Frame List Barang Pelanggan
            } else if (source.equals(vwListBarang.getBtnAdd())){
                        String b = vwListBarang.getTfNamaBarang();
                        if (b!=""){
                            app.tambahBarang(pelanggan.getPesanan(), b);
                        }
                        if (pelanggan.getPesanan().getJumlahBarang() != 0){  
                            vwListBarang.setListItem(pelanggan.getPesanan().getListBarang());
                        }
                        vwListBarang.setTfNamaBarang("");
            } else if (source.equals(vwListBarang.getBtnBack())){
                        vwListBarang.setVisible(false);
                        vwPesanKurir.setVisible(true);
                        vwListBarang.setTfNamaBarang("");
            } else if (source.equals(vwListBarang.getBtnRemove())){
                        int selected = vwListBarang.getSelectedBarang();
                        app.removeBarang(pelanggan.getPesanan(), selected+1);
                        vwListBarang.setListItem(pelanggan.getPesanan().getListBarang());
            }
            
           //====================================================================== 
            
            else if (source.equals(vwMenuPelanggan.getBtnStatus())){
                        vwMenuPelanggan.setVisible(false);
                        vwStatusPesanan.setVisible(true);                                   //Frame Status Pesanan
                        /*try{
                            if (cekPesananOnPengemudi(pelanggan.getPesanan())==1){
                                vwStatusPesanan.setTfStatus(pelanggan.getPesanan().
                                        getStatus(3));
                            } else if (cekAkun(pelanggan.getPesanan())==1){
                                vwStatusPesanan.setTfStatus(pelanggan.getPesanan().
                                        getStatus(2));
                            } else {
                                vwStatusPesanan.setTfStatus(pelanggan.getPesanan().
                                        getStatus(1));
                            }
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(vwStatusPesanan, "Status Pesanan Tidak Terdefinisi");
                        }*/
            } else if (source.equals(vwStatusPesanan.getBtnView())){
                            vwStatusPesanan.setVisible(false);
                            vwDetailPesanan.setVisible(true);
                            
                            
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
