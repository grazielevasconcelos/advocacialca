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
	 *  Método para retorno do número do processo
	 *  @param nrProcesso Código da processo
	 *  @return nrProcesso Retorna o processo
	 */
	
	public int getNrProcesso() {
		return nrProcesso;
	}

	public void setNrProcesso(int nrProcesso) {
		this.nrProcesso = nrProcesso;
	}
	
	/**
	 *  Método para retorno de um Fórum
	 *  @param forum Código do Fórum
	 *  @return forum Retorna o Fórum 
	 */

	public ForumBean getForum() {
		return forum;
	}
	
	public void setForum(ForumBean forum) {
		this.forum = forum;
	}
	
	/**
	 *  Método para retorno de um cliente
	 *  @param clinte Código do cliente
	 *  @return cliente Retorna o cliente
	 */

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

	/**
	 *  Método para retorno de um tipo de causa
	 *  @param tipoCausa Código do tipo de causa
	 *  @return tipoCausa Retorna o tipo de causa
	 */

	public TipoCausaBean getTipoCausa() {
		return tipoCausa;
	}

	public void setTipoCausa(TipoCausaBean tipoCausa) {
		this.tipoCausa = tipoCausa;
	}
	
	/**
	 *  Método para retorno de um tipo de cobrança
	 *  @param tipoCobrança Código do tipo de cobrança
	 *  @return tipoCobrança Retorna o tipo de cobrança
	 */


	public TipoCobrancaBean getTipoCobranca() {
		return tipoCobranca;
	}

	public void setTipoCobranca(TipoCobrancaBean tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}
	
	/**
	 *  Método para retorno da descrição do processo
	 *  @param deProcesso Descrição do processo
	 *  @return dsProcesso Retorna a descrição do processo
	 */

	public String getDsProcesso() {
		return dsProcesso;
	}

	public void setDsProcesso(String dsProcesso) {
		this.dsProcesso = dsProcesso;
	}

	/**
	 *  Método para retorno da data de abertura
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
	 *  Método para retorno da data de fechamento
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
	 *  Método para retorno do dia do vencimento do título
	 *  @param ddDiaVencimento Data do vencimento
	 *  @return ddDiaVencimento Retorna a data do vencimento do título
	 */
	
	public int getDdDiaVencimento() {
		return ddDiaVencimento;
	}

	public void setDdDiaVencimento(int ddDiaVencimento) {
		this.ddDiaVencimento = ddDiaVencimento;
	}
	
	/**
	 *  Método para retorno do resultado
	 *  @param cdResultado Código do resultado
	 *  @return cdResultado Retorna o resultado
	 */


	public int getCdResultado() {
		return cdResultado;
	}

	public void setCdResultado(int cdResultado) {
		this.cdResultado = cdResultado;
	}
	
	/**
	 *  Método para retorno da descrição
	 *  @param dsObservacao Descrição da observação
	 *  @return dsObservacao Retorna a observação
	 */


	public String getDsObservacao() {
		return dsObservacao;
	}

	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}
	
}
