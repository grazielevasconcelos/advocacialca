package br.com.advocacialca.teste;

import java.util.List;

import br.com.advocacialca.beans.ForumBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.negocio.ForumBO;
import br.com.advocacialca.negocio.PessoaBO;

public class TesteForum {
	
	public static boolean Testar(){
		
		boolean sucesso = true;
		
		try {
			PessoaBO pessoaBO = new PessoaBO();
			
			PessoaBean pessoaBean = new PessoaBean();
			pessoaBean.setCdPessoa(32);
			pessoaBean.setNmPessoa("Teste de Forum");
			
			//pessoaBO.cadastrar(pessoaBean);
			
			ForumBean forumBean = new ForumBean();
			forumBean.setPessoa(pessoaBean);
			forumBean.setDsForum("Teste de Forum");
			
			ForumBO forumBO = new ForumBO();
			
			
			
			
			/* M�todo CONSULTAR:
			 * ForumBean forum = forumBO.consultar(7);
			 * System.out.println(forum.getPessoa().getCdPessoa());
			 * System.out.println(forum.getPessoa().getNmPessoa());
			 * System.out.println(forum.getDsForum());
			 * M�todo Testado e Funcionando 
			 * */
			
			/* M�todo CADASTRAR:
			 * forumBO.cadastrar(forumBean);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo ATUALIZAR:
			 * forumBO.atualizar(forumBean);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo REMOVER:
			 * forumBO.remover(32);
			 * M�todo Testado e Funcionando
			 * */
			
			
			/* M�todo LISTAR:
			 * List<ForumBean> lista = forumBO.listar();
			 * for(ForumBean forum : lista){
			 * 	System.out.println("Codigo: " + forumBean.getPessoa().getCdPessoa());
			 * 	System.out.println("Nome: " + forumBean.getPessoa().getNmPessoa());
			 * 	System.out.println("Descricao: " + forumBean.getDsForum());
			 * }
			 * M�todo Testado e Funcionando
			 * */
			
			
		} catch (Exception e) {
			
			System.out.println("ERRO: TesteForum");
			
			sucesso = false;
		}
		
		return sucesso;
		
	}

}
