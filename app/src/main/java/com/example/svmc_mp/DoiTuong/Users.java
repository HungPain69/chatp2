package com.example.svmc_mp.DoiTuong;

public class Users {
    private String id;
    private String username;
    private String hoTen;
    private String queQuan;
    private String ngaySinh;

    public Users() {
    }

    public Users(String username, String hoTen, String queQuan, String ngaySinh) {
        this.username = username;
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
    }

    public Users(String id , String username, String hoTen, String queQuan, String ngaySinh) {
        this.id = id;
        this.username = username;
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
