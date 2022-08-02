package br.com.upnow.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Cursor;

public class Cliente {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void iniCliente() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icons8-nuvem-96.png")));
		frame.setSize(650, 700);
		frame.setTitle("UpNow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setFocusable(true);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/UpNowLogo.jpeg")));
		logo.setBounds(-6, 64, 614, 200);
		frame.getContentPane().add(logo);
		
		JLabel msgBaixo = new JLabel("");
		msgBaixo.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/MensagemBaixo.jpeg")));
		msgBaixo.setBounds(10, 583, 483, 67);
		frame.getContentPane().add(msgBaixo);
		JButton btnClienteSemConta = new JButton("");
		btnClienteSemConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteReg.clienteReg();
				frame.setVisible(false);
			}
		});
		btnClienteSemConta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClienteSemConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClienteSemConta.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/adicionar-pasta-100.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClienteSemConta.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/adicionar-pasta-90.png")));
			}
		});
		btnClienteSemConta.setBackground(Color.WHITE);
		btnClienteSemConta.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/adicionar-pasta-90.png")));
		btnClienteSemConta.setBorderPainted(false);
		btnClienteSemConta.setBounds(357, 344, 100, 100);
		frame.getContentPane().add(btnClienteSemConta);
		
		JButton btnCliente = new JButton("");
		btnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteLog.cliLog();
				frame.setVisible(false);
			}
		});
		btnCliente.setBackground(Color.WHITE);
		btnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCliente.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/pago-100.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCliente.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/pago-90.png")));
			}
		});
		JLabel lblCliente = new JLabel("Já tenho conta");
		lblCliente.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCliente.setBounds(178, 441, 112, 14);
		frame.getContentPane().add(lblCliente);
		btnCliente.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/pago-90.png")));
		btnCliente.setBorderPainted(false);
		btnCliente.setBounds(182, 344, 100, 100);
		frame.getContentPane().add(btnCliente);
		
		JLabel lblClienteSemConta = new JLabel("Não tenho conta");
		lblClienteSemConta.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblClienteSemConta.setBounds(345, 441, 128, 14);
		frame.getContentPane().add(lblClienteSemConta);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpNow.main(null);
				frame.setVisible(false);
			}
		});
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVoltar.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/icons8-voltar-52.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVoltar.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/icons8-voltar-48.png")));
			}
		});
		btnVoltar.setBorder(null);
		btnVoltar.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/icons8-voltar-48.png")));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(10, 11, 48, 48);
		frame.getContentPane().add(btnVoltar);
		
	}
}
