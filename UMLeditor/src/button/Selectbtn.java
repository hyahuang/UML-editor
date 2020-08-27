package button;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import console.Frame;
import console.UMLcanvas;
import mode.Selectmode;

public class Selectbtn extends Basicbtn {
	public Selectbtn(int x,int y,int width,int height,ArrayList<Basicbtn> btnlist) {
		super(x,y,width,height, btnlist);
		ImageIcon image =  new ImageIcon("resource/select.png");
		image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));
		this.setIcon(image);	
	}
	@Override
	public void setcurrentmode() {
		UMLcanvas.getInstance().setcurrentmode(new Selectmode());
	}
}

