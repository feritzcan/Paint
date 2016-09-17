import java.awt.Color;
import java.awt.Point;


public class Oval extends Shape {

	 public Oval(int x,int y,int h,int w,Color col) {
		super(x,y,h,w,col);
		this.isOval=true;
	}
	 
	 
	public boolean inside(Point p) {

		int dx=(int) Math.abs(p.getX()-this.x);
		if(dx>width)
		{
			return false;
		}
		
		int dy=(int) Math.abs(p.getY()-this.y);
		if(dy>width)
		{
			return false;
		}
		  if ( dx+dy <= width ) return true;

		  return ( dx*dx + dy*dy <= width*width );
	}

}
