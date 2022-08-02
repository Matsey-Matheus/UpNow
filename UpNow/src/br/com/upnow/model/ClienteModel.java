package br.com.upnow.model;

public class ClienteModel {
	
	private int cdCliente; 
	private String dsEmailCliente, nmCliente , nrCpfCliente, nrRgCliente, dsSenha;
	
	public ClienteModel() {
	}
	
	public int getCdCliente() {
		return cdCliente;
	}
	public void setCdCliente(int cdCliente) {
		this.cdCliente = cdCliente;
	}
	public String getDsEmailCliente() {
		return dsEmailCliente;
	}
	public void setDsEmailCliente(String dsEmailCliente) {
		this.dsEmailCliente = dsEmailCliente;
	}
	public String getNmCliente() {
		return nmCliente;
	}
	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}
	public String getNrCpfCliente() {
		return nrCpfCliente;
	}
	public void setNrCpfCliente(String nrCpfCliente) {
		this.nrCpfCliente = nrCpfCliente;
	}
	public String getNrRgCliente() {
		return nrRgCliente;
	}
	public void setNrRgCliente(String nrRgCliente) {
		this.nrRgCliente = nrRgCliente;
	}
	public String getDsSenha() {
		return dsSenha;
	}
	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

}
