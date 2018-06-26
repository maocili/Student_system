import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	static Login frame = new Login();
	
	GetConn getConn=new GetConn();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setUndecorated(true); // 去掉窗口的装饰  
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}

			private void login() {
				Connection conn;
				try {
					
					conn=getConn.getConnection();
//					SQL连接语句
					PreparedStatement statement=conn.prepareStatement(
							"select * from account where student_id=? and password=?");
					statement.setString(1, textField_1.getText());
					statement.setString(2, new String(passwordField.getPassword()));
					ResultSet result=statement.executeQuery();
					/*
					 * 判断是否存在账号密码
					 * */
					if(result.next()) {
						
						main_frame main_f = new main_frame();
						main_f.setVisible(true);
						main_f.setLocationRelativeTo(null);
						frame.setVisible(false);
						
						
						
					}else {
						showMessageFrame showMsg = new showMessageFrame("登陆失败");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		
				btnNewButton.setIcon(new ImageIcon(".\\Images\\login.png"));
				btnNewButton.setBounds(144, 301, 57, 57);
				btnNewButton.setContentAreaFilled(false);
				btnNewButton.setFocusPainted(false);
				btnNewButton.setBorderPainted(false);
				contentPane.add(btnNewButton);
		
		
			
		passwordField = new JPasswordField();
		passwordField.setBounds(119, 246, 162, 32);
		passwordField.setOpaque(false);
		passwordField.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.add(passwordField);
		/*
		 * textField_1  username text
		 * */
		textField_1 = new JTextField();
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setBounds(119, 177, 162, 32);
		textField_1.setOpaque(false);
		textField_1.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						JTextField src = (JTextField)e.getSource();
						if(src.getText().trim().isEmpty()){
							src.setText("请输入用户名:");
							src.setForeground(Color.LIGHT_GRAY);
						}
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						JTextField src = (JTextField)e.getSource();
						src.setForeground(Color.blue);
							if(src.getText().equals("请输入用户名:"))
							{
								src.setText(null);
							}
					}
				});

		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("幼圆", Font.BOLD, 13));
		label.setBounds(55, 180, 66, 24);
		contentPane.add(label);
		
		JLabel label_4 = new JLabel("______________________");
		label_4.setBounds(119, 194, 162, 15);
		contentPane.add(label_4);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setFont(new Font("幼圆", Font.BOLD, 13));
		label_1.setBounds(55, 249, 66, 24);
		contentPane.add(label_1);
		
		JLabel label_5 = new JLabel("______________________");
		label_5.setBounds(119, 266, 162, 15);
		contentPane.add(label_5);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(".\\Images\\exit.png"));
		button.setBounds(318, 0, 20, 20);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		contentPane.add(button);
		
		
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(".\\Images\\2.png"));
		label_2.setBounds(138, 55, 86, 86);
		contentPane.add(label_2);
		
		/*
		 * Login_btn
		 * */
		
		JButton button_1 = new JButton("\u627E\u56DE\u5BC6\u7801");
		button_1.setBounds(217, 383, 93, 23);
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		contentPane.add(button_1);
		
		JButton register_btn = new JButton("\u8D26\u53F7\u6CE8\u518C");
		register_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		register_btn.setBounds(28, 383, 93, 23);
		register_btn.setContentAreaFilled(false);
		register_btn.setFocusPainted(false);
		register_btn.setBorderPainted(false);
		contentPane.add(register_btn);
		register_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register_frame register_f = new register_frame();
				register_f.setVisible(true);
				register_f.setLocationRelativeTo(null);
				frame.setVisible(false);
				
			}
		});
		
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(".\\Images\\break.png"));
		label_3.setBounds(0, 0, 340, 480);
		contentPane.add(label_3);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				button.setIcon(new ImageIcon(".\\Images\\exit.png"));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				button.setIcon(new ImageIcon(".\\Images\\exit2.png"));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
				
		
	}
}
