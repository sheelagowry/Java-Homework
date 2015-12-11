package javaProject;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentGradingSystem extends JFrame implements ActionListener {
	static JLabel lbSdetails,lbBlank,lbSScore,lbName,lbRegNo,lbEng,lbMaths,lbPhy,lbChem,lbBot,lbZoo,lbComp,lbTotal,lbPer,lbRem;
	static JTextField tfName,tfRegNo,tfEng,tfMaths,tfPhy,tfChem,tfBot,tfZoo,tfComp,tfTotal,tfPer,tfRem;
	static JButton btTotal,btPer,btRem,btPrint,btExit;
	
	public static void main (String[] args) {
		StudentGradingSystem s=new StudentGradingSystem();
		s.setSize(500,500);
		GridLayout g=new GridLayout(20,2,1,1);
		s.setLayout(g);
		s.setLocationRelativeTo(null);
		s.setTitle("Student Grades");
		s.add(lbSdetails =new JLabel ("STUDENT DETAILS"));
		s.add(lbBlank =new JLabel(" "));
		s.add(lbName =new JLabel ("Student Name"));
		s.add(tfName =new JTextField ());
		s.add(lbRegNo =new JLabel ("Registration Number"));
		s.add(tfRegNo =new JTextField ());
		
		s.add(lbSScore =new JLabel ("SUBJECTS & SCORES"));
		s.add(lbBlank =new JLabel(" "));
		s.add(lbEng =new JLabel ("English Grammar"));
		s.add(tfEng =new JTextField ());
		s.add(lbMaths =new JLabel ("Mathematics"));
		s.add(tfMaths =new JTextField ());
		s.add(lbPhy =new JLabel ("Physics"));
		s.add(tfPhy =new JTextField ());
		s.add(lbChem =new JLabel ("Chemistry"));
		s.add(tfChem =new JTextField ());
		s.add(lbBot =new JLabel ("Botony"));
		s.add(tfBot =new JTextField ());
		s.add(lbZoo =new JLabel ("Zoology"));
		s.add(tfZoo =new JTextField ());
		s.add(lbComp =new JLabel ("Computer"));
		s.add(tfComp =new JTextField ());
		s.add(lbBlank =new JLabel(" "));
		s.add(lbBlank =new JLabel(" "));
		
		s.add(lbTotal =new JLabel ("Total Score"));
		s.add(tfTotal =new JTextField ());
		s.add(lbPer =new JLabel ("Percentage"));
		s.add(tfPer =new JTextField ());
		s.add(lbRem =new JLabel ("Remarks"));
		s.add(tfRem =new JTextField ());
		s.add(lbBlank =new JLabel(" "));
		s.add(lbBlank =new JLabel(" "));
		
		s.add(btTotal =new JButton("TOTAL SCORE"));
		s.add(btPer =new JButton("PERCENTAGE"));
		s.add(btRem =new JButton("REMARKS"));
		s.add(btPrint =new JButton ("PRINT"));
		s.add(btExit =new JButton ("EXIT"));
		s.setVisible(true);
		
		
		
		
		
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}