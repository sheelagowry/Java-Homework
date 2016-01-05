package itcollege.panels;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import itcollege.data.Course;
import itcollege.data.DataCollections;

public class StudentPanel   {

	public static String ADD_BUTTON="Add student";
	public static String MENU_BUTTON="Menu";
		
	private static JButton mAddButton;
	private static JButton mMenuButton;
	private static JTextField mStudentNameText;
	private JComboBox mCourseList;
	private JFrame mLoginFrame;
	private DataCollections mDataCollections;
	
	

	public StudentPanel(DataCollections dataCollections) {
		mDataCollections = dataCollections;
		mLoginFrame = new JFrame("Add Student");
		mLoginFrame.setBounds(250, 250, 400, 150);
		mLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		placeComponents(mLoginFrame);
	}

	

	private void placeComponents(JFrame frame) {
		frame.setLayout(null);

		JLabel nameLabel = new JLabel("Student Name");
		nameLabel.setBounds(10, 10, 80, 25);
		frame.add(nameLabel);

		mStudentNameText = new JTextField(20);
		mStudentNameText.setBounds(100, 10, 230, 25);
		frame.add(mStudentNameText);

		JLabel courseLabel = new JLabel("Course");
		courseLabel.setBounds(10, 40, 80, 25);
		frame.add(courseLabel);
		
		ArrayList<Course> courses = mDataCollections.courses;
		String[] courseNames = new String[courses.size()];
		
		for(int i=0; i<courses.size(); i++){
			Course c = courses.get(i);
			courseNames[i]=	c.code;	
       }
				
		mCourseList = new JComboBox(courseNames);
		mCourseList.setSelectedIndex(0);
		mCourseList.setBounds(100, 40, 230, 25);
		frame.add(mCourseList);

		mAddButton = new JButton(ADD_BUTTON);
		mAddButton.setName(ADD_BUTTON);
		mAddButton.setBounds(10, 80, 150, 25);
		frame.add(mAddButton);

		mMenuButton = new JButton(MENU_BUTTON);
		mMenuButton.setName(MENU_BUTTON);
		mMenuButton.setBounds(180, 80, 150, 25);
		frame.add(mMenuButton);
	
	}

	public void addActionListener(ActionListener actionListener) {
		mAddButton.addActionListener(actionListener);
		mMenuButton.addActionListener(actionListener);
	}
	
	public String name(){
		return mStudentNameText.getText();
	}
	
	public String course(){
		return (String) mCourseList.getSelectedItem();
	}
	
	
	public void clear(){
		 mStudentNameText.setText("");
	}

	public void show(boolean b) {
		mLoginFrame.setVisible(b);
	}

}