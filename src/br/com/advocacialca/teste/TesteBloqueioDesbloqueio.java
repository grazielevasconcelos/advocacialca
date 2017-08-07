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
			
//			Método: CONSULTAR
//			bloqDesbloqBean = bloqDesbloqBO.consultar(2);
//			System.out.println(bloqDesbloqBean.getCdBloqDesbloq());
//			System.out.println(bloqDesbloqBean.getDsBloqDesbloq());
//			Método Testado e Funcionando
			
//			Método: LISTAR.
//			List<BloqueioDesbloqueioBean> bloqDesbloq = bloqDesbloqBO.listar();			
//			for(BloqueioDesbloqueioBean bloqDes : bloqDesbloq ){
//				System.out.println("Código: " + bloqDes.getCdBloqDesbloq());
//				System.out.println("Descrição: " + bloqDes.getDsBloqDesbloq());
//			}
//			Método Testado e Funcionando
			
		} catch (Exception e) {
			System.out.println("ERRO: Teste Bloqueio Desbloqueio");
			sucesso = false;
		}
		
		return sucesso;
	}
}
