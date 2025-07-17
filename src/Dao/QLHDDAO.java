/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.QuanLyHoaDon;
import Service.DBconnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class QLHDDAO {

    public List<QuanLyHoaDon> getAll() {
        List<QuanLyHoaDon> listHD = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try {
            Connection con = DBconnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maHoaDon = rs.getString(1);
                String maNV = rs.getString(2);
                String ngaydat = rs.getString(3);
                Double tongtien = rs.getDouble(4);
                int soluong = rs.getInt(5);
                String size = rs.getString(6);
                String maKH = rs.getString(7);
                String trangthai = rs.getString(8);

                QuanLyHoaDon hd = new QuanLyHoaDon(maHoaDon, maNV, ngaydat, tongtien, soluong, size, maKH, trangthai);
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public Object[] getRow(QuanLyHoaDon hd) {
        String maHoaDon = hd.getMaHD();
        String maNV = hd.getMaNV();
        String ngaydat = hd.getNgayDat();
        Double tongtien = hd.getTongTien();
        int soluong = hd.getSoLuong();
        String size = hd.getSize();
        String maKH = hd.getMaKH();
        String trangthai = hd.getTrangThai();

        return new Object[]{maHoaDon, maNV, ngaydat, tongtien, soluong, size, maKH, trangthai};
    }

    public int addHD(QuanLyHoaDon hd) {
        String sql = "insert into HoaDon(MaHD, MaNV, NgayDat, TongTien, SoLuong, Size, MaKH, TrangThai) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, hd.getMaHD());
            pstm.setString(2, hd.getMaNV());
            LocalDate localDate = LocalDate.parse(hd.getNgayDat(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
            pstm.setDate(3, sqlDate);
            pstm.setDouble(4, hd.getTongTien());
            pstm.setInt(5, hd.getSoLuong());
            pstm.setString(6, hd.getSize());
            pstm.setString(7, hd.getMaKH());
            pstm.setString(8, hd.getTrangThai());

            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int editHD(QuanLyHoaDon hd) {
        String sql = "UPDATE HoaDon SET MaHD = ?, MaNV = ?, NgayDat = ?, TongTien = ?, SoLuong = ?, Size = ?, MaKH = ?, TrangThai = ? WHERE MaHD = ?";
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, hd.getMaHD());
            pstm.setString(2, hd.getMaNV());
            pstm.setString(3, hd.getNgayDat());
            pstm.setDouble(4, hd.getTongTien());
            pstm.setInt(5, hd.getSoLuong());
            pstm.setString(6, hd.getSize());
            pstm.setString(7, hd.getMaKH());
            pstm.setString(8, hd.getTrangThai());

            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteHD(QuanLyHoaDon hd) {
        String sql = "delete from HoaDon where MaHD = ?";
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, hd.getMaHD());

            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
