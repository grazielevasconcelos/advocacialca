package br.com.advocacialca.teste;

import java.util.List;

import br.com.advocacialca.beans.TipoCobrancaBean;
import br.com.advocacialca.negocio.TipoCobrancaBO;

public class TesteTipoCobranca {

	public static boolean Testar() {
		
		boolean sucesso = true;
		
		try
		{
			TipoCobrancaBean tipoCobrancaoBean = new TipoCobrancaBean(); 
			
			tipoCobrancaoBean.setCdCobranca(1);
			tipoCobrancaoBean.setDsCobranca("A pagar!");
			tipoCobrancaoBean.setTxJuros(29.50);
			tipoCobrancaoBean.setVlMoraDiaria(2.50);
			
			TipoCobrancaBO tipoCobrancaBO = new TipoCobrancaBO();
			/*Método Listar testado e funcionando:
			List<TipoCobrancaBean> listaTipoCobranca = tipoCobrancaBO.listar();
			
			for(TipoCobrancaBean cob : listaTipoCobranca){
				System.out.println(cob.getCdCobranca());
				System.out.println(cob.getDsCobranca());
			}
			*/
		}
		catch (Exception e) {
			
			System.out.println("ERRO: TesteProcesso");
			
			sucesso = false;
		}
		
		return sucesso;
	}
}
