package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_escolha extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_escolha frame = new Tela_escolha();
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
	public Tela_escolha() {
		setTitle("Administra\u00E7\u00E3o de Jogos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_escolha.class.getResource("/imagens/images (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton REGISTRAR = new JButton("");
		REGISTRAR.addActionListener(new ActionListener() {
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
		REGISTRAR.setIcon(new ImageIcon(Tela_escolha.class.getResource("/imagens/Registrar.png")));
		REGISTRAR.setFont(new Font("Swis721 Blk BT", Font.PLAIN, 16));
		REGISTRAR.setForeground(Color.ORANGE);
		REGISTRAR.setBackground(Color.WHITE);
		REGISTRAR.setBounds(543, 445, 110, 38);
		contentPane.add(REGISTRAR);
		
		JButton ACESSAR = new JButton("");
		ACESSAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
		ACESSAR.setIcon(new ImageIcon(Tela_escolha.class.getResource("/imagens/Acessar.png")));
		ACESSAR.setBounds(183, 445, 95, 38);
		contentPane.add(ACESSAR);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Tela_escolha.class.getResource("/imagens/escolhas.jpg")));
		lblNewLabel.setBounds(0, 0, 800, 600);
		contentPane.add(lblNewLabel);
	}

}
