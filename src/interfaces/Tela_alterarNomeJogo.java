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
import javafx.scene.control.Spinner;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class Tela_alterarNomeJogo extends JFrame {

	private JPanel contentPane;
	private JTextField Jogo;
	program executar = new program();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_alterarNomeJogo frame = new Tela_alterarNomeJogo();
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
	public Tela_alterarNomeJogo() {
		setTitle("Administra\u00E7\u00E3o de jogos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_alterarNomeJogo.class.getResource("/imagens/images (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 16));
		spinner.setBounds(208, 65, 52, 20);
		contentPane.add(spinner);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	

				String nomejogo = Jogo.getText();
				int Id = (int) spinner.getValue();
				Date data = new Date();
				SimpleDateFormat formatar = new SimpleDateFormat("H:m d/M/y");
				String dataformatada = formatar.format(data);
				Connection conn = null;
				PreparedStatement st = null;
				try {
					conn = DB.getConnection();
					st = conn.prepareStatement(
							"UPDATE jogos "
							+"SET Nome_jogo = ? , Data = ? "
							+"WHERE ID = ? ");
					
					st.setString(1, nomejogo);
					st.setString(2, dataformatada);
					st.setInt(3,Id);
					
					st.executeUpdate();
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				
			
			
				
				
			

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
		
		
		btnNewButton.setIcon(new ImageIcon(Tela_alterarNomeJogo.class.getResource("/imagens/ALTERJOGO.jpg")));
		btnNewButton.setBounds(208, 154, 123, 36);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("Novo Jogo");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(94, 95, 91, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblIdDaLinha = new JLabel("ID do jogo");
		lblIdDaLinha.setForeground(Color.ORANGE);
		lblIdDaLinha.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
		lblIdDaLinha.setBounds(94, 61, 104, 23);
		contentPane.add(lblIdDaLinha);
		
		Jogo = new JTextField();
		Jogo.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 16));
		Jogo.setForeground(Color.ORANGE);
		Jogo.setBackground(Color.BLACK);
		Jogo.setBounds(208, 95, 123, 26);
		contentPane.add(Jogo);
		Jogo.setColumns(10);
		
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
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-892, -69, 1673, 687);
		lblNewLabel.setIcon(new ImageIcon(Tela_alterarNomeJogo.class.getResource("/imagens/rise-of-shadows-wallpaper-1920x1080-general007.jpg")));
		contentPane.add(lblNewLabel);
	}
}
