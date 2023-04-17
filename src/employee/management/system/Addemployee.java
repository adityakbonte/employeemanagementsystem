package employee.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;    // to add jcalender this library is used.
import java.util.*;    // this is used to generate random number for emp ID.
import java.awt.event.*;

public class Addemployee extends JFrame implements ActionListener{
    
    JButton add,back;
    JTextField tffirstname, tflastname, tflabelsalary, tflabelemail, tflabeladdress,tflabelphone, tflabelaadhar,tflabeldesignation;
    JDateChooser dcdob;
    JComboBox jbeducation;
    JLabel lbempid;
    
    Random ran = new Random();
    int number = ran.nextInt(99999);     // this 9 five times shows that it generates emp id of 5digit using random number genrator
    
    Addemployee(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(230,25,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,23));
        add(heading);
        
        JLabel firstname = new JLabel("First Name");
        firstname.setBounds(50,100,150,30);
        add(firstname);
        
        tffirstname = new JTextField();
        tffirstname.setBounds(150,100,150,30);
        add(tffirstname);
        
        JLabel lastname = new JLabel("Last Name");
        lastname.setBounds(350,100,150,30);
        add(lastname);
        
        tflastname = new JTextField();
        tflastname.setBounds(450,100,150,30);
        add(tflastname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,160,150,30);
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(150, 160, 150, 30);
        add(dcdob);
        
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
        
        JLabel labeleducation = new JLabel("Email");
        labeleducation.setBounds(350,280,150,30);
        add(labeleducation);
        
        String courses[] = {"B-TECH","BE","B.COM","BCA","BBA","BA","BSC","MSC","MA","M-TECH","MBA","MCA"};
        jbeducation = new JComboBox(courses);
        jbeducation.setBackground(Color.WHITE);
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
        
        tflabelaadhar = new JTextField();
        tflabelaadhar.setBounds(450,340,150,30);
        add(tflabelaadhar);
        
        JLabel labelempid= new JLabel("Employee ID");
        labelempid.setBounds(270,390,150,30);
        add(labelempid);
        
        lbempid = new JLabel(""+ number);  //  this Jlable required string inside so to insert int this way we add  //  here to gernerate JLabel is used because JLabel not able to edit 
        lbempid.setBounds(370,390,150,30);
        add(lbempid);
        
        
        add = new JButton("Add Details");
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
            String fname = tffirstname.getText();
            String lname = tflastname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();  // this getText function is work only o string so we covert this dob in jtextfield and then appky getText()
            String salary = tflabelsalary.getText();
            String address = tflabeladdress.getText();
            String phone = tflabelphone.getText();
            String email = tflabelemail.getText();
            String education = (String)jbeducation.getSelectedItem();
            String aadhar = tflabelaadhar.getText();
            String empid = lbempid.getText();
            String designation = tflabeldesignation.getText();
            
            try{
                Conn con = new Conn();
                String query = "insert into employee values('"+fname+"','"+lname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+aadhar+"','"+empid+"','"+designation+"')";  // this DMl command
                
                con.s.executeUpdate(query);    // to execute the DML query use this executeUpdate()
                JOptionPane.showMessageDialog(null,"Details Added Succcessfully");
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
        new Addemployee();
    }
}
