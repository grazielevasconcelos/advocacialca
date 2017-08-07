package br.com.advocacialca.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.BloqueioDesbloqueioBean;
import br.com.advocacialca.beans.HistBloqDesbloqBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.negocio.HistBloqDesbloqBO;
import br.com.advocacialca.negocio.ProcessoBO;

public class BloqueioSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BloqueioSetup() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object objNrProcesso = request.getParameter("nrProcesso");
	
		if (objNrProcesso != null) {
			
			int nrProcesso = Integer.parseInt((String)objNrProcesso);
			
			if (nrProcesso > 0) {
				
				ProcessoBO processoBO = new ProcessoBO();
				HistBloqDesbloqBO histBO = new HistBloqDesbloqBO();
				
				Calendar dtBloqueioDesbloq = Calendar.getInstance();	
				
				BloqueioDesbloqueioBean bloqueioDesbloq = new BloqueioDesbloqueioBean();
				bloqueioDesbloq.setCdBloqDesbloq(1);			
				
				ProcessoBean processo = processoBO.consultar(nrProcesso);
					
				HistBloqDesbloqBean histBean = new HistBloqDesbloqBean();		
				histBean.setBloqueioDesbloq(bloqueioDesbloq);
				histBean.setProcesso(processo);		
				histBean.setDtBloqueioDesbloq(dtBloqueioDesbloq);			
				
				RespostaCRUD resp = histBO.cadastrar(histBean);
				
				String linkRedirecionamento = "./PreparaCadastroProcesso?nrProcesso=" + processo.getNrProcesso();
				String txtLinkRedirecionamento = "Voltar para tela do processo";
				resp.setLinkRedirecionamento(linkRedirecionamento);
				resp.setTxtLinkRedirecionamento(txtLinkRedirecionamento);
				
				request.setAttribute("respostaCRUD", resp);
			}
		}
		
		request.getRequestDispatcher("/WebSite/paginas/output.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
