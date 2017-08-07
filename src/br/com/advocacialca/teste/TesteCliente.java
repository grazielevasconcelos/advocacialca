package br.com.advocacialca.teste;

import java.util.List;

import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.beans.TelefoneBean;
import br.com.advocacialca.negocio.ClienteBO;
import br.com.advocacialca.negocio.PessoaBO;

public class TesteCliente {
	public static boolean Testar() {
		boolean sucesso = true;
		try {
			
			PessoaBean pessoaBean = new PessoaBean();
			pessoaBean.setCdPessoa(32);
			pessoaBean.setNmPessoa("Teste de Cliente");
			
			PessoaBO pessoaBO = new PessoaBO();
			//pessoaBO.cadastrar(pessoaBean);

			ClienteBO cliBO = new ClienteBO();
			

			/* Método CONSULTAR:
			 * ClienteBean cliente = cliBO.consultar(4);
			 * System.out.println("Código: " + cliente.getPessoa().getCdPessoa());
			 * System.out.println("Descrição: " + cliente.getPessoa().getNmPessoa());
			 * System.out.println("Nome Razão Social: " + cliente.getNmRazaoSocial());
			 * System.out.println("CNPJ: " + cliente.getNrCNPJ());
			 * System.out.println("Insc. Estadual: " + cliente.getNrInscEstadual());
			 * System.out.println("Email: " + cliente.getDsEmail());
			 * System.out.println("Password: " + cliente.getDsPassword());
			 * Método Testado e Funcionando 
			 * */
			
			/* Método CADASTRAR:
			 * ClienteBean cliBean = new ClienteBean();
			 * cliBean.setPessoa(pessoaBean);
			 * cliBean.setNmRazaoSocial("C&A");
			 * cliBean.setNrCNPJ(213543);
			 * cliBean.setNrInscEstadual(1523);
			 * cliBean.setDsEmail("juridicoc&a@advocacia.com");
			 * cliBean.setDsPassword("c&a1515");
			 * cliBO.cadastrar(cliBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método ATUALIZAR:
			 * ClienteBean cliBean = new ClienteBean();
			 * cliBean.setPessoa(pessoaBean);
			 * cliBean.setNmRazaoSocial("C&A");
			 * cliBean.setNrCNPJ(213543);
			 * cliBean.setNrInscEstadual(1523);
			 * cliBean.setDsEmail("juridicoc&a@advocacia.com");
			 * cliBean.setDsPassword("c&a1515");
			 * cliBO.atualizar(cliBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método REMOVER:
			 * cliBO.remover(31);
			 * Método Testado e Funcionando
			 * */
			
			
			/* Método LISTAR:
			 * List<ClienteBean> clientes = cliBO.listar();
			 * for(ClienteBean cli : clientes){
			 * 	System.out.println("Código cliente: " + cli.getPessoa().getCdPessoa());
			 * 	System.out.println("Nome: " + cli.getPessoa().getNmPessoa());
			 * 	System.out.println("Razão Social: " + cli.getNmRazaoSocial());
			 * 	System.out.println("CNPJ: " + cli.getNrCNPJ());
			 * 	System.out.println("Insc. Estadual: " + cli.getNrInscEstadual());
			 * 	System.out.println("Email: " + cli.getDsEmail());
			 * 	System.out.println("Senha: " + cli.getDsPassword());
			 * }	
			 * Método Testado e Funcionando
			 * */
			
			List<TelefoneBean> lista = cliBO.obterTelefoneCliente(1);
			for(TelefoneBean telefone : lista){
				System.out.println("(" + telefone.getNrDDD() + ") " + telefone.getNrTelefone());
			}
			
		} catch (Exception e) {
			System.out.println("ERRO: TesteCliente");
			sucesso = false;
		}
		
		return sucesso;
	}
}
