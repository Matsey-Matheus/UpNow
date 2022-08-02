package br.com.upnow.controller;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.upnow.dao.ClienteDAO;
import br.com.upnow.factory.ConnectionFactory;
import br.com.upnow.model.ClienteModel;

public class ClienteController {
	
	private ClienteDAO clienteDAO;

	public ClienteController() {
		Connection connection = new ConnectionFactory().connect();
		this.clienteDAO = new ClienteDAO(connection);
	}
	
	public void insert(ClienteModel cliente) throws SQLException {
		this.clienteDAO.insert(cliente);
	}
	
	public String selectCpfExistente(String cpf) throws SQLException {
		return this.clienteDAO.selectCpfExistente(cpf);
	}
	
	public String selectEmail(String email) throws SQLException {
		return this.clienteDAO.selectEmail(email);
	}
	
	public ClienteModel selectInfosLogin(String email, String senha) {
		return this.clienteDAO.selectInfosLogin(email, senha);		
	}
	
	public String selectNome(String email) throws SQLException {
		return this.clienteDAO.selectNome(email);		
	}

}
