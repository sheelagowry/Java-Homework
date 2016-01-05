package itcollege.panels;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPanel {
	
	public static String ADD_MARKS_BUTTON="Add Marks";
	public static String ADD_STUDENT_BUTTON="Add Student";
		
	private static JButton mAddMarksButton;
	private static JButton mAddStudentButton;
	
	private JFrame mMenuFrame;
	public MenuPanel() {
		mMenuFrame = new JFrame("ESTONIAN IT COLLEGE");
		mMenuFrame.setBounds(250, 250, 300, 250);
		mMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		placeComponents(mMenuFrame);
	}

	private static void placeComponents(JFrame frame) {
		frame.setLayout(null);

		
		mAddStudentButton = new JButton(ADD_STUDENT_BUTTON);
		mAddStudentButton.setName(ADD_STUDENT_BUTTON);
		mAddStudentButton.setBounds(50, 50, 200, 50);
		frame.add(mAddStudentButton);
		
		mAddMarksButton = new JButton(ADD_MARKS_BUTTON);
		mAddMarksButton.setName(ADD_MARKS_BUTTON);
		mAddMarksButton.setBounds(50, 110, 200, 50);
		frame.add(mAddMarksButton);

		
	
	}

	public void addActionListener(ActionListener loginActionListener) {
		// TODO Auto-generated method stub
		mAddMarksButton.addActionListener(loginActionListener);
		mAddStudentButton.addActionListener(loginActionListener);
	}
	
	
	public void show(boolean b) {
		mMenuFrame.setVisible(b);
	}
}
