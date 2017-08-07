package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.Calendar;

	/**
	 * Classe de um t�tulo
	 * @author Pixel
	 */

public class TituloBean implements Serializable {

	private static final long serialVersionUID = 1L;

    private int nrTitulo;
    private ProcessoBean processo;
    private int nrAgenciaCedente;
    private Calendar dtDocumento;
    private Calendar dtVencimento;
    private float vlDocumento;	
	private double total;
    
	public TituloBean() {}

	/**
	 *  M�todo para retorno de um t�tulo
	 *  @param nrTitulo N�mero do t�tulo
	 *  @return nrTitulo Retorna o t�tulo 
	 */

	public int getNrTitulo() {
		return nrTitulo;
	}

	public void setNrTitulo(int nrTitulo) {
		this.nrTitulo = nrTitulo;
	}

	/**
	 *  M�todo para retorno de um processo
	 *  @param processo C�digo da processo
	 *  @return processo Retorna a processp
	 */

	public ProcessoBean getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoBean processo) {
		this.processo = processo;
	}
	
	/**
	 *  M�todo para retorno a ag�ncia cedente
	 *  @param nrAgenciaCedente N�mero da ag�ncia cedente
	 *  @return nrAgenciaCedente Retorna a ag�ncia cedente
	 */

	public int getNrAgenciaCedente() {
		return nrAgenciaCedente;
	}

	public void setNrAgenciaCedente(int nrAgenciaCedente) {
		this.nrAgenciaCedente = nrAgenciaCedente;
	}
	
	/**
	 *  M�todo para retorno da data do documento
	 *  @param dtDocumento Data do documento
	 *  @return dtDocumento Retorna a data 
	 */

	public Calendar getDtDocumento() {
		return dtDocumento;
	}

	public void setDtDocumento(Calendar dtDocumento) {
		this.dtDocumento = dtDocumento;
	}

	/**
	 *  M�todo para retorno da data de vencimento
	 *  @param dtVencimento Data de vencimento
	 *  @return dtVencimento Retorna a data de vencimento
	 */
	
	public Calendar getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Calendar dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	/**
	 *  M�todo para retorno do valor do documento
	 *  @param vlDocumento Valor do documento
	 *  @return vlDocumento Retorna o valor do documento
	 */

	
	public float getVlDocumento() {
		return vlDocumento;
	}

	public void setVlDocumento(float vlDocumento) {
		this.vlDocumento = vlDocumento;
	}
	
	/**
	 *  M�todo para retorno do valor total
	 *  @param total Valor total
	 *  @return total Retorna o valor total
	 */

	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
