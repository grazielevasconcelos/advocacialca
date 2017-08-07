package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.Calendar;

	/**
	 * Classe de um honorário
	 * @author Pixel
	 */

public class AdvogadoHonorarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int cdHonorario;
	private ProcessoBean processo;
	private AdvogadoBean advogado;
	private TarefaBean tarefa;
	private Calendar dtHonorario;
	private int qtHoras;
	private String dsObservacao;
	
	/**
	 *  Método para retorno de um honorário
	 *  @param cdHonorario Código do honorário
	 *  @return cdHonorario Retorna o honorário
	 */
	
	public int getCdHonorario() {
		return cdHonorario;
	}
	public void setCdHonorario(int cdHonorario) {
		this.cdHonorario = cdHonorario;
	}
	
	/**
	 *  Método para retorno da quantidade de horas
	 *  @param qtHoras Quantidade de horas
	 *  @return qtHoras Retorna a quantidade de horas
	 */

	public int getQtHoras() {
		return qtHoras;
	}
	public void setQtHoras(int qtHoras) {
		this.qtHoras = qtHoras;
	}
	
	/**
	 *  Método para retorno de uma observação
	 *  @param dsObservacao Descrição da observação
	 *  @return dsObservacao Retorno da observação
	 */

	public String getDsObservacao() {
		return dsObservacao;
	}
	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}
	
	/**
	 *  Método para retorno de uma data de um honorário
	 *  @param dtHonorario Data do honorário
	 *  @return dtHonorario Retorna a data do honorário
	 */

	public Calendar getDtHonorario() {
		return dtHonorario;
	}
	public void setDtHonorario(Calendar dtHonorario) {
		this.dtHonorario = dtHonorario;
	}
	
	/**
	 *  Método para retorno de um processo
	 *  @param processo Código do processo
	 *  @return processo Retorna o processo
	 */

	public ProcessoBean getProcesso() {
		return processo;
	}
	public void setProcesso(ProcessoBean processo) {
		this.processo = processo;
	}
	
	/**
	 *  Método para retorno de um advogado
	 *  @param advogado Código do advogado
	 *  @return advogado Retorna o advogado
	 */

	public AdvogadoBean getAdvogado() {
		return advogado;
	}
	public void setAdvogado(AdvogadoBean advogado) {
		this.advogado = advogado;
	}
	
	/**
	 *  Método para retorno de um tarefa
	 *  @param tarefa Código da tarefa
	 *  @return tarefa Retorna a tarefa
	 */

	public TarefaBean getTarefa() {
		return tarefa;
	}
	public void setTarefa(TarefaBean tarefa) {
		this.tarefa = tarefa;
	}
}
