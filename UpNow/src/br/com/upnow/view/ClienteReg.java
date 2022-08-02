package br.com.upnow.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.upnow.controller.ClienteController;
import br.com.upnow.model.ClienteModel;

public class ClienteReg {

	private JFrame frame;
	private JTextField txtEmail;
	private JLabel lblCampos;
	private JPasswordField txtSenha;
	private JLabel lblCpfCadastrado;
	private JTextField textNome;
	private JTextField txtCpf;
	private JTextField textRg;
	private JPasswordField txtConfirmeASenha;
	private JLabel lblSenhasNaoBatem;
	private JLabel lblEmailExiste;
	
	/**
	 * Launch the application.
	 */
	public static void clienteReg() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteReg window = new ClienteReg();
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
	public ClienteReg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Cliente.class.getResource("/imagens/UpNowLogo.jpeg")));
		logo.setBounds(-6, 64, 614, 200);
		frame.getContentPane().add(logo);

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

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblEmail.setBounds(288, 268, 57, 22);
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
		txtEmail.setBounds(188, 293, 265, 35);
		frame.getContentPane().add(txtEmail);
		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("");
		txtSenha.setSelectedTextColor(Color.LIGHT_GRAY);
		txtSenha.setName("");
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setForeground(Color.WHITE);
		txtSenha.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txtSenha.setBorder(null);
		txtSenha.setBackground(new Color(0, 194, 203));
		txtSenha.setBounds(188, 483, 265, 35);
		frame.getContentPane().add(txtSenha);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSenha.setBounds(122, 490, 57, 22);
		frame.getContentPane().add(lblSenha);

		JButton btnEntrar = new JButton("");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (!txtEmail.getText().equalsIgnoreCase("") && !txtSenha.getText().equalsIgnoreCase("")
						&& !textNome.getText().equals("") && txtCpf.getText().length() == 14
						&& textRg.getText().length() == 12) {

					ClienteModel cliente = new ClienteModel();
					cliente.setDsEmailCliente(txtEmail.getText());
					cliente.setNmCliente(textNome.getText());
					cliente.setNrCpfCliente(txtCpf.getText());
					cliente.setNrRgCliente(textRg.getText());
					cliente.setDsSenha(txtSenha.getText());

					ClienteController cliController = new ClienteController();
					try {
						if (!txtCpf.getText().equals(cliController.selectCpfExistente(cliente.getNrCpfCliente()))) {
							if (!txtEmail.getText().equals(cliController.selectEmail(cliente.getDsEmailCliente()))) {
								if (txtSenha.getText().equals(txtConfirmeASenha.getText())) {
									cliController.insert(cliente);
									ClienteLog.cliLog();
									frame.setVisible(false);
								} else {
									lblSenhasNaoBatem.setVisible(true);
									lblCpfCadastrado.setVisible(false);
									lblCampos.setVisible(false);
									lblEmailExiste.setVisible(false);
								}
							} else {
								lblEmailExiste.setVisible(true);
								lblSenhasNaoBatem.setVisible(false);
								lblCampos.setVisible(false);
								lblCpfCadastrado.setVisible(false);
							}
						} else {
							lblCpfCadastrado.setVisible(true);
							lblSenhasNaoBatem.setVisible(false);
							lblCampos.setVisible(false);
							lblEmailExiste.setVisible(false);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					lblCpfCadastrado.setVisible(false);
					lblSenhasNaoBatem.setVisible(false);
					lblCampos.setVisible(true);
					lblEmailExiste.setVisible(false);
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
		btnEntrar.setBounds(287, 590, 60, 60);
		frame.getContentPane().add(btnEntrar);

		lblCampos = new JLabel("Preencha os campos.");
		lblCampos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCampos.setVisible(false);
		lblCampos.setForeground(Color.RED);
		lblCampos.setBounds(261, 575, 116, 14);
		frame.getContentPane().add(lblCampos);

		lblCpfCadastrado = new JLabel("Esse CPF já está cadastrado.");
		lblCpfCadastrado.setVisible(false);
		lblCpfCadastrado.setForeground(Color.RED);
		lblCpfCadastrado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpfCadastrado.setBounds(243, 575, 155, 14);
		frame.getContentPane().add(lblCpfCadastrado);

		JLabel lblNome = new JLabel("Nome completo:");
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNome.setBounds(251, 327, 134, 22);
		frame.getContentPane().add(lblNome);

		textNome = new JTextField();
		textNome.setToolTipText("");
		textNome.setSelectedTextColor(Color.LIGHT_GRAY);
		textNome.setName("");
		textNome.setHorizontalAlignment(SwingConstants.CENTER);
		textNome.setForeground(Color.WHITE);
		textNome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textNome.setBorder(null);
		textNome.setBackground(new Color(0, 194, 203));
		textNome.setBounds(188, 352, 265, 35);
		frame.getContentPane().add(textNome);

		txtCpf = new JTextField();
		txtCpf.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				if (txtCpf.isFocusable()) {
					int puxText = txtCpf.getText().length();
					if (puxText == 3 || puxText == 7) {
						txtCpf.setText(txtCpf.getText() + ".");
					} else if (puxText == 11) {
						txtCpf.setText(txtCpf.getText() + "-");
					} else if (puxText == 14) {
						txtCpf.disable();
					}
				}
			}
		});
		txtCpf.setVerifyInputWhenFocusTarget(false);
		txtCpf.setToolTipText("");
		txtCpf.setSelectedTextColor(Color.LIGHT_GRAY);
		txtCpf.setName("");
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setForeground(Color.WHITE);
		txtCpf.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txtCpf.setBorder(null);
		txtCpf.setBackground(new Color(0, 194, 203));
		txtCpf.setBounds(138, 422, 162, 35);
		frame.getContentPane().add(txtCpf);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCpf.setBounds(200, 398, 38, 22);
		frame.getContentPane().add(lblCpf);

		JButton btnApagarCpf = new JButton("");
		btnApagarCpf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnApagarCpf.setIcon(new ImageIcon(ClienteReg.class.getResource("/imagens/icons8-apagar-25.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnApagarCpf.setIcon(new ImageIcon(ClienteReg.class.getResource("/imagens/icons8-apagar-20.png")));
			}

			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCpf.setText("");
				txtCpf.enable();
				txtCpf.setFocusable(true);
			}
		});
		btnApagarCpf.setBorder(null);
		btnApagarCpf.setIcon(new ImageIcon(ClienteReg.class.getResource("/imagens/icons8-apagar-20.png")));
		btnApagarCpf.setBackground(Color.WHITE);
		btnApagarCpf.setBounds(302, 428, 25, 25);
		frame.getContentPane().add(btnApagarCpf);

		textRg = new JTextField();
		textRg.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				if (textRg.isFocusable()) {
					int puxText = textRg.getText().length();
					if (puxText == 2 || puxText == 6) {
						textRg.setText(textRg.getText() + ".");
					} else if (puxText == 10) {
						textRg.setText(textRg.getText() + "-");
					} else if (puxText == 12) {
						textRg.disable();
					}
				}
			}
		});
		textRg.setVerifyInputWhenFocusTarget(false);
		textRg.setToolTipText("");
		textRg.setSelectedTextColor(Color.LIGHT_GRAY);
		textRg.setName("");
		textRg.setHorizontalAlignment(SwingConstants.CENTER);
		textRg.setForeground(Color.WHITE);
		textRg.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textRg.setBorder(null);
		textRg.setBackground(new Color(0, 194, 203));
		textRg.setBounds(337, 422, 162, 35);
		frame.getContentPane().add(textRg);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblRg.setBounds(405, 398, 30, 22);
		frame.getContentPane().add(lblRg);

		JButton btnApagarRg = new JButton("");
		btnApagarRg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnApagarRg.setIcon(new ImageIcon(ClienteReg.class.getResource("/imagens/icons8-apagar-25.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnApagarRg.setIcon(new ImageIcon(ClienteReg.class.getResource("/imagens/icons8-apagar-20.png")));
			}

			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				textRg.setText("");
				textRg.enable();
				textRg.setFocusable(true);
			}
		});
		btnApagarRg.setIcon(new ImageIcon(ClienteReg.class.getResource("/imagens/icons8-apagar-20.png")));
		btnApagarRg.setBorder(null);
		btnApagarRg.setBackground(Color.WHITE);
		btnApagarRg.setBounds(501, 428, 25, 25);
		frame.getContentPane().add(btnApagarRg);

		txtConfirmeASenha = new JPasswordField();
		txtConfirmeASenha.setToolTipText("");
		txtConfirmeASenha.setSelectedTextColor(Color.LIGHT_GRAY);
		txtConfirmeASenha.setName("");
		txtConfirmeASenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtConfirmeASenha.setForeground(Color.WHITE);
		txtConfirmeASenha.setFont(new Font("Segoe UI", Font.BOLD, 18));
		txtConfirmeASenha.setBorder(null);
		txtConfirmeASenha.setBackground(new Color(0, 194, 203));
		txtConfirmeASenha.setBounds(188, 529, 265, 35);
		frame.getContentPane().add(txtConfirmeASenha);

		JLabel lblConfirmeASenha = new JLabel("Confirme a senha:");
		lblConfirmeASenha.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblConfirmeASenha.setBounds(36, 536, 137, 22);
		frame.getContentPane().add(lblConfirmeASenha);

		lblSenhasNaoBatem = new JLabel("As senhas não coincidem.");
		lblSenhasNaoBatem.setVisible(false);
		lblSenhasNaoBatem.setForeground(Color.RED);
		lblSenhasNaoBatem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSenhasNaoBatem.setBounds(247, 575, 140, 14);
		frame.getContentPane().add(lblSenhasNaoBatem);
		
		lblEmailExiste = new JLabel("E-mail já cadastrado.");
		lblEmailExiste.setVisible(false);
		lblEmailExiste.setForeground(Color.RED);
		lblEmailExiste.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmailExiste.setBounds(262, 575, 111, 14);
		frame.getContentPane().add(lblEmailExiste);

	}
}
