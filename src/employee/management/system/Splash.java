package employee.management.system;

////////////////// this project has only Admin login.//////////////////////

import javax.swing.*;
import java.awt.*;       // to use color ,font this function on frame
import java.awt.event.*;   // to use events like, implement ActionListener.

public class Splash extends JFrame implements ActionListener{
    
    Splash(){
        
        setLayout(null);          /// by default layout id border layout 
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");    // this JLabel called component
        add(heading);
        heading.setBounds(140,40,1200,80);     // this we have to use our own layout which we make null
        heading.setFont(new Font("seirf",Font.BOLD, 50));
        heading.setForeground(Color.red);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(80,120,1000,500);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400,400,200,50);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);   //   image.add(), this means that it is relative to image.
        
        getContentPane().setBackground(Color.white);    // to change the default color of frame
        setSize(1170,650);
        setLocation(200,50);   // by default frame is at right most top corner but if we want change its position then use this function
        setVisible(true);   // by default frame is hidden but to make it visible this method is used.
        
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(300);
            }catch(Exception e){
                
            }
            heading.setVisible(true);
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae){     // this is use to remove the error in splash beacuse ut is we habe override this same method then it error removes.
        setVisible(false);
        new login();
    }
    
    public static void main(String args[]){
        new Splash();
    }
}

