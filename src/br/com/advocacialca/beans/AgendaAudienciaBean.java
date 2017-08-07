package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe de uma agenda
 * @author Pixel
 */

public class AgendaAudienciaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public AgendaAudienciaBean(){}
	
	private int cdAgenda;
    private ProcessoBean numProcesso;
    private int cdPessoaAdv;
    private Calendar dtHoraAgenda;
    private char slForum;
    
    
	/**
	 *  M�todo para retorno de uma agenda
	 *  @param cdAgenda C�digo da agenda
	 *  @return cdAgenda Retorna a agenda
	 */
    
	public int getCdAgenda() {
		return cdAgenda;
	}
	public void setCdAgenda(int cdAgenda) {
		this.cdAgenda = cdAgenda;
	}
	
	/**
	 *  M�todo para retorno de um advogado
	 *  @param cdPessoaAdv C�digo do advogado
	 *  @return cdPessoaAdv Retorna o advogado
	 */
	public int getCdPessoaAdv() {
		return cdPessoaAdv;
	}
	public void setCdPessoaAdv(int cdPessoaAdv) {
		this.cdPessoaAdv = cdPessoaAdv;
	}
	
	/**
	 *  M�todo para retorno de uma data/hora da agenda
	 *  @param dtHoraAgenda Data
	 *  @return dtHoraAgenda Retorna a data/hora da agenda
	 */
	
	public Calendar getDtHoraAgenda() {
		return dtHoraAgenda;
	}
	public void setDtHoraAgenda(Calendar dtHoraAgenda) {
		this.dtHoraAgenda = dtHoraAgenda;
	}
	
	/**
	 *  M�todo para retorno de uma sala do F�rum
	 *  @param slForum N�mero da sala
	 *  @return SlForum Retorna a sala do F�rum
	 */
	
	public char getSlForum() {
		return slForum;
	}
	public void setSlForum(char slForum) {
		this.slForum = slForum;
	}
	
	/**
	 *  M�todo para retorno de um processo
	 *  @param numProcesso C�digo do processo
	 *  @return numProcesso Retorna o c�digo do processo
	 */
	
	public ProcessoBean getNumProcesso() {
		return numProcesso;
	}
	public void setNumProcesso(ProcessoBean numProcesso) {
		this.numProcesso = numProcesso;
	}
	
    
}
