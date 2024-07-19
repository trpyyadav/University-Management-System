
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JButton login,cancel;
    JTextField tfusername,tfpassword;
   


    Login(){


        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);

        JLabel username = new JLabel("USERNAME");
        username.setBounds(40,20,100,40);
        add(username);

        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,40);
        add(tfusername);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(40,70,100,40);
        add(password);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,40);
        add(tfpassword);

        login = new JButton("LOGIN");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("tahoma",Font.BOLD,15));
        add(login);

        cancel = new JButton("CANCEL");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD,15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Copy of Untitled.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,20,200,200);
        add(image);


        setSize(600,300);
        setLocation(315,175);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where username='"+username+"'and password ='"+password+"'";

            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Dashboard();

                }else{
                    JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PASSWORD");

                }

            }catch(Exception e){
                e.printStackTrace();

            }

        }else if(ae.getSource() == cancel){
            setVisible(false);
        }

    }
    
    public static void main(String args[]){
        new Login();
    }
    
}
