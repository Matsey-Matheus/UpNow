package br.com.upnow.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	public Connection connect() {
		try {
			return DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_a4530a70e132ef3","b29eb273f96432","f7ed6dc1");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			JOptionPane.showMessageDialog(null, "Erro de conexão!");
			throw new RuntimeException(e);
		}
	}

}
