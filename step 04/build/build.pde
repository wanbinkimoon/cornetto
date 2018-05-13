int stageW      = 600;
int stageH      = 600;
color bgC       = #2e2e2e;
String dataPATH = "../../data";

// ================================================================

boolean letsRender = false;
int     renderNum  = 0;
String  renderPATH = "../render/";

// ================================================================

import hype.*;
import hype.extended.behavior.*;
import hype.extended.colorist.*;
import hype.extended.layout.*;
import hype.interfaces.*;

import peasy.*;
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

void settings(){ 
	size(stageW,stageH,P3D);
}

// ================================================================

void setup() {
	colors = new HColorPool(#ed6b5a, #f4f1bc, #9bc1bb, #5aa3a8, #e5eade);
	
	H.init(this).background(bgC).use3D(true);
	smooth();

	int rects = 4;

	for (int i = 1; i < rects; ++i) {
		for (int j = 1; j < rects; ++j) {
			for (int k = 1; k < rects; ++k) {
				
				shapeSelector = ((k + j) % 2 == 1);
				d = shapeSelector ? new HSphere() : new HCylinder();

				_r = shapeSelector ? 25.0 : 50.0;
				area = 200;

				x = map(i * _r, 0, rects * _r, -area, area);
				y = map(j * _r, 0, rects * _r, -area, area);
				z = map(k * _r, 0, rects * _r, -area, area);
				
				alpha = 255;
				color fgC = color(colors.getColor(), alpha);

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
void draw() {
	lights();
	H.drawStage();

	if (letsRender) {
		letsRender = false;
		save(renderPATH + renderNum + ".png");
		renderNum++;
	}
}


void keyPressed() {
	switch (key) {
		case 'p':
			letsRender = true;
		break;
	}
}
