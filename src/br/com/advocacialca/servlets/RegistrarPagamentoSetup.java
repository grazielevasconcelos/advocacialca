package br.com.advocacialca.servlets;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TituloBean;
import br.com.advocacialca.beans.TituloPagoBean;
import br.com.advocacialca.negocio.TituloBO;
import br.com.advocacialca.negocio.TituloPagoBO;

public class RegistrarPagamentoSetup extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	public RegistrarPagamentoSetup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object objNrTitulo = request.getParameter("nrTitulo");
		
		if (objNrTitulo != null) {
			
			int nrTitulo = Integer.parseInt((String)objNrTitulo);
			
			TituloBO tituloBO = new TituloBO();
			
			TituloBean tituloBean = tituloBO.consultar(nrTitulo);
			
			request.setAttribute("tituloBean", tituloBean);
			
			request.getRequestDispatcher("/WebSite/paginas/cadastro-pagamento.jsp").forward(request, response);
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object objNrTitulo = request.getParameter("nrTitulo");
		
		if (objNrTitulo != null) {
			
			int nrTitulo = Integer.parseInt((String)objNrTitulo);
			
			TituloBO tituloBO = new TituloBO();
			
			TituloBean tituloBean = tituloBO.consultar(nrTitulo);
			
			TituloPagoBO tituloPagoBO = new TituloPagoBO();
			
			TituloPagoBean tituloPagoBean = new TituloPagoBean();
			tituloPagoBean.setTitulo(tituloBean);
			tituloPagoBean.setVlPago(tituloBean.getTotal());
			tituloPagoBean.setDtPagamento(Calendar.getInstance());

			RespostaCRUD resp = tituloPagoBO.cadastrar(tituloPagoBean);
			String linkRedirecionamento = "./ListaTitulosProcessoSetup?nrProcesso=" + tituloPagoBean.getTitulo().getProcesso().getNrProcesso();
			String txtLinkRedirecionamento = "Ir lista de títulos do processo";
			resp.setLinkRedirecionamento(linkRedirecionamento);
			resp.setTxtLinkRedirecionamento(txtLinkRedirecionamento);
			request.setAttribute("respostaCRUD", resp);
			
			request.getRequestDispatcher("/WebSite/paginas/output.jsp").forward(request, response);
			
		}
	}
}
