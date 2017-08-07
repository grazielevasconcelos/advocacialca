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
	 *  Método para retorno de uma agenda
	 *  @param cdAgenda Código da agenda
	 *  @return cdAgenda Retorna a agenda
	 */
    
	public int getCdAgenda() {
		return cdAgenda;
	}
	public void setCdAgenda(int cdAgenda) {
		this.cdAgenda = cdAgenda;
	}
	
	/**
	 *  Método para retorno de um advogado
	 *  @param cdPessoaAdv Código do advogado
	 *  @return cdPessoaAdv Retorna o advogado
	 */
	public int getCdPessoaAdv() {
		return cdPessoaAdv;
	}
	public void setCdPessoaAdv(int cdPessoaAdv) {
		this.cdPessoaAdv = cdPessoaAdv;
	}
	
	/**
	 *  Método para retorno de uma data/hora da agenda
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
	 *  Método para retorno de uma sala do Fórum
	 *  @param slForum Número da sala
	 *  @return SlForum Retorna a sala do Fórum
	 */
	
	public char getSlForum() {
		return slForum;
	}
	public void setSlForum(char slForum) {
		this.slForum = slForum;
	}
	
	/**
	 *  Método para retorno de um processo
	 *  @param numProcesso Código do processo
	 *  @return numProcesso Retorna o código do processo
	 */
	
	public ProcessoBean getNumProcesso() {
		return numProcesso;
	}
	public void setNumProcesso(ProcessoBean numProcesso) {
		this.numProcesso = numProcesso;
	}
	
    
}
