package br.com.advocacialca.teste;

import java.util.List;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.negocio.AdvogadoBO;
import br.com.advocacialca.negocio.PessoaBO;

public class TesteAdvogado {
	
	public static boolean Testar(){
		boolean sucesso = true;
		try {
			
			PessoaBean pessoaBean = new PessoaBean();
			pessoaBean.setCdPessoa(31);
			pessoaBean.setNmPessoa("Teste de Advogado");

			PessoaBO pessoaBO = new PessoaBO();
			//pessoaBO.atualizar(pessoaBean);
			
			AdvogadoBean advBean = new AdvogadoBean();
			
			advBean.setPessoa(pessoaBean);
			advBean.setNrOAB(23456);
			advBean.setNrCPF(12345680);
			advBean.setNrRG("1658908983");
			advBean.setDsEmail("contador@advocacialca.com");
			advBean.setDsPassword("89698");
			
			AdvogadoBO advBO = new AdvogadoBO();
			
			/* Método CONSULTAR:
			 * AdvogadoBean adv = advBO.consultar(1);
			 * System.out.println(adv.getPessoa().getCdPessoa());
			 * System.out.println(adv.getPessoa().getNmPessoa());
			 * System.out.println(adv.getNrOAB());
			 * System.out.println(adv.getNrCPF());
			 * System.out.println(adv.getNrRG());
			 * System.out.println(adv.getDsEmail());
			 * System.out.println(adv.getDsPassword());
			 * Método Testado e Funcionando 
			 * */
			
			/* Método CADASTRAR:
			 * advBO.cadastrar(advBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método ATUALIZAR:
			 * advBO.atualizar(advBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método REMOVER:
			 * advBO.remover(31);
			 * Método Testado e Funcionando
			 * */
			
			
			// Método LISTAR:
			  List<AdvogadoBean> lista = advBO.listarPorProcesso(1);
			 for(AdvogadoBean adv : lista){
			  	System.out.println(adv.getPessoa().getCdPessoa());
			  	System.out.println(adv.getPessoa().getNmPessoa());
			   System.out.println(adv.getNrOAB());
			   System.out.println(adv.getNrCPF());
			  System.out.println(adv.getNrRG());
			  System.out.println(adv.getDsEmail());
			  System.out.println(adv.getDsPassword());
			 } 
			// Método Testado e Funcionando
			 
			
		} catch (Exception e) {
			System.out.println("ERRO: TesteAdvogado");
			sucesso = false;
		}
		
		return sucesso;
	}
	
	public static void main(String[] args) {
		
		TesteAdvogado teste = new TesteAdvogado();
		
		boolean suc = teste.Testar();
		
		System.out.println(suc);
		
	}
}
