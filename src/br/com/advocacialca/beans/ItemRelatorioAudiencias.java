package br.com.advocacialca.beans;

import java.io.Serializable;
import java.sql.Date;

	/**
	 * Classe de itens de relatório de audiência
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
	 *  Método para retorno da data da Audiência
	 *  @param dtAudiencia Data da audiência
	 *  @return dtAudiencia Retorna a data da audiência
	 */

	public Date getDtAudiencia() {
		return dtAudiencia;
	}

	public void setDtAudiencia(Date dtAudiencia) {
		this.dtAudiencia = dtAudiencia;
	}
	
	/**
	 *  Método para retorno do nome do Fórum
	 *  @param nomeForum Nome do Fórum
	 *  @return nomeForum Retorna o nome do Fórum 
	 */

	public String getNomeForum() {
		return nomeForum;
	}

	public void setNomeForum(String nomeForum) {
		this.nomeForum = nomeForum;
	}

	/**
	 *  Método para retorno de um endereço
	 *  @param endereco Descrição do endereço
	 *  @return endereco Retorna o endereço
	 */
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 *  Método para retorno de uma sala
	 *  @param sala Número da sala
	 *  @return sala Retorna a sala 
	 */

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
}
