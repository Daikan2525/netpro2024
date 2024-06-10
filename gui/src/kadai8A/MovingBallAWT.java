package kadai8A;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//配列で5つのボールを動かしてみよう

public class MovingBallAWT {
	public static void main(String[] args) {
		FFrame f = new FFrame();
		f.setSize(500, 500);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.show();
	}


	static class FFrame extends Frame implements Runnable {
        Border border;
		Thread th;
		Ball myBall1;
		Ball myBall2;

		private boolean enable = true;
		private int counter = 0;

		FFrame() {
			th = new Thread(this);
			th.start();
		}

		public void run() {
            border = new Border();
            border.setPos(50,50);
            border.setLength(400);

			myBall1 = new Ball();
			myBall1.setPosition(200, 150);
			myBall1.setR(100);
			myBall1.setColor(Color.RED);

			myBall2 = new Ball();
			myBall2.setPosition(50, 250);
			myBall2.setR(60);
			myBall2.setColor(Color.GREEN);

			while (enable) {

				try {
					th.sleep(60);
					counter++;
					if (counter >= 200) enable = false;
				} catch (InterruptedException e) {
				}

				myBall1.move(border.getXStart(),border.getYStart(),border.getLength());
				myBall2.move(border.getXStart(),border.getYStart(),border.getLength());

				repaint();  // paint()メソッドが呼び出される
			}
		}


		public void paint(Graphics g) {
            border.drawBorder(g);
			myBall1.draw(g);
			myBall2.draw(g);
		}

		// Ball というインナークラスを作る
		class Ball {
			int x;
			int y;
			int r; // 半径
			Color c;

			int xDir = 1;  // 1:+方向  -1: -方向
			int yDir = 1;

			void setColor(Color c) {
				this.c = c;
			}


			void move(int xmin,int ymin,int length) {

				if ((xDir == 1) && (x >= xmin + length - 2 * r)) {
					xDir = -1;
				}
				if ((xDir == -1) && (x <= xmin)) {
					xDir = 1;
				}

				if (xDir == 1) {
					x = x + 10;
				} else {
					x = x - 10;
				}


				if ((yDir == 1) && (y >= ymin + length - 2 * r)) {
					yDir = -1;
				}
				if ((yDir == -1) && (y <= ymin)) {
					yDir = 1;
				}

				if (yDir == 1) {
					y = y + 10;
				} else {
					y = y - 10;
				}


			}


			void setPosition(int x, int y) {
				this.x = x;
				this.y = y;
			}

			void setR(int r) {
				this.r = r;
			}

			void draw(Graphics g) {
				g.setColor(c);
				g.fillOval(x, y, 2 * r, 2 * r);  // rは半径なので2倍にする
			}

		}//innner class Ball end

        class Border{
            int xStart;
            int yStart;
            int length;

            void setPos(int x, int y){
                this.xStart = x;
                this.yStart = y;
            }

            void setLength(int len){
                this.length = len;
            }

            void drawBorder(Graphics g){
                g.drawRect(xStart,yStart,length,length);
            }

            int getXStart(){
                return xStart;
            }

            int getYStart(){
                return yStart;
            }

            int getLength(){
                return length;
            }
        }

	}

}

