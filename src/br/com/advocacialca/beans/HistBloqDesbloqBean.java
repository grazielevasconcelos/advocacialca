package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.Calendar;
	
	/**
	 * Classe do histórico de bloqueio de desbloqueio
	 * @author Pixel
	 */

public class HistBloqDesbloqBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public HistBloqDesbloqBean() {
	}
	
	private ProcessoBean processo;
	private Calendar dtBloqueioDesbloq;
	private BloqueioDesbloqueioBean bloqueioDesbloq;

	
	/**
	 *  Método para retorno de um processo
	 *  @param processo Código do proceso
	 *  @return processo Retorna o processo 
	 */

	public ProcessoBean getProcesso() {
		return processo;
	}
	public void setProcesso(ProcessoBean processo) {
		this.processo = processo;
	}
	
	/**
	 *  Método para retorno da data do bloqueio ou desbloqueio
	 *  @param dtBloqueioDesbloq Data
	 *  @return dtBloqueioDesbloq Retorna a da do bloqueio ou desbloqueio
	 */
	
	public Calendar getDtBloqueioDesbloq() {
		return dtBloqueioDesbloq;
	}
	public void setDtBloqueioDesbloq(Calendar dtBloqueioDesbloq) {
		this.dtBloqueioDesbloq = dtBloqueioDesbloq;
	}
	
	/**
	 *  Método para retorno do bloqueio ou desbloqueio
	 *  @param bloqueioDesbloq Código do bloqueio ou desbloqueio
	 *  @return pessoa Retorna o bloqueio ou desbloqueio
	 */

	public BloqueioDesbloqueioBean getBloqueioDesbloq() {
		return bloqueioDesbloq;
	}
	public void setBloqueioDesbloq(BloqueioDesbloqueioBean bloqueioDesbloq) {
		this.bloqueioDesbloq = bloqueioDesbloq;
	}
	
	
	
}
