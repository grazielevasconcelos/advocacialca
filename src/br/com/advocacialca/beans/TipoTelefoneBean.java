package br.com.advocacialca.beans;

import java.io.Serializable;

	/**
	 * Classe de um Advogado
	 * @author Pixel
	 */

public class TipoTelefoneBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	public TipoTelefoneBean() {}
	
	private int cdTipoTelefone;
	private String dsTipoTelefone;
	
	/**
	 *  M�todo para retorno de um tipo de telefone
	 *  @param cdTipoTelefone C�digo do tipo de telefone
	 *  @return cdTipoTelefone Retorna o tipo de telefone
	 */
		
	public int getCdTipoTelefone() {
		return cdTipoTelefone;
	}
	public void setCdTipoTelefone(int cdTipoTelefone) {
		this.cdTipoTelefone = cdTipoTelefone;
	}
	
	/**
	 *  M�todo para retorno da descri��o
	 *  @param dsTipoTelefone Descri��o do tipo de telefone
	 *  @return dsTipoTelefone Retorna a descri��o
	 */
	
	public String getDsTipoTelefone() {
		return dsTipoTelefone;
	}
	public void setDsTipoTelefone(String dsTipoTelefone) {
		this.dsTipoTelefone = dsTipoTelefone;
	}
		
}
