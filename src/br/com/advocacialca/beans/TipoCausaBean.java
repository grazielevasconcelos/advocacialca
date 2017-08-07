package br.com.advocacialca.beans;

import java.io.Serializable;

	/**
	 * Classe de um Advogado
	 * @author Pixel
	 */

public class TipoCausaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int cdCausa;
	private String dsCausa;
	
	public TipoCausaBean (){}

	/**
	 *  M�todo para retorno de uma causa
	 *  @param cdCausa C�digo da causa
	 *  @return cdCausa Retorna a causa
	 */

	public int getCdCausa() {
		return cdCausa;
	}

	public void setCdCausa(int cdCausa) {
		this.cdCausa = cdCausa;
	}
	
	/**
	 *  M�todo para retorno de uma descri��o
	 *  @param dsCausa Descri��o da causa
	 *  @return dsCausa Retorna a descri��o
	 */

	public String getDsCausa() {
		return dsCausa;
	}

	public void setDsCausa(String dsCausa) {
		this.dsCausa = dsCausa;
	}
	
}
