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
	 *  M�todo para retorno de uma pessoa
	 *  @param pessoa C�digo da Pessoa
	 *  @return pessoa Retorna a pessoa 
	 */
	
	public PessoaBean getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}
	
	/**
	 *  M�todo para retorno de uma Raz�o Social
	 *  @param nmRazaoSocial Descri��o da Raz�o Social
	 *  @return nmRazaoSocial Retorna a Raz�o Social
	 */

	public String getNmRazaoSocial() {
		return nmRazaoSocial;
	}
	public void setNmRazaoSocial(String nmRazaoSocial) {
		this.nmRazaoSocial = nmRazaoSocial;
	}
	
	/**
	 *  M�todo para retorno de um CNPJ
	 *  @param nrCNPJ N�mero do CNPJ
	 *  @return nrCNPJ Retorna o CNPJ 
	 */

	public long getNrCNPJ() {
		return nrCNPJ;
	}
	public void setNrCNPJ(long nrCNPJ) {
		this.nrCNPJ = nrCNPJ;
	}
	
	/**
	 *  M�todo para retorno de uma Inscri��o Estadual
	 *  @param nrInscEstadual N�mero da Insri��o Estadual
	 *  @return nrInscEstadual Retorna a Inscri��o Estudal
	 */

	public long getNrInscEstadual() {
		return nrInscEstadual;
	}
	public void setNrInscEstadual(long nrInscEstadual) {
		this.nrInscEstadual = nrInscEstadual;
	}
	
	/**
	 *  M�todo para retorno de um e-mail
	 *  @param dsEmail Descri��o do e-mail
	 *  @return dsEmail Retorna o e-mail
	 */

	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	
	/**
	 *  M�todo para retorno de um senha
	 *  @param dsPassword Descri��o da senha
	 *  @return dsPassword Retorna a senha
	 */

	public String getDsPassword() {
		return dsPassword;
	}
	public void setDsPassword(String dsPassword) {
		this.dsPassword = dsPassword;
	}
	
	
	
}
