
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener {

    Dashboard(){
        setSize(1500,700);
        //setLocation(0,0);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        mb.setBackground(Color.WHITE);

        //NEW INFORMATION
        JMenu newInformation = new JMenu("INFORMATION");
        newInformation.setForeground(Color.DARK_GRAY);
        mb.add(newInformation);

        JMenuItem newFacultyInfo = new JMenuItem("FACULTY INFORMATION");
        newFacultyInfo.setBackground(Color.WHITE);
        newFacultyInfo.addActionListener(this);
        newInformation.add(newFacultyInfo);

        JMenuItem newStudentInfo = new JMenuItem("STUDENT INFORMATION");
        newStudentInfo.setBackground(Color.WHITE);
        newStudentInfo.addActionListener(this);
        newInformation.add(newStudentInfo);

        //details
        JMenu details = new JMenu("DETAILS");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem studentDetails = new JMenuItem("STUDENT DETAILS");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        JMenuItem facultyDetails = new JMenuItem("FACULTY DETAILS");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        //APPLY LEAVE
        JMenu leave = new JMenu("APPLY LEAVE");
        leave.setForeground(Color.DARK_GRAY);
        mb.add(leave);

        JMenuItem studentLeave = new JMenuItem("STUDENT LEAVE");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        JMenuItem facultyLeave = new JMenuItem("FACULTY LEAVE");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

         //APPLY LEAVE DETAILS
         JMenu leaveDetails = new JMenu("LEAVE DETAILS");
         leaveDetails.setForeground(Color.RED);
         mb.add(leaveDetails);
 
         JMenuItem studentLeaveDetails = new JMenuItem("STUDENT LEAVE DETAILS");
         studentLeaveDetails.setBackground(Color.WHITE);
         studentLeaveDetails.addActionListener(this);
         leaveDetails.add(studentLeaveDetails);
 
         JMenuItem facultyLeaveDetails = new JMenuItem("FACULTY LEAVE DETAILS");
         facultyLeaveDetails.setBackground(Color.WHITE);
         facultyLeaveDetails.addActionListener(this);
         leaveDetails.add(facultyLeaveDetails);

         //EXAMINATION
         JMenu exam = new JMenu("EXAMINATION");
         exam.setForeground(Color.DARK_GRAY);
         mb.add(exam);
 
         JMenuItem examResults = new JMenuItem("EXAMINATION RESULTS");
         examResults.setBackground(Color.WHITE);
         examResults.addActionListener(this);
         exam.add(examResults);
 
         JMenuItem enterMarks = new JMenuItem("ENTER MARKS");
         enterMarks.setBackground(Color.WHITE);
         enterMarks.addActionListener(this);
         exam.add(enterMarks);

         //UPDATE DETAILS
         JMenu updateDetails = new JMenu("UPDATE DETAILS");
         updateDetails.setForeground(Color.RED);
         mb.add(updateDetails);
 
         JMenuItem updateStudentInfo = new JMenuItem("UPDATE STUDENT DETAILS");
         updateStudentInfo.setBackground(Color.WHITE);
         updateStudentInfo.addActionListener(this);
         updateDetails.add(updateStudentInfo);
 
         JMenuItem updateFacultyInfo = new JMenuItem("UPDATE FACULTY DETAILS");
         updateFacultyInfo.setBackground(Color.WHITE);
         updateFacultyInfo.addActionListener(this);
         updateDetails.add(updateFacultyInfo);

         //FEE DETAILS
         JMenu fee = new JMenu("FEE DETAILS");
         fee.setForeground(Color.DARK_GRAY);
         mb.add(fee);
 
         JMenuItem feeStructure = new JMenuItem("FEE STRUCTURE");
         feeStructure.setBackground(Color.WHITE);
         feeStructure.addActionListener(this);
         fee.add(feeStructure);
 
         JMenuItem feeForm = new JMenuItem("STUDENT FEE FORM");
         feeForm.setBackground(Color.WHITE);
         feeForm.addActionListener(this);
         fee.add(feeForm);

         //UTILITY
         JMenu utility = new JMenu("UTILITY");
         utility.setForeground(Color.RED);
         mb.add(utility);
 
         JMenuItem notepad = new JMenuItem("NOTEPAD");
         notepad.setBackground(Color.WHITE);
         notepad.addActionListener(this);
         utility.add(notepad);
 
         JMenuItem calc = new JMenuItem("CALCULATOR");
         calc.setBackground(Color.WHITE);
         calc.addActionListener(this);
         utility.add(calc);

         //EXIT
         JMenu exit = new JMenu("EXIT");
         exit.setForeground(Color.DARK_GRAY);
         mb.add(exit);
 
         JMenuItem ex = new JMenuItem("EXIT");
         ex.setBackground(Color.WHITE);
         ex.addActionListener(this);
         exit.add(ex);
 

        setJMenuBar(mb);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        
        if(msg.equals("EXIT")){
            setVisible(false);
        }else if(msg.equals("CALCULATOR")){
            try{
                Runtime.getRuntime().exec("calc.exe");

            }catch(Exception e){

            }
        }else if(msg.equals("NOTEPAD")){
            try{
                Runtime.getRuntime().exec("NOTEPAD.exe");

            }catch(Exception e){

            }
    }else if(msg.equals("FACULTY INFORMATION")){
        new AddTeacher();
    }else if(msg.equals("STUDENT INFORMATION")){
        new AddStudent();
    }else if(msg.equals("STUDENT DETAILS")){
        new StudentDetails();
    }else if(msg.equals("FACULTY DETAILS")){
        new TeacherDetails();
    }else if(msg.equals("STUDENT LEAVE")){
        new StudentLeave();
    }else if(msg.equals("FACULTY LEAVE")){
        new TeacherLeave();
    }else if(msg.equals("STUDENT LEAVE DETAILS")){
        new StudentLeaveDetails();
    }else if(msg.equals("FACULTY LEAVE DETAILS")){
        new TeacherLeaveDetails();
    }else if(msg.equals("UPDATE STUDENT DETAILS")){
        new UpdateStudent();
    }else if(msg.equals("UPDATE FACULTY DETAILS")){
        new UpdateTeacher();
    }else if(msg.equals("ENTER MARKS")){
        new EnterMarks();
    }else if(msg.equals("EXAMINATION RESULTS")){
        new ExamResults();
    }else if(msg.equals("FEE STRUCTURE")){
        new FeeStructure();
    }else if(msg.equals("STUDENT FEE FORM")){
        new StudentFeeForm();
    }
}


    public static void main(String args[]){
        new Dashboard();
    }
    
}
