/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nết
 */
public class Account {
    private int id;
    private String user;
    private String pass;
    private int isSeller;
    private int isAdmin;

    public Account() {
    }

    public Account(int id, String user, String pass, int isSeller, int isAdmin) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.isSeller = isSeller;
        this.isAdmin = isAdmin;
    }

    public Account(int id, String pass) {
        this.id = id;
        this.pass = pass;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(int isSeller) {
        this.isSeller = isSeller;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    
}
