package br.com.advocacialca.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.AdvogadoHonorarioBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TarefaBean;
import br.com.advocacialca.negocio.AdvogadoHonorarioBO;

public class CadastroHonorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroHonorario() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cdAdvogado = Integer.parseInt(request.getParameter("cdAdvogado"));
		int nrProcesso = Integer.parseInt(request.getParameter("nrProcesso"));
		int cdTarefa = Integer.parseInt(request.getParameter("tipoTarefa"));
		String dataHonorario = request.getParameter("dataHonorario");
		int qtHoras = Integer.parseInt(request.getParameter("horasTrabalhadas"));
		String dsObservacao = request.getParameter("dsObservacao");
		
		PessoaBean pessoaAdvogadoBean = new PessoaBean();
		pessoaAdvogadoBean.setCdPessoa(cdAdvogado);		
		AdvogadoBean advogadoBean = new AdvogadoBean();
		advogadoBean.setPessoa(pessoaAdvogadoBean);
		
		ProcessoBean processoBean = new ProcessoBean();
		processoBean.setNrProcesso(nrProcesso);
		
		TarefaBean tarefaBean = new TarefaBean();
		tarefaBean.setCdTarefa(cdTarefa);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calDataHonorario = Calendar.getInstance();
		try {
			calDataHonorario.setTime(sdf.parse(dataHonorario));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		AdvogadoHonorarioBean advogadoHonorarioBean = new AdvogadoHonorarioBean();
		advogadoHonorarioBean.setAdvogado(advogadoBean);
		advogadoHonorarioBean.setProcesso(processoBean);
		advogadoHonorarioBean.setTarefa(tarefaBean);
		advogadoHonorarioBean.setDtHonorario(calDataHonorario);
		advogadoHonorarioBean.setQtHoras(qtHoras);
		advogadoHonorarioBean.setDsObservacao(dsObservacao);
		
		AdvogadoHonorarioBO advogadoHonorarioBO = new AdvogadoHonorarioBO();
		RespostaCRUD resp = advogadoHonorarioBO.cadastrar(advogadoHonorarioBean);
		
		String linkRedirecionamento = "./ListaHonorarioSetup";
		String txtLinkRedirecionamento = "Ir para lista de honor‡rios";
		resp.setLinkRedirecionamento(linkRedirecionamento);
		resp.setTxtLinkRedirecionamento(txtLinkRedirecionamento);
		request.setAttribute("respostaCRUD", resp);
		
		request.getRequestDispatcher("/WebSite/paginas/output.jsp").forward(request, response);
		
	}

}








