import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;

@SuppressWarnings({ "serial" })
class StackItUp extends JFrame{
	static int cntr=0,t=0;
	int i;
	JLabel  t1;
	Block actual =new Block();
	Block nextblk =new Block();

		StackItUp()
		{
			   
		super("StackItUp!!!");
				t1 = new JLabel() ;
				t1.setLocation(0,0) ; 
				ArrayList<Block> b = new ArrayList<Block>();
				Block blk= new Block();
				//blk.y-=blk.h;
				//blk.x=0;
				//b.add(blk);
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
					
					actual.keyPressed(e);
					cntr++;
					//ArrayList<Block> b = new ArrayList();
					//Block blk= new Block();
					blk.y-=blk.h;
					
					//System.out.println(blk.y);
					blk.x=0;
					b.add(blk);
					System.out.println(b.size());
					nextblk=b.get(t);
					t1.setText("SCORE :  "+cntr);
					//nextblk.keyPressed(e);
					//if(cntr>=8) nextblk.drop();
					//nextblk.nextrect();
				}
			});
			setFocusable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(720,720);
			
			//setBackground(Color.red);
			
			setResizable(false);
			setVisible(true);
			add(t1);
			
			}
			
		public void move() {
			actual.moverect();
			nextblk.moverect();
			
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			actual.paint(g);
			nextblk.paint(g);
		}
		public static void main(String[]args)throws InterruptedException {
		{
			 StackItUp rect=new StackItUp();
			 while(true)
			 {
				rect.move();
				rect.repaint();
				Thread.sleep(150);	 
			 }
		}
	}
}
@SuppressWarnings("serial")
 class Block extends JFrame {
	double vel=2.0;
	int x=0,w=250,h=50,y=600,r=255,gn=255,b=255;
	 Block(){
		 int r = (int)(Math.random()*((255+1)));
		 int gn = (int)(Math.random()*((255+1)));
		 int b = (int)(Math.random()*((255+1)));
			
		 double vel=2.0;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h= h;
		this.vel=vel;
		this.r=r;
		this.gn=gn;
		this.b=b;
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
	 g.setColor(new Color(r, gn, b)); //apply random value using rand()
		//g.setColor(Color.RED);
	 g.fillRect(x,y,w,h);
	}
	void drop() {
		
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			vel = 0;		
		}
	}
}