package kadai8B;

import java.awt.Color;
import java.awt.Graphics;

class GUIAnimatinFaceLook {// 顔のオブジェクト

	int h = 100;
	int w = 100;

	int xStart = 0;
	int yStart = 0;

	public void setXY(int x, int y) {
		this.xStart = x;
		this.yStart = y;
	}

	public void setSize(int h, int w) {
		this.h = h;
		this.w = h;
	}

	public GUIAnimatinFaceLook() {

	}
/* 
	void makeFace(Graphics g) {
		// makeRim(g);
		makeEyes(g, w / 5);
		makeNose(g, h / 5);
		makeMouth(g, w / 2);
	}
*/
	public void makeFace(Graphics g, String emotion) {
		// **ここにemotion毎の顔を用意する。*///
		makeEyes(g, w / 5);
		makeBrows(g,emotion);
		makeNose(g, h / 5);
		makeMouth(g, w / 2,emotion);
	}

	/*
	 * public void makeRim(Graphics g) { g.drawLine(xStart, yStart, xStart + h,
	 * yStart); g.drawLine(xStart, yStart, xStart, yStart + w);
	 * g.drawLine(xStart, yStart + w, xStart + h, yStart + w); g.drawLine(xStart
	 * + h, yStart, xStart + h, yStart + w); }
	 */

	public void makeEyes(Graphics g, int eyeSize) {
		g.setColor(Color.blue);

		g.fillArc(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize,0, 300);
		g.setColor(Color.black);

		g.drawOval(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
		g.drawOval(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
	}// makeEyes()

	public void makeBrows(Graphics g, String emotion){
		if(emotion.equals("angry")){
			g.drawLine(xStart + (h * 1 / 3) - 10, yStart + (w * 1 / 3) - 10,xStart + (h * 1 / 3) + 5, yStart + (w * 1 / 3));
			g.drawLine(xStart + (h * 2 / 3) - 5, yStart + (w * 1 / 3),xStart + (h * 2 / 3) + 10, yStart + (w * 1 / 3) - 10);
		}else{
			g.drawLine(xStart + (h * 1 / 3) - 10, yStart + (w * 1 / 3) - 10,xStart + (h * 1 / 3) + 5, yStart + (w * 1 / 3) - 10);
			g.drawLine(xStart + (h * 2 / 3) - 5, yStart + (w * 1 / 3) - 10,xStart + (h * 2 / 3) + 10, yStart + (w * 1 / 3) - 10);
		}
	}

	public void makeNose(Graphics g, int noseSize) {
		g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart + (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
	}// makeNose() end

	public void makeMouth(Graphics g, int mouseSize, String emotion) {
		int xMiddle = xStart + h / 2;
		int yMiddle = yStart + 3 * w / 4;
		if(emotion.equals("smile")){
			g.drawLine(xMiddle - mouseSize / 2, yMiddle, xMiddle, yMiddle + 10);
			g.drawLine(xMiddle, yMiddle + 10, xMiddle + mouseSize / 2, yMiddle);
		}else if(emotion.equals("angry")){
			g.drawLine(xMiddle - mouseSize / 2, yMiddle + 10, xMiddle, yMiddle);
			g.drawLine(xMiddle, yMiddle, xMiddle + mouseSize / 2, yMiddle + 10);
		}else{
			g.drawLine(xMiddle - mouseSize / 2, yMiddle, xMiddle + mouseSize / 2, yMiddle);
		}
		
	}
}// FaceObj End