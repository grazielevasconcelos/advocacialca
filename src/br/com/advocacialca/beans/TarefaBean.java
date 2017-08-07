package br.com.advocacialca.beans;

import java.io.Serializable;

	/**
	 * Classe de uma tarefa
	 * @author Pixel
	 */

public class TarefaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int cdTarefa;
	private String dsTarefa;
	
	/**
	 *  M�todo para retorno de uma tarefa
	 *  @param cdTarefa C�digo da tarefa
	 *  @return cdTarefa Retorna a tarefa
	 */
	
	public int getCdTarefa() {
		return cdTarefa;
	}
	public void setCdTarefa(int cdTarefa) {
		this.cdTarefa = cdTarefa;
	}
	
	/**
	 *  M�todo para retorno de uma descri��o de tarefa
	 *  @param dsTarefa Descri��o da tarefa
	 *  @return dsTarefa Retorna a descri��o da tarefa
	 */

	public String getDsTarefa() {
		return dsTarefa;
	}
	public void setDsTarefa(String dsTarefa) {
		this.dsTarefa = dsTarefa;
	}

}