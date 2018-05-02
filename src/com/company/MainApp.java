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
        // window size
        size(600, 865);

    }
    public void setup(){

        fill(0);
        textSize(40);
    }
    public void draw(){
        // check if the game started
       if(!gameStarted){
           imageMode(CENTER);
           // display lending screen
           image(startImg, width/2,height/2);
           text("High Score: "+highScore, 50, width);

       }else {
           //generate the map with undless movment
           imageMode(CORNER);
           image(backImg, backImgX, 0);
           image(backImg, backImgX+backImg.width, 0);
           image(birdImg, width/2, bird.getY(),100,100);
           // background movment
           backImgX -= 6;
           // simulating gravity
           gravity += 1;
           // reset after exciding the actual map width
           if(backImgX == -1800){
               backImgX = 0;
           }
           // folling bird
           bird.setY(bird.getY()+gravity);
           // generating wall in random position
           imageMode(CENTER);
           image(wallImg,wall1.getX(),wall1.getY() - (wallImg.height/2+100));
           image(wallImg,wall1.getX(),wall1.getY() + (wallImg.height/2+100));

           image(wallImg,wall2.getX(),wall2.getY() - (wallImg.height/2+100));
           image(wallImg,wall2.getX(),wall2.getY() + (wallImg.height/2+100));
           // reset wall after hit left side
           if(wall1.getX() < 0) {
               wall1.setY((int)random(200,height-200));
               wall1.setX(width);
           }
           if (wall2.getX() < 0){
               wall2.setY((int)random(200,height-200));
               wall2.setX(width);
           }
           // wall movment
           wall1.setX(wall1.getX()-6);
           wall2.setX(wall2.getX()-6);
           // if bird get pass the wall update the score
           if(wall1.getX() == width/2 || wall2.getX() == width/2)
               highScore = max(++score, highScore);
           // colison detecting end game
           if(bird.getY()>height || bird.getY()<0
                   || ((abs(width/2-wall1.getX()))<25
                   && (abs(bird.getY()-wall1.getY())>100 ) ) || ((abs(width/2-wall2.getX()))<25
                   && (abs(bird.getY()-wall2.getY())>100 ) )){
               gameStarted = false;
           }
            // display the actual score
           text(""+score, width/2-15, 700);

       }

    }
    public void mousePressed() {
        // start the game
        if(!gameStarted) {
            gameStarted = true;
            gravity = 0;
            score = 0;
            wall1 = new Point(600,height/2);
            wall2 = new Point(900,600);
            bird = new Point(0,width/2);
        }
        else {
            // change bird position by reversing the gravity
            gravity = -15;
        }
    }
}
