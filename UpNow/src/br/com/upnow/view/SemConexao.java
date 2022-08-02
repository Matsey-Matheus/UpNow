package br.com.upnow.view;

import java.awt.Color;
import java.awt.Cursor;
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

public class SemConexao {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void semconexao() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemConexao window = new SemConexao();
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
	public SemConexao() {
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
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteLog.cliLog();;
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
		
		JLabel lblConstrucao = new JLabel("");
		lblConstrucao.setIcon(new ImageIcon(SemConexao.class.getResource("/imagens/icons8-nuvem-erro-100.png")));
		lblConstrucao.setBounds(271, 351, 100, 100);
		frame.getContentPane().add(lblConstrucao);
		
		JLabel lblTextoCons = new JLabel("Erro ao conectar");
		lblTextoCons.setFont(new Font("Constantia", Font.BOLD, 16));
		lblTextoCons.setBounds(259, 450, 133, 20);
		frame.getContentPane().add(lblTextoCons);
		
		
		
	}

}
