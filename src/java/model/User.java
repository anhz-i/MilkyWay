/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hp
 */
public class User {
    private String name, email, password, code;

    public User() {
    }
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;        
    }
    
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;        
    }

    public User(String name, String email, String password, String code) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
}
