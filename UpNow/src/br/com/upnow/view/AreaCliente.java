package br.com.upnow.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.SwingConstants;

import br.com.upnow.controller.ClienteController;
import br.com.upnow.model.ClienteLoginModel;

import javax.swing.JTextArea;

public class AreaCliente {

	private static JFrame frame;
	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		AreaCliente.frame = frame;
	}

	private JLabel lblTextoCons;
	private JLabel lblOlaUsuario;

	/**
	 * Launch the application.
	 */
	public static void areaCliente() {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					AreaCliente window = new AreaCliente();
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
	public AreaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setSize(new Dimension(100, 0));
		frame.getContentPane().setBounds(new Rectangle(100, 0, 100, 0));
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icons8-nuvem-96.png")));
		frame.setSize(650, 700);
		frame.setTitle("UpNow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setFocusable(true);
		
		JLabel msgBaixo = new JLabel("");
		msgBaixo.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/MensagemBaixo.jpeg")));
		msgBaixo.setBounds(11, 583, 483, 67);
		frame.getContentPane().add(msgBaixo);

		JLabel lblSair = new JLabel("Sair");
		lblSair.setVisible(false);
		lblSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSair.setBounds(70, 136, 22, 14);
		frame.getContentPane().add(lblSair);

		JButton btnSair = new JButton("");
		btnSair.setVisible(false);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmSaida.confirmeSair();
				frame.setEnabled(false);
			}
		});
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSair.setIcon(new ImageIcon(AreaCliente.class.getResource("/imagens/icons8-kitar-35.png")));
				lblSair.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSair.setIcon(new ImageIcon(AreaCliente.class.getResource("/imagens/icons8-kitar-30.png")));
				lblSair.setVisible(false);
			}
		});
		btnSair.setBorder(null);
		btnSair.setIcon(new ImageIcon(AreaCliente.class.getResource("/imagens/icons8-kitar-30.png")));
		btnSair.setBackground(Color.WHITE);
		btnSair.setBounds(25, 128, 35, 35);
		frame.getContentPane().add(btnSair);

		JLabel lblConstrucao = new JLabel("");
		lblConstrucao.setIcon(new ImageIcon(AreaCliente.class.getResource("/imagens/icons8-martelo-100.png")));
		lblConstrucao.setBounds(287, 173, 100, 100);
		frame.getContentPane().add(lblConstrucao);

		lblTextoCons = new JLabel("Em produção");
		lblTextoCons.setFont(new Font("Constantia", Font.BOLD, 16));
		lblTextoCons.setBounds(270, 304, 113, 20);
		frame.getContentPane().add(lblTextoCons);

		JLabel lblInformacoes = new JLabel("Informações");
		lblInformacoes.setVisible(false);
		lblInformacoes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformacoes.setBounds(70, 91, 72, 14);
		frame.getContentPane().add(lblInformacoes);

		JLabel lblInfosCliente = new JLabel("");
		lblInfosCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInfosCliente.setVisible(false);
		lblInfosCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblInfosCliente
						.setIcon(new ImageIcon(AreaCliente.class.getResource("/imagens/icons8-informações-35.png")));
				lblInformacoes.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblInfosCliente
						.setIcon(new ImageIcon(AreaCliente.class.getResource("/imagens/icons8-informações-30.png")));
				lblInformacoes.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
				

			}
		});

		lblInfosCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfosCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInfosCliente.setIcon(new ImageIcon(AreaCliente.class.getResource("/imagens/icons8-informações-30.png")));
		lblInfosCliente.setBorder(null);
		lblInfosCliente.setBackground(Color.WHITE);
		lblInfosCliente.setBounds(25, 82, 35, 35);
		frame.getContentPane().add(lblInfosCliente);

		JLabel lblCliente = new JLabel("");
		lblCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 0 && !lblInfosCliente.isVisible()) {
					lblCliente.setIcon(new ImageIcon(AreaCliente.class.getResource("/imagens/icons8-usuário-65.png")));
					lblInfosCliente.setVisible(true);
					btnSair.setVisible(true);
				} else {
					lblCliente.setIcon(new ImageIcon(AreaCliente.class.getResource("/imagens/icons8-usuário-60.png")));
					lblInfosCliente.setVisible(false);
					btnSair.setVisible(false);
				}
			}
		});
		lblCliente.setIcon(new ImageIcon(AreaCliente.class.getResource("/imagens/icons8-usuário-60.png")));
		lblCliente.setBackground(Color.WHITE);
		lblCliente.setBorder(null);
		lblCliente.setBounds(11, 11, 65, 65);
		frame.getContentPane().add(lblCliente);

		JTextArea txtrSadsaDsadasDsadsa = new JTextArea();
		txtrSadsaDsadasDsadsa.setEnabled(false);
		txtrSadsaDsadasDsadsa.setText(
				"     Obs: Criem algumas contas, \r\n tentem fazer login, saiam do login,\r\n  testem a área de \"informações do \r\ncliente e vejam se tudo está funcional\r\nFaçam todos os testes possiveis para\r\n eu tentar encontrar possíveis bugs\r\n    e se possível me dêem ideias.");
		txtrSadsaDsadasDsadsa.setBounds(223, 335, 293, 125);
		frame.getContentPane().add(txtrSadsaDsadasDsadsa);
		
		try {
			ClienteController cliCon = new ClienteController();
			lblOlaUsuario = new JLabel("");
			lblOlaUsuario.setText("Olá, " + cliCon.selectNome(ClienteLoginModel.getNome()) + "!");
			lblOlaUsuario.setForeground(new Color(0, 139, 139));
			lblOlaUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblOlaUsuario.setBounds(86, 30, 414, 25);
			frame.getContentPane().add(lblOlaUsuario);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		

	}

}
