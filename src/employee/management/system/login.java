package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;       // this is for to use ActionListener
import java.sql.*;

public class login extends JFrame implements ActionListener{
    
    JTextField tfusername,tfpassword;     // define globally to access in actionevetlistener contructor.
    
    login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(70,100,100,30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150,100,100,30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(70,150,100,30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150,150,100,30);
        add(tfpassword);
        
        JButton login = new JButton("Login");
        login.setBounds(150,200,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,50,200,200);
        add(image);
        
        setSize(600,400);
        setLocation(450,230);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tfusername.getText();     // to get the textfeild entered info
            String password = tfpassword.getText();
            
            Conn con = new Conn();
            /// now we have to check given credentials present in table or not
            String query = "SELECT * FROM login WHERE username = '"+username+"' and password = '"+password+"' ";  // DDL command
            /// to excute this query use statement from Conn.java class
            // fot this create Conn class object her 
            
            ResultSet rs =  con.s.executeQuery(query);  // to execute DDL command use this c.s.executeQuery  // after executing this query stroering the result in ResultSet rs.
            
            if(rs.next()){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new login();
    }
}
