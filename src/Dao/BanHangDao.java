/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.QuanLyHoaDon;
import Model.QuanLySanPham;
import Service.DBconnect;
import Service.DBconnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class BanHangDao {

    public List<QuanLySanPham> getAllSP() {
        List<QuanLySanPham> listSP = new ArrayList<>();
        String sql = "SELECT * FROM SANPHAM";
        try {
            Connection con = DBconnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString(1);
                String tenSP = rs.getString(2);
                double giaTien = rs.getDouble(3);
                Date ngayDatHang = rs.getDate(4);

                QuanLySanPham SP = new QuanLySanPham(maSP, tenSP, giaTien, ngayDatHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public Object[] getRowSP(QuanLySanPham SP) {
        String maSP = SP.getMaSP();       // Mã sản phẩm (PK)
        String tenSP = SP.getTenSP();      // Tên sản phẩm
        double giaTien = SP.getGiaTien();    // Giá tiền
        Date ngayDatHang = SP.getNgayDatHang();
        return new Object[]{maSP,tenSP,giaTien,ngayDatHang};
    }

}
