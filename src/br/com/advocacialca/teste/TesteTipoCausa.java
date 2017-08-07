package br.com.advocacialca.teste;

import java.util.Date;
import java.util.List;

import br.com.advocacialca.beans.TipoCausaBean;
import br.com.advocacialca.negocio.TipoCausaBO;

public class TesteTipoCausa {
	public static boolean Testar() {
		
		boolean sucesso = true;
		
		try
		{
			TipoCausaBean tipoCausaBean = new TipoCausaBean(); 
			
			tipoCausaBean.setCdCausa(4);
			tipoCausaBean.setDsCausa("Tipo de Causa");
			
			TipoCausaBO tipoCausaBO = new TipoCausaBO();
			
			
			
			/* Método CONSULTAR:
			 * TipoCausaBean tipo = tipoCausaBO.consultar(1);
			 * System.out.println(tipo.getCdCausa());
			 * System.out.println(tipo.getDsCausa());
			 * Método Testado e Funcionando 
			 * */
			
			/* Método CADASTRAR:
			 * tipoCausaBO.cadastrar(tipoCausaBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método ATUALIZAR:
			 * tipoCausaBO.atualizar(tipoCausaBean);
			 * Método Testado e Funcionando
			 * */
			
			/* Método REMOVER:
			 * tipoCausaBO.remover(4);
			 * Método Testado e Funcionando
			 * */
			
			
			/* Método LISTAR:
			 * List<TipoCausaBean> lista = tipoCausaBO.listar();
			 * for(TipoCausaBean tipo : lista){
			 * 	System.out.println(tipo.getCdCausa());
			 * 	System.out.println(tipo.getDsCausa());
			 * }
			 * Método Testado e Funcionando
			 * */
		
		}
		catch (Exception e) {
			
			System.out.println("ERRO: TesteTipoCausa");
			
			sucesso = false;
		}
		
		return sucesso;
	}

}
