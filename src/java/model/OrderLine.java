/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nết
 */
public class OrderLine {
    private int oid;
    private int pid;
    private int amount;
    private int saleid;
    private int detailtotal;
    private int price;
    private String img;
    private String name;
    
    public OrderLine() {
    }

    public OrderLine(int oid, int pid, int amount, int saleid, int detailtotal, int price, String img, String name) {
        this.oid = oid;
        this.pid = pid;
        this.amount = amount;
        this.saleid = saleid;
        this.detailtotal = detailtotal;
        this.price = price;
        this.img = img;
        this.name = name;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSaleid() {
        return saleid;
    }

    public void setSaleid(int saleid) {
        this.saleid = saleid;
    }

    public int getDetailtotal() {
        return detailtotal;
    }

    public void setDetailtotal(int detailtotal) {
        this.detailtotal = detailtotal;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    
}
