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
	 *  Método para retorno do código do bloqueio ou desbloqueio
	 *  @param cdBloqDescloq Código do bloqueio ou desbloqueio
	 *  @return cdBloqDesbloq Retorno do bloqueio ou desbloqueio
	 */

	public long getCdBloqDesbloq() {
		return cdBloqDesbloq;
	}
	public void setCdBloqDesbloq(long cdBloqDesbloq) {
		this.cdBloqDesbloq = cdBloqDesbloq;
	}
	
	/**
	 *  Método para retorno da descrição do bloqueio ou desbloqueio
	 *  @param dsBloqDesbloq Descrição do bloqueio ou desbloqueio 
	 *  @return dsBloqDesbloq Retorna a descrição
	 */
	
	public String getDsBloqDesbloq() {
		return dsBloqDesbloq;
	}
	public void setDsBloqDesbloq(String dsBloqDesbloq) {
		this.dsBloqDesbloq = dsBloqDesbloq;
	}
	
}
