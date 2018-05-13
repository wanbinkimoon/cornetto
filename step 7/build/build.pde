int stageW      = 600;
int stageH      = 600;
color bgC       = #FF7700;
String dataPATH = "../../data";

// ================================================================

PGraphics top;
PGraphics bottom;

// ================================================================

void settings(){ 
	size(stageW, stageH);
}

// ================================================================

void setup() {
	top = createGraphics(width, height / 2);
}

// ================================================================
void draw() {
	top.beginDraw();
	top.background(#FF7700);
	top.endDraw();
	image(top, 0, 0);	
}
