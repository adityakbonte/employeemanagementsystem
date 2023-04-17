package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;      // it is used for adding data ito table.  this library present inside the rs2xml jar file
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table;
    Choice cemployeeId;
    JButton search,update,back,print;
    
    ViewEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee ID");
        searchlbl.setBounds(20,30,150,25);
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180,30,150,25);
        add(cemployeeId);
        
        search = new JButton("Search");
        search.setBounds(100,60,150,25);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(280,60,150, 25);
        print.addActionListener(this);
        add(print);
   
        back = new JButton("Back");
        back.setBounds(450,60,150,25);
        back.addActionListener(this);
        add(back);
        
        update = new JButton("Update");
        update.setBounds(620,60,150,25);
        update.addActionListener(this);
        add(update);
        
        table = new JTable();
        
        // this try and catch for adding the emp_id ito the choice by using while loop
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from employee");
            while(rs.next()){
                cemployeeId.add(rs.getString("empId"));
            }
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        //this try and catch for add info into the table
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));     // using this data is added into table.
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        // if we want scrollbar here to add this
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,912,630);
        add(jsp);
        
        
        
        setSize(920,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query = "select * from employee where empid = '"+cemployeeId.getSelectedItem()+"'";
            try{
                Conn con = new Conn();
                ResultSet rs = con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        }
        else if(ae.getSource()==print){            
           try{
               table.print();
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
        new ViewEmployee();
    }
}
