package employee.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
//import java.sql.ResultSet;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JButton add,back;
    JTextField  tflabelsalary, tflabelemail, tflabeladdress,tflabelphone, tflabeldesignation, jbeducation;
    String empId;
    
    UpdateEmployee(String empid){
        
        this.empId = empid;
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(230,25,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,23));
        add(heading);
        
        JLabel firstname = new JLabel("First Name");
        firstname.setBounds(50,100,150,30);
        add(firstname);
        
        JLabel tffirstname = new JLabel();      // convert into JLabel because we didn't give update chance here in name
        tffirstname.setBounds(150,100,150,30);
        add(tffirstname);
        
        JLabel lastname = new JLabel("Last Name");
        lastname.setBounds(350,100,150,30);
        add(lastname);
        
        JLabel tflastname = new JLabel();
        tflastname.setBounds(450,100,150,30);
        add(tflastname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,160,150,30);
        add(labeldob);
        
        JLabel dob = new JLabel();
        dob.setBounds(150,160,150,30);
        add(dob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(350, 160, 150, 30);
        add(labelsalary);
        
        tflabelsalary = new JTextField();
        tflabelsalary.setBounds(450,160,150,30);
        add(tflabelsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,220,150,30);
        add(labeladdress);
        
        tflabeladdress = new JTextField();
        tflabeladdress.setBounds(150,220,150,30);
        add(tflabeladdress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(350,220,150,30);
        add(labelphone);
        
        tflabelphone = new JTextField();
        tflabelphone.setBounds(450,220,150,30);
        add(tflabelphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,280,150,30);
        add(labelemail);
        
        tflabelemail = new JTextField();
        tflabelemail.setBounds(150,280,150,30);
        add(tflabelemail);
        
        JLabel labeleducation = new JLabel("Highest Edu");
        labeleducation.setBounds(350,280,150,30);
        add(labeleducation);

        jbeducation = new JTextField();
        jbeducation.setBounds(450,280,150,30);
        add(jbeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,340,150,30);
        add(labeldesignation);
        
        tflabeldesignation = new JTextField();
        tflabeldesignation.setBounds(150,340,150,30);
        add(tflabeldesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar No");
        labelaadhar.setBounds(350,340,150,30);
        add(labelaadhar);
        
        JLabel tflabelaadhar = new JLabel();
        tflabelaadhar.setBounds(450,340,150,30);
        add(tflabelaadhar);
        
        JLabel labelempid= new JLabel("Employee ID");
        labelempid.setBounds(270,390,150,30);
        add(labelempid);
        
        JLabel lbempid = new JLabel();  //  this Jlable required string inside so to insert int this way we add  //  here to gernerate JLabel is used because JLabel not able to edit 
        lbempid.setBounds(370,390,150,30);
        add(lbempid);
        
        
        
        try{
            
            Conn con = new Conn();
            String query = "select * from employee where empid = '"+empId+"'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                tffirstname.setText(rs.getString("fname"));
                tflastname.setText(rs.getString("lname"));
                dob.setText(rs.getString("dob"));
                tflabeladdress.setText(rs.getString("address"));
                tflabelaadhar.setText(rs.getString("addhar"));
                lbempid.setText(rs.getString("empid"));
                tflabelsalary.setText(rs.getString("salary"));
                tflabelphone.setText(rs.getString("phone"));
                tflabelemail.setText(rs.getString("email"));
                tflabeldesignation.setText(rs.getString("designation"));
                jbeducation.setText(rs.getString("education"));
            }  
        }catch(Exception e){
            e.printStackTrace();
        }

       
        
        add = new JButton("Update Details");
        add.setBounds(180,440,150,35);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(360,440,150,35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
       
        setSize(700,550);
        setLocation(400,180);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String salary = tflabelsalary.getText();
            String address = tflabeladdress.getText();
            String phone = tflabelphone.getText();
            String email = tflabelemail.getText();
            String education = jbeducation.getText();
            String designation = tflabeldesignation.getText();
            
            try{
                Conn con = new Conn();
                String query = "update employee set salary = '"+salary+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where empid = '"+empId+"'" ;  // this DMl command
                 
                con.s.executeUpdate(query);    // to execute the DML query use this executeUpdate()
                JOptionPane.showMessageDialog(null,"Details updated Succcessfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new UpdateEmployee("");
    }
}
