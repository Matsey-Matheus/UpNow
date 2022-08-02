package br.com.upnow.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfirmSaida {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void confirmeSair() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmSaida window = new ConfirmSaida();
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
	public ConfirmSaida() {
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
		frame.setSize(400, 300);
		frame.setTitle("UpNow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JLabel lblIconeSaida = new JLabel("");
		lblIconeSaida.setIcon(new ImageIcon(ConfirmSaida.class.getResource("/imagens/icons8-sair-80.png")));
		lblIconeSaida.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconeSaida.setBounds(150, 33, 80, 80);
		frame.getContentPane().add(lblIconeSaida);
		
		JLabel lblDesejaMesmoSair = new JLabel("Deseja mesmo sair?");
		lblDesejaMesmoSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesejaMesmoSair.setBounds(132, 124, 119, 14);
		frame.getContentPane().add(lblDesejaMesmoSair);
		
		JLabel lblConfirmar = new JLabel("");
		lblConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblConfirmar.setIcon(new ImageIcon(ConfirmSaida.class.getResource("/imagens/icons8-assessments-65.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblConfirmar.setIcon(new ImageIcon(ConfirmSaida.class.getResource("/imagens/icons8-assessments-60.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AreaCliente.getFrame().setVisible(false);
				frame.setVisible(false);
				UpNow.main(null);
			}
		});
		lblConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConfirmar.setIcon(new ImageIcon(ConfirmSaida.class.getResource("/imagens/icons8-assessments-60.png")));
		lblConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmar.setBounds(131, 170, 55, 55);
		frame.getContentPane().add(lblConfirmar);
		
		JLabel lblNegar = new JLabel("");
		lblNegar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNegar.setIcon(new ImageIcon(ConfirmSaida.class.getResource("/imagens/icons8-close-55.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNegar.setIcon(new ImageIcon(ConfirmSaida.class.getResource("/imagens/icons8-close-50.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AreaCliente.getFrame().setEnabled(true);
				AreaCliente.getFrame().setFocusable(true);
				frame.setVisible(false);
			}
		});
		lblNegar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNegar.setIcon(new ImageIcon(ConfirmSaida.class.getResource("/imagens/icons8-close-50.png")));
		lblNegar.setHorizontalAlignment(SwingConstants.CENTER);
		lblNegar.setBounds(196, 170, 55, 55);
		frame.getContentPane().add(lblNegar);
		frame.setFocusable(true);
	}
}
