package br.com.advocacialca.teste;

import java.util.List;
import br.com.advocacialca.beans.TipoTelefoneBean;
import br.com.advocacialca.negocio.TipoTelefoneBO;

public class TesteTipoTelefone {
	public static boolean Testar() {
		
		boolean sucesso = true;
		
		try
		{
			TipoTelefoneBO tipoTelefoneBO = new TipoTelefoneBO();
			
//			Método LISTAR:
//			List<TipoTelefoneBean> listaTipoTelefone = tipoTelefoneBO.listar();
//			for(TipoTelefoneBean tpTel : listaTipoTelefone ){
//				System.out.println(tpTel.getCdTipoTelefone());
//				System.out.println(tpTel.getDsTipoTelefone());
//			}
//			Método Testado e Funcionando
		}
		catch (Exception e) {
			
			System.out.println("ERRO: TesteTipoTelefone");
			
			sucesso = false;
		}
		
		return sucesso;
	}

}
