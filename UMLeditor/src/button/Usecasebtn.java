package button;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import console.Frame;
import console.UMLcanvas;
import mode.Usecasemode;

public class Usecasebtn extends Basicbtn {
	public Usecasebtn(int x,int y,int width,int height,ArrayList<Basicbtn> btnlist) {
		super(x,y,width,height,btnlist);
		ImageIcon image =  new ImageIcon("resource/usecase.png");
		image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));
		this.setIcon(image);	
	}
	
	@Override
	public void setcurrentmode() {
		UMLcanvas.getInstance().setcurrentmode(new Usecasemode());
	}

}
