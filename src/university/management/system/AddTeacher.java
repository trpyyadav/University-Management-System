
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfname,tfFname,tfaddress,tfphone,tfemail,tfclassX,tfclassXII,tfaadhar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;

    Random ran = new Random();
    long  first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    AddTeacher(){

        getContentPane().setBackground(Color.GREEN);

        setSize(800,550);
        setLocation(250,70);

        setLayout(null);

        JLabel heading = new JLabel("NEW TEACHER INFORMATION...");
        heading.setBounds(250,30,500,50);
        heading.setFont(new Font("serifs",Font.BOLD,20));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,90,150,20);
        lblname.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(170,90,100,25);
        add(tfname);

        JLabel lblfname = new JLabel(" Father's Name");
        lblfname.setBounds(350,90,150,20);
        lblfname.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblfname);

        tfFname = new JTextField();
        tfFname.setBounds(550,90,100,25);
        add(tfFname);

        JLabel lblempid = new JLabel("Emp.Id");
        lblempid.setBounds(50,140,150,20);
        lblempid.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblempid);

        labelempid = new JLabel("201"+ first4);
        labelempid.setBounds(170,138,100,25);
        labelempid.setFont(new Font("serifs",Font.ITALIC,20));
        add(labelempid);

        JLabel lbldob = new JLabel(" Date of Birth");
        lbldob.setBounds(350,140,150,20);
        lbldob.setFont(new Font("serifs",Font.ITALIC,20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(550,138,100,25);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,186,150,20);
        lbladdress.setFont(new Font("serifs",Font.ITALIC,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(170,186,100,25);
        add(tfaddress);

        JLabel lblphone = new JLabel(" Phone");
        lblphone.setBounds(350,190,150,20);
        lblphone.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(550,186,100,25);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50,234,150,20);
        lblemail.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(170,234,100,25);
        add(tfemail);

        JLabel lblclassX = new JLabel("Class X(%)");
        lblclassX.setBounds(350,240,150,20);
        lblclassX.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblclassX);

        tfclassX = new JTextField();
        tfclassX.setBounds(550,234,100,25);
        add(tfclassX);

        JLabel lblclassXII = new JLabel("Class XII(%)");
        lblclassXII.setBounds(50,282,150,20);
        lblclassXII.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblclassXII);

        tfclassXII = new JTextField();
        tfclassXII.setBounds(170,282,100,25);
        add(tfclassXII);

        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(350,290,150,20);
        lblaadhar.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(550,282,100,25);
        add(tfaadhar);

        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50,330,150,20);
        lblcourse.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblcourse);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(350,340,150,20);
        lblbranch.setFont(new Font("serifs",Font.ITALIC,20));
        add(lblbranch);

        String course[] = {"B.Tech","BBA","BCA","MBA","B.Com","M.Tech","M.Com","BJMC"};
        cbcourse = new JComboBox(course);
        cbcourse.setBackground(Color.WHITE);
        cbcourse.setBounds(170,330,100,25);
        add(cbcourse);

        String branch[] = {"Computer Science","Mechanical","Eletronics","Civil","IT","AI & ML","Data Science","Null"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBackground(Color.WHITE);
        cbbranch.setBounds(550,330,100,25);
        add(cbbranch);

        submit = new JButton("SUBMIT");
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
            String name = tfname.getText();
            String fname = tfFname.getText();
            String empid = labelempid.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String ClassX = tfclassX.getText();
            String classXII = tfclassXII.getText();
            String aadhar = tfaadhar.getText();
            String qualification = (String)cbcourse.getSelectedItem();
            String department = (String)cbbranch.getSelectedItem();

            try{
                String query = "insert into teacher values('"+name+"','"+fname+"','"+empid+"','"+address+"','"+dob+"','"+phone+"','"+email+"','"+ClassX+"','"+classXII+"','"+aadhar+"','"+qualification+"','"+department+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"TEACHER DETAILS INSERTED SUCCESSFULLY!!");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String args[] ){
        new AddTeacher();
    }
    
}

