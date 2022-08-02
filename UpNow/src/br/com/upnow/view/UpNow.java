package br.com.upnow.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Cursor;

public class UpNow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpNow window = new UpNow();
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
	public UpNow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(650, 700);
		frame.setTitle("UpNow");
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icons8-nuvem-96.png")));
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

		JButton btnAdm = new JButton("");
		btnAdm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdm.setIcon(new ImageIcon(UpNow.class.getResource("/imagens/adm100.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAdm.setIcon(new ImageIcon(UpNow.class.getResource("/imagens/adm90.png")));
			}
		});
		btnAdm.setBackground(Color.WHITE);
		btnAdm.setIcon(new ImageIcon(UpNow.class.getResource("/imagens/adm90.png")));
		btnAdm.setBorderPainted(false);
		btnAdm.setBounds(357, 344, 100, 100);
		frame.getContentPane().add(btnAdm);

		JButton btnCliente = new JButton("");
		btnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente.iniCliente();
				frame.setVisible(false);
			}
		});
		btnCliente.setBackground(Color.WHITE);
		btnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCliente.setIcon(new ImageIcon(UpNow.class.getResource("/imagens/icons8-usuário-100.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCliente.setIcon(new ImageIcon(UpNow.class.getResource("/imagens/icons8-usuário-90.png")));
			}
		});
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCliente.setBounds(204, 441, 54, 14);
		frame.getContentPane().add(lblCliente);
		btnCliente.setIcon(new ImageIcon(UpNow.class.getResource("/imagens/icons8-usuário-90.png")));
		btnCliente.setBorderPainted(false);
		btnCliente.setBounds(182, 344, 100, 100);
		frame.getContentPane().add(btnCliente);

		JLabel lblAdm = new JLabel("Administração");
		lblAdm.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAdm.setBounds(350, 441, 115, 14);
		frame.getContentPane().add(lblAdm);
		

	}
}
