
package university.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;




import java.sql.ResultSet;


public class TeacherLeave extends JFrame implements ActionListener {
    Choice cempid,ctime;
    JDateChooser leaveDate;
    
    JButton submit,cancel;

    TeacherLeave(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblLeave = new JLabel("APPLY LEAVE(Teacher)");
        lblLeave.setBounds(100,25,300,40);
        lblLeave.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(lblLeave);

        JLabel lblempid = new JLabel("EMPLOYEE ID");
        lblempid.setBounds(25,85,300,40);
        lblempid.setFont(new Font("SERIF",Font.BOLD,15));
        add(lblempid);

        cempid = new Choice();
        cempid.setBackground(Color.WHITE);
        cempid.setBounds(28,135,200,30);
        add(cempid);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cempid.add(rs.getString("emp_id"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel date = new JLabel("Date");
        date.setBounds(25,175,300,40);
        date.setFont(new Font("SERIF",Font.BOLD,15));
        add(date);

        leaveDate = new JDateChooser();
        leaveDate.setBounds(28,225,200,30);
        add(leaveDate);

        JLabel time = new JLabel("Time");
        time.setBounds(25,265,300,40);
        time.setFont(new Font("SERIF",Font.BOLD,15));
        add(time);

        
        ctime = new Choice();
        ctime.setBackground(Color.WHITE);
        ctime.setBounds(28,315,200,30);
        ctime.add("HALF DAY");
        ctime.add("FULL DAY");
        add(ctime);

        submit = new JButton("SUBMIT");
        submit.setBounds(28,385,100,30);
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(178,385,100,30);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(500,500);
        setLocation(400,100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String empid = cempid.getSelectedItem();
            String date = ((JTextField)leaveDate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "insert into teacherleave values('"+empid+"','"+date+"','"+duration+"')";

            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"LEAVE CONFIRMED");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new TeacherLeave();
    }
    
}
