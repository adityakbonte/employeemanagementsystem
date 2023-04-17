/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;
import java.awt.*;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
    
    JButton add,view,update,remove;
    
    Home(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,500);
        add(image);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(450,30,400,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        image.add(heading);
        
        add = new JButton("Add Eployee");
        add.setBounds(450,100,150,30);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Employees");
        view.setBounds(630,100,150,30);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Eployee");
        update.setBounds(450,150,150,30);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(630,150,150,30);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(900,500);
        setLocation(250,180);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            setVisible(false);
            new Addemployee();
        }
        else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new ViewEmployee();
        }
        else{
            setVisible(false);
            new RemoveEmployee();
        }
    }
    
    public static void main(String[] args){
        new Home();
    }
    
}
