package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.program;
import db.DB;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DropMode;

public class Tela_acesso extends JFrame {

	private JPanel contentPane;
	program execute = new program();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_acesso frame = new Tela_acesso();
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
	public Tela_acesso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Administra\u00E7\u00E3o de Jogos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_acesso.class.getResource("/imagens/images (1).png")));
		setBounds(100, 100, 699, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.ORANGE);
		textArea.setSelectedTextColor(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(144, 201, 399, 299);
		textArea.setEditable(false);
		textArea.setFont(new Font("Source Code Pro Black", Font.PLAIN, 16));
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea);
		
		JScrollPane sp = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(144, 201, 399, 299);
		contentPane.add(sp);
		
		JButton btnMostrar = new JButton("");
		btnMostrar.setBounds(148, 124, 97, 30);
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0 ) {
				
				
				//program.recuperar_dados();
				//resgata os dados do BD e os mostra na ordem dita
				
				
				Connection conn = null; //conectar
				Statement st = null; //buscar os departamentos do banco de dados
				ResultSet rs = null; //resultado da consulta
				
				try {
					conn = DB.getConnection(); 
					st = conn.createStatement(); 
					rs= st.executeQuery("Select * from jogos");
					int cont = 1;
					while(rs.absolute(cont)){
						textArea.insert(" "+rs.getInt("ID")+" | "+rs.getString("Nome")+" | "+rs.getString("Nome_jogo")+" | "+rs.getString("Data")+"\n",cont++);
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				
			
			}
		});
		
		btnMostrar.setIcon(new ImageIcon(Tela_acesso.class.getResource("/imagens/Acessar.png")));
		contentPane.add(btnMostrar);
		
		JButton btnEscolhas = new JButton("");
		btnEscolhas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tela_registro frame = new Tela_registro();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						dispose();
					}
				});
			
			}
		});
		btnEscolhas.setBounds(434, 124, 109, 30);
		btnEscolhas.setIcon(new ImageIcon(Tela_acesso.class.getResource("/imagens/Registrar.png")));
		contentPane.add(btnEscolhas);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-837, 0, 1582, 681);
		lblNewLabel.setIcon(new ImageIcon(Tela_acesso.class.getResource("/imagens/0_F6OPpDyz21LxBwlv-1068x601-1620x800.jpg")));
		contentPane.add(lblNewLabel);
		
		
	}
}
