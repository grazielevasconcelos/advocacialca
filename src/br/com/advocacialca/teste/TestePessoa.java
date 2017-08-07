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
						
			
			/* M�todo CONSULTAR:
			 * PessoaBean pesBean2 = pesBO.consultar(1);
			 * System.out.println(pesBean2.getCdPessoa());
			 * System.out.println(pesBean2.getNmPessoa());
			 * M�todo Testado e Funcionando 
			 * */
			
			/* M�todo CADASTRAR:
			 * pesBO.cadastrar(pesBean);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo ATUALIZAR:
			 * pesBO.atualizar(pesBean);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo REMOVER:
			 * pesBO.remover(31);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo LISTAR:
			 * List<PessoaBean> pessoas = pesBO.listar();
			 * for(PessoaBean pes : pessoas){
			 * 		System.out.println("C�digo: " + pes.getCdPessoa());
			 * 		System.out.println("Nome: " + pes.getNmPessoa());
			 * 	}
			 * M�todo Testado e Funcionando
			 * */
			
		} catch (Exception e) {
			System.out.println("ERRO: TesteProcesso");
			sucesso = false;
		}
		
		return sucesso;
	}
}

