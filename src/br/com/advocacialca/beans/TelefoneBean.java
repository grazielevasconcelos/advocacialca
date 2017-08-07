package br.com.advocacialca.beans;

import java.io.Serializable;

	/**
	 * Classe de um telefone
	 * @author Pixel
	 */

public class TelefoneBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long cdTelefone;
	private PessoaBean pessoa;
	private TipoTelefoneBean tipoTelefone;
	private int nrDDD;
	private int nrTelefone;


	/**
	 *  Método para retorno de um telefone
	 *  @param cdTelefone Código do telefone
	 *  @return cdTelefone Retorna o telefone
	 */
	
	public long getCdTelefone() {
		return cdTelefone;
	}
	public void setCdTelefone(long cdTelefone) {
		this.cdTelefone = cdTelefone;
	}
	
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
	 *  Método para retorno de um tipo de telefone
	 *  @param tipoTelefone Código do tipo de telefone
	 *  @return tipoTelefone Retorna o tipo de telefone
	 */
	
	public TipoTelefoneBean getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(TipoTelefoneBean tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	/**
	 *  Método para retorno de um número de DDD
	 *  @param nrDDD Número do DDD
	 *  @return nrDDD Retorna o número do DDD
	 */

	public int getNrDDD() {
		return nrDDD;
	}
	public void setNrDDD(int nrDDD) {
		this.nrDDD = nrDDD;
	}
	
	/**
	 *  Método para retorno de um número de telefone
	 *  @param nrTelefone Número do telefone
	 *  @return nrTelefone Retorna o número do telefone
	 */

	public int getNrTelefone() {
		return nrTelefone;
	}
	public void setNrTelefone(int nrTelefone) {
		this.nrTelefone = nrTelefone;
	}
}
