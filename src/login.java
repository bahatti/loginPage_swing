import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username_stok;
	private JPasswordField pwdPassword;
	private JTextField user;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*other page code
					login main_PAGE = new login();
					main_PAGE.setVisible(true);
					*/
					login frame = new login();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//button function
	public void signin() {
        //define  (user and password)
		String UserName = new String("A");
		String Password = new String("A");
		//read value
		String enteredUserName = user.getText();
		String enteredPassword = new String(passwordField.getPassword());
		//compare define value and read value
		if (UserName.matches(enteredUserName) && Password.matches(enteredPassword)) {
			dispose();//Close login page
		/*open other page code
		 * 	main_PAGE page = new main_PAGE();
			page.setVisible(true);*/
		} else {
			JOptionPane.showMessageDialog(null, "Username/Password Eror", "ERROR", JOptionPane.ERROR_MESSAGE);
			user.setText(null);
			passwordField.setText(null);
			user.requestFocusInWindow();
		}
	}

	public login() {
		//windows image
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/img_login/icons_password-64.png")));
		//windows title
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//windows screen size
		setBounds(100, 100, 900, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// center windows
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		//button 
		JButton signinbtn = new JButton("Giri\u015F");
		signinbtn.setBounds(451, 371, 261, 50);
		signinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//go to button function
				signin();
			}
		});

		signinbtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//press to enter do click
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					signinbtn.doClick();
				}
			}
		});

		contentPane.setLayout(null);
		//button specification
		signinbtn.setBackground(Color.YELLOW);
		signinbtn.setForeground(Color.RED);
		signinbtn.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(signinbtn);

		user = new JTextField("Enter The Username");
		user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.setForeground(Color.BLACK);
				user.setText(null);
			}
		});
		
		
		user.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordField.requestFocusInWindow();
					
				}
			}
		});
		user.setFont(new Font("Times New Roman", Font.ITALIC, 29));
		user.setForeground(Color.LIGHT_GRAY);
		user.setBounds(451, 183, 261, 62);
		contentPane.add(user);
		user.setColumns(20);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		passwordField.setBounds(451, 277, 261, 62);
		contentPane.add(passwordField);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					signinbtn.doClick();
				}
			}
		});
		JLabel label = new JLabel("");
		label.setBounds(352, 267, 64, 71);
		label.setIcon(new ImageIcon(login.class.getResource("/img_login/icons_password-64.png")));
		contentPane.add(label);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(352, 183, 64, 71);
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/img_login/icons_user2-64.png")));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(login.class.getResource("/img_login/LOGO240_240PX.png")));
		lblNewLabel_3.setBounds(98, 183, 227, 241);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/img_login/wood.jpg")));
		lblNewLabel.setBounds(-6, -16, 895, 609);
		contentPane.add(lblNewLabel);

	}
}
