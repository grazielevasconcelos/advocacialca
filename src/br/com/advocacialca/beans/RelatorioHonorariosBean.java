package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.List;

	/**
	 * Classe de um relatório de honorários
	 * @author Pixel
	 */

public class RelatorioHonorariosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ClienteBean cliente;
	
	private ProcessoBean processo;
	
	private List<AdvogadoBean> advogados;
	
	private List<TelefoneBean> telefones;

	private List<ItemRelatorioHonorarios> itemsRelatorioHonorario;
	
	public RelatorioHonorariosBean() { }

	
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
	 *  Método para retorno de uma lista de items de honorarios
	 *  @param ItemsRelatorioHonorario
	 *  @return List<ItemRelatorioHonorarios> Retorna a lista de itens de relatorio
	 */
	
	public List<ItemRelatorioHonorarios> getItemsRelatorioHonorario() {
		return itemsRelatorioHonorario;
	}

	public void setItemsRelatorioHonorario(
			List<ItemRelatorioHonorarios> itemsRelatorioHonorario) {
		this.itemsRelatorioHonorario = itemsRelatorioHonorario;
	}
	
	/**
	 *  Método para retorno da lista de advogados
	 *  @param advogados Código do advogado
	 *  @return List<AdvogadoBean> Retorna lista de advogados
	 */
	
	public List<AdvogadoBean> getAdvogados() {
		return advogados;
	}

	public void setAdvogados(List<AdvogadoBean> advogados) {
		this.advogados = advogados;
	}
	
	/**
	 *  Método para retorno de uma lista de telefones
	 *  @param telefones
	 *  @return List<TelefoneBean> Retorna uma lista de telefones
	 */
	
	public List<TelefoneBean> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneBean> telefones) {
		this.telefones = telefones;
	}
}
