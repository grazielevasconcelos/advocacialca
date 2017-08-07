package br.com.advocacialca.beans;

import java.io.Serializable;
import java.sql.Date;
	
	/**
	 * Classe de itens de relatório de honorário
	 * @author Pixel
	 */

public class ItemRelatorioHonorarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date dtTarefa;
	private String nomeAdvogado;
	private Float valorTarefa;
	
	public ItemRelatorioHonorarios() { }

	/**
	 *  Método para retorno da data de uma tarefa	
	 *  @param dtTarefa Data da tarefa
	 *  @return dtTarefa Retorna a data da tarefa
	 */
	
	public Date getDtTarefa() {
		return dtTarefa;
	}

	public void setDtTarefa(Date dtTarefa) {
		this.dtTarefa = dtTarefa;
	}

	/**
	 *  Método para retorno do nome do advogado
	 *  @param nomeAdvogado Nome do advogado
	 *  @return nomeAdvogado Retorna o nome do advogado
	 */
	
	public String getNomeAdvogado() {
		return nomeAdvogado;
	}

	public void setNomeAdvogado(String nomeAdvogado) {
		this.nomeAdvogado = nomeAdvogado;
	}

	/**
	 *  Método para retorno do valor de uma tarefa
	 *  @param valorTarefa Valor da tarefa
	 *  @return valorTarefa Retorna o valor da tarefa
	 */
	
	public Float getValorTarefa() {
		return valorTarefa;
	}

	public void setValorTarefa(Float valorTarefa) {
		this.valorTarefa = valorTarefa;
	}
}
