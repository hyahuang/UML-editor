package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import console.Frame;
import console.UMLcanvas;

public class ClsObject extends BasicObject {
	JPanel  jp;
	public ClsObject(int leftupX,int leftupY) {
		super.leftupX = leftupX;
		super.leftupY = leftupY;
		this.jp = new JPanel() {
		     public void paintComponent(Graphics g) {
		     super.paintComponent(g);
		     ImageIcon img = new ImageIcon("resource/class.png");
		     img.setImage(img.getImage().getScaledInstance(60, 60,Image.SCALE_DEFAULT ));
		     g.drawImage(img.getImage(), 0, 0, null);
		     g.drawString(label, 20, 15);
		     }
		     };
		     jp.setBounds(this.leftupX, this.leftupY, 60, 60);
		     jp.setOpaque(true);
		     jp.setBackground(Color.WHITE);
		     UMLcanvas.getInstance().add(jp,new Integer(1));
		     moveObjToFront();
	}
	@Override
	public void moveObjToFront() {
		UMLcanvas.getInstance().moveToFront(this.jp);
	}
	@Override 
	public void move(int mousepressX,int mousepressY,int mousereleaseX,int mousereleaseY) {
		UMLcanvas.getInstance().remove(jp);
		super.move(mousepressX, mousepressY, mousereleaseX, mousereleaseY);
		jp.setBounds(this.leftupX, this.leftupY, 60, 60);
		UMLcanvas.getInstance().add(jp,new Integer(1));
		moveObjToFront();
		UMLcanvas.getInstance().moveToListHead(this);
		UMLcanvas.getInstance().repaint();
	}

}
