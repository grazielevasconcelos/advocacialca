package br.com.advocacialca.beans;

import java.io.Serializable;

	/**
	 * Classe de uma pessoa
	 * @author Pixel
	 */

public class PessoaBean implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	public PessoaBean() {}
		
	private int cdPessoa;
	private String nmPessoa;

	/**
	 *  Método para retorno de uma pessoa
	 *  @param pessoa Código da pessoa
	 *  @return pessoa Retorna a pessoa 
	 */
	
	public int getCdPessoa() {
		return cdPessoa;
	}
	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}
	
	/**
	 *  Método para retorno do noem de uma pessoa
	 *  @param nmPessoa Nome da pessoa
	 *  @return nmPessoa Retorna o nome da pessoa 
	 */

	public String getNmPessoa() {
		return nmPessoa;
	}
	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}
	
}
