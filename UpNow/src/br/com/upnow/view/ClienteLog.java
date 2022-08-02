package br.com.upnow.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.upnow.controller.ClienteController;
import br.com.upnow.model.ClienteLoginModel;
import br.com.upnow.model.ClienteModel;

import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ClienteLog {

	private JFrame frame;
	private JTextField txtEmail;
	private JLabel lblCampos;
	private JPasswordField txtSenha;
	private JLabel lblIncorreto;
	private ClienteModel cliente;
	private ClienteController cliCon; 

	/**
	 * Launch the application.
	 */
	public static void cliLog() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteLog window = new ClienteLog();
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
	public ClienteLog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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

		JLabel lblEmail = new JLabel("Digite seu e-mail:");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblEmail.setBounds(185, 291, 134, 22);
		frame.getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int enter = e.getExtendedKeyCode();
				if (txtEmail.isFocusable() && enter == 10) {
					txtEmail.setFocusable(false);
					txtSenha.setFocusable(true);
				}
				txtEmail.setFocusable(true);
			}
		});
		txtEmail.setSelectedTextColor(Color.LIGHT_GRAY);
		txtEmail.setBorder(null);
		txtEmail.setName("");
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setBackground(new Color(0, 194, 203));
		txtEmail.setToolTipText("");
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txtEmail.setBounds(185, 320, 263, 53);
		frame.getContentPane().add(txtEmail);

		txtSenha = new JPasswordField();
		txtSenha.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				int enter = e.getExtendedKeyCode();
				if (txtSenha.isFocusable() && enter == 10) {
					if (!txtEmail.getText().equalsIgnoreCase("") && !txtSenha.getText().equalsIgnoreCase("")) {
						cliente = new ClienteModel();
						cliente.setDsEmailCliente(txtEmail.getText());
						cliente.setDsSenha(txtSenha.getText());
						
						cliCon = new ClienteController();
						try {
							if(cliente.getDsEmailCliente().equals(cliCon.selectInfosLogin(txtEmail.getText(), txtSenha.getText()).getDsEmailCliente()) && cliente.getDsSenha().equals(cliCon.selectInfosLogin(txtEmail.getText(), txtSenha.getText()).getDsSenha())) {
								lblIncorreto.setVisible(false);
								ClienteLoginModel.setNome(txtEmail.getText());
								AreaCliente.areaCliente();
								frame.setVisible(false);
							}
						} catch (Exception e2) {
							lblIncorreto.setVisible(true);
							lblCampos.setVisible(false);
						}
						
						
					} else {
						lblIncorreto.setVisible(false);
						lblCampos.setVisible(true);
					}
				}
			}
		});
		txtSenha.setToolTipText("");
		txtSenha.setSelectedTextColor(Color.LIGHT_GRAY);
		txtSenha.setName("");
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setForeground(Color.WHITE);
		txtSenha.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txtSenha.setBorder(null);
		txtSenha.setBackground(new Color(0, 194, 203));
		txtSenha.setBounds(185, 422, 263, 53);
		frame.getContentPane().add(txtSenha);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSenha.setBounds(185, 395, 57, 22);
		frame.getContentPane().add(lblSenha);

		JButton btnEntrar = new JButton("");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (!txtEmail.getText().equalsIgnoreCase("") && !txtSenha.getText().equalsIgnoreCase("")) {
					cliente = new ClienteModel();
					cliente.setDsEmailCliente(txtEmail.getText());
					cliente.setDsSenha(txtSenha.getText());
					
					cliCon = new ClienteController();
					try {
						if(cliente.getDsEmailCliente().equals(cliCon.selectInfosLogin(txtEmail.getText(), txtSenha.getText()).getDsEmailCliente()) && cliente.getDsSenha().equals(cliCon.selectInfosLogin(txtEmail.getText(), txtSenha.getText()).getDsSenha())) {
							lblIncorreto.setVisible(false);
							ClienteLoginModel.setNome(txtEmail.getText());
							AreaCliente.areaCliente();
							frame.setVisible(false);
						}
					} catch (Exception e2) {
						lblIncorreto.setVisible(true);
						lblCampos.setVisible(false);
					}
					
					
				} else {
					lblIncorreto.setVisible(false);
					lblCampos.setVisible(true);
				}
			}
		});
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntrar.setIcon(
						new ImageIcon(ClienteLog.class.getResource("/imagens/icons8-digite-a-chave-do-mac-70.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEntrar.setIcon(
						new ImageIcon(ClienteLog.class.getResource("/imagens/icons8-digite-a-chave-do-mac-60.png")));
			}
		});
		btnEntrar.setIcon(new ImageIcon(ClienteLog.class.getResource("/imagens/icons8-digite-a-chave-do-mac-60.png")));
		btnEntrar.setBorder(null);
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		btnEntrar.setBounds(288, 512, 60, 60);
		frame.getContentPane().add(btnEntrar);

		lblCampos = new JLabel("Preencha os campos.");
		lblCampos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCampos.setVisible(false);
		lblCampos.setForeground(Color.RED);
		lblCampos.setBounds(260, 493, 116, 14);
		frame.getContentPane().add(lblCampos);

		lblIncorreto = new JLabel("E-mail ou senha incorretos.");
		lblIncorreto.setVisible(false);
		lblIncorreto.setForeground(Color.RED);
		lblIncorreto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIncorreto.setBounds(247, 493, 158, 14);
		frame.getContentPane().add(lblIncorreto);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente.iniCliente();
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
