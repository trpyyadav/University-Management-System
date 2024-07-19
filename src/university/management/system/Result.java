
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class Result extends JFrame implements ActionListener{
    String rollno;
    JButton back; 

    Result(String rollno){
        this.rollno = rollno;

        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        JLabel heading = new JLabel("MERI COLLEGE");
        heading.setBounds(150,25,200,40);
        heading.setFont(new Font("TAHOMA",Font.CENTER_BASELINE,25));
        add(heading);

        JLabel heading2 = new JLabel("Result of Examination");
        heading2.setBounds(135,75,250,40);
        heading2.setFont(new Font("TAHOMA",Font.CENTER_BASELINE,20));
        add(heading2);

        JLabel lblrollno = new JLabel("Roll Number: " + rollno);
        lblrollno.setBounds(100,135,200,40);
        lblrollno.setFont(new Font("TAHOMA",Font.PLAIN,15));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(100,165,200,40);
        lblsemester.setFont(new Font("TAHOMA",Font.PLAIN,15));
        add(lblsemester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(100,225,200,40);
        sub1.setFont(new Font("TAHOMA",Font.PLAIN,15));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100,260,200,40);
        sub2.setFont(new Font("TAHOMA",Font.PLAIN,15));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100,305,200,40);
        sub3.setFont(new Font("TAHOMA",Font.PLAIN,15));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100,355,200,40);
        sub4.setFont(new Font("TAHOMA",Font.PLAIN,15));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100,405,200,40);
        sub5.setFont(new Font("TAHOMA",Font.PLAIN,15));
        add(sub5);

        JLabel sub6 = new JLabel();
        sub6.setBounds(100,455,200,40);
        sub6.setFont(new Font("TAHOMA",Font.PLAIN,15));
        add(sub6);

        try{
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from subject where ROLL_NO='"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("SUBJECT1"));
                sub2.setText(rs1.getString("SUBJECT2"));
                sub3.setText(rs1.getString("SUBJECT3"));
                sub4.setText(rs1.getString("SUBJECT4"));
                sub5.setText(rs1.getString("SUBJECT5"));
                sub6.setText(rs1.getString("SUBJECT6"));
                
            }

            ResultSet rs2 = c.s.executeQuery("select * from marks where ROLL_NO='"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText() + "-----------" + rs2.getString("MARKS1"));
                sub2.setText(sub2.getText() + "-----------" + rs2.getString("MARKS2"));
                sub3.setText(sub3.getText() + "-----------" + rs2.getString("MARKS3"));
                sub4.setText(sub4.getText() + "------------" +rs2.getString("MARKS4"));
                sub5.setText(sub5.getText() + "------------" + rs2.getString("MARKS5"));
                sub6.setText(sub6.getText() + "------------" + rs2.getString("MARKS6"));
                lblsemester.setText(rs2.getString("SEMESTER"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBounds(200,515,100,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);




        setSize(500,600);
        setLocation(400,50);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new Result("");
    }
    
}
