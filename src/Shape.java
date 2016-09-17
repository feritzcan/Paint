import java.awt.Color;
import java.awt.Point;


public abstract class Shape {
	
	protected int x;
	protected int y;
	protected int width,height;
	public boolean isOval;
	public boolean isFilled;
	public boolean isDragging;
	Color colour;
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isOval() {
		return isOval;
	}

	public Shape(int x,int y,int width,int height,Color col)
	{
		this.colour=col;
		this.x=x;
		this.y=y;
		this.isFilled=false;
		this.width=width;
		this.isDragging=false;
		this.height=height;
	}
	
	public abstract boolean inside(Point p);

}
