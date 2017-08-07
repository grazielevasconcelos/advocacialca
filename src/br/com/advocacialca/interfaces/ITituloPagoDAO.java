package br.com.advocacialca.interfaces;

import java.sql.Date;
import java.util.List;

import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TituloPagoBean;
public interface ITituloPagoDAO {
	
	public RespostaCRUD cadastrar (TituloPagoBean tituloPago);
	public void remover (int cdTitulo, Date dataTitulo);
	public TituloPagoBean consultar(int idTituloPago, Date dataTitulo);
	public List<TituloPagoBean> listar();
	
}
