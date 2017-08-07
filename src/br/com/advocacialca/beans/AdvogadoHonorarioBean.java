package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.Calendar;

	/**
	 * Classe de um honor�rio
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
	 *  M�todo para retorno de um honor�rio
	 *  @param cdHonorario C�digo do honor�rio
	 *  @return cdHonorario Retorna o honor�rio
	 */
	
	public int getCdHonorario() {
		return cdHonorario;
	}
	public void setCdHonorario(int cdHonorario) {
		this.cdHonorario = cdHonorario;
	}
	
	/**
	 *  M�todo para retorno da quantidade de horas
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
	 *  M�todo para retorno de uma observa��o
	 *  @param dsObservacao Descri��o da observa��o
	 *  @return dsObservacao Retorno da observa��o
	 */

	public String getDsObservacao() {
		return dsObservacao;
	}
	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}
	
	/**
	 *  M�todo para retorno de uma data de um honor�rio
	 *  @param dtHonorario Data do honor�rio
	 *  @return dtHonorario Retorna a data do honor�rio
	 */

	public Calendar getDtHonorario() {
		return dtHonorario;
	}
	public void setDtHonorario(Calendar dtHonorario) {
		this.dtHonorario = dtHonorario;
	}
	
	/**
	 *  M�todo para retorno de um processo
	 *  @param processo C�digo do processo
	 *  @return processo Retorna o processo
	 */

	public ProcessoBean getProcesso() {
		return processo;
	}
	public void setProcesso(ProcessoBean processo) {
		this.processo = processo;
	}
	
	/**
	 *  M�todo para retorno de um advogado
	 *  @param advogado C�digo do advogado
	 *  @return advogado Retorna o advogado
	 */

	public AdvogadoBean getAdvogado() {
		return advogado;
	}
	public void setAdvogado(AdvogadoBean advogado) {
		this.advogado = advogado;
	}
	
	/**
	 *  M�todo para retorno de um tarefa
	 *  @param tarefa C�digo da tarefa
	 *  @return tarefa Retorna a tarefa
	 */

	public TarefaBean getTarefa() {
		return tarefa;
	}
	public void setTarefa(TarefaBean tarefa) {
		this.tarefa = tarefa;
	}
}
