package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.TipoCausaBean;

public interface ITipoCausaDAO {
	
	public void cadastrar(TipoCausaBean tipoCausaBean);
	public void atualizar(TipoCausaBean tipoCausaBean);
	public void remover(int idTipoCausa);
	public TipoCausaBean consultar(int idTipoCausa);
	public List<TipoCausaBean> listar();

}
