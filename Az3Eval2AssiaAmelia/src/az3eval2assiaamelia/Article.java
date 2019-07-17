/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az3eval2assiaamelia;

/**
 *
 * @author TAOURIRT
 */
public class Article {
    private String code_art;
    private String des_art;
    private String code_cat;
    private double prix;

    public String getCode_art() {
        return code_art;
    }

    public void setCode_art(String code_art) {
        this.code_art = code_art;
    }

    public String getDes_art() {
        return des_art;
    }

    public void setDes_art(String des_art) {
        this.des_art = des_art;
    }

    public String getCode_cat() {
        return code_cat;
    }

    public void setCode_cat(String code_cat) {
        this.code_cat = code_cat;
    }

    public double getprix() {
        return prix;
    }

    public void setprix(double prix) {
        this.prix = prix;
    }

    public Article(String code_art, String des_art, String code_cat,double prix) {
        this.code_art = code_art;
        this.des_art = des_art;
        this.code_cat = code_cat;
        this.prix = prix;
    }
 
    
}
