/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public class modelQLHDCT {
    String maQLHDCT;
    String maHD;
    String maSP;
    String dongia;
    String trangthai;
    
    public modelQLHDCT() {
    }
    
    public modelQLHDCT(String maQLHDCT, String maHD, String maSP, String dongia, String trangthai) {
        this.maQLHDCT = maQLHDCT;
        this.maHD = maHD;
        this.maSP = maSP;
        this.dongia = dongia;
        this.trangthai = trangthai;
    }

    public String getMaQLHDCT() {
        return maQLHDCT;
    }

    public void setMaQLHDCT(String maQLHDCT) {
        this.maQLHDCT = maQLHDCT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
}
