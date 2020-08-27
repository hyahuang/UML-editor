package mode;

import console.Frame;
import console.UMLcanvas;
import shape.BasicObject;
import shape.UsecaseObject;

public class Usecasemode extends Basicmode {
	BasicObject thisObj;
	public Usecasemode() {

        
	}


	@Override
	public void releaseaction(int mousepressX,int mousepressY,int mousereleaseX,int mousereleaseY,BasicObject pressOnObject,BasicObject releaseOnObject) {
        thisObj=new UsecaseObject(mousereleaseX,mousereleaseY);
		UMLcanvas.getInstance().Objlist.add(thisObj);
        if (releaseOnObject != null) {
        	UMLcanvas.getInstance().moveToListHead(thisObj);
        	System.out.print("click on");
        }
		
	}
}
