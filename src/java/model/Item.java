/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nết
 */
public class Item {
    private Product p;
    private int quantity;
    private double price;

    public Item() {
    }

    public Item(Product p, int quantity, double price) {
        this.p = p;
        this.quantity = quantity;
        this.price = price;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
