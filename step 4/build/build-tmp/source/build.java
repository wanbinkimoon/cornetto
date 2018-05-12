import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import hype.*; 
import hype.extended.behavior.*; 
import hype.extended.colorist.*; 
import hype.extended.layout.*; 
import hype.interfaces.*; 
import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {

int stageW      = 600;
int stageH      = 600;
int bgC       = 0xff2e2e2e;
String dataPATH = "../../data";

// ================================================================

boolean letsRender = false;
int     renderNum  = 0;
String  renderPATH = "../render/";

// ================================================================








PeasyCam cam;
HDrawable3D d;
HColorPool colors;
HRotate r;

float x;
float y;
float z;
float _r;

int alpha;
int area;
boolean shapeSelector;

// ================================================================

public void settings(){ 
	size(stageW,stageH,P3D);
}

// ================================================================

public void setup() {
	colors = new HColorPool(0xffed6b5a, 0xfff4f1bc, 0xff9bc1bb, 0xff5aa3a8, 0xffe5eade);
	
	H.init(this).background(bgC).use3D(true);
	

	int rects = 4;

	for (int i = 1; i < rects; ++i) {
		for (int j = 1; j < rects; ++j) {
			for (int k = 1; k < rects; ++k) {
				
				shapeSelector = ((k + j) % 2 == 1);
				d = shapeSelector ? new HSphere() : new HCylinder();

				_r = shapeSelector ? 25.0f : 50.0f;
				area = 200;

				x = map(i * _r, 0, rects * _r, -area, area);
				y = map(j * _r, 0, rects * _r, -area, area);
				z = map(k * _r, 0, rects * _r, -area, area);
				
				alpha = 255;
				int fgC = color(colors.getColor(), alpha);

				d
					.size(_r)
					.loc(x,y,z)
					// .fill(fgC)
					.stroke(fgC)
					.noFill();

				new HOscillator()
					.target(d)
					.property(H.SIZE)
					// .relativeVal(0)
					.range(25, 50)
					.speed(random(0, 1))
					.freq(10);

				H.add(d);
				
			}
		}
	}

cam = new PeasyCam(this, 600);
}

// ================================================================
public void draw() {
	lights();
	H.drawStage();

	if (letsRender) {
		letsRender = false;
		save(renderPATH + renderNum + ".png");
		renderNum++;
	}
}


public void keyPressed() {
	switch (key) {
		case 'p':
			letsRender = true;
		break;
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
