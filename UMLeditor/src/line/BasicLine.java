package line;

import java.awt.Graphics;

import javax.swing.JPanel;

import console.Frame;
import console.UMLcanvas;
import shape.BasicObject;

public class BasicLine {

	JPanel  jp;
	BasicObject pressOnObject,releaseOnObject;
	int startDirection,endDirection,startX,startY,endX,endY,SPX,SPY;
	int distanceToBorderX,distanceToBorderY;
	int mousepressX,mousepressY,mousereleaseX, mousereleaseY;
	public BasicLine(int mousepressX,int mousepressY, int mousereleaseX,int mousereleaseY,BasicObject pressOnObject, BasicObject releaseOnObject) {
		this.pressOnObject=pressOnObject;
		this.releaseOnObject=releaseOnObject;
		this.mousepressX=mousepressX;
		this.mousepressY=mousepressY;
		this.mousereleaseX=mousereleaseX;
		this.mousereleaseY=mousereleaseY;
		connectPort();
		portcoordinate();
	}
	public void connectPort() {
		distanceToBorderX = mousepressX-pressOnObject.leftupX;
    	distanceToBorderY = mousepressY-pressOnObject.leftupY;
    	if(distanceToBorderX>distanceToBorderY) {
    		if((60-distanceToBorderX)<distanceToBorderY) {
    			startDirection = 2;
    		}
    		else {
    			startDirection = 1;
    		}
    	}
    	else {
    		if((60-distanceToBorderY)<distanceToBorderX) {
    			startDirection = 3;
    		}
    		else {
    			startDirection = 4;
    		}
    	}
		distanceToBorderX = mousereleaseX-releaseOnObject.leftupX;
    	distanceToBorderY = mousereleaseY-releaseOnObject.leftupY;
    	if(distanceToBorderX>distanceToBorderY) {
    		if((60-distanceToBorderX)<distanceToBorderY) {
    			endDirection = 2;
    		}
    		else {
    			endDirection = 1;
    		}
    	}
    	else {
    		if((60-distanceToBorderY)<distanceToBorderX) {
    			endDirection = 3;
    		}
    		else {
    			endDirection = 4;
    		}
    	}

	}
	public void portcoordinate()
	{
		if(startDirection==1) {
			startX=pressOnObject.leftupX+26;
			startY=pressOnObject.leftupY-4;
			SPX=startX;
			SPY=startY-8;
		}
		else if (startDirection == 2) {
			startX=pressOnObject.leftupX+56;
			startY=pressOnObject.leftupY+26;
			SPX=startX+8;
			SPY=startY;
		}
		else if (startDirection == 3) {
			startX=pressOnObject.leftupX+26;
			startY=pressOnObject.leftupY+56;
			SPX=startX;
			SPY=startY+8;
		}
		else if (startDirection == 4) {
			startX=pressOnObject.leftupX-4;
			startY=pressOnObject.leftupY+26;
			SPX=startX-8;
			SPY=startY;
		}
		if(endDirection==1) {
			endX=releaseOnObject.leftupX+26;
			endY=releaseOnObject.leftupY-4;
			SPX=startX;
			SPY=startY-8;
		}
		else if (endDirection == 2) {
			endX=releaseOnObject.leftupX+56;
			endY=releaseOnObject.leftupY+26;
			SPX=startX+8;
			SPY=startY;
		}
		else if (endDirection == 3) {
			endX=releaseOnObject.leftupX+26;
			endY=releaseOnObject.leftupY+56;
			SPX=startX;
			SPY=startY+8;
		}
		else if (endDirection == 4) {
			endX=releaseOnObject.leftupX-4;
			endY=releaseOnObject.leftupY+26;
			SPX=startX-8;
			SPY=startY;
		}
	}
	public void move() {
		portcoordinate();
		UMLcanvas.getInstance().remove(jp);
		UMLcanvas.getInstance().add(jp,new Integer(2));
		UMLcanvas.getInstance().repaint();
	}
}
