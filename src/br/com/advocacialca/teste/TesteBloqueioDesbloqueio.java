package br.com.advocacialca.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.BloqueioDesbloqueioBean;
import br.com.advocacialca.negocio.AdvogadoBO;
import br.com.advocacialca.negocio.BloqueioDesbloqueioBO;

public class TesteBloqueioDesbloqueio {
	
	public static boolean Testar(){
		
		boolean sucesso = true;
		try {
			BloqueioDesbloqueioBean bloqDesbloqBean = new BloqueioDesbloqueioBean();
			
			BloqueioDesbloqueioBO bloqDesbloqBO = new BloqueioDesbloqueioBO();
			
//			M�todo: CONSULTAR
//			bloqDesbloqBean = bloqDesbloqBO.consultar(2);
//			System.out.println(bloqDesbloqBean.getCdBloqDesbloq());
//			System.out.println(bloqDesbloqBean.getDsBloqDesbloq());
//			M�todo Testado e Funcionando
			
//			M�todo: LISTAR.
//			List<BloqueioDesbloqueioBean> bloqDesbloq = bloqDesbloqBO.listar();			
//			for(BloqueioDesbloqueioBean bloqDes : bloqDesbloq ){
//				System.out.println("C�digo: " + bloqDes.getCdBloqDesbloq());
//				System.out.println("Descri��o: " + bloqDes.getDsBloqDesbloq());
//			}
//			M�todo Testado e Funcionando
			
		} catch (Exception e) {
			System.out.println("ERRO: Teste Bloqueio Desbloqueio");
			sucesso = false;
		}
		
		return sucesso;
	}
}
