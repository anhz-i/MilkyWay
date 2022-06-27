/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Hp
 */
public class Project {

    private int id;
    private String name;
    private String color = "tomato";
    private String date = LocalDate.now().toString();
    private String email;
    private String view = "list";

    public Project() {
        color = "tomato";
        date = LocalDate.now().toString();
        view = "list";
    }

    public Project(int id, String name, String color, String date, String email, String view) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.date = date;
        this.email = email;
        this.view = view;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

}
