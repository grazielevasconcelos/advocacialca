package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.Calendar;


	/**
	 * Classe de um processo
	 * @author Pixel
	 */

public class ProcessoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int nrProcesso;
	private ForumBean forum;
	private ClienteBean cliente;
	private TipoCausaBean tipoCausa;
	private TipoCobrancaBean tipoCobranca;
	private String dsProcesso;
	private Calendar dtAbertura;
	private Calendar dtFechamento;
	private int ddDiaVencimento;
	private int cdResultado;
	private String dsObservacao;

	public ProcessoBean() {}

	/**
	 *  M�todo para retorno do n�mero do processo
	 *  @param nrProcesso C�digo da processo
	 *  @return nrProcesso Retorna o processo
	 */
	
	public int getNrProcesso() {
		return nrProcesso;
	}

	public void setNrProcesso(int nrProcesso) {
		this.nrProcesso = nrProcesso;
	}
	
	/**
	 *  M�todo para retorno de um F�rum
	 *  @param forum C�digo do F�rum
	 *  @return forum Retorna o F�rum 
	 */

	public ForumBean getForum() {
		return forum;
	}
	
	public void setForum(ForumBean forum) {
		this.forum = forum;
	}
	
	/**
	 *  M�todo para retorno de um cliente
	 *  @param clinte C�digo do cliente
	 *  @return cliente Retorna o cliente
	 */

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

	/**
	 *  M�todo para retorno de um tipo de causa
	 *  @param tipoCausa C�digo do tipo de causa
	 *  @return tipoCausa Retorna o tipo de causa
	 */

	public TipoCausaBean getTipoCausa() {
		return tipoCausa;
	}

	public void setTipoCausa(TipoCausaBean tipoCausa) {
		this.tipoCausa = tipoCausa;
	}
	
	/**
	 *  M�todo para retorno de um tipo de cobran�a
	 *  @param tipoCobran�a C�digo do tipo de cobran�a
	 *  @return tipoCobran�a Retorna o tipo de cobran�a
	 */


	public TipoCobrancaBean getTipoCobranca() {
		return tipoCobranca;
	}

	public void setTipoCobranca(TipoCobrancaBean tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}
	
	/**
	 *  M�todo para retorno da descri��o do processo
	 *  @param deProcesso Descri��o do processo
	 *  @return dsProcesso Retorna a descri��o do processo
	 */

	public String getDsProcesso() {
		return dsProcesso;
	}

	public void setDsProcesso(String dsProcesso) {
		this.dsProcesso = dsProcesso;
	}

	/**
	 *  M�todo para retorno da data de abertura
	 *  @param dtAbertura Data de abertura
	 *  @return dtAbertura Retorna a data de abertura 
	 */
	
	public Calendar getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Calendar dtAbertura) {
		this.dtAbertura = dtAbertura;
	}
	
	/**
	 *  M�todo para retorno da data de fechamento
	 *  @param dtFechamento Data do fechamento
	 *  @return dtFechamento Retorna a data do fechamento
	 */


	public Calendar getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(Calendar dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	/**
	 *  M�todo para retorno do dia do vencimento do t�tulo
	 *  @param ddDiaVencimento Data do vencimento
	 *  @return ddDiaVencimento Retorna a data do vencimento do t�tulo
	 */
	
	public int getDdDiaVencimento() {
		return ddDiaVencimento;
	}

	public void setDdDiaVencimento(int ddDiaVencimento) {
		this.ddDiaVencimento = ddDiaVencimento;
	}
	
	/**
	 *  M�todo para retorno do resultado
	 *  @param cdResultado C�digo do resultado
	 *  @return cdResultado Retorna o resultado
	 */


	public int getCdResultado() {
		return cdResultado;
	}

	public void setCdResultado(int cdResultado) {
		this.cdResultado = cdResultado;
	}
	
	/**
	 *  M�todo para retorno da descri��o
	 *  @param dsObservacao Descri��o da observa��o
	 *  @return dsObservacao Retorna a observa��o
	 */


	public String getDsObservacao() {
		return dsObservacao;
	}

	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}
	
}
