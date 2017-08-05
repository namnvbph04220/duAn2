package com.example.user.myapplication.DTO;

/**
 * Created by User on 8/2/2017.
 */

public class MonDTO {

    private int _id;
    private String tenmon;
    private int kalo;
    public MonDTO() {
    }
    public MonDTO(int _id, String tenmon, int kalo) {
        this._id = _id;
        this.tenmon = tenmon;
        this.kalo = kalo;
    }

    public MonDTO(String tenmon, int kalo) {
        this.tenmon = tenmon;
        this.kalo = kalo;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getKalo() {
        return kalo;
    }

    public void setKalo(int kalo) {
        this.kalo = kalo;
    }
}
