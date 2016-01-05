package itcollege;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import itcollege.data.DataCollections;
import itcollege.panels.LoginPanel;
import itcollege.panels.MarkSheetPanel;
import itcollege.panels.MenuPanel;
import itcollege.panels.StudentPanel;

public class StudentManager {
private LoginPanel mLogin;
private MenuPanel mMenu;
private StudentPanel mStudentPanel;
private MarkSheetPanel mMarkSheetPanel;
private DataCollections mDataCollections;
private ActionListener mActionListener;

public StudentManager() {
	initialize();
}

private void exit() {
	System.exit(0);
}

public void checkUser() {
	String name = mLogin.username();
	String pwd = mLogin.password();
	
	
	System.out.println("check user  "+name+ " " +pwd);	
	
	boolean sucess= mDataCollections.validAdmin(name, pwd);
	if(sucess){
		showMenuPanel();
	}else{
		JOptionPane.showMessageDialog(null, "login failed, enter valid username and password..");
	}
}

private void showMenuPanel() {
	mLogin.show(false);
	mStudentPanel.show(false);
	mMarkSheetPanel.show(false);
	mMenu.show(true);
}

public void initialize(){
	mDataCollections = new DataCollections();
	createActionListener();
	createPanels();
	showLoginPanel();
}

private void showLoginPanel() {  //purpose???
	mLogin.show(true);
}

private void createActionListener()  {
	mActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {                  
        	Component source = (Component) actionEvent.getSource();
        	String sourceName= source.getName();
        	if(sourceName == LoginPanel.LOGIN_BUTTON){
        		checkUser();
        	}else if (sourceName == LoginPanel.CANCEL_BUTTON){
        		exit();
        	}else if (sourceName == MenuPanel.ADD_MARKS_BUTTON){
        		showMarksPanel();
        	}else if (sourceName == MenuPanel.ADD_STUDENT_BUTTON){
        		showStudentPanel();
        	}else if (sourceName == StudentPanel.ADD_BUTTON){
        		addStudentInfo();
        		mMarkSheetPanel.updateStudentListAndSubjects();
        		mMarkSheetPanel.updateStudentInfoAndMarks();
        	}else if (sourceName == StudentPanel.MENU_BUTTON){
        		showMenuPanel();
        	}else if (sourceName == MarkSheetPanel.COURSE_LIST){
        		mMarkSheetPanel.updateStudentListAndSubjects();
        		mMarkSheetPanel.updateStudentInfoAndMarks();
        	}else if (sourceName == MarkSheetPanel.STUDENT_LIST){
        		mMarkSheetPanel.updateStudentInfoAndMarks();
        	}else if (sourceName == MarkSheetPanel.UPDATE_BUTTON){
        		mMarkSheetPanel.updateMarkSheet();
        	}else if (sourceName == MarkSheetPanel.EXAM_LIST){
        		mMarkSheetPanel.updateStudentInfoAndMarks();
        	}
        }

		private void addStudentInfo() {
			String stdName = mStudentPanel.name();
			if(stdName.trim().length()>0){
			String course = mStudentPanel.course();
			int sequenceStudentId = mDataCollections.sequenceStudentId();
			mDataCollections.addStudent(sequenceStudentId, stdName, course);
			mStudentPanel.clear();
			}
		}

		private void showStudentPanel() {
			mMenu.show(false);
			mStudentPanel.show(true);
		}

		private void showMarksPanel() {
			mMenu.show(false);
			mMarkSheetPanel.show(true);
		}
  };
}


private void createPanels() {
	mLogin = new LoginPanel();
	mLogin.show(false);
	mLogin.addActionListener(mActionListener);
	
	mMenu = new MenuPanel();
	mMenu.show(false);
	mMenu.addActionListener(mActionListener);
	
	mStudentPanel = new StudentPanel(mDataCollections);
	mStudentPanel.show(false);
	mStudentPanel.addActionListener(mActionListener);
	
	mMarkSheetPanel = new MarkSheetPanel(mDataCollections);
	mMarkSheetPanel.show(false);
	mMarkSheetPanel.addActionListener(mActionListener);
	
}


}
