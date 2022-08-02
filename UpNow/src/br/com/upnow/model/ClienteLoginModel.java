package br.com.upnow.model;

public class ClienteLoginModel {

	private static String nome;
	
	public ClienteLoginModel() {
	}
	
	public static String getNome() {
		return nome;
	}

	public static void setNome(String email) {
		ClienteLoginModel.nome = email;
	}

}
