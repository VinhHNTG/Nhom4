/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DAO.QLHDDAO;
import Model.QuanLyHoaDon;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLHD extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    QLHDDAO hdDao = new QLHDDAO();

    /**
     * Creates new form QLHD
     */
    public QLHD() {
        initComponents();
        fillTable();
        initTable();
    }

    public void initTable() {
        String[] cols = new String[]{"Mã HĐ", "Mã NV", "Ngày đặt", "Tổng Tiền", "Số lượng", "Size", "Mã KH", "Trạng Thái"};
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(cols);
        jTable3.setModel(tableModel);
    }

    public void fillTable() {
        tableModel.setRowCount(0);
        for (QuanLyHoaDon hd : hdDao.getAll()) {
            tableModel.addRow(hdDao.getRow(hd));
        }
    }

    private boolean validateForm() {
        if (txtMaHD.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hóa đơn.");
            return false;
        }
        if (txtmaNV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên.");
            return false;
        }
        if (txtNgayDat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày đặt.");
            return false;
        }
        try {
            // Định dạng ngày nhập vào
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ngayDat = LocalDate.parse(txtNgayDat.getText().trim(), formatter);
            LocalDate today = LocalDate.now();
            LocalDate oneYearAgo = today.minusYears(1);

            if (ngayDat.isAfter(today)) {
                JOptionPane.showMessageDialog(this, "Ngày đặt không được là ngày trong tương lai.");
                return false;
            }

            if (ngayDat.isBefore(oneYearAgo)) {
                JOptionPane.showMessageDialog(this, "Ngày đặt không được quá 1 năm trước.");
                return false;
            }

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày đặt không đúng định dạng. Định dạng đúng: yyyy-MM-dd");
            return false;
        }
        if (txtTongTien.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá tiền.");
            return false;
        }
        try {
            double gia = Double.parseDouble(txtTongTien.getText().trim());
            if (gia <= 0) {
                JOptionPane.showMessageDialog(this, "Giá tiền phải lớn hơn 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá tiền phải là số hợp lệ.");
            return false;
        }
        if (txtSoluong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng.");
            return false;
        }
        try {
            int soluong = Integer.parseInt(txtSoluong.getText().trim());
            if (soluong <= 0) {
                JOptionPane.showMessageDialog(this, "số lượng phải lớn hơn 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số hợp lệ.");
            return false;
        }
        if (txtMaKH.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng.");
            return false;
        }
        if (!rboChuaThanhToan.isSelected() && !rboDaThanhToan.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái");
            return true;
        }
        return true;
    }

    public void add() {
        String maHD = txtMaHD.getText();
        String maNV = txtmaNV.getText();
        String ngayDat = txtNgayDat.getText();
        double tongTien = Double.parseDouble(txtTongTien.getText());
        int soLuong = Integer.parseInt(txtSoluong.getText());
        String size = (String) CBBSize.getSelectedItem();
        String maKH = txtMaKH.getText();
        String trangThai = null;
        if (rboChuaThanhToan.isSelected()) {
            trangThai = "Đã Thanh Toán";
        } else if (rboChuaThanhToan.isSelected()) {
            trangThai = "Chưa Thanh Toán";
        }
        QuanLyHoaDon hd = new QuanLyHoaDon(maHD, maNV, ngayDat, tongTien, soLuong, size, maKH, trangThai);
        if (hdDao.addHD(hd) == 1) {
            fillTable();
            JOptionPane.showMessageDialog(this, "Nhap thanh cong");
        } else {
            JOptionPane.showMessageDialog(this, "Loi!");
        }

    }

    public void Update() {
        int i = jTable3.getSelectedRow();
        if (i != -1) {
            String maHD = txtMaHD.getText();
            String maNV = txtmaNV.getText();
            String ngayDat = txtNgayDat.getText();
            double tongTien = Double.parseDouble(txtTongTien.getText());
            int soLuong = Integer.parseInt(txtSoluong.getText());
            String size = (String) CBBSize.getSelectedItem();
            String maKH = txtMaKH.getText();
            String trangThai = null;
            if (rboChuaThanhToan.isSelected()) {
                trangThai = "Đã Thanh Toán";
            } else if (rboChuaThanhToan.isSelected()) {
                trangThai = "Chưa Thanh Toán";
            }
            QuanLyHoaDon hd = new QuanLyHoaDon(maHD, maNV, ngayDat, tongTien, soLuong, size, maKH, trangThai);

            if (hdDao.editHD(hd) == 1) {
                JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
                fillTable();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa dữ liệu thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui long chon 1 hang de sua");
        }
    }

    public void deleteHD() {
        String maHD = txtMaHD.getText();
        String maNV = txtmaNV.getText();
        String ngayDat = txtNgayDat.getText();
        double tongTien = Double.parseDouble(txtTongTien.getText());
        int soLuong = Integer.parseInt(txtSoluong.getText());
        String size = (String) CBBSize.getSelectedItem();
        String maKH = txtMaKH.getText();
        String trangThai = null;
        if (rboChuaThanhToan.isSelected()) {
            trangThai = "Đã Thanh Toán";
        } else if (rboChuaThanhToan.isSelected()) {
            trangThai = "Chưa Thanh Toán";
        }
        QuanLyHoaDon hd = new QuanLyHoaDon(maHD, maNV, ngayDat, tongTien, soLuong, size, maKH, trangThai);

        if (hdDao.deleteHD(hd) == 1) {
            fillTable();
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm mới thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TrangThai = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtNgayDat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CBBSize = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rboDaThanhToan = new javax.swing.JRadioButton();
        rboChuaThanhToan = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtmaNV = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập Thông Tin"));

        jLabel2.setText("Mã hóa đơn:");

        jLabel3.setText("Ngày đặt:");

        jLabel4.setText("Tổng tiền:");

        jLabel5.setText("Số Lượng:");

        jLabel6.setText("Size:");

        CBBSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "X", "XL" }));
        CBBSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBBSizeActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã khách hàng:");

        jLabel8.setText("Trạng Thái:");

        TrangThai.add(rboDaThanhToan);
        rboDaThanhToan.setText("Đã Thanh Toán");
        rboDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rboDaThanhToanActionPerformed(evt);
            }
        });

        TrangThai.add(rboChuaThanhToan);
        rboChuaThanhToan.setText("Chưa Thanh Toán");

        jLabel9.setText("Mã nhân viên:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaKH)
                    .addComponent(txtSoluong)
                    .addComponent(txtTongTien)
                    .addComponent(txtNgayDat)
                    .addComponent(txtMaHD)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rboDaThanhToan)
                            .addComponent(CBBSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rboChuaThanhToan)
                            .addComponent(txtmaNV))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CBBSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rboDaThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rboChuaThanhToan)
                .addGap(27, 27, 27))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn chức năng"));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-26.png"))); // NOI18N
        btnThem.setText("Add");

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-update-26.png"))); // NOI18N
        btnSua.setText("UpDate");

        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-26.png"))); // NOI18N
        btnSua1.setText("Delete");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý hóa đơn");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảng hóa đơn"));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rboDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rboDaThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rboDaThanhToanActionPerformed

    private void CBBSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBBSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBBSizeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBBSize;
    private javax.swing.ButtonGroup TrangThai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JRadioButton rboChuaThanhToan;
    private javax.swing.JRadioButton rboDaThanhToan;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgayDat;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtmaNV;
    // End of variables declaration//GEN-END:variables
}
