package mode;

import console.Frame;
import console.UMLcanvas;
import line.AssociationLineObject;
import line.BasicLine;
import shape.BasicObject;

public class Associationmode extends Basicmode{
	BasicLine thisLine;
	@Override
	public void releaseaction(int mousepressX,int mousepressY,int mousereleaseX,int mousereleaseY,BasicObject pressOnObject,BasicObject releaseOnObject) {

        if (pressOnObject != null &&releaseOnObject != null && pressOnObject!=releaseOnObject) {
            thisLine = new AssociationLineObject(mousepressX,mousepressY,mousereleaseX,mousereleaseY,pressOnObject,releaseOnObject);
    		UMLcanvas.getInstance().lineList.add(thisLine);
        }
		
	}
	

}
