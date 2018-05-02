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
    int score = 0 ;
    int backImgX = 0;
    int gravity = 0;
    int birdY = 0;
    Point bird;
    Point wall1 ;
    Point wall2 ;
    public static void main(String[] args) {
        // full path to class
        PApplet.main("com.company.MainApp",args);
    }
    public void settings(){
        size(600, 865);

    }
    public void setup(){

        fill(0);
        textSize(40);
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
           image(birdImg, width/2, bird.getY(),100,100);
           backImgX -= 6;
           gravity += 1;
           if(backImgX == -1800){
               backImgX = 0;
           }
           bird.setY(bird.getY()+gravity);
           imageMode(CENTER);
           image(wallImg,wall1.getX(),wall1.getY() - (wallImg.height/2+100));
           image(wallImg,wall1.getX(),wall1.getY() + (wallImg.height/2+100));

           image(wallImg,wall2.getX(),wall2.getY() - (wallImg.height/2+100));
           image(wallImg,wall2.getX(),wall2.getY() + (wallImg.height/2+100));
           if(wall1.getX() < 0) {
               wall1.setY((int)random(200,height-200));
               wall2.setY((int)random(200,height-200));
               wall1.setX(width);
               wall1.setX(width);
           }
           wall1.setX(wall1.getX()-6);
           wall2.setX(wall2.getX()-6);
           if(wall1.getX() == width/2 || wall2.getX() == width/2) highScore = max(++score, highScore);
           if(bird.getY()>height || bird.getY()<0
                   || ((abs(width/2-wall1.getX()))<25
                   && (abs(bird.getY()-wall1.getY())>100 ) ) || ((abs(width/2-wall2.getX()))<25
                   && (abs(bird.getY()-wall2.getY())>100 ) )){
               gameStarted = false;
           }

           text(""+score, width/2-15, 700);

       }

    }
    public void mousePressed() {

        if(!gameStarted) {
            gameStarted = true;
            gravity = 0;
            score = 0;
            wall1 = new Point(600,height/2);
            wall2 = new Point(900,600);
            bird = new Point(0,width/2);
        }
        else {
            gravity = -15;
        }
    }
}
