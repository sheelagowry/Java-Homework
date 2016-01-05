package itcollege.panels;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import itcollege.data.Batch;
import itcollege.data.Course;
import itcollege.data.DataCollections;
import itcollege.data.Exam;
import itcollege.data.Mark;
import itcollege.data.MarkSheet;
import itcollege.data.Student;
import itcollege.data.Subject;

class MarkTextField extends PlainDocument{
	  MarkTextField() {
	    super();
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;
	   
	    int length= getLength() ;
	    if (length + str.length() > 3) {
	     return;
	    }
	    
	    for (int i = 0; i < str.length(); i++) {        
	        char charAt = str.charAt(i);
	        if (Character.isDigit(charAt)==false) {
	        return;    
	        }
	    }
           	   	    
	    String m=getText(0, length)+str;
	    int mark=Integer.parseInt(m);
	    
	    if(mark >100){
	    	return;
	   }
	 
	    super.insertString(offset, str, attr);
	  }
}


public class MarkSheetPanel {

	
	public static String COURSE_LIST="course list";
	public static String EXAM_LIST="exam list";
	public static String STUDENT_LIST="student list";
	public static String UPDATE_BUTTON="Update Mark Sheet";
	public static String MENU_BUTTON="Menu";
	
	
	private JFrame mMarkSheetFrame;
	private DataCollections mDataCollections;
	private JComboBox mCourseList;
	private JComboBox mExamList;
	private JComboBox mStudentList;
	private JTextField mStudentName;
	private JLabel mSub1Name;
	private JLabel mSub2Name;
	private JLabel mSub3Name;
	private JLabel mSub4Name;
	private JLabel mSub5Name;
	private JLabel mSub6Name;
	private JTextField mSub1Mark;
	private JTextField mSub2Mark;
	private JTextField mSub3Mark;
	private JTextField mSub4Mark;
	private JTextField mSub5Mark;
	private JTextField mSub6Mark;
	
	
	private JTextField mRemark;

	private JTextField mPercentage;

	private JTextField mTotal;
	
	private boolean studentListUpdating = false;
	
	
	
	private static JButton mAddButton;
	private static JButton mMenuButton;
	
	
	public MarkSheetPanel(DataCollections dataCollections) {
		mDataCollections = dataCollections;
		placeComponents();
	}
		
	private void placeComponents() {
			
		mMarkSheetFrame = new JFrame();
		mMarkSheetFrame.setSize(500,500);
		GridLayout g=new GridLayout(20,2,1,1);
		mMarkSheetFrame.setLayout(g);
		mMarkSheetFrame.setLocationRelativeTo(null);
		mMarkSheetFrame.setTitle("Student Grades");
		
		JLabel courseLabel = new JLabel("Course");
		courseLabel.setBounds(10, 10, 80, 25);
		mMarkSheetFrame.add(courseLabel);
		
		ArrayList<Course> courses = mDataCollections.courses;
		String[] courseNames = new String[courses.size()];
		
		for(int i=0; i<courses.size(); i++){
			Course c = courses.get(i);
			courseNames[i]=	c.code;	
       }
				
		mCourseList = new JComboBox(courseNames);
		mCourseList.setSelectedIndex(0);
		mCourseList.setBounds(10, 10, 160, 25);
		mCourseList.setName(COURSE_LIST);
		mMarkSheetFrame.add(mCourseList);
			
		JLabel examLabel = new JLabel("Exam");
		examLabel.setBounds(10, 40, 80, 25);
		mMarkSheetFrame.add(examLabel);
		
		ArrayList<Exam> exams = mDataCollections.exams;
		String[] examNames = new String[exams.size()];
		
		for(int i=0; i<exams.size(); i++){
			Exam c = exams.get(i);
			examNames[i]=c.code;	
       }
				
		mExamList = new JComboBox(examNames);
		mExamList.setSelectedIndex(0);
		mExamList.setName(EXAM_LIST);
		mExamList.setBounds(100, 40, 160, 25);
		mMarkSheetFrame.add(mExamList);
		
		JLabel studentLabel = new JLabel("Student ID");
		studentLabel.setBounds(10, 70, 80, 25);
		mMarkSheetFrame.add(studentLabel);
		
		
		
		mStudentList = new JComboBox();
		mStudentList.setBounds(100, 70, 160, 25);
		mStudentList.setName(STUDENT_LIST);
		mMarkSheetFrame.add(mStudentList);
		
		JLabel label1 = new JLabel("Student Name");
		label1.setBounds(10, 100, 80, 25);
		mMarkSheetFrame.add(label1);
	
		mStudentName = new JTextField(20);
		mStudentName.setBounds(100, 100, 160, 25);
		mStudentName.setEditable(false);
		mMarkSheetFrame.add(mStudentName);
		
		mSub1Name = new JLabel();
		mSub1Name.setBounds(10, 130, 80, 25);
		mMarkSheetFrame.add(mSub1Name);
		
		mSub1Mark = new JTextField(3);     
		mSub1Mark.setBounds(100, 130, 160, 25);
		mSub1Mark.setDocument(new MarkTextField());
		mMarkSheetFrame.add(mSub1Mark);
		
		mSub2Name = new JLabel();
		mSub2Name.setBounds(10, 130, 80, 25);
		mMarkSheetFrame.add(mSub2Name);
		
		mSub2Mark = new JTextField(3);
		mSub2Mark.setBounds(100, 130, 160, 25);
		mSub2Mark.setDocument(new MarkTextField());
		mMarkSheetFrame.add(mSub2Mark);
		
		mSub3Name = new JLabel();
		mSub3Name.setBounds(10, 130, 80, 25);
		mMarkSheetFrame.add(mSub3Name);
		
		mSub3Mark = new JTextField(3);
		mSub3Mark.setBounds(100, 130, 160, 25);
		mSub3Mark.setDocument(new MarkTextField());
		mMarkSheetFrame.add(mSub3Mark);
		
		mSub4Name = new JLabel();
		mSub4Name.setBounds(10, 130, 80, 25);
		mMarkSheetFrame.add(mSub4Name);
		
		mSub4Mark = new JTextField(3);
		mSub4Mark.setBounds(100, 130, 160, 25);
		mSub4Mark.setDocument(new MarkTextField());
		mMarkSheetFrame.add(mSub4Mark);
			
		mSub5Name = new JLabel();
		mSub5Name.setBounds(10, 130, 80, 25);
		mMarkSheetFrame.add(mSub5Name);
		
		mSub5Mark = new JTextField(3);
		mSub5Mark.setBounds(100, 130, 160, 25);
		mSub5Mark.setDocument(new MarkTextField());
		mMarkSheetFrame.add(mSub5Mark);
			
		mSub6Name = new JLabel();
		mSub6Name.setBounds(10, 130, 80, 25);
		mMarkSheetFrame.add(mSub6Name);
		
		mSub6Mark = new JTextField(3);
		mSub6Mark.setBounds(100, 130, 160, 25);
		mSub6Mark.setDocument(new MarkTextField());
		mMarkSheetFrame.add(mSub6Mark);
		
		JLabel label3 = new JLabel("Total");
		label3.setBounds(10, 130, 80, 25);
		mMarkSheetFrame.add(label3);
		
		mTotal = new JTextField(3);
		mTotal.setBounds(100, 130, 160, 25);
		mTotal.setEditable(false);
		mMarkSheetFrame.add(mTotal);
		
		JLabel label4 = new JLabel("Percentage");
		label4.setBounds(10, 130, 80, 25);
		mMarkSheetFrame.add(label4);
		
		mPercentage = new JTextField();
		mPercentage.setBounds(100, 130, 160, 25);
		mPercentage.setEditable(false);
		mMarkSheetFrame.add(mPercentage);
		
		JLabel label5 = new JLabel("Remarks");
		label5.setBounds(10, 130, 80, 25);
		mMarkSheetFrame.add(label5);
		
		mRemark = new JTextField(20);
		mRemark.setBounds(100, 130, 160, 25);
		mRemark.setEditable(false);
		mMarkSheetFrame.add(mRemark);
		
		
		mAddButton = new JButton(UPDATE_BUTTON);
		mAddButton.setName(UPDATE_BUTTON);
		mAddButton.setBounds(10, 80, 80, 25);
		mMarkSheetFrame.add(mAddButton);

		mMenuButton = new JButton(MENU_BUTTON);
		mMenuButton.setName(MENU_BUTTON);
		mMenuButton.setBounds(180, 80, 80, 25);
		mMarkSheetFrame.add(mMenuButton);
		
		updateStudentListAndSubjects();
		updateStudentInfoAndMarks();

	}

	public void updateStudentListAndSubjects() {
		
		studentListUpdating = true;
		Batch batch = mDataCollections.getBatch((String) mCourseList.getSelectedItem());
		ArrayList<Student> students = batch.students;
		mStudentList.removeAllItems();
		for(int i=0; i<students.size(); i++){
			Student a = students.get(i);
			mStudentList.addItem(a.id);
			mStudentList.setSelectedIndex(0);
       }
		
		Course course = mDataCollections.getCourse((String) mCourseList.getSelectedItem());
		ArrayList<Subject> subjects = course.subjects;

		mSub1Name.setText(subjects.get(0).name);
		mSub2Name.setText(subjects.get(1).name);
		mSub3Name.setText(subjects.get(2).name);
		mSub4Name.setText(subjects.get(3).name);
		mSub5Name.setText(subjects.get(4).name);
		mSub6Name.setText(subjects.get(5).name);
		
		studentListUpdating = false;
	}
	
	public void updateStudentInfoAndMarks() {
		
		if(!studentListUpdating){
			Student student = mDataCollections.getStudent((int) mStudentList.getSelectedItem());
			mStudentName.setText(student.name);
			
			Course course = mDataCollections.getCourse((String) mCourseList.getSelectedItem());
			ArrayList<Subject> subjects = course.subjects;
			
			MarkSheet marksheet = mDataCollections.getMarkSheet((String) mExamList.getSelectedItem(), student.id);
			
			mSub1Mark.setText("");
			mSub2Mark.setText("");
			mSub3Mark.setText("");
			mSub4Mark.setText("");
			mSub5Mark.setText("");
			mSub6Mark.setText("");
			mTotal.setText("");
			mPercentage.setText("");
			mRemark.setText("");
			
			if(marksheet != null){
				mSub1Mark.setText(""+marksheet.getMark(subjects.get(0).code));
				mSub2Mark.setText(""+marksheet.getMark(subjects.get(1).code));
				mSub3Mark.setText(""+marksheet.getMark(subjects.get(2).code));
				mSub4Mark.setText(""+marksheet.getMark(subjects.get(3).code));
				mSub5Mark.setText(""+marksheet.getMark(subjects.get(4).code));
				mSub6Mark.setText(""+marksheet.getMark(subjects.get(5).code));
			}
		}
		
	}	
	
	public void show(boolean b) {
		mMarkSheetFrame.setVisible(b);
	}
	
	public void addActionListener(ActionListener actionListener) {
		mCourseList.addActionListener(actionListener);
		mExamList.addActionListener(actionListener);
		mMenuButton.addActionListener(actionListener);
		mAddButton.addActionListener(actionListener);
		mStudentList.addActionListener(actionListener);
	}

	public void updateMarkSheet() {
		int sub1=0;
		if(mSub1Mark.getText().length()>0){
			sub1=Integer.parseInt(mSub1Mark.getText());	    
		}
		int sub2=0;
		if(mSub2Mark.getText().length()>0){
			sub2=Integer.parseInt(mSub2Mark.getText());	
		}
		int sub3=0;
		if(mSub3Mark.getText().length()>0){
			sub3=Integer.parseInt(mSub3Mark.getText());	
		}
		int sub4=0;
		if(mSub4Mark.getText().length()>0){
			sub4=Integer.parseInt(mSub4Mark.getText());	
		}
		int sub5=0;
		if(mSub5Mark.getText().length()>0){
			sub5=Integer.parseInt(mSub5Mark.getText());	
		}
		int sub6=0;
		if(mSub6Mark.getText().length()>0){
			sub6=Integer.parseInt(mSub6Mark.getText());	
		}
		
		Course course = mDataCollections.getCourse((String) mCourseList.getSelectedItem());
		ArrayList<Subject> subjects = course.subjects;
		
		ArrayList<Mark> marks =new ArrayList<Mark>();
		marks.add(mDataCollections.createMark(subjects.get(0).code, sub1));
		marks.add(mDataCollections.createMark(subjects.get(1).code, sub2));
		marks.add(mDataCollections.createMark(subjects.get(2).code, sub3));
		marks.add(mDataCollections.createMark(subjects.get(3).code, sub4));
		marks.add(mDataCollections.createMark(subjects.get(4).code, sub5));
		marks.add(mDataCollections.createMark(subjects.get(5).code, sub6));

		String examId = (String)mExamList.getSelectedItem();
		int stdId = (int) mStudentList.getSelectedItem();
		mDataCollections.addMarkSheet(examId,stdId, marks);
		
		float totalScore=sub1+sub2+sub3+sub4+sub5+sub6;
		float percentage=totalScore/6;
		
		mTotal.setText(" "+Math.round(totalScore));
		mPercentage.setText(String.format("%,.2f%%", percentage));
		
		if (percentage<50) {
			mRemark.setText("FAIL");
		}
		else  if (percentage<60) {
			mRemark.setText("FAIR");
		}
		else  if (percentage<70) {
				mRemark.setText("GOOD");
		}
		else  if (percentage<80) {
			mRemark.setText("VERY GOOD");
		}
		else  if (percentage<90) {
			mRemark.setText("EXCELLENT");
		}
		else  if (percentage<=100) {
				mRemark.setText("OUT STANDING");
		}
	}

}

