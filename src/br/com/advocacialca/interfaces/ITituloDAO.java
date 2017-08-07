package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.TituloBean;

public interface ITituloDAO {
	
	public void cadastrar(TituloBean tituloBean);
	public void atualizar(TituloBean tituloBean);
	public void remover(int idTitulo);
	public TituloBean consultar(int idTitulo);
	public List<TituloBean> listar(int nrProcesso);

}