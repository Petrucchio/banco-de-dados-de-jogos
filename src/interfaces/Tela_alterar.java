package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_alterar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_alterar frame = new Tela_alterar();
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
	public Tela_alterar() {
		setTitle("Administra\u00E7\u00E3o de Jogos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_alterar.class.getResource("/imagens/images (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlterarNome = new JButton("");
		btnAlterarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tela_alterarNome frame = new Tela_alterarNome();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						dispose();
					}
				});
			
			}
		});
		btnAlterarNome.setIcon(new ImageIcon(Tela_alterar.class.getResource("/imagens/ALTERNOME.jpg")));
		btnAlterarNome.setBounds(403, 302, 127, 34);
		contentPane.add(btnAlterarNome);
		
		JButton btnAlterarJogo = new JButton("");
		btnAlterarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tela_alterarNomeJogo frame = new Tela_alterarNomeJogo();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						dispose();
					}
				});
			
			}
		});
		btnAlterarJogo.setIcon(new ImageIcon(Tela_alterar.class.getResource("/imagens/ALTERJOGO.jpg")));
		btnAlterarJogo.setBounds(95, 302, 127, 34);
		contentPane.add(btnAlterarJogo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tela_alterar.class.getResource("/imagens/Darm8vzV4AI0CMX.jpg")));
		lblNewLabel.setBounds(-185, -46, 800, 573);
		contentPane.add(lblNewLabel);
	}
}
