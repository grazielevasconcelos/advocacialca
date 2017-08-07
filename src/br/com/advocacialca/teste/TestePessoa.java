package br.com.advocacialca.teste;

import java.util.List;

import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.negocio.PessoaBO;

public class TestePessoa {
	public static boolean Testar() {
		boolean sucesso = true;
		try {
			
			PessoaBean pesBean = new PessoaBean();
			pesBean.setCdPessoa(31);
			pesBean.setNmPessoa("Teste Pessoa2");
			
			PessoaBO pesBO = new PessoaBO();
						
			
			/* Método CONSULTAR:
			 * PessoaBean pesBean2 = pesBO.consultar(1);
			 * System.out.println(pesBean2.getCdPessoa());
			 * System.out.println(pesBean2.getNmPessoa());
			 * Método Testado e Funcionando 
			 * */
			
			/* Método CADASTRAR:
			 * pesBO.cadastrar(pesBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método ATUALIZAR:
			 * pesBO.atualizar(pesBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método REMOVER:
			 * pesBO.remover(31);
			 * Método Testado e Funcionando
			 * */
			
			/* Método LISTAR:
			 * List<PessoaBean> pessoas = pesBO.listar();
			 * for(PessoaBean pes : pessoas){
			 * 		System.out.println("Código: " + pes.getCdPessoa());
			 * 		System.out.println("Nome: " + pes.getNmPessoa());
			 * 	}
			 * Método Testado e Funcionando
			 * */
			
		} catch (Exception e) {
			System.out.println("ERRO: TesteProcesso");
			sucesso = false;
		}
		
		return sucesso;
	}
}

