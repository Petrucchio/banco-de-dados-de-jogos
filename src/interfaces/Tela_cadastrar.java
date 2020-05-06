package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.program;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Tela_cadastrar extends JFrame {

	private JPanel contentPane;
	private JTextField Nome;
	private JTextField Nome_jogo;
	program execute = new program();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_cadastrar frame = new Tela_cadastrar();
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
	public Tela_cadastrar() {
		setTitle("Adiministra\u00E7\u00E3o de Jogos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_cadastrar.class.getResource("/imagens/images (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 24));
		lblNome.setForeground(new Color(255, 200, 0));
		lblNome.setBackground(Color.ORANGE);
		lblNome.setBounds(142, 193, 72, 26);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel_1 = new JLabel("Jogo");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(142, 260, 72, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				program.inserir_dados(Nome.getText(), Nome_jogo.getText());
				

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
		btnCadastrar.setIcon(new ImageIcon(Tela_cadastrar.class.getResource("/imagens/Screenshot_2.jpg")));
		btnCadastrar.setBounds(288, 347, 109, 26);
		contentPane.add(btnCadastrar);
		
		Nome = new JTextField();
		Nome.setBackground(Color.BLACK);
		Nome.setForeground(Color.ORANGE);
		Nome.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 16));
		Nome.setBounds(224, 190, 232, 40);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		Nome_jogo = new JTextField();
		Nome_jogo.setForeground(Color.ORANGE);
		Nome_jogo.setBackground(Color.BLACK);
		Nome_jogo.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 16));
		Nome_jogo.setBounds(224, 258, 232, 40);
		contentPane.add(Nome_jogo);
		Nome_jogo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Tela_cadastrar.class.getResource("/imagens/rxXhHYr.jpg")));
		lblNewLabel.setBounds(-395, -43, 1526, 933);
		contentPane.add(lblNewLabel);
	}
}
