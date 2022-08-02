package br.com.upnow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.upnow.model.ClienteModel;

public class ClienteDAO {

	private Connection conexao;

	public ClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void insert(ClienteModel cliente) throws SQLException {

		String sql = "INSERT INTO `heroku_a4530a70e132ef3`.`t_cliente` (`ds_email_cliente`, `nm_cliente`, `nr_cpf_cliente`, `nr_rg_cliente`, `ds_senha`) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, cliente.getDsEmailCliente());
		stmt.setString(2, cliente.getNmCliente());
		stmt.setString(3, cliente.getNrCpfCliente());
		stmt.setString(4, cliente.getNrRgCliente());
		stmt.setString(5, cliente.getDsSenha());

		stmt.execute();

		stmt.close();

	}

	public String selectCpfExistente(String cpf) throws SQLException {
		ClienteModel cliente = null;
		String sql = "SELECT c.nr_cpf_cliente\r\n" + "FROM t_cliente c\r\n" + "WHERE nr_cpf_cliente = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, cpf);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			cliente = new ClienteModel();
			cliente.setNrCpfCliente(rs.getString(1));
			return cliente.getNrCpfCliente();
		}

		rs.close();
		stmt.close();
		return null;
	}

	public String selectEmail(String email) throws SQLException {
		ClienteModel cliente = null;
		String sql = "SELECT ds_email_cliente from t_cliente where ds_email_cliente = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, email);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			cliente = new ClienteModel();
			cliente.setDsEmailCliente(rs.getString(1));
			return cliente.getDsEmailCliente();

		}

		rs.close();
		stmt.close();
		return null;
	}

	public ClienteModel selectInfosLogin(String email, String senha) {
		try {
			
			ClienteModel cliente = null;
			String sql = "SELECT c.ds_email_cliente, c.ds_senha from t_cliente c where ds_email_cliente = ? and ds_senha = ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, email);

			stmt.setString(2, senha);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				cliente = new ClienteModel();
				cliente.setDsEmailCliente(rs.getString(1));
				cliente.setDsSenha(rs.getString(2));

			}

			rs.close();
			stmt.close();
			return cliente;

		} catch (SQLException e) {
			System.out.println("disparou aqui");
			e.printStackTrace();
		}
		return null;

	}
	
	public String selectNome(String email) throws SQLException {
		ClienteModel cliente = null;
		String sql = "SELECT nm_cliente FROM t_cliente WHERE ds_email_cliente = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, email);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			cliente = new ClienteModel();
			cliente.setNmCliente(rs.getString(1));
			return cliente.getNmCliente();

		}

		rs.close();
		stmt.close();
		return null;
	}

}
