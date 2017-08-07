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
			
			
			/* Método CONSULTAR:
			 * TarefaBean tarefa = tarefaBO.consultar(1);
			 * System.out.println(tarefa.getCdTarefa());
			 * System.out.println(tarefa.getDsTarefa());
			 * Método Testado e Funcionando 
			 * */
			
			/* Método CADASTRAR:
			 * tarefaBO.cadastrar(tarefaBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método ATUALIZAR:
			 * tarefaBO.atualizar(tarefaBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método REMOVER:
			 * tarefaBO.remover(5);
			 * Método Testado e Funcionando
			 * */
			
			/* Método LISTAR:
			 * List<TarefaBean> lista = tarefaBO.listar();
			 * for(TarefaBean tarefa : lista){
			 * 		System.out.println("Código: " + tarefa.getCdTarefa());
			 * 		System.out.println("Descrição: " + tarefa.getDsTarefa());
			 * }
			 * Método Testado e Funcionando
			 * */
			
		} catch (Exception e) {
			
			System.out.println("ERRO: TesteTarefa");
			
			sucesso = false;
		}
		
		return sucesso;
	}

}
