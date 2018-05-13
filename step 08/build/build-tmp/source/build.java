import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {

/**
* ControlP5 Toggle
*
*
* find a list of public methods available for the Toggle Controller
* at the bottom of this sketch.
*
* by Andreas Schlegel, 2011
* www.sojamo.de/libraries/controlp5
*
*/




ControlP5 cp5;

int col = color(255);

boolean toggleValue = false;

public void setup() {
  
  
  cp5 = new ControlP5(this);
  
  // create a toggle
  cp5.addToggle("toggleValue")
     .setPosition(40,100)
     .setSize(50,20)
     ;
  
  // create a toggle and change the default look to a (on/off) switch look
  cp5.addToggle("toggle")
     .setPosition(40,250)
     .setSize(50,20)
     .setValue(true)
     .setMode(ControlP5.SWITCH)
     ;
     
}
  

public void draw() {
  background(0);
  
  pushMatrix();
  
  if(toggleValue==true) {
    fill(255,255,220);
  } else {
    fill(128,128,110);
  }
  translate(280,100);
  ellipse(0,0,100,100);
  
  
  translate(0,150);
  fill(col);
  ellipse(0,0,40,40);
  
  popMatrix();
}



public void toggle(boolean theFlag) {
  if(theFlag==true) {
    col = color(255);
  } else {
    col = color(100);
  }
  println("a toggle event.");
}
  public void settings() {  size(400,400);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
