import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.awt.Graphics2D;
import java.awt.BasicStroke;	
public class ThreadsInjava extends Applet 
{
	Thread th;
	String error;
	String s = "Java World";
	int width ;
	int x = 0,oldX;
	Color[] color = {Color.YELLOW,Color.WHITE,Color.RED,Color.WHITE,Color.ORANGE,
	                 Color.WHITE,Color.PINK,Color.WHITE,Color.BLUE,Color.WHITE,
					 Color.MAGENTA,Color.WHITE,Color.GRAY,Color.WHITE};
	int i=-1;
	public void init()
	{
		new Thread()
		{
			public void run()
			{
				while(true)
				{
					x+=5;
					oldX = x;
					i++;
					repaint();
					try
					{
						Thread.sleep(500);
					}
					catch(Exception e)
					{
						error = "Can't sleep";
					}
				}
			}
		}.start();
		
		width = getWidth();
	}
	public void paint(Graphics g1)
	{
		
		Graphics2D g = (Graphics2D) g1;
		g.setStroke(new BasicStroke(4));
		
		if(i > color.length-1)
			i=0;
		g.setColor(color[i]);	
		g.fillOval(79,59, 300,60);//big oval
		g.fillOval(70,150, 60,100);
		g.fillOval(320,150, 60,100);
		g.fillOval(160,140, 130,170);
		g.setColor(Color.BLACK);
		
		g.drawOval(79,59, 300,60);
		g.drawOval(70,150, 60,100);
		g.drawOval(320,150, 60,100);
		g.drawOval(160,140, 130,170);
		
		g.drawLine(80, 85, 40, 288);//right from oval
		g.drawLine(379, 90,400, 288);//left from oval 
		
		g.drawArc(40, 240,360, 100, 180, 180);
		
		g.drawLine(240, 340,260, 470);//left from Arc
		g.drawLine(200, 340,180, 470);//right from Arc
	
		g.drawRect(70, 470, 300, 50);
		
		g.setColor(Color.BLUE);	
		Font f = new Font(Font.DIALOG, Font.BOLD, 25);
		g1.setFont(f);
		for(int i=0;i<s.length();i++)
		{
			if(x > width)
			{
				x = 0;
			}
			g1.drawString(s.charAt(i)+"",x,getHeight()-100);
			if(i==5)
				x+=22;
			else if(i==7)
				x+=10;
			else if(i==8)
				x+=8;
			else
				x+=15;
			
		}
		x = oldX;
		if(x > width)
		{
			x = 0;
		}
		
		f = new Font(Font.DIALOG, Font.BOLD, 18);
		g.setColor(Color.MAGENTA);
		Date d = new Date();
		g1.setFont(f);
			
	    g1.drawString(d.toString(),(getWidth()/2)-150,getHeight()-50);
	}
	
}