/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class QuanLyHoaDonCT {
    private int maCTHD;
    private int maHD;
    private int maSP;
    private double donGia;
    private String trangThai;

    public QuanLyHoaDonCT() {
    }

    public QuanLyHoaDonCT(int maCTHD, int maHD, int maSP, double donGia, String trangThai) {
        this.maCTHD = maCTHD;
        this.maHD = maHD;
        this.maSP = maSP;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public int getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(int maCTHD) {
        this.maCTHD = maCTHD;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}