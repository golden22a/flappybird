package com.company;
import processing.core.PApplet;
import processing.core.PImage;

public class MainApp extends processing.core.PApplet {
    PImage backImg =loadImage("http://i.imgur.com/cXaR0vS.png");
    PImage birdImg =loadImage("https://i.imgur.com/MCgU6pJ.png");
    PImage wallImg =loadImage("http://i.imgur.com/4SUsUuc.png");
    PImage startImg=loadImage("https://i.imgur.com/88nmGjE.png");
    boolean gameState = false
    public static void main(String[] args) {
        // full path to class
        PApplet.main("com.company.MainApp",args);
    }
    public void settings(){
        size(1920, 1080);

    }
    public void setup(){

        background(255);
        stroke(200);
    }
    public void draw(){
        stroke(0);
        fill(255,0,255);
        ellipse(mouseX,mouseY,100,100);
        println(mouseX + " : " + mouseY);

    }
}
