/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public class modelTopping {
    String maTopping;
    String tenTopping;
    int soluong;
    String giatien;
    String trangthai;
    String maDM;

    public modelTopping() {
    }

    public modelTopping(String maTopping, String tenTopping, int soluong, String giatien, String trangthai, String maDM) {
        this.maTopping = maTopping;
        this.tenTopping = tenTopping;
        this.soluong = soluong;
        this.giatien = giatien;
        this.trangthai = trangthai;
        this.maDM = maDM;
    }

    public String getMaTopping() {
        return maTopping;
    }

    public void setMaTopping(String maTopping) {
        this.maTopping = maTopping;
    }

    public String getTenTopping() {
        return tenTopping;
    }

    public void setTenTopping(String tenTopping) {
        this.tenTopping = tenTopping;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }
    
}
