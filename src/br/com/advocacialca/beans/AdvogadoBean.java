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
	 *  Método para retorno de uma Pessoa
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
	 *  Método para retorno do número do OAB
	 *  @param nrOAB Número do OAB 
	 *  @return nrOAB Retorna o número do OAB
	 */
		
	public int getNrOAB() {
		return nrOAB;
	}
	public void setNrOAB(int nrOAB) {
		this.nrOAB = nrOAB;
	}
	
	/**
	 *  Método para retorno do número do CPF
	 *  @param nrCPF Número do CPF 
	 *  @return nrCPF Retorna o número do CPF
	 */
	
	public long getNrCPF() {
		return nrCPF;
	}
	public void setNrCPF(long nrCPF) {
		this.nrCPF = nrCPF;
	}
	
	/**
	 *  Método para retorno do número do RG
	 *  @param nrRG Número do RG
	 *  @return nrRG Retorna o número do RG
	 */
	
	public String getNrRG() {
		return nrRG;
	}
	public void setNrRG(String nrRG) {
		this.nrRG = nrRG;
	}
	
	/**
	 *  Método para retorno da descrição do e-mail
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
	 *  Método para retorno da senha
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


