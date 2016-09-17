import java.awt.Color;
import java.awt.Point;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.Rect;


public class Rectangle  extends Shape {

	
	 public  Rectangle(int x,int y,int h,int w,Color col) {
		super(x,y,h,w,col);
		this.isOval=false;
		
	}

	@Override
	public boolean inside(Point p) {
		// TODO Auto-generated method stub
		if(p.getX()>this.x-width/2&&p.getX()<x+width/2&&p.getY()>y-height/2&&p.getY()<y+height/2)
		{
			return true;
		}
		else return false;
	}

}
