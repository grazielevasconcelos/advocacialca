package br.com.advocacialca.beans;

import java.io.Serializable;
	
	/**
	 * Classe de um fórum
	 * @author Pixel
	 */

public class ForumBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PessoaBean pessoa;
	private String dsForum;

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
	 *  Método para retorno de uma descrição do Fórum
	 *  @param dsForum Descrição do Fórum
	 *  @return dsForum Retorna a descrição
	 */

	public String getDsForum() {
		return dsForum;
	}
	public void setDsForum(String dsForum) {
		this.dsForum = dsForum;
	}

}
