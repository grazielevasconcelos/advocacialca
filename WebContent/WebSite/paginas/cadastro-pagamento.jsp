<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.advocacialca.beans.TituloPagoBean"%>
<%@page import="br.com.advocacialca.beans.TituloBean"%>
<%@page import="br.com.advocacialca.beans.ProcessoBean"%>
<html>
<head>
	<title>Advocacia LCA</title>
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/relatorios.js"></script>
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
			<div class="pesquisa">
				<%

				Object attrTitulo = (TituloBean)request.getAttribute("tituloBean");
				
				TituloBean titulo = null;
				
				if (attrTitulo != null)
					titulo = (TituloBean)attrTitulo;
				%>
				<% if (titulo!=null) { %>
					<form action="RegistrarPagamentoSetup" method="POST">
						<table class="cadastro" frame="box" rules="none" cellpadding="8px">
							<tr>
	
								<td>Nr. Processo:</td>
								<td>
									<input type="text" name="idProcesso" disabled="disabled" value="<%= titulo.getProcesso().getNrProcesso()%>"/>
								</td>
							</tr>
							<tr>
								<td>Tipo de Cobrança</td>
								<td>
									<input type="text" value="<%= titulo.getProcesso().getTipoCobranca().getDsCobranca() %>" disabled="disabled" />
									<input type="hidden" name="dsCobranca" value="<%= titulo.getProcesso().getTipoCobranca().getDsCobranca() %>" />
								</td>
							</tr>
							<tr>
								<td>Número do documento:</td>
								<td>
									<input type="text" size=10 name="idTitulo" value="<%= titulo.getNrTitulo() %>" disabled="disabled" />
									<input type="hidden" name="nrTitulo" value="<%= titulo.getNrTitulo() %>" />
								</td>
							</tr>
							<tr>
								<td>Data do Pagamento:</td>
								<% SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");%>
								<%Calendar calPG = Calendar.getInstance(); %>
								<td>
								<% String dataPagamento = formatador.format(calPG.getTime().getTime()); %>
									<input type="text" size=10 name="dtPagamento" value="<%= dataPagamento %>" disabled="disabled" />
									<input type="hidden" name="dataPagamento" value="<%= dataPagamento %>" />
								</td>
							</tr>
							<tr>
								<td>Data do Vencimento:</td>
								<td>
									<% String dataVencimento = formatador.format(titulo.getDtVencimento().getTime().getTime()); %>
									<input type="text" size=10 name="dtVecto" value="<%= dataVencimento %>"  disabled="disabled" />
									<input type="hidden" name="dataVecto" value="<%= dataVencimento %>" />
								</td>
							</tr>
							<tr>
								<td>Valor do documento:</td>
								<td><% DecimalFormat df = new DecimalFormat("0.00");
								String total = df.format(titulo.getTotal()); %>
									<input type="text" size=10 name="vlrDoc" value="R$ <%= total  %>"  disabled="disabled" />
									<input type="hidden" name="vaorDoc" value="<%= total %>" />
								</td>
							</tr>
							<tr class="buttons">
								<td colspan="2"> 
									<input type="submit" value="Registrar Pagamento" />
									<input type="button" value="Voltar" class="voltar" />
								</td>
							</tr>
						</table>
					</form>
				<% } %>
			</div>
		</div>
		<div class="rodape">
			<strong>&copy; 2012 Advocacia LCA </strong>
			- Todos os direitos reservados. <br />
			<img src="WebSite/estilos/images/pixel.png" height="33" width="60" style="margin-top:6px;" />
		</div>
	</div>
</body>
</html>