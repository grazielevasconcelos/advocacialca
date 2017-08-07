<%@page import="br.com.advocacialca.beans.ProcessoBean"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="br.com.advocacialca.beans.TarefaBean"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.advocacialca.beans.AdvogadoBean"%>
<html>
<head>
	<title>Advocacia LCA</title>
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/relatorios.js"></script>
	<script type="text/javascript">		
		$(document).ready(function(){

			$('#cadHonorario .submit').mousedown(function(e){
				
				var nrProcesso = $('#nrProcesso').val();
				var dataHonorario = $('#dataHonorario').val();
				var horasTrabalhadas = $('#horasTrabalhadas').val();
				var dsObservacao = $('#dsObservacao').val();
				
				var itensMensagem = [];
				
				if (nrProcesso.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.honorario.numero_processo_nao_informado);
				else if (isNaN(nrProcesso))
					itensMensagem.push(msgsValidacaoClient.cadastros.honorario.numero_processo_invalido);
				
				if (dataHonorario.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.honorario.data_honorario_nao_informada);
				else if (validaData(dataHonorario))
					itensMensagem.push(msgsValidacaoClient.cadastros.honorario.data_honorario_invalida);
				
				if (horasTrabalhadas.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.honorario.horas_honorario_nao_informado);
				else if (isNaN(horasTrabalhadas))
					itensMensagem.push(msgsValidacaoClient.cadastros.honorario.horas_honorario_invalido);
				//else if (horasTrabalhadas(parseInt(horasTrabalhadas,10)))
				//	itensMensagem.push(msgsValidacaoClient.cadastros.honorario.horas_honorario_fora_range);
				
				//if (validaLetrasENumeros(dsObservacao))
				//	itensMensagem.push(msgsValidacaoClient.cadastros.honorario.desc_observacao_invalida);
				
				if (itensMensagem.length > 0) {
					mostrarMensagem(itensMensagem, "Ocorreu um erro cadastrar o honorário ", "erro");
					e.preventDetault();
					return false;
				} else {
					$('#cadHonorario').submit();
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
				<h3>- Lançamento de Honorário</h3>
			</div>
			<div class="menu" />
		</div>		
		<% 
		
		Object objAdvogado = request.getAttribute("advogado");

		AdvogadoBean advogadoBean = null;
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		if (objAdvogado != null) {
			advogadoBean = (AdvogadoBean)objAdvogado;
		%>
		
		<div class="corpo">
			<div class="pesquisa">		
				<form id="cadHonorario" action="CadastroHonorario" method="post">

					<table class="cadastro" frame="box" rules="none" cellpadding="8px">
						<tr>
							<td>Advogado:</td>
							<td>
								<input type="text" name="advogado" disabled="disabled" value="<%= advogadoBean.getPessoa().getNmPessoa() %>"/>
								<input type="hidden" name="cdAdvogado" value="<%= advogadoBean.getPessoa().getCdPessoa() %>" />
							</td>
						</tr>
						<tr>
							<% List<ProcessoBean> listaProcesso = (List<ProcessoBean>)request.getAttribute("listaProcesso"); %>
							<td>Descrição:</td>
							<td>
								<select name="nrProcesso" id="nrProcesso">
									<%if (listaProcesso.get(0) != null) %>
										<%for (ProcessoBean processoBean : listaProcesso){ %>
											<option value="<%= processoBean.getNrProcesso() %>"><%= processoBean.getNrProcesso() + " - " + processoBean.getDsProcesso() %></option>
										<%} %>
									<%} %>
								</select>
							</td>
						</tr>
						<tr>
							<% List<TarefaBean> listaTarefaBean = (List<TarefaBean>)request.getAttribute("listaTarefaBean"); %>
							<td>Tipo de Tarefa:</td>
							<td> 
								<select name="tipoTarefa" id="tipoTarefa">
									<%for (TarefaBean tarefaBean : listaTarefaBean){ %>
										<option value="<%= tarefaBean.getCdTarefa() %>"><%= tarefaBean.getDsTarefa() %></option>
									<%} %>
								</select>
							</td>
						</tr>
						<tr>
							<td>Data do honorário:</td>
							<td>
								<input type="text" name="dataHonorario" id="dataHonorario" />
							</td>
						</tr>
						<tr>
							<td>Horas Trabalhadas:</td>
							<td>
								<input type="text" name="horasTrabalhadas" id="horasTrabalhadas" maxlength="9"/>
							</td>
						</tr>
						<tr>
							<td>Observações:</td>
							<td>
								<textarea rows="3" cols="30" name="dsObservacao"></textarea>
							</td>
						</tr>
						<tr class="buttons">
							<td colspan="2">
								<input type="button" value="Novo" class="submit" />
								<input type="reset" value="Limpar" />
								<input type="button" value="Voltar" class="voltar" />
							</td>
						</tr>
					</table>
				</form>
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