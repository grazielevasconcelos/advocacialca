package br.com.advocacialca.beans;

import java.io.Serializable;
	
	/**
	 * Classe de um f�rum
	 * @author Pixel
	 */

public class ForumBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PessoaBean pessoa;
	private String dsForum;

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
	 *  M�todo para retorno de uma descri��o do F�rum
	 *  @param dsForum Descri��o do F�rum
	 *  @return dsForum Retorna a descri��o
	 */

	public String getDsForum() {
		return dsForum;
	}
	public void setDsForum(String dsForum) {
		this.dsForum = dsForum;
	}

}
