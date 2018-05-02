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
    int score ;
    int backImgX = 0;
    int gravity = 0;
    int birdY = 0;
    Point wall1 = new Point(0,0);
    Point wall2 = new Point(0,0);
    public static void main(String[] args) {
        // full path to class
        PApplet.main("com.company.MainApp",args);
    }
    public void settings(){
        size(600, 865);

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
           imageMode(CORNER);
           image(backImg, backImgX, 0);
           image(backImg, backImgX+backImg.width, 0);
           image(birdImg, width/2, birdY,100,100);
           gravity += 1;
           birdY += gravity;
           backImgX -= 6;
          
           image(wallImg,wall1.getX(),wall1.getY() - (wallImg.height/2+100));
           image(wallImg,wall1.getX(),wall2.getY() + (wallImg.height/2+100));
       }

    }
    public void mousePressed() {

        if(!gameStarted) {
            gameStarted = true;
            score = 0;
            System.out.println("heeey");
        }
        else {
            gravity = -15;
        }
    }
}
