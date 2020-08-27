package shape;

import java.awt.Graphics;

import javax.swing.JPanel;

import console.Frame;
import console.UMLcanvas;

public class Port {
	JPanel port;
	public void showPort(int leftupX, int leftupY) {
	port = new JPanel() {
		public void paintComponent(Graphics g) {
		     super.paintComponent(g);
				g.fillRect(36, 6, 8, 8);
				g.fillRect(66, 36, 8, 8);
				g.fillRect(36, 66, 8, 8);
				g.fillRect(6, 36, 8, 8);
		}
	};
	port.setOpaque(false);
	port.setBounds(leftupX-10, leftupY-10, 80, 80);
	UMLcanvas.getInstance().add(port,new Integer(2));
	}
	public void hidePort() {
		UMLcanvas.getInstance().remove(port);
		UMLcanvas.getInstance().repaint();
	}
}
