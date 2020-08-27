package shape;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import console.Frame;
import console.UMLcanvas;

public class Group extends BasicObject{
		public ArrayList<BasicObject> groupedList;
		public Group(ArrayList<BasicObject> groupedList ) {
			this.groupedList = new ArrayList(groupedList);
			System.out.print(this.groupedList);
		}
		@Override
		public void showPort() {
			for (int i = 0; i < groupedList.size(); i++) {
				groupedList.get(i).showPort();
	        }
		}
		@Override
		public void hidePort() {
			for (int i = 0; i < groupedList.size(); i++) {
				groupedList.get(i).hidePort();
	        }
		}
		@Override
		public void move(int mousepressX, int  mousepressY, int mousereleaseX, int mousereleaseY) {
			for (int i = 0; i < groupedList.size(); i++) {
				groupedList.get(i).move(mousepressX, mousepressY, mousereleaseX, mousereleaseY);
	        }
		}
		@Override
		public void moveObjToFront() {
			for (int i = 0; i < groupedList.size(); i++) {
				groupedList.get(i).moveObjToFront();
	        }
		}
		public void moveListToListHead() {

			for (int i = 0; i < groupedList.size(); i++) {
				UMLcanvas.getInstance().moveToListHead(groupedList.get(i));
	        }
		}
		
}
