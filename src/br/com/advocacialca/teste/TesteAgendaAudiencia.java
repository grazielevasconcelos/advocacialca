package br.com.advocacialca.teste;

import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.AgendaAudienciaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.negocio.AgendaAudienciaBO;

public class TesteAgendaAudiencia {
	
public static boolean Testar() {
		
		boolean sucesso = true;
		
		try
		{
			AgendaAudienciaBean agendaAudienciaBean = new AgendaAudienciaBean(); 
			
			ProcessoBean procBean = new ProcessoBean();
			
			agendaAudienciaBean.setCdAgenda(1);
			agendaAudienciaBean.setCdPessoaAdv(1);
			procBean.setNrProcesso(1);
			agendaAudienciaBean.setSlForum('1');
			agendaAudienciaBean.setDtHoraAgenda(Calendar.getInstance());
			
			
			AgendaAudienciaBO agendaAudienciaBO = new AgendaAudienciaBO();
			
			//Teste de cadastro
			agendaAudienciaBO.cadastrar(agendaAudienciaBean);
			
			//Teste de atualização
			agendaAudienciaBO.atualizar(agendaAudienciaBean);
	
			//Teste de consulta
			agendaAudienciaBO.consultar(1);
			
			//Teste de lista
			List<AgendaAudienciaBean> listaAgendaAudienciaBeans = agendaAudienciaBO.listar();
		
		}
		catch (Exception e) {
			
			System.out.println("ERRO: TesteProcesso");
			
			sucesso = false;
		}
		
		return sucesso;
	}

	
}
