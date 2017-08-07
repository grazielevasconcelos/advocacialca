package br.com.advocacialca.beans;

import java.io.Serializable;
import java.sql.Date;

	/**
	 * Classe de itens de relat�rio de audi�ncia
	 * @author Pixel
	 */

public class ItemRelatorioAudiencias implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date dtAudiencia;
	private String nomeForum;
	private String endereco;
	private String sala;
	
	public ItemRelatorioAudiencias() { }

	
	/**
	 *  M�todo para retorno da data da Audi�ncia
	 *  @param dtAudiencia Data da audi�ncia
	 *  @return dtAudiencia Retorna a data da audi�ncia
	 */

	public Date getDtAudiencia() {
		return dtAudiencia;
	}

	public void setDtAudiencia(Date dtAudiencia) {
		this.dtAudiencia = dtAudiencia;
	}
	
	/**
	 *  M�todo para retorno do nome do F�rum
	 *  @param nomeForum Nome do F�rum
	 *  @return nomeForum Retorna o nome do F�rum 
	 */

	public String getNomeForum() {
		return nomeForum;
	}

	public void setNomeForum(String nomeForum) {
		this.nomeForum = nomeForum;
	}

	/**
	 *  M�todo para retorno de um endere�o
	 *  @param endereco Descri��o do endere�o
	 *  @return endereco Retorna o endere�o
	 */
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 *  M�todo para retorno de uma sala
	 *  @param sala N�mero da sala
	 *  @return sala Retorna a sala 
	 */

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
}
