<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.advocacialca.beans.TipoCausaBean"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="br.com.advocacialca.negocio.TipoCausaBO"%>
<%@page import="br.com.advocacialca.beans.ProcessoBean"%>
<%@page import="br.com.advocacialca.beans.TelefoneBean"%>
<%@page import="br.com.advocacialca.beans.ClienteBean"%>
<%@page import="br.com.advocacialca.beans.AdvogadoBean"%>
<%@page import="br.com.advocacialca.beans.AdvogadoProcessoBean"%>
<%@page import="java.util.List"%>
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
				<h3>- Página do Cliente</h3>
			</div>
			<div class="menu" />
		</div>		
		<div class="corpo">
		
			<% ProcessoBean processo = (ProcessoBean)request.getAttribute("processo"); %>
			<% if (processo != null) { %>
				<h3>Dados do Processo</h3>
				<table class="cabecalho border" frame="box" rules="rows" cellpadding="8px">
					<tr>
						<th>Nome do Cliente</th>
						<td><%= processo.getCliente().getPessoa().getNmPessoa() %></td>
					</tr>
					<tr>
						<th>Número do Processo</th>
						<td><%= processo.getNrProcesso() %></td>
					</tr>
					<tr>
						<th>Tipo de Causa</th>
						<td><%= processo.getTipoCausa().getDsCausa() %></td>
					</tr>
					<tr>
						<th>Descrição do Processo</th>
						<td><%= processo.getDsProcesso() %> </td>
					</tr>
				</table>
				<br />
			<% } %>
			
			<% List<AdvogadoBean> novosAdvogadosProcesso = (List<AdvogadoBean>)request.getAttribute("novosAdvogadosProcesso"); %>
			<% if (novosAdvogadosProcesso != null) { %>
				<form method="POST" action="./AdvogadosProcesso">
					<h3>Advogados Disponíveis</h3>
					<input name="cdCliente" type="hidden" value="<%= processo.getCliente().getPessoa().getCdPessoa() %>" />
					<input name="nrProcesso" type="hidden" value="<%= processo.getNrProcesso() %>" />
					<select name="cdAdvogado" id="forum" class="filtro-lista">
						<% for(AdvogadoBean advogadoBean : novosAdvogadosProcesso){%>
							<option value="<%= advogadoBean.getPessoa().getCdPessoa() %>"><%= advogadoBean.getPessoa().getNmPessoa() %></option>
						<% } %>
					</select>
					<input type="submit" class="acao-lista" value="Associar Advogado" />
				</form>
			<% } %>
			
			<% List<AdvogadoProcessoBean> advogadosProcesso = (List<AdvogadoProcessoBean>)request.getAttribute("advogadosProcesso"); %>
			<% if (advogadosProcesso != null) { %>
				<div class="boxLista">
					<h3>Lista de Advogados do Processo</h3>
					<br />
					<div class="boxRelatorio">
						<table class="relatorio" rules="rows" cellpadding="8px">
							<tr class="cabecalho">
								<th>No. OAB</th>
								<th>Nome Advogado</th>
								<th>Email</th>
								<th>Data Associação</th>
							</tr>
							<% SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");%>
							<%Calendar calPG = Calendar.getInstance(); %>
							<% for(AdvogadoProcessoBean advProc : advogadosProcesso) { %>
							<tr>
								<% String dataInicioParticipacao = formatador.format(advProc.getDtInicioParticipacao().getTime().getTime()); %>
								<% String emailAdvogado = advProc.getAdvogado().getDsEmail() != null ? advProc.getAdvogado().getDsEmail() : "-"; %>
								<td><%= advProc.getAdvogado().getNrOAB() %></td>
								<td><%= advProc.getAdvogado().getPessoa().getNmPessoa() %></td>
								<td><%= emailAdvogado %></td>
								<td><%= dataInicioParticipacao %></td>
							</tr>
							<% } %>
						</table>
					</div>
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