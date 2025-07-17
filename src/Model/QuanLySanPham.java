/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class QuanLySanPham {
       private String maSP;       // Mã sản phẩm (PK)
    private String tenSP;      // Tên sản phẩm
    private double giaTien;    // Giá tiền
    private Date ngayDatHang; 

    public QuanLySanPham() {
    }

    public QuanLySanPham(String maSP, String tenSP, double giaTien, Date ngayDatHang) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaTien = giaTien;
        this.ngayDatHang = ngayDatHang;
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

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    
}
