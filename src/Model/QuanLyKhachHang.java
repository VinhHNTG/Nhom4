/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class QuanLyKhachHang {
      private String maKH;     // Mã khách hàng (PK)
    private String tenKH;    // Tên khách hàng
    private String sdt;      // Số điện thoại
    private String diaChi;

    public QuanLyKhachHang() {
    }

    public QuanLyKhachHang(String maKH, String tenKH, String sdt, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
}
