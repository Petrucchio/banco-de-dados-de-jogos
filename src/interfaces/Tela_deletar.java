package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import application.program;
import db.DB;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Tela_deletar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	program executar = new program();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_deletar frame = new Tela_deletar();
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
	public Tela_deletar() {
		setTitle("Administra\u00E7\u00E3o de Jogos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_deletar.class.getResource("/imagens/images (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				program.deletar_dados(textField.getText());
				

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tela_acesso frame = new Tela_acesso();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						dispose();
					}
				});
				
			
			}
		});
		btnNewButton.setIcon(new ImageIcon(Tela_deletar.class.getResource("/imagens/Screenshot_3.jpg")));
		btnNewButton.setBounds(230, 148, 109, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ID a ser deletado");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(85, 98, 135, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(Color.ORANGE);
		textField.setBackground(Color.BLACK);
		textField.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 16));
		textField.setBounds(230, 96, 198, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 11, 397, 297);
		textArea.setForeground(Color.ORANGE);
		textArea.setSelectedTextColor(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setFont(new Font("Source Code Pro Black", Font.PLAIN, 16));
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea);
		
		JScrollPane sp = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(144, 201, 399, 299);
		contentPane.add(sp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tela_deletar.class.getResource("/imagens/retirar.jpg")));
		lblNewLabel.setBounds(-275, -53, 1077, 746);
		contentPane.add(lblNewLabel);
		

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

}
