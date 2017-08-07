package br.com.advocacialca.beans;

import java.io.Serializable;

	/**
	 * Classe de bloqueio e desbloqueio
	 * @author Pixel
	 */

public class BloqueioDesbloqueioBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public BloqueioDesbloqueioBean (){}
	
	private long cdBloqDesbloq;
	private String dsBloqDesbloq;
	
	/**
	 *  M�todo para retorno do c�digo do bloqueio ou desbloqueio
	 *  @param cdBloqDescloq C�digo do bloqueio ou desbloqueio
	 *  @return cdBloqDesbloq Retorno do bloqueio ou desbloqueio
	 */

	public long getCdBloqDesbloq() {
		return cdBloqDesbloq;
	}
	public void setCdBloqDesbloq(long cdBloqDesbloq) {
		this.cdBloqDesbloq = cdBloqDesbloq;
	}
	
	/**
	 *  M�todo para retorno da descri��o do bloqueio ou desbloqueio
	 *  @param dsBloqDesbloq Descri��o do bloqueio ou desbloqueio 
	 *  @return dsBloqDesbloq Retorna a descri��o
	 */
	
	public String getDsBloqDesbloq() {
		return dsBloqDesbloq;
	}
	public void setDsBloqDesbloq(String dsBloqDesbloq) {
		this.dsBloqDesbloq = dsBloqDesbloq;
	}
	
}
