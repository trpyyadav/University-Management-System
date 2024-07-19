
package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    
    Thread t;
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(934, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image); 
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        int x = 1;
        for(int i=100;i<=592;i+=5,x+=1){
        setLocation(492 - (i+x)/2,342 - (i/2));
        setSize(i + 4*x,i+(x/4));
        
        try{
        Thread.sleep(10);
        } catch(Exception e) {}
        
        
        }
        //setSize(984,600);
        
    }
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);

            //NEXT FRAME
            new Login();
        } catch(Exception e){}
        
    }
    
    public static void main(String args[]){
        new Splash();
    }
    
}
