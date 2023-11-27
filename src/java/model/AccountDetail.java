/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nết
 */
public class AccountDetail {
    private int id;
    private String userName;
    private String phone;
    private String email;
    private String address;
    private String avatar;
    private boolean gender;

    public AccountDetail() {
    }

    public AccountDetail(int id, String userName, String phone, String email, String address, String avatar, boolean gender) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.avatar = avatar;
        this.gender = gender;
    }

    public AccountDetail(int id, String userName, String address, String avatar, boolean gender) {
        this.id = id;
        this.userName = userName;
        this.address = address;
        this.avatar = avatar;
        this.gender = gender;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "AccountDetail{" + "id=" + id + ", userName=" + userName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", avatar=" + avatar + ", gender=" + gender + '}';
    }
    
    
}
