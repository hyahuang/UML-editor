package mode;

import java.util.ArrayList;

import console.Frame;
import console.UMLcanvas;
import shape.BasicObject;

public class Selectmode extends Basicmode{
	boolean ismoved=false;
	@Override
	public void releaseaction(int mousepressX,int mousepressY,int mousereleaseX,int mousereleaseY,BasicObject pressOnObject,BasicObject releaseOnObject) {
		UMLcanvas.getInstance().groupedList.clear();
		Frame.menubar.groupMenuItem.setEnabled(false);
		Frame.menubar.ungroupMenuItem.setEnabled(false);
		Frame.menubar.changenameMenuItem.setEnabled(false);
		if (pressOnObject != null && releaseOnObject != null) {
        	for (int i = 0; i < UMLcanvas.getInstance().Objlist.size(); i++) {
    				UMLcanvas.getInstance().Objlist.get(i).hidePort();
    		}
           if (pressOnObject==releaseOnObject) {
           		pressOnObject.showPort();
           		pressOnObject.moveObjToFront();
           		UMLcanvas.getInstance().moveToListHead(pressOnObject);
        		Frame.menubar.changenameMenuItem.setEnabled(true);
	    		for (int i = 0; i < UMLcanvas.getInstance().groupList.size(); i++) {
	    			if(UMLcanvas.getInstance().groupList.get(i).groupedList.contains(pressOnObject)) {
	    				UMLcanvas.getInstance().groupList.get(i).showPort();
	    				UMLcanvas.getInstance().groupList.get(i).moveObjToFront();
	    				UMLcanvas.getInstance().groupList.get(i).moveListToListHead();
	    				Frame.menubar.ungroupMenuItem.setEnabled(true);
	    				Frame.menubar.changenameMenuItem.setEnabled(false);
	    				break;
	    			}
	    		}
            }
           else if (pressOnObject!=releaseOnObject) {
	    		for (int i = 0; i < UMLcanvas.getInstance().groupList.size(); i++) {
	    			if(UMLcanvas.getInstance().groupList.get(i).groupedList.contains(pressOnObject)) {
	    				UMLcanvas.getInstance().groupList.get(i).move(mousepressX,mousepressY,mousereleaseX,mousereleaseY);
	    				UMLcanvas.getInstance().groupList.get(i).moveObjToFront();
	    				UMLcanvas.getInstance().groupList.get(i).moveListToListHead();
	    				ismoved = true;
	    				break;
	    			}
	    		}
	    		if(!ismoved) {
	    			pressOnObject.move(mousepressX,mousepressY,mousereleaseX,mousereleaseY);
	    		}
	    		ismoved = false;
           }
        }
        else if(pressOnObject == null && releaseOnObject == null) {
    		if (mousepressX>mousereleaseX){
    			int tmp;
    			tmp = mousepressX;
    			mousepressX=mousereleaseX;
    			mousereleaseX=tmp;
    		}
    		if (mousepressY>mousereleaseY){
    			int tmp;
    			tmp = mousepressY;
    			mousepressY=mousereleaseY;
    			mousereleaseY=tmp;
    		}
    		for (int i = 0; i < UMLcanvas.getInstance().Objlist.size(); i++) {
    			if (mousepressX<UMLcanvas.getInstance().Objlist.get(i).leftupX && mousereleaseX>UMLcanvas.getInstance().Objlist.get(i).leftupX+60 && mousepressY<UMLcanvas.getInstance().Objlist.get(i).leftupY && mousereleaseY>UMLcanvas.getInstance().Objlist.get(i).leftupY+60 ) {	
    				UMLcanvas.getInstance().Objlist.get(i).showPort();
    				UMLcanvas.getInstance().groupedList.add(UMLcanvas.getInstance().Objlist.get(i));
    			}
    			else {
    	    			 UMLcanvas.getInstance().Objlist.get(i).hidePort();
    			}
    			if (UMLcanvas.getInstance().groupedList.size()>1) {
    				Frame.menubar.groupMenuItem.setEnabled(true);
    			}
            }

        }
        else if (pressOnObject != null && releaseOnObject == null) {
        	for (int i = 0; i < UMLcanvas.getInstance().Objlist.size(); i++) {
    				UMLcanvas.getInstance().Objlist.get(i).hidePort();
    		}
        	for (int i = 0; i < UMLcanvas.getInstance().groupList.size(); i++) {
    			if(UMLcanvas.getInstance().groupList.get(i).groupedList.contains(pressOnObject)) {
    				UMLcanvas.getInstance().groupList.get(i).move(mousepressX,mousepressY,mousereleaseX,mousereleaseY);
    				UMLcanvas.getInstance().groupList.get(i).moveObjToFront();
    				UMLcanvas.getInstance().groupList.get(i).moveListToListHead();
    				ismoved = true;
    				break;
    			}
    		}
    		if(!ismoved) {
    			pressOnObject.move(mousepressX,mousepressY,mousereleaseX,mousereleaseY);
    		}
    		ismoved = false;
    		for (int i = 0; i < UMLcanvas.getInstance().lineList.size(); i++) {
    			UMLcanvas.getInstance().lineList.get(i).move();
            }
        }
	}
}
