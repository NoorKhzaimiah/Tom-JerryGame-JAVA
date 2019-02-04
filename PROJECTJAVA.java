
package projectjava;
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class MMYFrame extends JFrame {
    MMYFrame(){
          Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit.getScreenSize();
this.setSize((int)dim.getWidth(), (int)dim.getHeight());
    Container r=this.getContentPane();
     r.add(new MMyPanel ());
         this.setTitle("JAVA GAME ");
      this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } }///// end of class
    
    class MMyPanel extends JPanel {
      JButton B1 = new JButton(" START ! ") ;
      
         public void paintComponent(Graphics g)   {   
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      Toolkit kit = Toolkit.getDefaultToolkit();
              Image img =kit.getImage("d:\\g1.jpg");
             g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); }
      MMyPanel(){
           B1.setSize(500, 400 );
           B1.setBackground(Color.yellow);
           B1.addActionListener(new AL());
            this.add(B1);
      }
      class AL implements ActionListener{
           public void actionPerformed(ActionEvent e){
               if (e.getSource() ==B1)
                   new MyFrame();
                
           }
     }   
     }// end of MMypanel class
    
    class MyFrame extends JFrame{
    MyFrame(){
          Toolkit kit = Toolkit.getDefaultToolkit();
          Dimension dim = kit.getScreenSize();
this.setSize((int)dim.getWidth(), (int)dim.getHeight());
    this.setDefaultCloseOperation(3);
    Container c=this.getContentPane();
     c.add(new MyPanel());
       this.setTitle("JAVA GAME ");
   
this.setIconImage(kit.getImage("D:\\M.PNG"));
    this.setVisible(true);
    }
}// end Myframe class
    
    class MyPanel extends JPanel{
        JPanel panel=this;
  
       int x=120,y=450;
       int Y1,Y2,Y3,Y4, score=0 , timer=0;
       int X1 =100 , X2=600, X3=400 , X4=200 ;
    
        
             
               
        MyPanel(){ 
            new TimerA().start();
            new TimerB().start();
            new TimerC().start();
            new TimerD().start();
            this.setFocusable(true);
            this.addKeyListener(new KL());
        }//
        
public void paintComponent(Graphics g)   {   
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      Toolkit kit = Toolkit.getDefaultToolkit();
              Image img =kit.getImage("d:\\B.jpg");
             g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); 
              Font f = new Font("BankGothic Md BT",Font.BOLD,40);
               g2.setFont(f);
             // g2.setColor(Color.white);
              //g2.drawString("Welcome ", 50, 70);
               g2.setColor(Color.yellow);
               g2.drawString("Score: " + score, 1020  ,360  );
               g2.setColor(Color.black);
               Font ff = new Font("BankGothic Md BT",Font.BOLD,20);
               g2.setFont(ff);
              
              g2.drawString("Time: " + timer, 1000  ,390  );
                         Line2D line = new Line2D.Double(this.getWidth()-50,this.getHeight()-50, 50, this.getHeight()-50);
                           g2.draw(line);            
                         Image img1 =kit.getImage("d:\\M.PNG");
                         g2.drawImage(img1, x , y , 200  , 200, this);
                          Image imm = kit.getImage("d:\\C.PNG");
                        Image immR = kit.getImage("d:\\R.PNG");
                          
                                      
                 g2.drawImage(imm , X1 , Y1 ,  50 ,50 , this); 
                 g2.drawImage(imm , X2, Y2 , 50 , 50, this);
                 g2.drawImage(imm , X3 , Y3 ,  50 ,  50, this);
                 g2.drawImage(imm , X4 , Y4 ,  50 ,50 , this); 
                
               //  g2.drawImage(immR , CC , RR , 50 , 50, this);
                         
                        
                           
    }// paint comp
class KL implements KeyListener{
boolean shift=false;
        public void keyPressed(KeyEvent e){
if (e.getKeyCode()==KeyEvent.VK_SHIFT)
    
    shift=true;
if (e.getKeyCode() == KeyEvent.VK_LEFT)
    if (shift){
       if(x>0)
        x-=20;}
else
    x--;
    else
if (e.getKeyCode() == KeyEvent.VK_RIGHT)    
    if (shift){
        if(x!=1000&&x<800)
        x+=20;
    }
else
  x++;
     panel.repaint();
        
        }
        public void keyTyped(KeyEvent e){
        }
        public void keyReleased(KeyEvent e){
         if (e.getKeyCode()==KeyEvent.VK_SHIFT)
    shift=false;
        }  
    }//KL 


class TimerA extends Thread{
      public void run(){
          try{    
               int vY=(int)(Math.random()*50);
               while (true){
                   Y1+=vY;
                    if (Y1<=panel.getHeight()-y){
                   if((X1 >=x && X1<=x+50)&&(Y1 >=y && Y1<=y+50))
                       score++;
                    Y1=0;}
                Thread.sleep(600);
         panel.repaint(); 
       
               }
        
          }

catch ( Exception e ) {
               
          };  
      }
}//timerA
class TimerB extends Thread{
      public void run(){
          try{    
               int vYY=(int)(Math.random()*50);
               while (true){
                   Y2+=vYY;
                    if (Y2<=panel.getHeight()-y){
                   if((X2 >=x && X2<=x+50)&&(Y2 >=y && Y2<=y+50))
                       score++;
                         Y2=0;}
                 
                  
               vYY=(int)(Math.random()*50);
                Thread.sleep(400);
         panel.repaint(); 
         
               }
        
          }

catch ( Exception e ) {
               
          };  
      }
}//timerB 

class TimerC extends Thread{
      public void run(){
          try{    
               int vYYY=(int)(Math.random()*50);
               while (true){
                   Y3+=vYYY;
                     if (Y3<=panel.getHeight()-y){
                   if((X3 >=x && X3<=x+50)&&(Y3 >=y && Y3<=y+50))
                       score++;
                     Y3=0;}
                 
               vYYY=(int)(Math.random()*1000);
                Thread.sleep(250);
         panel.repaint(); 
               }
        
          }

catch ( Exception e ) {
               
          };  
      }
}//timer C

class TimerD extends Thread{
      public void run(){
          try{    
               int vYYYY=(int)(Math.random()*1000);
               while (true){
                   Y4+=vYYYY;
                    if (Y4<=panel.getHeight()-y){
                   if((X4 >=x && X4<=x+50)&&(Y4 >=y && Y4<=y+50))
                       score++;
                          Y4=0;}
                   timer++;
               vYYYY=(int)(Math.random()*50);
                Thread.sleep(1000);
         panel.repaint(); 
               }
        
          }

catch ( Exception e ) {
               
          };  
      }
}
    }//panel




 public class PROJECTJAVA {
    public static void main(String[] args) {
        new MMYFrame ();
    }
    
}
