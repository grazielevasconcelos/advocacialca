package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.List;

	/**
	 * Classe de um relatatório de audiência
	 * @author Pixel
	 */

public class RelatorioAudienciasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ClienteBean cliente;
	
	private ProcessoBean processo;
	
	private List<AdvogadoBean> advogados;
	
	private List<TelefoneBean> telefones;

	private List<ItemRelatorioAudiencias> itemsRelatorioAudiencias;
	
	public RelatorioAudienciasBean() { }

	/**
	 *  Método para retorno de um cliente
	 *  @param cliente Código do cliente
	 *  @return cliente Retorna o cliente 
	 */

	
	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

	/**
	 *  Método para retorno de um processo
	 *  @param processo Código do processo
	 *  @return processo Retorna o processo
	 */

	
	public ProcessoBean getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoBean processo) {
		this.processo = processo;
	}

	/**
	 *  Método para retorno de uma lista de itens de relatório 
	 *  @param itemsRelatorioAudiencias 
	 *  @return itemsRelatorioAudiencias Retorna a lista de items
	 */

	public List<ItemRelatorioAudiencias> getItemsRelatorioAudiencias() {
		return itemsRelatorioAudiencias;
	}

	public void setItemsRelatorioAudiencias(
			List<ItemRelatorioAudiencias> itemsRelatorioAudiencias) {
		this.itemsRelatorioAudiencias = itemsRelatorioAudiencias;
	}
	
	/**
	 *  Método para retorno de uma lista de advogados
	 *  @param List<AdvogadoBean> 
	 *  @return processo Retorna lista de advogados
	 */
	
	public List<AdvogadoBean> getAdvogados() {
		return advogados;
	}

	public void setAdvogados(List<AdvogadoBean> advogados) {
		this.advogados = advogados;
	}
	
	/**
	 *  Método para retorno de uma lista de telefones
	 *  @param List<TelefonesBean> 
	 *  @return List<TelefonesBean> Retorna lista de telefones
	 */
	
	public List<TelefoneBean> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneBean> telefones) {
		this.telefones = telefones;
	}
}
