package br.com.advocacialca.teste;

import java.util.List;

import br.com.advocacialca.beans.ClienteBean;
import br.com.advocacialca.beans.TelefoneBean;
import br.com.advocacialca.negocio.TelefoneBO;

public class TesteTelefone {
	public static boolean Testar(){
		boolean sucesso = true;
		try {
//			TelefoneBO telBO = new TelefoneBO();
//			Método : LISTAR
//			List<TelefoneBean> telefones = telBO.listar(2);
//			for(TelefoneBean telCli : telefones){
//				System.out.println(telCli.getNrDDD());
//				System.out.println(telCli.getNrTelefone());
//				System.out.println(telCli.getTipoTelefone().getDsTipoTelefone());
//			}
//			Método Testado e Funcionando

			
		} catch (Exception e) {
			System.out.println("ERRO: TesteTelefone");
			sucesso = false;
		}


		return sucesso;
	}
}
