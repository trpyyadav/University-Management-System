package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class StudentFeeForm extends JFrame implements ActionListener{
    Choice rollno;
    JLabel name,fname,labeltotal;
    JComboBox cbcourse,cbbranch,cbsemester;
    JButton update,payFee,cancel;

    StudentFeeForm(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Paper-Money.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,100,300,300);
        add(image);

        JLabel heading = new JLabel("SELECT ROLL NUMBER");
        heading.setBounds(25,50,150,50);
        add(heading);

        
        rollno = new Choice();
        rollno.setBackground(Color.WHITE);
        rollno.setBounds(200,60,200,30);
        add(rollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                rollno.add(rs.getString("ROLL_NO"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(25,100,150,50);
        add(lblname);

        JLabel lblfname = new JLabel("FATHER'S NAME");
        lblfname.setBounds(25,150,150,50);
        add(lblfname);

        JLabel lblcourse = new JLabel("COURSE");
        lblcourse.setBounds(25,200,150,50);
        add(lblcourse);

        JLabel lblbranch = new JLabel("BRANCH");
        lblbranch.setBounds(25,250,150,50);
        add(lblbranch);

        JLabel lblsemester = new JLabel("SEMESTER");
        lblsemester.setBounds(25,300,150,50);
        add(lblsemester);

        JLabel lbltotal = new JLabel("TOTAL PAYABLE");
        lbltotal.setBounds(25,350,150,50);
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(200,360,200,30);
        labeltotal.setForeground(Color.RED);
        labeltotal.setFont(new Font("tahoma",Font.BOLD,20));
        add(labeltotal);

        name = new JLabel();
        name.setBounds(200,110,200,30);
        add(name);

        fname = new JLabel();
        fname.setBounds(200,160,200,30);
        add(fname);

        try{
            Conn c = new Conn();
            String query = "select * from student where ROLL_NO ='"+rollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                name.setText(rs.getString("NAME"));
                fname.setText(rs.getString("FATHER_NAME"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        rollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from student where ROLL_NO ='"+rollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        name.setText(rs.getString("NAME"));
                        fname.setText(rs.getString("FATHER_NAME"));
                        
                    }
        
                }catch(Exception e){
                    e.printStackTrace();
                }
                

            }

        });

         String course[] = {"B.TECH","BBA","BCA","MBA","B.COM","M.TECH","M.COM","BJMC"};
        cbcourse = new JComboBox(course);
        cbcourse.setBackground(Color.WHITE);
        cbcourse.setBounds(200,210,200,30);
        add(cbcourse);

        String branch[] = {"Computer Science","Mechanical","Eletronics","Civil","IT","AI & ML","Data Science","Null"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBackground(Color.WHITE);
        cbbranch.setBounds(200,260,200,30);
        add(cbbranch);

        String sem[] = {"SEMESTER_1","SEMESTER_2","SEMESTER_3","SEMESTER_4","SEMESTER_5","SEMESTER_6","SEMESTER_7","SEMESTER_8"};
        cbsemester = new JComboBox(sem);
        cbsemester.setBackground(Color.WHITE);
        cbsemester.setBounds(200,310,200,30);
        add(cbsemester);

        update = new JButton("UPDATE");
        update.setBounds(25,450,150,40);
        update.addActionListener(this);
        update.setBackground(Color.DARK_GRAY);
        update.setForeground(Color.WHITE);
        add(update);

        cancel = new JButton("CANCEL");
        cancel.setBounds(195,450,150,40);
        cancel.addActionListener(this);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        payFee = new JButton("PAYFEE");
        payFee.setBounds(365,450,150,40);
        payFee.addActionListener(this);
        payFee.setBackground(Color.DARK_GRAY);
        payFee.setForeground(Color.WHITE);
        add(payFee);


        



        setSize(800,550);
        setLocation(300,70);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String course = (String)cbcourse.getSelectedItem();
            String semester = (String)cbsemester.getSelectedItem();

            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from feestructure where COURSE='"+course+"'");

                while(rs.next()){
                    labeltotal.setText(rs.getString(semester));
                }

            }catch(Exception e){
                e.printStackTrace();

            }

        }else if(ae.getSource() == payFee){
            String roll_no = rollno.getSelectedItem();
            String course = (String)cbcourse.getSelectedItem();
            String semester = (String)cbsemester.getSelectedItem();
            String branch = (String)cbbranch.getSelectedItem();
            String total = labeltotal.getText();

            try{
                Conn c = new Conn();
                String query = "insert into feepaid values('"+roll_no+"','"+course+"','"+semester+"','"+branch+"','"+total+"')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"FEES PAID SUCCESSFULLY!!");

            }catch(Exception e){
                e.printStackTrace();

            }


        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
        
    }
    public static void main(String args[]){
        new StudentFeeForm();
    }
    
}
