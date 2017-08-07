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
	 *  Método para retorno de um tipo de telefone
	 *  @param cdTipoTelefone Código do tipo de telefone
	 *  @return cdTipoTelefone Retorna o tipo de telefone
	 */
		
	public int getCdTipoTelefone() {
		return cdTipoTelefone;
	}
	public void setCdTipoTelefone(int cdTipoTelefone) {
		this.cdTipoTelefone = cdTipoTelefone;
	}
	
	/**
	 *  Método para retorno da descrição
	 *  @param dsTipoTelefone Descrição do tipo de telefone
	 *  @return dsTipoTelefone Retorna a descrição
	 */
	
	public String getDsTipoTelefone() {
		return dsTipoTelefone;
	}
	public void setDsTipoTelefone(String dsTipoTelefone) {
		this.dsTipoTelefone = dsTipoTelefone;
	}
		
}
