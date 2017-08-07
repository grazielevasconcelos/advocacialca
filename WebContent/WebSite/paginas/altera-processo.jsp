<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="br.com.advocacialca.beans.TipoCobrancaBean"%>
<%@page import="br.com.advocacialca.beans.TipoCausaBean"%>
<%@page import="br.com.advocacialca.beans.ForumBean"%>
<%@page import="java.util.List"%>
<%@page import="br.com.advocacialca.beans.ProcessoBean"%>
<html>
<head>
	<title>Advocacia LCA</title>
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/relatorios.js"></script>
	<script type="text/javascript">		
		$(document).ready(function() {

			$('#alteraProcesso [type="submit"]').mousedown(function(e){
				
				var dataAbertura = $('#dataAbertura').val();
				var dataFechamento = $('#dataFechamento').val();
				var dsProcesso = $('#dsProcesso').val();
				var dsObservacao = $('#dsObservacao').val();
				
				var itensMensagem = [];
				
				if (dataAbertura.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.data_abertura_nao_informada);
				else if (validaData(dataAbertura))
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.data_abertura_invalida);
				
				if (dataFechamento.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.data_fechamento_nao_informada);
				else if (validaData(dataFechamento))
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.data_fechamento_invalida);
				
				if (dsProcesso.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.desc_processo_nao_informada);
				else if (dsProcesso.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.desc_processo_invalida);
				
				if (dsObservacao.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.desc_observacao_invalida);
					
				if (itensMensagem.length > 0) {
					mostrarMensagem(itensMensagem, "Ocorreu um erro alterar o processo ", "erro");
					e.preventDetault();
					return false;
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
				<h3>- Alteração de Processo</h3>
			</div>
			<div class="menu" />
		</div>		
		<div class="corpo">
			<form id="alteraProcesso" action="CadastraProcesso" method="post">
			<input type="hidden" name="tipoManutencao" value="atualizacao"/>
			<% ProcessoBean processoBean = (ProcessoBean)request.getAttribute("processoBean"); %>
				<table class="cadastro" frame="box" rules="none" cellpadding="8px">
					<tr>
						<td>Cliente:</td>
						<td>
							<input type="text" name="nomeCliente" disabled="disabled" value="<%= processoBean.getCliente().getPessoa().getNmPessoa() %>" />
							<input type="hidden" name="cdCliente" value="<%= processoBean.getCliente().getPessoa().getCdPessoa() %>"/>
						</td>
					</tr>
					<tr>
						<td>Nr. Processo:</td>
						<td>
							<input type="text" name="numeroProcesso" value="<%= processoBean.getNrProcesso() %>" disabled="disabled" />
							<input type="hidden" name="nrProcesso" value="<%= processoBean.getNrProcesso() %>">
						</td>
					</tr>
					<%  %>
					<tr>
						<td>Fórum:</td>
						<td>
							<input type="text" disabled="disabled" value="<%= processoBean.getForum().getPessoa().getNmPessoa() %>" />
							<input type="hidden" name="forum" value="<%= processoBean.getForum().getPessoa().getCdPessoa() %>" />
						</td>
					</tr>
					<tr>
						<td>Tipo de causa:</td>
						<td>
							<input type="text" disabled="disabled" value="<%= processoBean.getTipoCausa().getDsCausa() %>" />
							<input type="hidden" name="tipoCausa" value="<%= processoBean.getTipoCausa().getCdCausa() %>" />
						</td>
					</tr>
					<tr>
						<td>Tipo de cobrança:</td>
						<td>
							<input type="text" disabled="disabled" value="<%= processoBean.getTipoCobranca().getDsCobranca() %>" />
							<input type="hidden" name="tipoCobranca" value="<%= processoBean.getTipoCobranca().getCdCobranca() %>" />
						</td>
					</tr>
					<tr>
						<td>Vencimento do Pagamento:</td>
						<td>
							<input type="text" disabled="disabled" value="Dia <%= processoBean.getDdDiaVencimento() %>" />
							<input type="hidden" name="dataVencimento" value="<%= processoBean.getDdDiaVencimento() %>" />
						</td>
					</tr>
					<tr>
						<%SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");%>
						<td>Data de Abertura:</td>
						<td>
							<% String dataAbertura = formatador.format(processoBean.getDtAbertura().getTime().getTime()); %>
							<input type="text" value="<%= dataAbertura %>" disabled="disabled"/>
							<input type="hidden" name="dataAbertura" value="<%= dataAbertura %>" />
						</td>
					</tr>
					<% int cdResultado = processoBean.getCdResultado(); %>
					<tr>
						<td>Data de Fechamento:</td>
						<td>
							<% String dataFechamento = formatador.format(processoBean.getDtFechamento().getTime().getTime()); %>
							<input type="text" value="<%= dataFechamento %>"
							<%if( cdResultado != 0 && cdResultado != 1){ %>
								name="dataFechamento" />
							<% } else { %>
								 disabled="disabled" />
								<input type="hidden" name="dataFechamento" value="<%= dataFechamento %>" />
							<% } %>
						</td>
					</tr>
					<tr>
						<td>Resultado do Processo:</td>
						<td>
							<%if (cdResultado != 0 && cdResultado != 1){ %>
								<select name="resultado">
									<option value="2" <%if(cdResultado == 2){%> selected="selected" <%} %>>Em andamento</option>
									<option value="0" <%if(cdResultado == 0){%> selected="selected" <%} %>>Perdida</option>
									<option value="1" <%if(cdResultado == 1){%> selected="selected" <%} %>>Ganha</option>
								</select>
							<%} else {%>
								<input type="text" value="<% if(cdResultado == 0) {%>Perdida"<%}else{ %>Ganha"<%} %> disabled="disabled" />
								<input type="hidden" value="<%= cdResultado %>" name="resultado" />								
							<%} %>
						</td>
					</tr>
					<tr>
						<td>Descrição do Processo:</td>
						<td>
							<textarea rows="3" cols="30" disabled="disabled" ><%if(processoBean.getDsProcesso() != null){ %><%= processoBean.getDsProcesso() %><%} %></textarea>
							<textarea name="dsProcesso" hidden="hidden" ><%if(processoBean.getDsProcesso() != null){ %><%= processoBean.getDsProcesso() %><%} %></textarea>
						</td>
					</tr>
					<tr>
						<td>Observações do Processo:</td>
						<td>
							<textarea rows="3" cols="30" <% if(cdResultado != 0 && cdResultado != 1){ %>name="dsObservacao" <%}else{ %>disabled="disabled"<%}%>><%if(processoBean.getDsObservacao() != null){%><%= processoBean.getDsObservacao() %><%}%></textarea>
							<%if(cdResultado == 0 || cdResultado == 1) {%>
								<textarea name="dsObservacao" hidden="hidden"><%if(processoBean.getDsObservacao() != null){%><%= processoBean.getDsObservacao() %><%}%></textarea>
							<%} %>
						</td>
					</tr>
					<tr class="buttons">
						<td colspan="2">
							<input type="submit" value="Alterar" />
							<!-- <input type="reset" value="Limpar" /> -->
							<a href="./BloqueioSetup?nrProcesso=<%= processoBean.getNrProcesso() %>">
								<input type="button" value="Bloquear" />
							</a>
							<a href="./AdvogadosProcesso?nrProcesso=<%= processoBean.getNrProcesso() %>">
								<input type="button" value="Advogados Processo" />
							</a>
							<input type="button" value="Voltar" class="voltar" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="rodape">
			<strong>&copy; 2012 Advocacia LCA </strong>
			- Todos os direitos reservados. <br />
			<img src="WebSite/estilos/images/pixel.png" height="33" width="60" style="margin-top:6px;" />
		</div>
	</div>
</body>
</html>
	