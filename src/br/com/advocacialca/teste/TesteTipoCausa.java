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
			
			
			
			/* M�todo CONSULTAR:
			 * TipoCausaBean tipo = tipoCausaBO.consultar(1);
			 * System.out.println(tipo.getCdCausa());
			 * System.out.println(tipo.getDsCausa());
			 * M�todo Testado e Funcionando 
			 * */
			
			/* M�todo CADASTRAR:
			 * tipoCausaBO.cadastrar(tipoCausaBean);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo ATUALIZAR:
			 * tipoCausaBO.atualizar(tipoCausaBean);
			 * M�todo Testado e Funcionando
			 * */
			
			/* M�todo REMOVER:
			 * tipoCausaBO.remover(4);
			 * M�todo Testado e Funcionando
			 * */
			
			
			/* M�todo LISTAR:
			 * List<TipoCausaBean> lista = tipoCausaBO.listar();
			 * for(TipoCausaBean tipo : lista){
			 * 	System.out.println(tipo.getCdCausa());
			 * 	System.out.println(tipo.getDsCausa());
			 * }
			 * M�todo Testado e Funcionando
			 * */
		
		}
		catch (Exception e) {
			
			System.out.println("ERRO: TesteTipoCausa");
			
			sucesso = false;
		}
		
		return sucesso;
	}

}
