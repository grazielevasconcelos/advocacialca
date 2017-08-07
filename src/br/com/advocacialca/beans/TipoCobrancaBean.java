package br.com.advocacialca.beans;

import java.io.Serializable;
	
	/**
	 * Classe de um tipo de cobrança
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
	 *  Método para retorno de um tipo de cobrança
	 *  @param cdCobranaa Código do tipo de cobrança
	 *  @return cdCobranca Retorna o tipo de cobrança
	 */
	
	public int getCdCobranca() {
		return cdCobranca;
	}
	public void setCdCobranca(int cdCobranca) {
		this.cdCobranca = cdCobranca;
	}
	
	/**
	 *  Método para retorno da descrição
	 *  @param dsCobrança descrição do tipo da cobrança
	 *  @return dsCobrança Retorna a descrição
	 */
	
	public String getDsCobranca() {
		return dsCobranca;
	}
	public void setDsCobranca(String dsCobranca) {
		this.dsCobranca = dsCobranca;
	}
	
	/**
	 *  Método para retorno da taxa de juros
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
	 *  Método para retorno do valor da mora diária
	 *  @param vlMoraDiaria Valor da mora diária
	 *  @return vlMoraDiaria Retorna o valor da mora diária
	 */
	
	public double getVlMoraDiaria() {
		return vlMoraDiaria;
	}
	public void setVlMoraDiaria(double vlMoraDiaria) {
		this.vlMoraDiaria = vlMoraDiaria;
	}

	
}
