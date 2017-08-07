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
	 *  M�todo para retorno de um telefone
	 *  @param cdTelefone C�digo do telefone
	 *  @return cdTelefone Retorna o telefone
	 */
	
	public long getCdTelefone() {
		return cdTelefone;
	}
	public void setCdTelefone(long cdTelefone) {
		this.cdTelefone = cdTelefone;
	}
	
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
	 *  M�todo para retorno de um tipo de telefone
	 *  @param tipoTelefone C�digo do tipo de telefone
	 *  @return tipoTelefone Retorna o tipo de telefone
	 */
	
	public TipoTelefoneBean getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(TipoTelefoneBean tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	/**
	 *  M�todo para retorno de um n�mero de DDD
	 *  @param nrDDD N�mero do DDD
	 *  @return nrDDD Retorna o n�mero do DDD
	 */

	public int getNrDDD() {
		return nrDDD;
	}
	public void setNrDDD(int nrDDD) {
		this.nrDDD = nrDDD;
	}
	
	/**
	 *  M�todo para retorno de um n�mero de telefone
	 *  @param nrTelefone N�mero do telefone
	 *  @return nrTelefone Retorna o n�mero do telefone
	 */

	public int getNrTelefone() {
		return nrTelefone;
	}
	public void setNrTelefone(int nrTelefone) {
		this.nrTelefone = nrTelefone;
	}
}
