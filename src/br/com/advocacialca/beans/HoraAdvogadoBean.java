package br.com.advocacialca.beans;

import java.io.Serializable;
import java.sql.Date;


	/**
	 * Classe que insere o valor hora de um advogado
	 * @author Pixel
	 */

public class HoraAdvogadoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public HoraAdvogadoBean() {
	}
	
	private int cdHistorico;
	private PessoaBean advogado;
	private Date dtVigente;
	private double vlHora;

	/**
	 *  M�todo para retorno do hist�rico
	 *  @param cdHistorico C�digo do hist�rico
	 *  @return cdHIstorico Retorna o hist�rico
	 */

	public int getCdHistorico() {
		return cdHistorico;
	}
	public void setCdHistorico(int cdHistorico) {
		this.cdHistorico = cdHistorico;
	}
	
	/**
	 *  M�todo para retorno de um advogado
	 *  @param advogado C�digo do advogado
	 *  @return advogado Retorna o advogado
	 */

	public PessoaBean getAdvogado() {
		return advogado;
	}
	public void setAdvogado(PessoaBean advogado) {
		this.advogado = advogado;
	}
	
	/**
	 *  M�todo para retorno da data vigente
	 *  @param dtVigente Data
	 *  @return dtVigente Retorna a data vigente
	 */

	public Date getDtVigente() {
		return dtVigente;
	}
	public void setDtVigente(Date dtVigente) {
		this.dtVigente = dtVigente;
	}
	
	/**
	 *  M�todo para retorno do valor hora cobrado pelo advogado
	 *  @param vlHora Valor da hora cobrada
	 *  @return vlHora Retorna o valor da hora cobrado pela advogado
	 */

	public double getVlHora() {
		return vlHora;
	}
	public void setVlHora(double vlHora) {
		this.vlHora = vlHora;
	}
	
	
}
