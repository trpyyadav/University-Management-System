
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.event.ItemListener;



public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField tfaddress,tfphone,tfemail,tfcourse,tfbranch;
    JLabel labelempid;
    
     
    JButton submit,cancel;
    Choice empid;

   
    UpdateTeacher(){

        getContentPane().setBackground(Color.YELLOW);

        setSize(800,550);
        setLocation(250,70);

        setLayout(null);

        JLabel heading = new JLabel("UPDATE FACULTY DETAILS...");
        heading.setBounds(50,20,500,50);
        heading.setFont(new Font("TAHOMA",Font.ITALIC,30));
        add(heading);

        JLabel sEMPID = new JLabel("SELECT EMPLOYEE ID");
        sEMPID.setBounds(50,80,200,20);
        add(sEMPID);

        
        empid = new Choice();
        empid.setBackground(Color.WHITE);
        empid.setBounds(300,80,200,20);
        add(empid);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                empid.add(rs.getString("emp_id"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,130,150,20);
        lblname.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(170,130,100,25);
        labelname.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(labelname);

        JLabel lblfname = new JLabel(" Father's Name");
        lblfname.setBounds(350,130,150,20);
        lblfname.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(550,130,100,25);
        labelfname.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(labelfname);

        JLabel lblempid = new JLabel("Employee Id");
        lblempid.setBounds(50,180,150,20);
        lblempid.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblempid);

        labelempid = new JLabel();
        labelempid.setBounds(170,178,100,25);
        labelempid.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(labelempid);

        JLabel lbldob = new JLabel(" Date of Birth");
        lbldob.setBounds(350,180,150,20);
        lbldob.setFont(new Font("serifs",Font.ITALIC,20));
        add(lbldob);

        JLabel lbdob = new JLabel();
        lbdob.setBounds(550,178,100,25);
        lbdob.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(lbdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,226,150,20);
        lbladdress.setFont(new Font("serifs",Font.ITALIC,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(170,226,100,25);
        tfaddress.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(tfaddress);

        JLabel lblphone = new JLabel(" Phone");
        lblphone.setBounds(350,230,150,20);
        lblphone.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(550,226,100,25);
        tfphone.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50,274,150,20);
        lblemail.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(170,274,100,25);
        tfemail.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(tfemail);

        JLabel lblclassX = new JLabel("Class X(%)");
        lblclassX.setBounds(350,280,150,20);
        lblclassX.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblclassX);

        JLabel labelclassX = new JLabel();
        labelclassX.setBounds(550,274,100,25);
        labelclassX.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(labelclassX);

        JLabel lblclassXII = new JLabel("Class XII(%)");
        lblclassXII.setBounds(50,322,150,20);
        lblclassXII.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblclassXII);

        JLabel labelclassXII = new JLabel();
        labelclassXII.setBounds(170,322,100,25);
        labelclassXII.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(labelclassXII);

        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(350,330,150,20);
        lblaadhar.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblaadhar);

        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(550,322,100,25);
        labelaadhar.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(labelaadhar);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50,370,150,20);
        lblcourse.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(350,380,150,20);
        lblbranch.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblbranch);

        
        tfcourse = new JTextField();
        tfcourse.setBackground(Color.WHITE);
        tfcourse.setBounds(170,370,100,25);
        add(tfcourse);

        
        tfbranch = new JTextField();
        tfbranch.setBackground(Color.WHITE);
        tfbranch.setBounds(550,370,100,25);
        add(tfbranch);

        try{
            Conn c = new Conn();
            String query = "select * from teacher where emp_id ='"+empid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("NAME"));
                labelfname.setText(rs.getString("FATHER_NAME"));
                lbdob.setText(rs.getString("DOB"));
                tfaddress.setText(rs.getString("ADRESS"));
                tfphone.setText(rs.getString("PHONE"));
                tfemail.setText(rs.getString("EMAIL"));
                labelclassX.setText(rs.getString("CLASSX"));
                labelclassXII.setText(rs.getString("CLASSXII"));
                labelaadhar.setText(rs.getString("AADHAR"));
                labelempid.setText(rs.getString("emp_id"));
                tfcourse.setText(rs.getString("qualification"));
                tfbranch.setText(rs.getString("department"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        empid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from teacher where emp_id ='"+empid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("NAME"));
                        labelfname.setText(rs.getString("FATHER_NAME"));
                        lbdob.setText(rs.getString("DOB"));
                        tfaddress.setText(rs.getString("ADRESS"));
                        tfphone.setText(rs.getString("PHONE"));
                        tfemail.setText(rs.getString("EMAIL"));
                        labelclassX.setText(rs.getString("CLASSX"));
                        labelclassXII.setText(rs.getString("CLASSXII"));
                        labelaadhar.setText(rs.getString("AADHAR"));
                        labelempid.setText(rs.getString("emp_id"));
                        tfcourse.setText(rs.getString("qualification"));
                        tfbranch.setText(rs.getString("department"));
                    }
        
                }catch(Exception e){
                    e.printStackTrace();
                }
                

            }

        });

        submit = new JButton("UPDATE");
        submit.setBounds(200,450,120,35);
        submit.addActionListener(this);
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.WHITE);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(380,450,120,35);
        cancel.addActionListener(this);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.WHITE);
        add(cancel);


        


        



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String empid = labelempid.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            try{
                String query = "update teacher set ADRESS='"+address+"',PHONE='"+phone+"',EMAIL='"+email+"',qualification='"+course+"',department='"+branch+"'where emp_id='"+empid+"'";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"FACULTY DETAILS UPDATED SUCCESSFULLY!!");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String args[] ){
        new UpdateTeacher();
    }
    
}
