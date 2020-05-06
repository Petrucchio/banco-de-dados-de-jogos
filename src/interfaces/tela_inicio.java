package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Cursor;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class tela_inicio extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_inicio frame = new tela_inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public tela_inicio() throws ParseException {
		
		setTitle("Administra\u00E7\u00E3o de jogos");
		setForeground(Color.WHITE);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(tela_inicio.class.getResource("/imagens/images (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 819);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton CONECTAR = new JButton("");
		CONECTAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("nome do login")&&passwordField.getText().equals("senha do login")) {//aqui você define o login e a senha de forma manual
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Tela_escolha frame = new Tela_escolha();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
							dispose();
						}
					});
				
				}
			}
		});
		MaskFormatter mas = new MaskFormatter("Senha");
		CONECTAR.setIcon(new ImageIcon(tela_inicio.class.getResource("/imagens/Sem t\u00EDtulo.png")));
		CONECTAR.setBounds(362, 538, 110, 51);
		contentPane.add(CONECTAR);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Swis721 Blk BT", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBounds(393, 461, 91, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Swis721 Blk BT", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(385, 401, 207, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Swis721 Blk BT", Font.PLAIN, 14));
		textField.setForeground(Color.ORANGE);
		textField.setBackground(Color.BLACK);
		textField.setBounds(315, 428, 207, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Swis721 Blk BT", Font.PLAIN, 14));
		passwordField.setForeground(Color.ORANGE);
		passwordField.setCaretColor(Color.ORANGE);
		passwordField.setBackground(Color.BLACK);
		passwordField.setSelectedTextColor(Color.ORANGE);
		passwordField.setBounds(343, 486, 152, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(tela_inicio.class.getResource("/imagens/will-murai-blizzcon2018-keyart-vertical-002-v3-nologo-copy-copy_Easy-Resize.com.jpg")));
		lblNewLabel.setBounds(0, -39, 858, 1131);
		contentPane.add(lblNewLabel);
	}
}
