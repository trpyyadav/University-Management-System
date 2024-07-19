
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class EnterMarks extends JFrame implements ActionListener {
    Choice rollno;
    JComboBox csemester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfsub6,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5,tfmarks6;
    JButton submit,cancel;

    EnterMarks(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(70,20,500,50);
        heading.setFont(new Font("TAHOMA",Font.CENTER_BASELINE,30));
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560,50,300,250);
        add(image);

        JLabel srollno = new JLabel("SELECT ROLL NUMBER");
        srollno.setBounds(50,100,200,20);
        add(srollno);

        
        rollno = new Choice();
        rollno.setBackground(Color.WHITE);
        rollno.setBounds(300,100,200,20);
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

        JLabel semester = new JLabel("SELECT SEMESTER");
        semester.setBounds(50,150,200,20);
        add(semester);

        String sem[] = {"1st SEMESTER","2nd SEMESTER","3rd SEMESTER","4th SEMESTER","5th SEMESTER","6th SEMESTER","7th SEMESTER","8th SEMESTER"};
        csemester = new JComboBox(sem);
        csemester.setBackground(Color.WHITE);
        csemester.setBounds(300,150,200,20);
        add(csemester);

        JLabel lbsubject = new JLabel("Enter Subject");
        lbsubject.setBounds(100,220,200,30);
        lbsubject.setFont(new Font("TAHOMA",Font.PLAIN,20));
        add(lbsubject);

        JLabel lbmarks = new JLabel("Enter Marks");
        lbmarks.setBounds(320,220,200,30);
        lbmarks.setFont(new Font("TAHOMA",Font.PLAIN,20));
        add(lbmarks);

        tfsub1 = new JTextField();
        tfsub1.setBounds(50,260,250,30);
        add(tfsub1);

        tfmarks1 = new JTextField();
        tfmarks1.setBounds(300,260,150,30);
        add(tfmarks1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(50,300,250,30);
        add(tfsub2);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(300,300,150,30);
        add(tfmarks2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(50,340,250,30);
        add(tfsub3);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(300,340,150,30);
        add(tfmarks3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(50,380,250,30);
        add(tfsub4);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(300,380,150,30);
        add(tfmarks4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(50,420,250,30);
        add(tfsub5);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(300,420,150,30);
        add(tfmarks5);

        tfsub6 = new JTextField();
        tfsub6.setBounds(50,460,250,30);
        add(tfsub6);

        tfmarks6 = new JTextField();
        tfmarks6.setBounds(300,460,150,30);
        add(tfmarks6);

        submit = new JButton("SUBMIT");
        submit.setBounds(600,320,140,35);
        submit.addActionListener(this);
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.WHITE);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(600,375,140,35);
        cancel.addActionListener(this);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.WHITE);
        add(cancel);





        setSize(900,550);
        setLocation(200,70);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                Conn c = new Conn();

                String query1 = "insert into subject values('"+rollno.getSelectedItem()+"','"+csemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"','"+tfsub6.getText()+"')";
                String query2 = "insert into marks values('"+rollno.getSelectedItem()+"','"+csemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"','"+tfmarks6.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"MARKS INSERTED SUCCESSFULLY");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource() == cancel) {
            setVisible(false);
            
        }

    }

    public static void main(String args[]){
        new EnterMarks();
    }
    
}
