/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Service.DBConnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ChiTietHoaDon;
import java.sql.PreparedStatement;

/**
 *
 * @author Admin
 */
public class HDCTDao {

    public List<ChiTietHoaDon> getAll() {
        List<ChiTietHoaDon> list = new ArrayList<>();
        String sql = "select * from ChiTietHoaDon";
        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int maCTHD = rs.getInt(1);
                int maHD = rs.getInt(2);
                int maSP = rs.getInt(3);
                int sl = rs.getInt(4);
                String ghichu = rs.getString(5);
                double donGia = rs.getDouble(6);
                String trangThai = rs.getString(7);

                ChiTietHoaDon hd = new ChiTietHoaDon( maCTHD, maHD, maSP, sl, ghichu, donGia, trangThai);
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Object[] getRow(ChiTietHoaDon hd) {
        int maHDCT = hd.getMaCTHD();
                int maHD = hd.getMaHD();
                int maSP = hd.getMaSP();
                String ghichu = hd.getGhichu();
                double dongia = hd.getDonGia();
                String trangthai = hd.getTrangThai();

        return new Object[]{maHDCT, maHD, maSP, ghichu, dongia,trangthai};
    }
    
    public int addHDCT(ChiTietHoaDon hdct) {
        String sql = "insert into ChiTietHoaDon(MaCTHD, MaHD, MaSP, Sl, GhiChu, DonGia, TrangThai) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, hdct.getMaCTHD());
            pstm.setInt(2, hdct.getMaHD());
            pstm.setInt(3, hdct.getMaSP());
            pstm.setInt(4, hdct.getSl());
            pstm.setString(5, hdct.getGhichu());
            pstm.setDouble(6, hdct.getDonGia());
            pstm.setString(7, hdct.getTrangThai());

            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
     public int editHDCT(ChiTietHoaDon hdct) {
        String sql = "UPDATE ChiTietHoaDon SET  MaHD = ?, MaSP = ?, Sl = ?,  GhiChu = ?, DonGia = ?, TrangThai = ?, WHERE MaCTHD = ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, hdct.getMaCTHD());
            pstm.setInt(2, hdct.getMaHD());
            pstm.setInt(3, hdct.getMaSP());
            pstm.setInt(4, hdct.getSl());
            pstm.setString(5, hdct.getGhichu());
            pstm.setDouble(6, hdct.getDonGia());
            pstm.setString(7, hdct.getTrangThai());

            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

     public int deleteHDCT(ChiTietHoaDon cthd) {
        String sql = "delete from ChiTietHoaDon where MaHDCT = ?";
        try {
            Connection con = DBConnect.getConnection();
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
