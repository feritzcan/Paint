import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class DrawArea  extends JComponent{
	
	private Image image,openedImg;
	private Graphics2D g2;
	private int penType	;
	private int penSize;
	
	private Color fillcol=Color.white;
	private int clickx,clicky;
	private ArrayList<Shape> shapes;
	private boolean opened=false;
	
	
	Random random=new Random();
	
	private int currentX,currentY,oldX,oldY;
	
	public DrawArea()
	{
		shapes=new ArrayList<Shape>();
		setDoubleBuffered(false);
		this.penType=2;
		this.penSize=1;
		
		addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e)
			{
				System.out.println("relase");
			for(int a=0;a<shapes.size();a++)
			{
				shapes.get(a).isDragging=false;
			}
			}
			public void mousePressed(MouseEvent e)
			{
				clickx=e.getX();
				clicky=e.getY();
				oldX=e.getX();
				oldY=e.getY(); 
				
				//FİLL
				if(penType==10)
				
				{	boolean nothing=true;
					for(int a=shapes.size()-1;a>=0;a--)
					{
						System.out.println(shapes.get(a).inside(new Point(e.getX(),e.getY())));
						if(shapes.get(a).inside(new Point(e.getX(),e.getY())))
						{
							nothing=false;
							if(shapes.get(a).isOval==true)
							{
								if(shapes.get(a).isFilled==false)
								{
									g2.fillOval(shapes.get(a).getX()+shapes.get(a).getWidth()/128
											, shapes.get(a).getY()+shapes.get(a).getWidth()/128, shapes.get(a).getWidth(), shapes.get(a).getWidth());
									repaint();
									shapes.get(a).isFilled=true;
									
									
								}
								else
								{
									break;
									
								}
							}
							else
							{
								if(shapes.get(a).isFilled==false)
								{
									g2.fillRect(shapes.get(a).getX()-shapes.get(a).getWidth(), shapes.get(a).getY()-shapes.get(a).getWidth(), shapes.get(a).getWidth(), shapes.get(a).getWidth());
									repaint();
									shapes.get(a).isFilled=true;
									
								}
								else
								{
									break;
									
								}
							}
						}
					}
					
					if(nothing==true)
					{
						fillcol=g2.getColor();
						g2.fillRect(0, 0, getWidth(),	 getHeight());
						
						
						repaint();
					}
				}

				//OVAL
				if(g2!=null&&penType==4)
				{
					
					Oval oval=new Oval(e.getX(), e.getY(), penSize, penSize,g2.getColor());
					oval.isDragging=true;
					//g2.drawOval(e.getX()-penSize/2, e.getY()-penSize/2, penSize, penSize);
					
					shapes.add(oval);
					
					repaint();
				}
				//RECT
				if(g2!=null&&penType==5)
				{
					g2.drawRect(e.getX()-penSize/2, e.getY()-penSize/2, penSize, penSize);
					shapes.add(new Rectangle(e.getX(), e.getY(), penSize, penSize,g2.getColor()));
					
					repaint();
				}
				
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e)
			{
				currentX=e.getX();
				currentY=e.getY();
				
				for(int a=0;a<shapes.size();a++)
				{
					if(shapes.get(a).isDragging==true)
					{
						
						Color temp=g2.getColor();
						g2.setPaint(fillcol);
						g2.fillRect(shapes.get(a).x, shapes.get(a).y, shapes.get(a).height+1, shapes.get(a).height+1);
						g2.setPaint(temp);
						g2.drawOval(shapes.get(a).x, shapes.get(a).y, Math.abs(e.getX()-clickx),Math.abs(e.getX()-clickx));
						if(shapes.get(a).isOval==false)
						{
							g2.drawRect(shapes.get(a).x, shapes.get(a).y, Math.abs(e.getX()-clickx),Math.abs(e.getX()-clickx));

						}
						shapes.get(a).height=Math.abs(e.getX()-clickx);
						shapes.get(a).width=Math.abs(e.getX()-clickx);

						repaint();
						oldX=currentX;
						oldY=currentY;
					}
				}
				
				if(g2!=null&&penType==1)
				{
					for(int a=0;a<penSize;a++)
					{
						g2.drawLine(oldX+a, oldY+a,currentX+a, currentY+a);

					}
					
					repaint();
					oldX=currentX;
					oldY=currentY;
				}
				if(g2!=null&&penType==2)
				{
					int a=random.nextInt(10);
					boolean b=random.nextBoolean();
					
					if(b)
					{
						g2.fillRect(currentX+a, currentY+a, penSize, penSize);

					}
					else
					{
						g2.fillRect(currentX-a, currentY-a, penSize, penSize);

					}
					repaint();
					oldX=currentX;
					oldY=currentY;
				}
				if(g2!=null&&penType==3)
				{
					g2.setPaint(Color.WHITE);
					
					g2.fillRect(currentX, currentY, penSize, penSize);
					g2.setPaint(Color.black);
					repaint();
				}
				
			}
		});
	}
	
	public void setImage(Image im)
	{
		opened=true;
		openedImg=im;

				repaint();
	}
	public void newFile()
	{
		image=createImage(getSize().width,getSize().height);
		g2=(Graphics2D) image.getGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		clear();
	}

	public void takeSnapShot(String path){
	       BufferedImage bufImage = new BufferedImage(getSize().width, getSize().height,BufferedImage.TYPE_INT_RGB);
	       paint(bufImage.createGraphics());
	       File imageFile = new File(path+"/new"+"."+"jpg");
	    try{
	        imageFile.createNewFile();
	        ImageIO.write(bufImage, "jpeg", imageFile);
	    }catch(Exception ex){
	    }
	}
	public void paintComponent(Graphics g)
	{
		if(image==null)
		{
			image=createImage(getSize().width,getSize().height);
			g2=(Graphics2D) image.getGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
			
		}
		g.drawImage(image,0, 0, null);
		g.drawImage(openedImg, 0, 0, null);

	}
	
	public void setPen(int type)
	{
		this.penType=type;
	}
	public void setPenSize(int size)
	{
		this.penSize=size;
	}
	public void clear()
	{
		fillcol=Color.WHITE;
		g2.setPaint(Color.WHITE);
		
		g2.fillRect(0, 0, getSize().width, getSize().height);
		g2.setPaint(Color.black);
		repaint();
	}
	public void setColor(Color color)
	{
		g2.setPaint(color);
	}
}
