import processing.core.PApplet;
import processing.core.PImage;
public class Sketch extends PApplet {
	//declare global variables
	PImage imageBird;
  PImage imageSky;
  float xSpeed = 3;
  float ySpeed = 3;

  float birdX = 100;
  float birdY = 100;

  float fltCircleX = 200;
  float fltCircleY = 200;
  float fltCircleSpeedX = 4;
  float fltCircleSpeedY = 4;

  float fltWave;
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1280, 853);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    //load images
    imageSky = loadImage("clouds-mf.jpg");
    imageBird = loadImage("dove.png");
    //resize
    imageBird.resize(200, 200);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    //computes the new value for the waves
   fltWave += (Math.PI/12);

	  //draw images
    image(imageSky, 0, 0);
    image(imageBird, birdX, birdY);

     //moves the bird along a sine wave
     birdX += (float)(Math.sin(fltWave)) + xSpeed;
     birdY += (float)(Math.sin(fltWave)) + ySpeed;

    //if statements to reverse the bird speed if it comes too close to the boundary
    if (birdX < 0 + 10 || birdX > width - 200) {
      xSpeed *= -1;
    }

    if (birdY < 0 + 10 || birdY > height - 200) {
      ySpeed *= -1;
    }

     //draws the circle
     fill(250, 253, 15);
     ellipse(fltCircleX, fltCircleY, 100, 100);

     //moves the circle along a cosine wave
     fltCircleX += (float)(Math.cos(fltWave)) + fltCircleSpeedX;
     fltCircleY += (float)(Math.cos(fltWave)) + fltCircleSpeedY;
 
     //if statements to reverse the circles speed if it comes too close to the boundary
     if (fltCircleX < 0 + 100 || fltCircleX > width - 100); {
       fltCircleSpeedX *= -1;
     }
 
     if (fltCircleY < 0 + 100 || fltCircleY > height - 100) {
       fltCircleSpeedY *= -1;
     }
  }
  
  // define other methods down here.
}