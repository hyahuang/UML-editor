package line;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import console.Frame;
import console.UMLcanvas;
import shape.BasicObject;

public class AssociationLineObject extends BasicLine {

	public AssociationLineObject(int mousepressX,int mousepressY,int mousereleaseX,int mousereleaseY,BasicObject pressOnObject,BasicObject releaseOnObject) {
		super(mousepressX,mousepressY,mousereleaseX,mousereleaseY,pressOnObject,releaseOnObject);
		this.jp = new JPanel() {
			@Override
			public void paint(Graphics g) {
			super.paint(g);
			g.drawLine(startX+4, startY+4, endX, endY);
			g.fillRect(startX, startY, 8, 8);
			g.fillRect(endX, endY, 8, 8);
			}
		};
		jp.setSize(800, 500);
		jp.setOpaque(false);
		UMLcanvas.getInstance().add(jp,new Integer(2));

	}
	
}
