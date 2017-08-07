package br.com.advocacialca.beans;

import java.io.Serializable;
	
	/**
	 * Classe de um tipo de cobran�a
	 * @author Pixel
	 */

public class TipoCobrancaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public TipoCobrancaBean(){
	}
	
	private int cdCobranca;
	private String dsCobranca;
	private double txJuros;
	private double vlMoraDiaria;
	
	
	/**
	 *  M�todo para retorno de um tipo de cobran�a
	 *  @param cdCobranaa C�digo do tipo de cobran�a
	 *  @return cdCobranca Retorna o tipo de cobran�a
	 */
	
	public int getCdCobranca() {
		return cdCobranca;
	}
	public void setCdCobranca(int cdCobranca) {
		this.cdCobranca = cdCobranca;
	}
	
	/**
	 *  M�todo para retorno da descri��o
	 *  @param dsCobran�a descri��o do tipo da cobran�a
	 *  @return dsCobran�a Retorna a descri��o
	 */
	
	public String getDsCobranca() {
		return dsCobranca;
	}
	public void setDsCobranca(String dsCobranca) {
		this.dsCobranca = dsCobranca;
	}
	
	/**
	 *  M�todo para retorno da taxa de juros
	 *  @param txJuros Valor do juros
	 *  @return txJuros Retorna a taxa de juros
	 */
	
	public double getTxJuros() {
		return txJuros;
	}
	public void setTxJuros(double txJuros) {
		this.txJuros = txJuros;
	}
	
	/**
	 *  M�todo para retorno do valor da mora di�ria
	 *  @param vlMoraDiaria Valor da mora di�ria
	 *  @return vlMoraDiaria Retorna o valor da mora di�ria
	 */
	
	public double getVlMoraDiaria() {
		return vlMoraDiaria;
	}
	public void setVlMoraDiaria(double vlMoraDiaria) {
		this.vlMoraDiaria = vlMoraDiaria;
	}

	
}
