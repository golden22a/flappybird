package com.company;
import processing.core.PApplet;
import processing.core.PImage;

public class MainApp extends processing.core.PApplet {
    PImage backImg =loadImage("http://i.imgur.com/cXaR0vS.png");
    PImage birdImg =loadImage("https://i.imgur.com/MCgU6pJ.png");
    PImage wallImg =loadImage("http://i.imgur.com/4SUsUuc.png");
    PImage startImg=loadImage("https://i.imgur.com/88nmGjE.png");
    boolean gameStarted = false;
    int highScore = 0;
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
       if(!gameStarted){

           imageMode(CENTER);
           image(startImg, width/2,height/2);
           text("High Score: "+highScore, 50, width);

       }else {


       }

    }
}
