package br.com.advocacialca.teste;

import java.util.Calendar;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.TituloBean;
import br.com.advocacialca.beans.TituloPagoBean;
import br.com.advocacialca.negocio.TituloPagoBO;

public class TesteTituloPago {
	
public static boolean Testar() {
		
		boolean sucesso = true;
		
		try
		{
			TituloPagoBean tituloPagoBean = new TituloPagoBean(); 
			
			tituloPagoBean.setVlPago(120);
			
			TituloBean titulo = new TituloBean();
			
			titulo.setNrTitulo(2);
			
			ProcessoBean processo = new ProcessoBean();
			
			processo.setNrProcesso(2);
			
			titulo.setProcesso(processo);
			titulo.setDtVencimento(Calendar.getInstance());
			titulo.setDtDocumento(Calendar.getInstance());
			
			
			
			tituloPagoBean.setTitulo(titulo);
			
			Calendar cal = Calendar.getInstance();
			
			cal.set(2012, 11, 20);
			
			System.out.println("Data no Calendar: " + cal.getTime());
			
			//Calendar.getInstance() - Retorna a data e hora atual do servidor
			tituloPagoBean.setDtPagamento(cal);
			
			TituloPagoBO tituloPagoBO = new TituloPagoBO();
			
			//TituloPagoBean titulo = tituloPagoBO.consultar(2, new Date(05,06,2011));
			
			//System.out.println(titulo.getTitulo().getNrTitulo());
			//System.out.println(titulo.getDtPagamento());
			//System.out.println(titulo.getVlPago());
			
			tituloPagoBO.cadastrar(tituloPagoBean);
			
			/* Método CONSULTAR:
			 * 
			 * Método Testado e Funcionando 
			 * */
			
			/* Método CADASTRAR:
			 * 
			 * Método Testado e Funcionando
			 * */
			
			/* Método ATUALIZAR:
			 * 
			 * Método Testado e Funcionando
			 * */
			
			/* Método REMOVER:
			 * 
			 * Método Testado e Funcionando
			 * */
			
			/* Método LISTAR:
			 * 
			 * Método Testado e Funcionando
			 * */
		
		}
		catch (Exception e) {
			
			System.out.println("ERRO: TesteProcesso");
			
			sucesso = false;
		}
		
		return sucesso;
	}

public static void main(String[] args) {
	
	TesteTituloPago teste = new TesteTituloPago();
	
	boolean res = teste.Testar();
	
	System.out.println(res);
	
}

	
}
