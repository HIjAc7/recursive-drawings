import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener {

	private int refreshInterval = 1000; //milliseconds
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 1000);
//		concentricRings(0, 0, 100, 10, g);
//		squares(300, 300, 100, g);
//		donut(400, 400, 0, 200, g);
//		clover(200, 200, 100,10, g);
//		snowFlake(5,100,100,500,500,g);
	}

	public void concentricRings(int x, int y, int width, int s, Graphics g) {
		if(width<=0) {
			return;
		}else {
			g.setColor(Color.white);
			g.drawOval(x, y, width, width);
			concentricRings(x + (s/2),y + (s/2),width-s,s,g);
		}
	}

	public void clover(int x, int y, int width, int s, Graphics g) {
		if(width<=0) {
			return;
		}else {
			g.setColor(Color.orange);
			g.drawOval(x, y+width, width, width);
			g.drawOval(x+width, y, width, width);
			g.drawOval(x+width, y+width, width, width);
			g.drawOval(x, y, width, width);
			clover(x + (s),y + (s),width-s,s,g);
		}
	}

	public void snowFlake(int len, int x1, int y1, int x2, int y2,Graphics g) {
		if(len<=0) {
			return;
		}else {
			g.setColor(newColor());
			g.drawLine(x1, y1+(y2-y1)/2, x2, y2-(y2-y1)/2);
			g.drawLine(x1+(x2-x1)/4, y1+(y2-y1)/12, x2-(x2-x1)/4,y2-(y2-y1)/12);
			g.drawLine(x2-(x2-x1)/4, y1+(y2-y1)/12, x1+(x2-x1)/4, y2-(y2-y1)/12);
			snowFlake(len-1, x1 + (x2-x1)/12,y1+(y2-y1)/12-(y2-y1)/4+ (x2-x1)/12,x1+(x2-x1)/2- (x2-x1)/12, y1+(y2-y1)/12+(y2-y1)/4- (x2-x1)/12,g);
			snowFlake(len-1, x1+(x2-x1)/12,y2-(y2-y1)/12-(y2-y1)/4+(x2-x1)/12,x1+(x2-x1)/2-(x2-x1)/12, y2-(y2-y1)/12+(y2-y1)/4-(x2-x1)/12,g);
			snowFlake(len-1, x2-(x2-x1)/2+(x2-x1)/12,y2-(y2-y1)/12-(y2-y1)/4+(x2-x1)/12,x2-(x2-x1)/12, y2-(y2-y1)/12+(y2-y1)/4-(x2-x1)/12,g);
			snowFlake(len-1, x2-(x2-x1)/2+(x2-x1)/12,y1+(y2-y1)/12-(y2-y1)/4+(x2-x1)/12,x2-(x2-x1)/12, y1+(y2-y1)/12+(y2-y1)/4-(x2-x1)/12,g);
			snowFlake(len-1, x2-(x2-x1)/4+(x2-x1)/12,y1+(y2-y1)/4+(x2-x1)/12,x2+(x2-x1)/4-(x2-x1)/12, y2-(y2-y1)/4-(x2-x1)/12,g);
			snowFlake(len-1, x1-(x2-x1)/4+(x2-x1)/12,y1+(y2-y1)/4+(x2-x1)/12,x1+(x2-x1)/4-(x2-x1)/12, y2-(y2-y1)/4-(x2-x1)/12,g);

		}
	}

	public void squares(int x, int y, int width, Graphics g) {
		if(width<=1) {
			return;
		}else {
			g.setColor(newColor());
			g.fillRect(x, y, width, width);
			squares(x+width/3, y-2*width/3, width/3, g);
			squares(x+width/3, y+4*width/3, width/3, g);
			squares(x-2*width/3, y+width/3, width/3, g);
			squares(x+4*width/3, y+width/3, width/3, g);
			squares(x-2*width/3, y-2*width/3, width/3, g);
			squares(x-2*width/3, y+4*width/3, width/3, g);
			squares(x+4*width/3, y+4*width/3, width/3, g);
			squares(x+4*width/3, y-2*width/3, width/3, g);
		}
	}

	int red = 0, green = 200, blue = 100;

	public void donut(int x, int y, int angle, int width, Graphics g) {
		
	}

	public void spiral(int x, int y, int angle, int width, Graphics g) {

	}

	public void binTree(int x1, int y1, int x2, int y2, int len, Graphics g) {
		
	}
	public Color newColor() {
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		Color newColor = new Color(red,green,blue);
		return newColor;
	}
	public static void main(String[] arg) {

		// find a way to run the constructor of the Driver class
		Driver d = new Driver(); // will this invoke a constructor?

	}

	// 1) add a Driver constructor
	public Driver() {
		JFrame frame = new JFrame("ArrayList stuff");
		frame.setSize(800, 600);
		frame.add(this);

		// this part makes sure the x button closes the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		t.start();
		// make the frame show up
		frame.setVisible(true);

	}

	Timer t = new Timer(refreshInterval, this);

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
}
