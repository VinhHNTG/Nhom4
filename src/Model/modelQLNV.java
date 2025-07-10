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
public class modelQLNV {
    String maNV;
    String tenNV;
    Date namsinh;
    String sdt;
    String chucvu;

    public modelQLNV() {
    }

    public modelQLNV(String maNV, String tenNV, Date namsinh, String sdt, String chucvu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.namsinh = namsinh;
        this.sdt = sdt;
        this.chucvu = chucvu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(Date namsinh) {
        this.namsinh = namsinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    
}
