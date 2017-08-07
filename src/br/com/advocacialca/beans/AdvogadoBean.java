package br.com.advocacialca.beans;

import java.io.Serializable;

	/**
	 * Classe de um Advogado
	 * @author Pixel
	 */

public class AdvogadoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public AdvogadoBean() {	}
	
	
	private PessoaBean pessoa;
	private int nrOAB;
	private long nrCPF;
	private String nrRG; 
	private String dsEmail;
	private String dsPassword;
	
	/**
	 *  M�todo para retorno de uma Pessoa
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
	 *  M�todo para retorno do n�mero do OAB
	 *  @param nrOAB N�mero do OAB 
	 *  @return nrOAB Retorna o n�mero do OAB
	 */
		
	public int getNrOAB() {
		return nrOAB;
	}
	public void setNrOAB(int nrOAB) {
		this.nrOAB = nrOAB;
	}
	
	/**
	 *  M�todo para retorno do n�mero do CPF
	 *  @param nrCPF N�mero do CPF 
	 *  @return nrCPF Retorna o n�mero do CPF
	 */
	
	public long getNrCPF() {
		return nrCPF;
	}
	public void setNrCPF(long nrCPF) {
		this.nrCPF = nrCPF;
	}
	
	/**
	 *  M�todo para retorno do n�mero do RG
	 *  @param nrRG N�mero do RG
	 *  @return nrRG Retorna o n�mero do RG
	 */
	
	public String getNrRG() {
		return nrRG;
	}
	public void setNrRG(String nrRG) {
		this.nrRG = nrRG;
	}
	
	/**
	 *  M�todo para retorno da descri��o do e-mail
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
	 *  M�todo para retorno da senha
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


