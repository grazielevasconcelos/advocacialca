package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.TelefoneBean;

public interface ITelefoneDAO {
	
	public TelefoneBean consultar(long cdTelefone);
	public void cadastrar(TelefoneBean telefoneBean);
	public void atualizar(TelefoneBean telefoneBean);
	public void remover(long cdTelefone);
	public List<TelefoneBean> listar(int idCliente);

}
