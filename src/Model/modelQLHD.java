/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Date;

/**
 *
 * @author ACER
 */
public class modelQLHD {
    String maHD;
    String maNV;
    Date ngaydat;
    String tongtien;
    int soluong;
    String size;
    String maKH;
    String trangthai;

    public modelQLHD() {
    }

    public modelQLHD(String maHD, String maNV, Date ngaydat, String tongtien, int soluong, String size, String maKH, String trangthai) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.ngaydat = ngaydat;
        this.tongtien = tongtien;
        this.soluong = soluong;
        this.size = size;
        this.maKH = maKH;
        this.trangthai = trangthai;
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

    public Date getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(Date ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
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

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
}
