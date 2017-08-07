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
			

			/* M�todo CONSULTAR:
			 * ClienteBean cliente = cliBO.consultar(4);
			 * System.out.println("C�digo: " + cliente.getPessoa().getCdPessoa());
			 * System.out.println("Descri��o: " + cliente.getPessoa().getNmPessoa());
			 * System.out.println("Nome Raz�o Social: " + cliente.getNmRazaoSocial());
			 * System.out.println("CNPJ: " + cliente.getNrCNPJ());
			 * System.out.println("Insc. Estadual: " + cliente.getNrInscEstadual());
			 * System.out.println("Email: " + cliente.getDsEmail());
			 * System.out.println("Password: " + cliente.getDsPassword());
			 * M�todo Testado e Funcionando 
			 * */
			
			/* M�todo CADASTRAR:
			 * ClienteBean cliBean = new ClienteBean();
			 * cliBean.setPessoa(pessoaBean);
			 * cliBean.setNmRazaoSocial("C&A");
			 * cliBean.setNrCNPJ(213543);
			 * cliBean.setNrInscEstadual(1523);
			 * cliBean.setDsEmail("juridicoc&a@advocacia.com");
			 * cliBean.setDsPassword("c&a1515");
			 * cliBO.cadastrar(cliBean);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo ATUALIZAR:
			 * ClienteBean cliBean = new ClienteBean();
			 * cliBean.setPessoa(pessoaBean);
			 * cliBean.setNmRazaoSocial("C&A");
			 * cliBean.setNrCNPJ(213543);
			 * cliBean.setNrInscEstadual(1523);
			 * cliBean.setDsEmail("juridicoc&a@advocacia.com");
			 * cliBean.setDsPassword("c&a1515");
			 * cliBO.atualizar(cliBean);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo REMOVER:
			 * cliBO.remover(31);
			 * M�todo Testado e Funcionando
			 * */
			
			
			/* M�todo LISTAR:
			 * List<ClienteBean> clientes = cliBO.listar();
			 * for(ClienteBean cli : clientes){
			 * 	System.out.println("C�digo cliente: " + cli.getPessoa().getCdPessoa());
			 * 	System.out.println("Nome: " + cli.getPessoa().getNmPessoa());
			 * 	System.out.println("Raz�o Social: " + cli.getNmRazaoSocial());
			 * 	System.out.println("CNPJ: " + cli.getNrCNPJ());
			 * 	System.out.println("Insc. Estadual: " + cli.getNrInscEstadual());
			 * 	System.out.println("Email: " + cli.getDsEmail());
			 * 	System.out.println("Senha: " + cli.getDsPassword());
			 * }	
			 * M�todo Testado e Funcionando
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
