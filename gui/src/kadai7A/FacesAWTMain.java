package kadai7A;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMain {

	public static void main(String[] args){
		new FacesAWTMain();
	}

    FacesAWTMain(){
		FaceFrame f = new FaceFrame();
		f.setSize(800,800);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);}});
		f.setVisible(true);
	}

	// インナークラスを定義
	class FaceFrame extends Frame{
        public void paint(Graphics g) {
        // この中には、g.drawLine というのは入ってこない
        // Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
            FaceObj[] faces = new FaceObj[9];

            for(int i = 0;i < 3;i++){
                for(int j = 0;j < 3;j++){
                    faces[j + i * 3] = new FaceObj(50 + 200 * j,50 + 200 * i);
                }
            }
            
            for(int i = 0;i < faces.length;i++){
                faces[i].drawFace(g,i);
            }
        }
    }//FaceFrame end

	//Faceクラスを作ってみよう。
	private class FaceObj{
        private int w = 200;
        private int h = 200;
        private int xStart;
        private int yStart;

        FaceObj(int x0, int y0){
            this.xStart = x0;
            this.yStart = y0;
        }

        void drawFace(Graphics g, int i){
            drawRim(g);
            drawBrow(g, 30,i);
            drawEye(g, 35);;
            drawNose(g, 40);
            drawMouth(g, 100,i);
        }

        //輪郭
        public void drawRim(Graphics g) {  // wが横幅、hが縦幅
            g.drawOval(xStart, yStart,w,h);
        }

        //眉毛
        public void drawBrow(Graphics g,int bx,int i) { // xは目の幅 呼ばれる方(=定義する方)
            if(i / 3 == 0){//普通 "- -"
                g.drawLine(xStart+30,yStart+45,xStart+80,yStart+45);
                g.drawLine(xStart+120,yStart+45,xStart+170,yStart+45);
            }else if(i / 3 == 1){// "\ /"
                g.drawLine(xStart+30,yStart+45,xStart+80,yStart+65);
                g.drawLine(xStart+120,yStart+65,xStart+170,yStart+45);
            }else{// "/ \"
                g.drawLine(xStart+30,yStart+65,xStart+80,yStart+45);
                g.drawLine(xStart+120,yStart+45,xStart+170,yStart+65);
            }
        }

        //鼻
        public void drawNose(Graphics g, int nx) { // xは鼻の長さ
            g.drawLine(xStart+100,yStart+80,xStart+100,yStart+140);
        }

        //目
        public void drawEye(Graphics g, int r) { // rは目の半径
            g.drawOval(xStart+45,yStart+65,r,r);
            g.drawOval(xStart+r+80,yStart+65,r,r);
        }

        //口
        public void drawMouth(Graphics g, int mx, int i) { // xは口の幅
            int xMiddle = xStart + w/2;
            int yMiddle = yStart + h - 30;
            if(i % 3 == 0){// "_"
                g.drawLine(xMiddle - mx/2, yMiddle, xMiddle + mx/2, yMiddle);
            }else if(i % 3 == 1){// "へ"
                g.drawLine(xMiddle - mx/2, yMiddle - 10, xMiddle, yMiddle + 10);
                g.drawLine(xMiddle, yMiddle + 10, xMiddle + mx/2, yMiddle - 10);
            }else{// "v"
                g.drawLine(xMiddle - mx/2, yMiddle + 10, xMiddle, yMiddle - 10);
                g.drawLine(xMiddle, yMiddle - 10, xMiddle + mx/2, yMiddle + 10);
            }
            
        }
	}

}//Faces class end
