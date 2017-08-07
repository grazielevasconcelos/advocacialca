<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="br.com.advocacialca.beans.RelatorioAudienciasBean" %>
<%@page import="br.com.advocacialca.beans.ItemRelatorioAudiencias" %>
<%@page import="br.com.advocacialca.beans.TelefoneBean" %>
<%@page import="br.com.advocacialca.beans.AdvogadoBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
				<h3>- Emitir relatório de Audiências do Processo</h3>
			</div>
			<div class="menu" />
		</div>		
		<div class="corpo">
			<% 
			
			RelatorioAudienciasBean relAudienciasBean = null;
			
			Object objRel = request.getAttribute("relAudiencia");
			
			if (objRel != null)
				relAudienciasBean = (RelatorioAudienciasBean)objRel;
			
			String nrProcesso = relAudienciasBean != null ? String.valueOf(relAudienciasBean.getProcesso().getNrProcesso()) : "";
			
			%>
			<form id="emitirRel" method="POST" action="./RelatorioAudienciaSetup">
				<h3>Nr. Processo</h3>
				<input type="text" class="filtro-lista" value="<%= nrProcesso %>" id="nrProcesso" name="nrProcesso"  maxlength="9" />
				<input type="button" class="acao-lista submit" value="Emitir Relatório" />
			</form>
			<br />
			<% if (relAudienciasBean != null) { %>
				<table class="cabecalho border" frame="box" rules="rows" cellpadding="8px">
					<tr>
						<th>Nome do Cliente</th>
						<td><%= relAudienciasBean.getCliente().getPessoa().getNmPessoa() %></td>
					</tr>
					<% for (TelefoneBean telefone : relAudienciasBean.getTelefones()) { %>
					<tr>
						<th>Telefone <%= telefone.getTipoTelefone().getDsTipoTelefone() %></th>
						<td>
							(<%= telefone.getNrDDD() %>)&ensp;<%= telefone.getNrTelefone() %>
						</td>
					</tr>
					<% } %>
				</table>
				<br />
				<div class="boxRelatorio">				
					<table class="relatorio" rules="rows" cellpadding="8px">
						<tr>
							<th style="" width="70px">Data da audiência</th>
							<th style="" width="130px">Nome do fórum</th>
							<th>Endereço</th>
							<th>Sala</th>
							<th>Advogados</th>
						</tr>
						<% for (ItemRelatorioAudiencias item : relAudienciasBean.getItemsRelatorioAudiencias()) { %>
								<tr>
									<td><%= item.getDtAudiencia() %></td>
									<td><%= item.getNomeForum() %></td>
									<td><%= item.getEndereco() %></td>
									<td>
										<% if (item.getSala() != null) { %>
											<%= item.getSala() %>
										<% } %>
									</td>
									<td>
									<% for (AdvogadoBean advogado : relAudienciasBean.getAdvogados()) { %>
										<%= advogado.getPessoa().getNmPessoa() + "; "%>
									<% } %>
									</td>
								</tr>
						<% } %>
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
</html>
</body>