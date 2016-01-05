package itcollege.panels;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel   {

	public static String LOGIN_BUTTON="login";
	public static String CANCEL_BUTTON="cancel";
		
	private static JButton mLoginButton;
	private static JButton mCancelButton;
	private static JTextField mUserText;
	private static JPasswordField mPasswordText;
	private JFrame mLoginFrame;
	

	public LoginPanel() {
		mLoginFrame = new JFrame("Login");
		mLoginFrame.setBounds(250, 250, 300, 150);
		mLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		placeComponents(mLoginFrame);
	}

	private static void placeComponents(JFrame frame) {
		frame.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		frame.add(userLabel);

		mUserText = new JTextField(20);
		mUserText.setBounds(100, 10, 160, 25);
		frame.add(mUserText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		frame.add(passwordLabel);

		mPasswordText = new JPasswordField(20);
		mPasswordText.setBounds(100, 40, 160, 25);
		frame.add(mPasswordText);

		mLoginButton = new JButton(LOGIN_BUTTON);
		mLoginButton.setName(LOGIN_BUTTON);
		mLoginButton.setBounds(10, 80, 80, 25);
		frame.add(mLoginButton);

		mCancelButton = new JButton(CANCEL_BUTTON);
		mCancelButton.setName(CANCEL_BUTTON);
		mCancelButton.setBounds(180, 80, 80, 25);
		frame.add(mCancelButton);
	
	}

	public void addActionListener(ActionListener loginActionListener) {
		// TODO Auto-generated method stub
		mLoginButton.addActionListener(loginActionListener);
		mCancelButton.addActionListener(loginActionListener);
	}
	
	public String username(){
		return mUserText.getText();
	}
	
	public String password(){
		return mPasswordText.getText();
	}
	
	
	public void show(boolean b) {
		mLoginFrame.setVisible(b);
	}

}