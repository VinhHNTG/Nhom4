/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class QuanLyHoaDon {
        private String maHD;      // Mã hóa đơn (PK)
    private String maNV;      // Mã nhân viên (FK)
    private String ngayDat;   // Ngày đặt (as String or LocalDate)
    private double tongTien;  // Tổng tiền
    private int soLuong;      // Số lượng
    private String size;      // Size
    private String maKH;      // Mã khách hàng (FK)
    private String trangThai; 

    public QuanLyHoaDon() {
    }

    public QuanLyHoaDon(String maHD, String maNV, String ngayDat, double tongTien, int soLuong, String size, String maKH, String trangThai) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.soLuong = soLuong;
        this.size = size;
        this.maKH = maKH;
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
