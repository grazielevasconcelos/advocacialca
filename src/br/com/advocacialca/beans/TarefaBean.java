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
	 *  Método para retorno de uma tarefa
	 *  @param cdTarefa Código da tarefa
	 *  @return cdTarefa Retorna a tarefa
	 */
	
	public int getCdTarefa() {
		return cdTarefa;
	}
	public void setCdTarefa(int cdTarefa) {
		this.cdTarefa = cdTarefa;
	}
	
	/**
	 *  Método para retorno de uma descrição de tarefa
	 *  @param dsTarefa Descrição da tarefa
	 *  @return dsTarefa Retorna a descrição da tarefa
	 */

	public String getDsTarefa() {
		return dsTarefa;
	}
	public void setDsTarefa(String dsTarefa) {
		this.dsTarefa = dsTarefa;
	}

}