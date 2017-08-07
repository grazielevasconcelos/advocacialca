package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.AgendaAudienciaBean;

public interface IAgendaAudienciaDAO {
	
	public void cadastrar(AgendaAudienciaBean agendaAudienciaBean);
	public void atualizar(AgendaAudienciaBean agendaAudienciaBean);
	public void remover(int idAgendaAudiencia);
	public AgendaAudienciaBean consultar(int idAgendaAudiencia);
	public List<AgendaAudienciaBean> listar();

	
}
