/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
/**
 *
 * @author ACER
 */
public class modelQLSP {
    String maSP;
    String tenSP;
    String giatien;
    Date Ngaydathang;

    public modelQLSP() {
    }

    public modelQLSP(String maSP, String tenSP, String giatien, Date Ngaydathang) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giatien = giatien;
        this.Ngaydathang = Ngaydathang;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public Date getNgaydathang() {
        return Ngaydathang;
    }

    public void setNgaydathang(Date Ngaydathang) {
        this.Ngaydathang = Ngaydathang;
    }
    
}
