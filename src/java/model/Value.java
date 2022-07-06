/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hp
 */
public class Value {

    List<String> color = new ArrayList<>();

    public Value() {
        setColor();
    }

    private void setColor() {
        color.add("tomato");
        color.add("red");
        color.add("orange");
        color.add("yellow");
        color.add("olive");
        color.add("limegreen");
        color.add("Green");
        color.add("mediumaquamarine");
        color.add("teal");
        color.add("skyblue");
        color.add("lightblue");
        color.add("blue");
        color.add("purple");
        color.add("violet");
        color.add("mediumorchid");
        color.add("magenta");
        color.add("salmon");
        color.add("darkgray");
        color.add("grey");
        color.add("tan");

    }

    public List getColor() {
        return color;
    }
}
