package br.com.advocacialca.teste;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.advocacialca.beans.HoraAdvogadoBean;
import br.com.advocacialca.negocio.HoraAdvogadoBO;

public class TesteHoraAdvogado {
	public static boolean Testar(){
		
		boolean sucesso = true;
		
		try {
			
			HoraAdvogadoBean hrAdvBean = new HoraAdvogadoBean();
			
			hrAdvBean.setCdHistorico(30);
			hrAdvBean.getAdvogado().setCdPessoa(10);
			hrAdvBean.setDtVigente(new Date(27,9,2012));
			hrAdvBean.setVlHora(198.69);

			HoraAdvogadoBO hrAdvBO = new HoraAdvogadoBO();

			hrAdvBO.cadastrar(hrAdvBean);
			//hrAdvBO.consultar(30);
			//hrAdvBO.remover(30);
			//hrAdvBO.atualizar(hrAdvBean);
			/*List<HoraAdvogadoBean> horaAdvogados = hrAdvBO.listar(); 
			for(HoraAdvogadoBean hrAdv : horaAdvogados){
				System.out.println("HORA : " + hrAdv.getVlHora());
				System.out.println("COD ADVOGADO : " + hrAdv.getCdAdvogado());
			}*/


		} catch (Exception e) {
			System.out.println("ERRO: TesteProcesso");
			e.printStackTrace();
			sucesso = false;
		}
		return sucesso;
	}
}