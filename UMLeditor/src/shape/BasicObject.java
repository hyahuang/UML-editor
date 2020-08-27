package shape;

import java.awt.Graphics;

import javax.swing.JPanel;

import console.Frame;

public class BasicObject {
	public int leftupX = 0;
	public int leftupY = 0;
	int moveX,moveY;
	boolean isshow= false;
	Port port = new Port();
	public String label = "";
	public void moveObjToFront() {}
	public void showPort() {
		if(!isshow) {
		port.showPort(leftupX, leftupY);
		isshow=true;
		}
	}
	public void hidePort() {
		if(isshow) {
		port.hidePort();
		isshow=false;
		}
	}
	public void move(int mousepressX,int mousepressY,int mousereleaseX,int mousereleaseY) {
		moveX=mousepressX-mousereleaseX;
		moveY=mousepressY-mousereleaseY;
		this.leftupX = leftupX-moveX;
		this.leftupY = leftupY-moveY;
	}


}
