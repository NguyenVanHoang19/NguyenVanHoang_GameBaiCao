package com.example.nguyenvanhoang_gamebaicao;

public class Bai {
    private int id;
    private String tenBai;
    private int hinh;
    private int diem;
    private int thuTuBai;

    public Bai(int id, String tenBai, int hinh, int diem) {
        this.id = id;
        this.tenBai = tenBai;
        this.hinh = hinh;
        this.diem = diem;
    }

    public Bai(int id, int diem) {
        this.id = id;
        this.diem = diem;
    }

    public int getThuTuBai() {
        return thuTuBai;
    }

    public void setThuTuBai(int thuTuBai) {
        this.thuTuBai = thuTuBai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenBai() {
        return tenBai;
    }

    public void setTenBai(String tenBai) {
        this.tenBai = tenBai;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}
