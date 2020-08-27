package console;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import button.Associationbtn;
import button.Basicbtn;
import button.Clsbtn;
import button.Compositionbtn;
import button.Generalizebtn;
import button.Selectbtn;
import button.Usecasebtn;


public class Buttonpanel extends JPanel  {
	public ArrayList <Basicbtn> buttonlist = new ArrayList();
	public Basicbtn selectbutton,associationbutton,generalizebutton,compositionbutton,classbutton,usecasebutton;
	public int btncount=0;
    public Buttonpanel() {
    	this.setLayout(null);
    	int x = 5;
    	int y = 10;
    	int width = 80;
    	int height = 80;
    	
    	//button
    	selectbutton = new Selectbtn(x,y,width,height,buttonlist);
    	this.add(selectbutton);
    	buttonlist.add(selectbutton);
    	y += 90;
    	btncount++;
        
    	associationbutton = new Associationbtn(x,y,width,height,buttonlist);
    	this.add(associationbutton);
    	buttonlist.add(associationbutton);
    	y += 90;
    	btncount++;
    	
    	generalizebutton = new Generalizebtn(x,y,width,height,buttonlist);
    	this.add(generalizebutton);
    	buttonlist.add(generalizebutton);
    	y += 90;
    	btncount++;
    	
    	compositionbutton = new Compositionbtn(x,y,width,height,buttonlist);
    	this.add(compositionbutton);
    	buttonlist.add(compositionbutton);
    	y += 90;
    	btncount++;

    	classbutton = new Clsbtn(x,y,width,height,buttonlist);
    	this.add(classbutton);
    	buttonlist.add(classbutton);
    	y += 90;
    	btncount++;

    	usecasebutton = new Usecasebtn(x,y,width,height,buttonlist);
    	this.add(usecasebutton);
    	buttonlist.add(usecasebutton);
    	btncount++;

    }
    public int panelheight()
    {
    	return btncount*90+10;
    }


}
