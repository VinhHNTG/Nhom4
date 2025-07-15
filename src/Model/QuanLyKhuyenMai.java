/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class QuanLyKhuyenMai {
   private String maKM;        // Mã khuyến mãi (PK)
    private String tenKM;       // Tên khuyến mãi
    private String moTa;        // Mô tả
    private String ngayBatDau;  // Ngày bắt đầu (consider using LocalDate)
    private String ngayKetThuc; // 

    public QuanLyKhuyenMai() {
    }

    public QuanLyKhuyenMai(String maKM, String tenKM, String moTa, String ngayBatDau, String ngayKetThuc) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
    
}
