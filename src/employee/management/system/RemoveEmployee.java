package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cempid ;
    JButton delete,back;
    
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(30,60,100,25);
        add(empid);
        
        cempid = new Choice();
        cempid.setBounds(150,60,150,25);
        add(cempid);
        
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from employee");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelfirstname = new JLabel("Name:");
        labelfirstname.setBounds(50,110,100,25);
        add(labelfirstname);
        
        JLabel lblfirstname = new JLabel();
        lblfirstname.setBounds(150,110,100,25);
        add(lblfirstname);
        
        JLabel labelphone = new JLabel("Phone:");
        labelphone.setBounds(50,160,100,25);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(150,160,100,25);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email:");
        labelemail.setBounds(50,210,100,25);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(150,210,100,25);
        add(lblemail);        
        
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from employee where empid = '"+cempid.getSelectedItem()+"'");
            while(rs.next()){
                lblfirstname.setText(rs.getString("fname"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                        Conn con = new Conn();
                        ResultSet rs = con.s.executeQuery("select * from employee where empid = '"+cempid.getSelectedItem()+"'");
                        while(rs.next()){
                        lblfirstname.setText(rs.getString("fname"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                }
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(20,290,120,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
      
        back = new JButton("Back");
        back.setBounds(160,290,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 =  i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(280,0,600,400);
        add(image);
        
        setSize(900,450);
        setLocation(250,200);
        setVisible(true);
       
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Conn con = new Conn();
                String query = "delete from employee where empid= '"+cempid.getSelectedItem()+"'";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully!");
                setVisible(false);
                new Home();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new RemoveEmployee();
    }
    
}
