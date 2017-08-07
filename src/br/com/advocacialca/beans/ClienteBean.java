package br.com.advocacialca.beans;

import java.io.Serializable;

/**
 * Classe de um cliente
 * @author Pixel
 */

public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public ClienteBean() {
	}
	
	private PessoaBean pessoa;
	private String nmRazaoSocial;
	private long nrCNPJ;
	private long nrInscEstadual;
	private String dsEmail;
	private String dsPassword;
	
	/**
	 *  Método para retorno de uma pessoa
	 *  @param pessoa Código da Pessoa
	 *  @return pessoa Retorna a pessoa 
	 */
	
	public PessoaBean getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}
	
	/**
	 *  Método para retorno de uma Razão Social
	 *  @param nmRazaoSocial Descrição da Razão Social
	 *  @return nmRazaoSocial Retorna a Razão Social
	 */

	public String getNmRazaoSocial() {
		return nmRazaoSocial;
	}
	public void setNmRazaoSocial(String nmRazaoSocial) {
		this.nmRazaoSocial = nmRazaoSocial;
	}
	
	/**
	 *  Método para retorno de um CNPJ
	 *  @param nrCNPJ Número do CNPJ
	 *  @return nrCNPJ Retorna o CNPJ 
	 */

	public long getNrCNPJ() {
		return nrCNPJ;
	}
	public void setNrCNPJ(long nrCNPJ) {
		this.nrCNPJ = nrCNPJ;
	}
	
	/**
	 *  Método para retorno de uma Inscrição Estadual
	 *  @param nrInscEstadual Número da Insrição Estadual
	 *  @return nrInscEstadual Retorna a Inscrição Estudal
	 */

	public long getNrInscEstadual() {
		return nrInscEstadual;
	}
	public void setNrInscEstadual(long nrInscEstadual) {
		this.nrInscEstadual = nrInscEstadual;
	}
	
	/**
	 *  Método para retorno de um e-mail
	 *  @param dsEmail Descrição do e-mail
	 *  @return dsEmail Retorna o e-mail
	 */

	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	
	/**
	 *  Método para retorno de um senha
	 *  @param dsPassword Descrição da senha
	 *  @return dsPassword Retorna a senha
	 */

	public String getDsPassword() {
		return dsPassword;
	}
	public void setDsPassword(String dsPassword) {
		this.dsPassword = dsPassword;
	}
	
	
	
}
