<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="br.com.advocacialca.beans.TipoCobrancaBean"%>
<%@page import="br.com.advocacialca.beans.TelefoneBean"%>
<%@page import="br.com.advocacialca.beans.ClienteBean"%>
<%@page import="br.com.advocacialca.beans.ProcessoBean"%>
<%@page import="br.com.advocacialca.beans.TituloBean"%>
<%@page import="java.util.List"%>
<html>
<head>
	<title>Advocacia LCA</title>
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/relatorios.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#emitirRel .submit').mousedown(function(e){
				
				var idProcesso = $('#nrProcesso').val();
				
				var itensMensagem = [];

				if (idProcesso.trim() == "")
					itensMensagem.push(msgsValidacaoClient.relatorios.numero_processo_nao_informado);
				else if (isNaN(idProcesso))
					itensMensagem.push(msgsValidacaoClient.relatorios.numero_processo_invalido);
				
				if (itensMensagem.length > 0) {
					mostrarMensagem(itensMensagem, "Ocorreu um gerar o Relatório de Audiências", "erro");
					e.preventDetault();
					return false;
				} else {
					$('#emitirRel').submit();
				}
				
			});
			
		});
	</script>
</head>
<body>
	<%
	PessoaBean usuarioLogado = null;
	Object objUsuarioLogado = request.getSession().getAttribute("usuarioLogado");
	if (objUsuarioLogado != null)
		usuarioLogado = (PessoaBean)objUsuarioLogado;
	%>
	<div class="site box centralizado-x">	
		<div class="cabecalho">
			<div class="informacoes-login">
				<span class="usuario-logado"><%= usuarioLogado.getNmPessoa() %></span> - 
				<a href="WebSite/paginas/login.jsp" class="sair">Sair</a>&emsp;
			</div>
			<div class="banner">
				<a href="./IndexSetup">
					<img class="logo" src="WebSite/estilos/images/logo.png"/>
				</a>
				<h1>Controle de processos e cobrança de honorários</h1>
				<h3>- Registro de Pagamentos</h3>
			</div>
			<div class="menu" />
		</div>		
		<div class="corpo">
			<%
			List<TelefoneBean> telefones = null;
			ProcessoBean processo = null;
			List<TituloBean> titulos = null;

			Object attrTelefones = request.getAttribute("telefones");
			Object attrProcesso = request.getAttribute("processo");
			Object attrTitulos = request.getAttribute("titulos");
			
			if(attrTelefones!= null)
				telefones = (List<TelefoneBean>)attrTelefones;
			
			if(attrProcesso != null)
				processo = (ProcessoBean)attrProcesso;
			
			if (attrTitulos != null)
				titulos = (List<TituloBean>)attrTitulos;
			
			String nrProcesso = processo != null ? String.valueOf(processo.getNrProcesso()) : "";
			
			%>
			<form id="emitirRel" method="POST" action="./ListaTitulosProcessoSetup">
				<h3>Nr. Processo</h3>
				<input type="text" class="filtro-lista" value="<%= nrProcesso %>" id="nrProcesso" name="nrProcesso"  maxlength="9" />
				<input type="button" class="acao-lista submit" value="Pesquisar" />
			</form>
			<br />
			<% if (processo != null && titulos != null) { %>
				<table class="cabecalho border" frame="box" rules="rows" cellpadding="8px">
					<tr>
						<th>Nome do Cliente</th>
						<td>
						<%= processo.getCliente().getPessoa().getNmPessoa() %>
						</td>
					</tr>
					<% for (TelefoneBean telefone : telefones) { %>
					<tr>
						<th>Telefone <%= telefone.getTipoTelefone().getDsTipoTelefone() %></th>
						<td>
							(<%= telefone.getNrDDD() %>)&ensp;<%= telefone.getNrTelefone() %>
						</td>
					</tr>
					<% } %>
					<tr>
						<th>Número do Processo</th>
						<td><%= processo.getNrProcesso() %></td>
					</tr>
					<tr>
						<th>Dia do Vencimento</th>
						<td><%= processo.getDdDiaVencimento() %></td>
					</tr>
					<tr>
						<th>Tipo de Cobrança</th>
						<td><%= processo.getTipoCobranca().getDsCobranca() %></td>
					</tr>
				</table>
				<br />
				<div class="boxRelatorio">				
					<table class="relatorio" rules="rows" cellpadding="8px">
						<thead>					
							<tr>
								<th style="" width="50">Nr. Título</th>
								<th style="" width="50">Ag. Cedente</th>
								<th>Dt. Doc.</th>
								<th>Dt. Venc.</th>
								<th>Valor</th>
								<th>Juros</th>
								<th>Total</th>
								<th>Situação</th>
								<th style="" width="55"></th>
							</tr>
						</thead>
						<tbody>
						<% for(TituloBean titulo : titulos) { %>
								<%SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");%>
							<% String dtDoc = formatador.format(titulo.getDtDocumento().getTime().getTime());%>

								<%SimpleDateFormat formatador2 = new SimpleDateFormat("dd/MM/yyyy");%>
							<% String dtVenc = formatador2.format(titulo.getDtVencimento().getTime().getTime()); %>
						<tr>
							<td><%= titulo.getNrTitulo() %></td>
							<td><%= titulo.getNrAgenciaCedente() %></td>
							<td><%=dtDoc %></td>
							<td><%=dtVenc %></td>
							<td><% DecimalFormat df = new DecimalFormat("0.00");
								String valorDoc = df.format(titulo.getVlDocumento()); %>
							<%= valorDoc %></td>
							<td><%= processo.getTipoCobranca().getTxJuros() %> %</td>
							<td><% String total = df.format(titulo.getTotal()); %>
							R$ <%= total %></td>
							<td>
								<%
								String resultadoCausa = ""; 
								if (processo.getCdResultado()==1)
									resultadoCausa = "Causa ganha";
								else if (processo.getCdResultado()== 2)
									resultadoCausa = "Causa em andamento";
								else
									resultadoCausa = "Causa Perdida";
								%>
								<%= resultadoCausa %>
							</td>
							<td>
								<a href="./RegistrarPagamentoSetup?nrTitulo=<%= titulo.getNrTitulo() %>">
									<img src="WebSite/estilos/images/editar.png" />
								</a>
							</td>
							<% } %>
						</tr>	
						</tbody>
					</table>
				</div>
			<% } %>
		</div>
		<div class="rodape">
			<strong>&copy; 2012 Advocacia LCA </strong>
			- Todos os direitos reservados. <br />
			<img src="WebSite/estilos/images/pixel.png" height="33" width="60" style="margin-top:6px;" />
		</div>
	</div>
</body>
</html>