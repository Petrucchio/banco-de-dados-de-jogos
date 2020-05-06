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

public class Tela_registro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_registro frame = new Tela_registro();
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
	public Tela_registro() {
		setTitle("Administra\u00E7\u00E3o de jogos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_registro.class.getResource("/imagens/images (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 794);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton REMOVER = new JButton("");
		REMOVER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tela_deletar frame = new Tela_deletar();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						dispose();
					}
				});
			
			}
		});
		REMOVER.setIcon(new ImageIcon(Tela_registro.class.getResource("/imagens/Screenshot_3.jpg")));
		REMOVER.setBounds(760, 385, 97, 31);
		contentPane.add(REMOVER);
		
		JButton ALTERAR = new JButton("");
		ALTERAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tela_alterar frame = new Tela_alterar();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						dispose();
					}
				});
			
			}
		});
		ALTERAR.setIcon(new ImageIcon(Tela_registro.class.getResource("/imagens/Screenshot_4.jpg")));
		ALTERAR.setBounds(412, 385, 105, 31);
		contentPane.add(ALTERAR);
		
		JButton ADICIONAR = new JButton("");
		ADICIONAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tela_cadastrar frame = new Tela_cadastrar();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						dispose();
					}
				});
			
			}
		});
		ADICIONAR.setIcon(new ImageIcon(Tela_registro.class.getResource("/imagens/Screenshot_2.jpg")));
		ADICIONAR.setBackground(Color.WHITE);
		ADICIONAR.setFont(new Font("Swis721 Blk BT", Font.PLAIN, 16));
		ADICIONAR.setForeground(Color.ORANGE);
		ADICIONAR.setBounds(121, 385, 105, 31);
		contentPane.add(ADICIONAR);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Tela_registro.class.getResource("/imagens/thumb-1920-1020079.png")));
		lblNewLabel_1.setBounds(-451, -208, 1640, 1426);
		contentPane.add(lblNewLabel_1);
	}
}
