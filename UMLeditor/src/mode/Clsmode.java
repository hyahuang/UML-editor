package mode;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import console.Frame;
import console.UMLcanvas;
import shape.BasicObject;
import shape.ClsObject;

public class Clsmode extends Basicmode {
	BasicObject thisObj;
	public Clsmode() {

        
	}


	@Override
	public void releaseaction(int mousepressX,int mousepressY,int mousereleaseX,int mousereleaseY,BasicObject pressOnObject,BasicObject releaseOnObject) {
        thisObj=new ClsObject(mousereleaseX,mousereleaseY);
		UMLcanvas.getInstance().Objlist.add(thisObj);
        if (releaseOnObject != null) {
        	UMLcanvas.getInstance().moveToListHead(thisObj);
        }
		
	}
	
	

}
