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
	 *  Método para retorno de uma causa
	 *  @param cdCausa Código da causa
	 *  @return cdCausa Retorna a causa
	 */

	public int getCdCausa() {
		return cdCausa;
	}

	public void setCdCausa(int cdCausa) {
		this.cdCausa = cdCausa;
	}
	
	/**
	 *  Método para retorno de uma descrição
	 *  @param dsCausa Descrição da causa
	 *  @return dsCausa Retorna a descrição
	 */

	public String getDsCausa() {
		return dsCausa;
	}

	public void setDsCausa(String dsCausa) {
		this.dsCausa = dsCausa;
	}
	
}
