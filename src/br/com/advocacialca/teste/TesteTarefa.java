package br.com.advocacialca.teste;

import java.util.List;

import br.com.advocacialca.beans.TarefaBean;
import br.com.advocacialca.negocio.TarefaBO;

public class TesteTarefa {
	
	public static boolean Testar(){
		boolean sucesso = true;
		
		try{
			
			TarefaBO tarefaBO = new TarefaBO();
			
			TarefaBean tarefaBean = new TarefaBean();
			
			tarefaBean.setCdTarefa(5);
			tarefaBean.setDsTarefa("Testando Tarefa");
			
			
			/* M�todo CONSULTAR:
			 * TarefaBean tarefa = tarefaBO.consultar(1);
			 * System.out.println(tarefa.getCdTarefa());
			 * System.out.println(tarefa.getDsTarefa());
			 * M�todo Testado e Funcionando 
			 * */
			
			/* M�todo CADASTRAR:
			 * tarefaBO.cadastrar(tarefaBean);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo ATUALIZAR:
			 * tarefaBO.atualizar(tarefaBean);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo REMOVER:
			 * tarefaBO.remover(5);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo LISTAR:
			 * List<TarefaBean> lista = tarefaBO.listar();
			 * for(TarefaBean tarefa : lista){
			 * 		System.out.println("C�digo: " + tarefa.getCdTarefa());
			 * 		System.out.println("Descri��o: " + tarefa.getDsTarefa());
			 * }
			 * M�todo Testado e Funcionando
			 * */
			
		} catch (Exception e) {
			
			System.out.println("ERRO: TesteTarefa");
			
			sucesso = false;
		}
		
		return sucesso;
	}

}
