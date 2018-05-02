package com.company;

import processing.core.PApplet;

public class Main  extends processing.core.PApplet{

    public static void main(String[] args) {
        PApplet.main("Main",args);
    }
    public void setup(){
        background(255);
    }
    public void draw(){
        stroke(0);
        fill(255,0,255);
        ellipse(width/2,height/2,100,100);
    }
}
