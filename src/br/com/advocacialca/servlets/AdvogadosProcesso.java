package br.com.advocacialca.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.AdvogadoProcessoBean;
import br.com.advocacialca.beans.ClienteBean;
import br.com.advocacialca.beans.ForumBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TipoCausaBean;
import br.com.advocacialca.beans.TipoCobrancaBean;
import br.com.advocacialca.negocio.AdvogadoBO;
import br.com.advocacialca.negocio.AdvogadoProcessoBO;
import br.com.advocacialca.negocio.ClienteBO;
import br.com.advocacialca.negocio.ForumBO;
import br.com.advocacialca.negocio.ProcessoBO;
import br.com.advocacialca.negocio.TipoCausaBO;
import br.com.advocacialca.negocio.TipoCobrancaBO;

public class AdvogadosProcesso extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public AdvogadosProcesso() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object objNrProcesso = request.getParameter("nrProcesso");
		
		if (objNrProcesso != null) {
			
			int nrProcesso = Integer.parseInt((String)objNrProcesso);
			
			AdvogadoBO advogadoBO = new AdvogadoBO();
			ProcessoBO processoBO = new ProcessoBO();
			AdvogadoProcessoBO advProcBO = new AdvogadoProcessoBO();

			ProcessoBean processo = processoBO.consultar(nrProcesso);
			List<AdvogadoBean> novosAdvogadosProcesso = advogadoBO.obterPossiveisNovosAdvogados(nrProcesso);
			List<AdvogadoProcessoBean> advogadosProcesso = advProcBO.listar(nrProcesso);
			
			request.setAttribute("processo", processo);
			request.setAttribute("advogadosProcesso", advogadosProcesso);
			request.setAttribute("novosAdvogadosProcesso", novosAdvogadosProcesso);
			request.getRequestDispatcher("WebSite/paginas/advogados-processo.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Object objCdCliente = request.getParameter("cdCliente");
		Object objCdAdvogado = request.getParameter("cdAdvogado");
		Object objNrProcesso = request.getParameter("nrProcesso");
		
		if (objNrProcesso != null && objCdAdvogado != null && objCdCliente != null) {
			
			AdvogadoProcessoBO advProcBO = new AdvogadoProcessoBO();

			int cdAdvogado = Integer.parseInt((String)objCdAdvogado);
			int nrProcesso = Integer.parseInt((String)objNrProcesso);
			
			PessoaBean pessoa = new PessoaBean();
			AdvogadoBean advogado = new AdvogadoBean();
			ProcessoBean processo = new ProcessoBean();
			
			pessoa.setCdPessoa(cdAdvogado);
			advogado.setPessoa(pessoa);
			processo.setNrProcesso(nrProcesso);
			
			Calendar calendar = Calendar.getInstance();
			
			AdvogadoProcessoBean advProcBean = new AdvogadoProcessoBean();
			advProcBean.setAdvogado(advogado);
			advProcBean.setProcesso(processo);
			advProcBean.setDtInicioParticipacao(calendar);

			RespostaCRUD resp = advProcBO.cadastrar(advProcBean);
			String linkRedirecionamento = "./AdvogadosProcesso?nrProcesso=" + processo.getNrProcesso();
			String txtLinkRedirecionamento = "Ir para tela de advogados do processo";
			resp.setLinkRedirecionamento(linkRedirecionamento);
			resp.setTxtLinkRedirecionamento(txtLinkRedirecionamento);
			request.setAttribute("respostaCRUD", resp);
			
			request.getRequestDispatcher("WebSite/paginas/output.jsp").forward(request, response);
		}
	}
}
