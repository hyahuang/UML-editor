package console;

import javax.swing.*;



import line.BasicLine;
import mode.Basicmode;
import shape.BasicObject;
import shape.Group;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UMLcanvas extends JLayeredPane{
	private static UMLcanvas uniqueInstance;
	public JPanel bottonwhite = new JPanel();
	public JPanel botton = new JPanel();
	public int layer =0;
	public Basicmode currentmode=null;
	public int mousepressX,mousepressY,mousereleaseX, mousereleaseY;
	public BasicObject pressOnObject = null,releaseOnObject = null;
	public ArrayList <BasicObject> Objlist = new ArrayList();
	public ArrayList <BasicLine> lineList = new ArrayList(); 
	public ArrayList<Group> groupList = new ArrayList();
	public ArrayList<BasicObject> groupedList = new ArrayList();
	private UMLcanvas() {
		this.setLayout(null);
		this.setBounds(130, 20, 800, 500);
		this.setOpaque(true);
		this.setBackground(Color.white);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentmode == null)
                    return;
                pressAction(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {  // create lines
                if (currentmode == null)
                    return;
                releaseAction(e.getX(), e.getY());
            }
        });
	}
	public static UMLcanvas getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new UMLcanvas();
		}
		return uniqueInstance;
	}
	public void pressAction(int x, int y) {
	mousepressX = x;
	mousepressY = y;
	pressOnObject = clickOnObject(x,y);
	
	}
	public void releaseAction(int x, int y) {
	mousereleaseX = x;
	mousereleaseY = y;
	releaseOnObject = clickOnObject(x,y);
	currentmode.releaseaction(mousepressX,mousepressY,mousereleaseX,mousereleaseY,pressOnObject,releaseOnObject);
	}
	
	public void addgroup(){
		groupList.add(0,new Group(groupedList));
	}
	public void removegroup(){
		for (int i = 0; i < UMLcanvas.getInstance().groupList.size(); i++) {
			if(UMLcanvas.getInstance().groupList.get(i).groupedList.contains(pressOnObject)) {
				groupList.remove(UMLcanvas.getInstance().groupList.get(i));
				break;
			}
		}

	}
	
	public void changeObjectName(){
		for (int i = 0; i < UMLcanvas.getInstance().groupList.size(); i++) {
			if(UMLcanvas.getInstance().groupList.get(i).groupedList.contains(pressOnObject)) {
				break;
			}
		}
		pressOnObject.label = JOptionPane.showInputDialog("Please input a value"); 
		if (pressOnObject.label!=null) {
		UMLcanvas.getInstance().repaint();
		}

	}
	public void setcurrentmode(Basicmode m) {
		this.currentmode=m;
	}
	
	public BasicObject clickOnObject(int x, int y) {
		for (int i = 0; i < Objlist.size(); i++) {
			if( Objlist.get(i).leftupX < x && Objlist.get(i).leftupX+60 > x && Objlist.get(i).leftupY < y && Objlist.get(i).leftupY+60 > y )
				return Objlist.get(i);
        }
		return null;
	}
	
	public void moveToListHead(BasicObject obj) {
				Objlist.remove(obj);
			    Objlist.add(0,obj);
	}


}
