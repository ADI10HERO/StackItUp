
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;

@SuppressWarnings({ "serial", "unused" })
class StackItUp extends JFrame{
	static int cntr=0,t=0;
	int i;
	JLabel  t1;
	

		Block[] b= new Block[30];

	
		StackItUp()
		{
			   
		super("StackItUp!!!");
				t1 = new JLabel() ;
			t1.setBounds(200,100,50,30) ; 
			
			

//ArrayList<Block> b = new ArrayList();
    for (int i = 0; i < b.length; i++)
            b[i] = new Block();
    
//actual=b.get(0);
			addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
				}
				@Override
				public void keyReleased(KeyEvent e) {
					}
				
				@Override
				public void keyPressed(KeyEvent e) {
					
					b[t].keyPressed(e);
					t++;
					
					//nextblk=b.get(t);
					b[t].nextrect();
					cntr++;
				t1.setText("SCORE :  "+cntr);
					
				
				}
			});
			setFocusable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(720,720);
			setResizable(false);
			setVisible(true);
			add(t1);
			}
			
		public void move() {
			 for (Block ablock : b) ablock.moverect();
			//actual.moverect();
			//nextblk.moverect();
			
		}
		@Override
		public void paint(Graphics g) {
		g.setColor(Color.black);
		for (Block ablk : b) {
            ablk.paint(g);
        }
			
		//actual.paint(g);
		//nextblk.paint(g);
		
			
		}
		public static void main(String[]args)throws InterruptedException {
		{
			 StackItUp rect=new StackItUp();
			 while(true)
			 {
				rect.move();
				rect.repaint();
				Thread.sleep(15);	 
			 }
		}
	}
}
@SuppressWarnings("serial")
 class Block extends JFrame {
	double vel=2.0;
	int x=0,w=250,h=50,y=600,r=255,g=255,b=255;
	 Block(){
		double vel=2.0;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h= h;
		this.vel=vel;
	}
 	

	public void moverect()
	{	
		if(x+vel<720 && x+vel>0)
		{x+=vel;
		}
		if(x+vel>=720-w)
		 {vel=vel*(-1);
		  x+=vel;
		 }
		if(x+vel==0)
		{vel=vel*(-1);
		  x+=vel;
		 }
	}
	public void nextrect()
	{	
		y-=h;
		x=0;
	   
	}
	
	@Override
	public void paint(Graphics g)
	{
	 g.setColor(Color.RED); 
	 g.fillRect(x,y,w,h);
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			vel = 0;	
			
			
		}
	}
}