/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Nết
 */
public class Order {
    private int id;
    private int aid;
    private Date date;
    private double totalmoney;
    private String address;
    private String phone;
    private String note;
    private String name;

    public Order() {
    }

    public Order(int id, int aid, Date date, double totalmoney, String address, String phone, String note, String name) {
        this.id = id;
        this.aid = aid;
        this.date = date;
        this.totalmoney = totalmoney;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", aid=" + aid + ", date=" + date + ", totalmoney=" + totalmoney + ", address=" + address + ", phone=" + phone + ", note=" + note + ", name=" + name + '}';
    }



}