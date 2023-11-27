/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Nết
 */
public class Product {

    private int id;
    private String name;
    private String img;
    private String title;
    private String description;
    private int cid;
    private int sid;
    private ProductDetail pd;
    private Language lang;
    private List<Genres> genres;
    private Genres g;
    private Category c;
    private Sale s;

    public Product() {
    }

    public Product(int id, String name, String img, String title, String description, int cid, int sid) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.title = title;
        this.description = description;
        this.cid = cid;
        this.sid = sid;
    }

    public Product(String name, String img, String title, String description, int cid, int sid, List<Genres> genres) {
        this.name = name;
        this.img = img;
        this.title = title;
        this.description = description;
        this.cid = cid;
        this.sid = sid;
        this.genres = genres;

    }

    public Product(int id, String name, String img, String title, String description, int cid, int sid, List<Genres> genres) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.title = title;
        this.description = description;
        this.cid = cid;
        this.sid = sid;
        this.genres = genres;
    }

    public Product(int id, String name, String title, String description, int cid, int sid, List<Genres> genres) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.cid = cid;
        this.sid = sid;
        this.genres = genres;
    }
    
    
  public Genres getG() {
        return g;
    }

    public void setG(Genres g) {
        this.g = g;
    }

    public Sale getS() {
        return s;
    }

    public void setS(Sale s) {
        this.s = s;
    }
    

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }


    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public ProductDetail getPd() {
        return pd;
    }

    public void setPd(ProductDetail pd) {
        this.pd = pd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void getG(Genres genres) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
