package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import console.Frame;
import console.UMLcanvas;

public class UsecaseObject extends BasicObject {
	JPanel  jp;
	public UsecaseObject(int leftupX,int leftupY) {
		super.leftupX = leftupX;
		super.leftupY = leftupY;
		this.jp = new JPanel() {
		     public void paintComponent(Graphics g) {
		     super.paintComponent(g);
		     ImageIcon img = new ImageIcon("resource/usecase.png");
		     img.setImage(img.getImage().getScaledInstance(60, 60,Image.SCALE_DEFAULT ));
		     g.drawImage(img.getImage(), 0, 0, null);
		     g.drawString(label, 20, 20);
		     }
		     };
		     jp.setOpaque(true);
		     jp.setBackground(Color.WHITE);
		     jp.setBounds(leftupX, leftupY, 60, 60);
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
