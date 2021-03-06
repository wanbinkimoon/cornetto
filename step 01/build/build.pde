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

// ================================================================

void settings(){ 
	size(stageW,stageH,P3D);
}

// ================================================================

void setup() {
	colors = new HColorPool(#E9F042, #08EF98, #3DCEF2, #FDB4F9, #F1F1F1, #ED329F);
	
	H.init(this).background(bgC).use3D(true);
	smooth();

	int rects = 4;

	for (int i = 1; i < rects; ++i) {
		for (int j = 1; j < rects; ++j) {
			for (int k = 1; k < rects; ++k) {
				
				d = new HSphere();

				_r = 50.0;
				area = 200;

				x = map(i * _r, 0, rects * _r, -area, area);
				y = map(j * _r, 0, rects * _r, -area, area);
				z = map(k * _r, 0, rects * _r, -area, area);
				
				alpha = 255;
				color fgC = color(colors.getColor(), alpha);

				d
					.size(_r)
					.loc(x,y,z)
					.anchorAt(H.CENTER)
					// .fill(fgC)
					.stroke(fgC)
					.noFill();

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
