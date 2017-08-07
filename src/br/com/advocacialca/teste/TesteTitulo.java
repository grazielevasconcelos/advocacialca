package br.com.advocacialca.teste;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.TituloBean;
import br.com.advocacialca.negocio.ClienteBO;
import br.com.advocacialca.negocio.ProcessoBO;
import br.com.advocacialca.negocio.TituloBO;

public class TesteTitulo {

	public static boolean Testar() {
		
		boolean sucesso = true;
		
		try
		{
			ClienteBO clienteBO = new ClienteBO();
			
			ProcessoBO processoBO = new ProcessoBO();
			ProcessoBean processoBean = processoBO.listar(clienteBO.listar().get(1).getPessoa().getCdPessoa()).get(1);
			
			TituloBean tituloBean = new TituloBean(); 

			tituloBean.setNrTitulo(4);
			tituloBean.setProcesso(processoBean);
			tituloBean.setNrAgenciaCedente(2);
			tituloBean.setDtDocumento(Calendar.getInstance());
			tituloBean.setDtVencimento(Calendar.getInstance());
			tituloBean.setVlDocumento(Float.parseFloat("1800"));
			
			TituloBO tituloBO = new TituloBO();
			
			tituloBO.remover(4);
			
			/* Método CONSULTAR:
			 * TituloBean titulo = tituloBO.consultar(1);
			 * System.out.println(titulo.getNrTitulo());
			 * System.out.println(titulo.getProcesso().getNrProcesso());
			 * System.out.println(titulo.getNrAgenciaCedente());
			 * System.out.println(titulo.getDtDocumento());
			 * System.out.println(titulo.getDtVencimento());
			 * System.out.println(titulo.getVlDocumento());
			 * Método Testado e Funcionando 
			 * */
			
			/* Método CADASTRAR:
			 * tituloBO.cadastrar(tituloBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método ATUALIZAR:
			 * tituloBO.atualizar(tituloBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método REMOVER:
			 * 
			 * Método Testado e Funcionando
			 * */
			
			/* Método LISTAR:
			 * List<TituloBean> lista = tituloBO.listar();
			 * for(TituloBean titulo : lista){
			 * 	System.out.println("Numero titulo: " + titulo.getNrTitulo());
			 * 	System.out.println("Numero Processo: " + titulo.getProcesso().getNrProcesso());
			 * 	System.out.println("Numero Agencia Cedente: " + titulo.getNrAgenciaCedente());
			 * 	System.out.println("Data do Documento: " + titulo.getDtDocumento());
			 * 	System.out.println("Data de Vencimento: " + titulo.getDtVencimento());
			 * 	System.out.println("Valor do Documento: " + titulo.getVlDocumento());
			 * 	System.out.println("---------------------");
			 * }
			 * Método Testado e Funcionando
			 * */
		
		}
		catch (Exception e) {
			
			System.out.println("ERRO: TituloTitulo");
			
			sucesso = false;
		}
		
		return sucesso;
	}

}
