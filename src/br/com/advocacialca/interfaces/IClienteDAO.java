package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.ClienteBean;

public interface IClienteDAO {
	public void cadastrar (ClienteBean cliBean);
	public void atualizar (ClienteBean cliBean);
	public void remover (int cdCliente);
	public ClienteBean consultar (int cdCliente);
	public List<ClienteBean> listar();
}
