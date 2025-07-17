/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Service.DBconnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.QuanLyHoaDonCT;
import java.sql.PreparedStatement;

/**
 *
 * @author Admin
 */
public class HDCTDao {

    public List<QuanLyHoaDonCT> getAll() {
        List<QuanLyHoaDonCT> list = new ArrayList<>();
        String sql = "select * from ChiTietHoaDon";
        try {
            Connection con = DBconnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int maCTHD = rs.getInt(1);
                int maHD = rs.getInt(2);
                int maSP = rs.getInt(3);
                double donGia = rs.getDouble(4);
                String trangThai = rs.getString(5);

                QuanLyHoaDonCT hd = new QuanLyHoaDonCT(maCTHD, maHD, maSP, donGia, trangThai);
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Object[] getRow(QuanLyHoaDonCT hd) {
        int maHDCT = hd.getMaCTHD();
                int maHD = hd.getMaHD();
                int maSP = hd.getMaSP();
                double dongia = hd.getDonGia();
                String trangthai = hd.getTrangThai();

        return new Object[]{maHDCT, maHD, maSP,dongia,trangthai};
    }
    
    public int addHDCT(QuanLyHoaDonCT hdct) {
        String sql = "insert into ChiTietHoaDon(MaCTHD, MaHD, MaSP, DonGia, TrangThai) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, hdct.getMaCTHD());
            pstm.setInt(2, hdct.getMaHD());
            pstm.setInt(3, hdct.getMaSP());
            pstm.setDouble(4, hdct.getDonGia());
            pstm.setString(5, hdct.getTrangThai());

            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
     public int editHDCT(QuanLyHoaDonCT hdct) {
        String sql = "UPDATE ChiTietHoaDon SET  MaHD = ?, MaSP = ?, DonGia = ?, TrangThai = ?, WHERE MaCTHD = ?";
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, hdct.getMaCTHD());
            pstm.setInt(2, hdct.getMaHD());
            pstm.setInt(3, hdct.getMaSP());
            pstm.setDouble(4, hdct.getDonGia());
            pstm.setString(5, hdct.getTrangThai());

            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

     public int deleteHDCT(QuanLyHoaDonCT cthd) {
        String sql = "delete from ChiTietHoaDon where MaHDCT = ?";
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, cthd.getMaCTHD());

            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
