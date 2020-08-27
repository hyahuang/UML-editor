package line;

import java.awt.Graphics;

import javax.swing.JPanel;

import console.Frame;
import console.UMLcanvas;
import shape.BasicObject;

public class GeneralizeLineObject extends BasicLine {
	public GeneralizeLineObject(int mousepressX,int mousepressY,int mousereleaseX,int mousereleaseY,BasicObject pressOnObject,BasicObject releaseOnObject) {
		super(mousepressX,mousepressY,mousereleaseX,mousereleaseY,pressOnObject,releaseOnObject);
		this.jp = new JPanel() {
			@Override
			public void paint(Graphics g) {
			super.paint(g);
			drawGPort(g);
			}
		};
		jp.setSize(800, 500);
		jp.setOpaque(false);
		UMLcanvas.getInstance().add(jp,new Integer(2));

	}
	public void drawGPort(Graphics g) {
		g.fillRect(startX, startY, 8, 8);
		g.fillRect(endX, endY, 8, 8);
		if (endDirection==1) {
			int px[]= {endX+4, endX,endX+8};
			int py[]= {endY+4, endY-8,endY-8};
			g.drawPolygon(px,py,3);
			g.drawLine(startX+4, startY+4, endX+4, endY-4);
		}
		else if (endDirection==2) {
			int px[]= {endX+8, endX+16,endX+16};
			int py[]= {endY+4, endY,endY+8};
			g.drawPolygon(px,py,3);
			g.drawLine(startX+4, startY+4, endX+12, endY+4);
		}
		else if (endDirection==3) {
			int px[]= {endX+4, endX,endX+8};
			int py[]= {endY+8, endY+16,endY+16};
			g.drawPolygon(px,py,3);
			g.drawLine(startX+4, startY+4, endX+4, endY+12);
		}
		else if (endDirection==4) {
			int px[]= {endX, endX-8,endX-8};
			int py[]= {endY+4, endY,endY+8};
			g.drawPolygon(px,py,3);
			g.drawLine(startX+4, startY+4, endX-4, endY+4);
		}	
	}
}
