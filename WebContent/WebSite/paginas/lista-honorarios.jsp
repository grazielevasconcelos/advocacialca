<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.advocacialca.beans.AdvogadoBean"%>
<%@page import="br.com.advocacialca.beans.AdvogadoHonorarioBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Advocacia LCA</title>
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/relatorios.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){			
			$('#filtrarHonorario').keyup(filtrarRelatorio);
			
			$('#addHonorario').click(function(){
				window.location = "CadastroHonorarioSetup";
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
				<h3>- Lista de Honorários</h3>
			</div>
			<div class="menu" />
		</div>	
		
		<% 
		
		Object objAdvogado = request.getAttribute("advogado");
		Object objListaAdvHon = request.getAttribute("listaAdvHon");

		AdvogadoBean advBean = null;
		List<AdvogadoHonorarioBean> listaAdvHon = null;
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		if (objAdvogado != null && objListaAdvHon != null) {
		
			advBean = (AdvogadoBean)objAdvogado;
			listaAdvHon = (List<AdvogadoHonorarioBean>)objListaAdvHon;
			
		%>
		
			<div class="corpo">
				<h3>Dados do Advogado</h3>
				<table class="cabecalho border" frame="box" rules="rows" cellpadding="8px" >
					<tr>
						<th>Advogado</th>
						<td><%= advBean.getPessoa().getNmPessoa() %></td>
					</tr>
					<tr>
						<th>OAB</th>
						<td><%= advBean.getNrOAB() %></td>
					</tr>
					<tr>
						<th>CPF</th>
						<td><%= advBean.getNrCPF() %></td>
					</tr>
					<tr>
						<th>RG</th>
						<td><%= advBean.getNrRG()%></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><%= advBean.getDsEmail() %></td>
					</tr>
				</table>
				<div class="boxLista">
					<h3>Lista de Honorários do Advogado</h3>
					<input id="filtrarHonorario" type="text" class="filtro-lista" value="" seletorLinha="table.relatorio tr" entidadeLista="honorario"  />
					<input id="addHonorario" type="button" class="acao-lista" value="Novo Honorário" />
					<br />
					<div class="boxRelatorio">
						<table class="relatorio" rules="rows" cellpadding="8px">
							<tr class="cabecalho">
								<th>Nr. Processo</th>
								<th>Tarefa</th>
								<th>Dt. Honorário</th>
								<th>Qtd. Hrs</th>
								<th>Observação</th>
							</tr>
							<% for (AdvogadoHonorarioBean honorario : listaAdvHon) { %>
								<% String dtHonorario = formatador.format(honorario.getDtHonorario().getTime().getTime()); %>
								<tr>
									<td><%= honorario.getProcesso().getNrProcesso() %></td>
									<td><%= honorario.getTarefa().getDsTarefa() %></td>
									<td><%= dtHonorario %></td>
									<td><%= honorario.getQtHoras() %></td>
									<td>
									<% if (honorario.getDsObservacao() != null) { %>
										<%= honorario.getDsObservacao() %>
									<% } %>
									</td>
								</tr>
							<% } %>
						</table>
					</div>
				</div>
			</div>
		
		<% } %>
		<div class="rodape">
			<strong>&copy; 2012 Advocacia LCA </strong>
			- Todos os direitos reservados. <br />
			<img src="WebSite/estilos/images/pixel.png" height="33" width="60" style="margin-top:6px;" />
		</div>
	</div>
</body>
</html>