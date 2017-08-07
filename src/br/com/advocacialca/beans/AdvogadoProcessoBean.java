package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.Calendar;

public class AdvogadoProcessoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public AdvogadoProcessoBean(){}
	
	private ProcessoBean processo;
	private AdvogadoBean advogado;
	private Calendar dtInicioParticipacao;

	public ProcessoBean getProcesso() {
		return processo;
	}
	public void setProcesso(ProcessoBean processo) {
		this.processo = processo;
	}
	public AdvogadoBean getAdvogado() {
		return advogado;
	}
	public void setAdvogado(AdvogadoBean advogado) {
		this.advogado = advogado;
	}
	public Calendar getDtInicioParticipacao() {
		return dtInicioParticipacao;
	}
	public void setDtInicioParticipacao(Calendar dtInicioParticipacao) {
		this.dtInicioParticipacao = dtInicioParticipacao;
	}
}