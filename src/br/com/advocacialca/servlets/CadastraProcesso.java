package br.com.advocacialca.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.ClienteBean;
import br.com.advocacialca.beans.ForumBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TipoCausaBean;
import br.com.advocacialca.beans.TipoCobrancaBean;
import br.com.advocacialca.negocio.ProcessoBO;

public class CadastraProcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CadastraProcesso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int	cdCliente = Integer.parseInt(request.getParameter("cdCliente"));
		int nrProcesso = Integer.parseInt(request.getParameter("nrProcesso"));
		int forum = Integer.parseInt(request.getParameter("forum"));
		int tipoCausa = Integer.parseInt(request.getParameter("tipoCausa"));
		int tipoCobranca = Integer.parseInt(request.getParameter("tipoCobranca"));
		int dataVencimento = Integer.parseInt(request.getParameter("dataVencimento"));
		String dataAbertura = request.getParameter("dataAbertura");
		String dataFechamento = request.getParameter("dataFechamento");
		String dsProcesso = request.getParameter("dsProcesso");
		String dsObservacao = request.getParameter("dsObservacao");
		String tipoManutencao = request.getParameter("tipoManutencao");
		
		PessoaBean pessoaBeanCliente = new PessoaBean();
		pessoaBeanCliente.setCdPessoa(cdCliente);
		ClienteBean clienteBean = new ClienteBean();
		clienteBean.setPessoa(pessoaBeanCliente);
		
		PessoaBean pessoaBeanForum = new PessoaBean();
		pessoaBeanForum.setCdPessoa(forum);
		ForumBean forumBean = new ForumBean();
		forumBean.setPessoa(pessoaBeanForum);
		
		TipoCausaBean tipoCausaBean = new TipoCausaBean();
		tipoCausaBean.setCdCausa(tipoCausa);
		
		TipoCobrancaBean tipoCobrancaBean = new TipoCobrancaBean();
		tipoCobrancaBean.setCdCobranca(tipoCobranca);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calDataAbertura = Calendar.getInstance();
		Calendar calDataFechamento = Calendar.getInstance();
		try {
			calDataAbertura.setTime(sdf.parse(dataAbertura));
			calDataFechamento.setTime(sdf.parse(dataFechamento));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ProcessoBean processoBean = new ProcessoBean();
		processoBean.setCliente(clienteBean);
		processoBean.setNrProcesso(nrProcesso);
		processoBean.setForum(forumBean);
		processoBean.setTipoCausa(tipoCausaBean);
		processoBean.setTipoCobranca(tipoCobrancaBean);
		processoBean.setDtAbertura(calDataAbertura);
		processoBean.setDdDiaVencimento(dataVencimento);
		processoBean.setDtFechamento(calDataFechamento);
		processoBean.setDsProcesso(dsProcesso);
		processoBean.setDsObservacao(dsObservacao);
		
		ProcessoBO processoBO = new ProcessoBO();
		
		if (tipoManutencao.equals("cadastro")){

			processoBean.setCdResultado(2);

			RespostaCRUD resp = processoBO.cadastrar(processoBean);
			String linkRedirecionamento = "./PreparaCadastroProcesso?cdCliente=" + processoBean.getCliente().getPessoa().getCdPessoa();
			String txtLinkRedirecionamento = "Voltar para tela de cadastro de processo";
			resp.setLinkRedirecionamento(linkRedirecionamento);
			resp.setTxtLinkRedirecionamento(txtLinkRedirecionamento);
			request.setAttribute("respostaCRUD", resp);
			
		} else if (tipoManutencao.equals("atualizacao")) {
			
			int resultado = Integer.parseInt(request.getParameter("resultado"));
			
			processoBean.setCdResultado(resultado);
			
			RespostaCRUD resp = processoBO.atualizar(processoBean);
			String linkRedirecionamento = "./DetalheClienteSetup?cdCliente=" + processoBean.getCliente().getPessoa().getCdPessoa();
			String txtLinkRedirecionamento = "Voltar para tela detalhes do cliente";
			resp.setLinkRedirecionamento(linkRedirecionamento);
			resp.setTxtLinkRedirecionamento(txtLinkRedirecionamento);
			request.setAttribute("respostaCRUD", resp);
		}
		
		request.getRequestDispatcher("/WebSite/paginas/output.jsp").forward(request, response);
	}

}
