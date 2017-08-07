/* SCRIPTS UTILIZADOS EM TODAS AS PçGINAS ***************************************************************************************************************************************/

(function($){
	
	$(document).ready(function(){
		$('.cabecalho .menu').html(obterHtmlMenu());

		$('.voltar').click(function(){
			window.history.back();
		});
	});
	
})(jQuery);

/* FUNCIONALIDADES DIVERSAS ***************************************************************************************************************************************/

function filtrarRelatorio() {
	var seletorLinha = $(this).attr("seletorLinha");
	var termoPesquisado = $(this).val().toLowerCase();
	if (termoPesquisado == "") {
		$(seletorLinha).removeClass('hide');
	} else {					
		$(seletorLinha).each(function(){
			var possuiValor = false;
			var linhaAtual = $(this);
			if (!linhaAtual.hasClass('cabecalho') && !linhaAtual.hasClass('rodape')) {
				$('td', linhaAtual).each(function(){
					if ($(this).text().toLowerCase().indexOf(termoPesquisado) > -1)
						possuiValor = true;
				});
				if (!possuiValor) 
					linhaAtual.addClass('hide');
				else
					linhaAtual.removeClass('hide');
			}
		});
	}
	
	var linhasVisiveis = $(seletorLinha + ':visible td');
	
	if (linhasVisiveis.length == 0) {
		
		var entidadeLista = $(this).attr("entidadeLista");
		
		var itensMensagem = [msgsValidacaoClient.filtroPesquisaEmLista[entidadeLista]];
		
		mostrarMensagem(itensMensagem, "Erro ao aplicar filtro", "erro");
	}
}

/* VALIDA‚ÌO DE FORMULçRIOS ***************************************************************************************************************************************/

function mensagem() {
	
	var novaMensagem = {
		titulo: "Erro ao efetuar operação",
		tipo: "erro",
		itens: [],
		add: function(item){ this.itens.push(item); }
	};
	
	return novaMensagem;
}

function mostrarMensagem(itens, titulo, tipo) {
	
	var paramsMensagem = new mensagem();

	paramsMensagem.tipo = tipo ? tipo : paramsMensagem.tipo;
	paramsMensagem.titulo = titulo ? titulo : paramsMensagem.titulo;
	
	for (var i=0; i < itens.length; i++)
		paramsMensagem.add(itens[i]);
	
	$('body').append(obterHtmlMensagem(paramsMensagem));
	
	$('.fecha-mensagem').live('click', function(){
		$('.modal').remove();
	});
	
}

var msgsValidacaoClient = {
	cadastros: {
		processo: {
			numero_processo_nao_informado: 'Informe o número do processo',
			numero_processo_invalido: 'Número de processo inválido',
			data_abertura_nao_informada: 'Informe data de abertura do processo',
			data_abertura_invalida: 'Data de abertura do processo inválido',
			data_fechamento_nao_informada: 'Informe data de fechamento do processo',
			data_fechamento_invalida: 'Data de fechamento do processo inválido',
			desc_processo_nao_informada: 'Informe descrição do processo',
			desc_processo_invalida: 'Descrição inválida. Utilize apenas letras e números',
			desc_observacao_invalida: 'Observação inválida. Utilize apenas letras e números'
		},
		honorario: {
			numero_processo_nao_informado: 'Informe o número do processo',
			numero_processo_invalido: 'Número de processo inválido',
			data_honorario_nao_informada: 'Informe a data do honorário',
			data_honorario_invalida: 'Data do honorário inválido',
			horas_honorario_nao_informado: 'Informe a quantidade de horas do honorário',
			horas_honorario_invalido: 'Quantidade de horas inválida',
			horas_honorario_fora_range: 'Quantidade de horas deve ser no minimo: 1 e no maximo: 24',
			desc_observacao_invalida: 'Observação inválida. Utilize apenas letras e números'
		},
		pagamento: {
			a: '',
			b: '',
			c: ''
		},
	},
	relatorios: {
		numero_processo_nao_informado: 'Informe o número do processo',
		numero_processo_invalido: 'Nœmero de processo inválido'
	},
	autenticacao: {
		entrar: {
			login_nao_informado: 'Informe o login de usuário',
			login_invalido: 'Login de usuário inválido',
			senha_nao_informada: 'Informe a senha de usuário',
			senha_invalida: 'Senha de usuário inválida'
		},
		sair: {
			a: '',
			b: '',
			c: ''
		}
	},
	filtroPesquisaEmLista: {
		cliente: 'Não foram encontrados Clientes a partir do termo digitado',
		processo: 'Não foram encontrados Processos a partir do termo digitado',
		honorario: 'Não foram encontrados Honorários a partir do termo digitado'
	},
	pesquisaRapida: {
		codigo_nao_informado: "Informe o código a ser pesquisado",
		codigo_invalido: "Código inválido. O código é numérico"
	}
};

/* OBTEN‚ÌO DE HTML ***************************************************************************************************************************************/

function obterHtmlMenu() {

	var menuHtml = "".concat("<ul>")
	.concat("<li>")
	.concat("<a href='/AdvocaciaLCA/ListaClienteSetup'>Lista de Clientes</a>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Relatórios</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='/AdvocaciaLCA/RelatorioAudienciaSetup'>Relatório de Audiências</a></li>")
	.concat("<li><a href='/AdvocaciaLCA/RelatorioHonorarioSetup'>Relatório de Honorários</a></li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Honorários</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='/AdvocaciaLCA/CadastroHonorarioSetup'>Lançar Honorários</a></li>")
	.concat("<li><a href='/AdvocaciaLCA/ListaHonorarioSetup'>Lista de Honorários</a></li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li><a href='/AdvocaciaLCA/ListaTitulosProcessoSetup'>Registrar Pagamentos</a></li>")
	.concat("</ul>");
	
	return menuHtml;

}

function obterHtmlMenuAdvogado() {

	var menuHtml = "".concat("<ul>")
	.concat("<li>")
	.concat("<a class='javascript:void(0);' href='javascript:void(0);'>Cadastros</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Honorário</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Despesa</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Causa</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Fóruns</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Valor/Hora</a>")
	.concat("</li>")
	.concat("</ul>")
	.concat("</div></li>")
	.concat("<li><a class='' href='javascript:void(0);'>Financeiro</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Lançar Despesas</a>")
	.concat("</li>")
	.concat("<li><a href='./CadastroHonorarioSetup'>Lançar Honorários</a>")
	.concat("</li>")
	.concat("</ul>")
	.concat("</div></li>")
	.concat("<li><a class='' href='javascript:void(0);'>Jurídico</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Agendar Audiência</a>")
	.concat("</li>")
	.concat("</ul>")
	.concat("</div></li>")
	.concat("<li><a class='' href='javascript:void(0);'>Consulta</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='./ListaHonorarioSetup'>Listar Honorários</a></li>  ")
    .concat("<li><a href='./ListaClienteSetup'>Listar Clientes</a></li>  ")
	.concat("<li><a href='javascript:void(0);'>Consultar Processos</a></li>")
	.concat("</ul>")
	.concat("</div></li>")
	.concat("<li><a class='' href='javascript:void(0);'>Relatórios</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Processos</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Despesas</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Tarefas</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Receitas Anuais</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Pagamentos em Aberto</a>")
	.concat("</li>")
	.concat("<li><a href='./RelatorioAudienciaSetup'>Audiências</a>")
	.concat("</li>")
	.concat("<li><a href='./RelatorioHonorarioSetup'>Honorários</a>")
	.concat("</li>")
	.concat("</ul>")
	.concat("</div></li>")
	
	return menuHtml;

}

function obterHtmlMenuSecretaria() {

	var menuHtml = "".concat("<ul>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Cadastros</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Cliente</a></li>")
	.concat("<li><a href='javascript:void(0);'>Advogado</a></li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Honorário</a></li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Despesa</a></li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Causa</a></li>")
	.concat("<li><a href='javascript:void(0);'>Fóruns</a></li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Cobrança</a></li>")
	.concat("<li><a href='javascript:void(0);'>Taxas</a></li>")
	.concat("<li><a href='javascript:void(0);'>Valor/Hora</a></li>")
	.concat("<li><a href='./ListaClienteSetup'>Processo</a></li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Financeiro</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Lançar Depesas</a></li>")
	.concat("<li><a href='./CadastroHonorarioSetup'>Lançar Honorários</a></li>")
	.concat("<li><a href='./ListaTitulosProcessoSetup'>Registrar Pagamentos</a></li>")
	.concat("<li><a href='javascript:void(0);'>Controlar Pagamentos em Atraso</a></li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Jurídico</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Agendar Audiência</a></li>  ")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Consulta</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='./ListaHonorarioSetup'>Listar Honorários</a></li>  ")
    .concat("<li><a href='./ListaClienteSetup'>Listar Clientes</a></li>  ")
	.concat("<li><a href='javascript:void(0);'>Consultar Processos</a></li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Relatórios</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href=''>Processos</a>")
	.concat("</li>")
	.concat("<li><a href=''>Despesas</a>")
	.concat("</li>")
	.concat("<li><a href=''>Tarefas</a>")
	.concat("</li>")
	.concat("<li><a href=''>Receitas Anuais</a>")
	.concat("</li>")
	.concat("<li><a href=''>Pagamentos em Aberto</a>")
	.concat("</li>")
	.concat("<li><a href='./RelatorioAudienciaSetup'>Audiências</a>")
	.concat("</li>")
	.concat("<li><a href='./RelatorioHonorarioSetup'>Honorários</a>")
	.concat("</li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
                
	return menuHtml;

}

function obterHtmlMensagem(objMensagem) {

	var modalHtml = ""
	.concat("<div class='modal'>")
	.concat("<div class='mensagem centralizado border " + objMensagem.tipo + "'>")
	.concat("<div class='titulo'>")
	.concat("<!-- <img src='' /> -->")
	.concat("<span>" + objMensagem.titulo + "</span>")
	.concat("</div>")
	.concat("<div class='corpo'>")
	.concat("<ul>");
	
	for (var i=0; i < objMensagem.itens.length; i++)
		modalHtml = modalHtml.concat("<li>" + objMensagem.itens[i] + "</li>");
	
	modalHtml = modalHtml.concat("</ul>")
	.concat("</div>")
	.concat("<div class='rodape'>")
	.concat("<input type='button' value='Ok' class='fecha-mensagem' />")
	.concat("</div>")
	.concat("</div>")
	.concat("</div>");
	
	return modalHtml;
	
}

/* VALIDA‚ÌO DE CAMPOS ***************************************************************************************************************************************/

function validaData(data) {
	
	var regExp = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/((19|20)[0-9]{2})$/;
	
	return !regExp.test(data);
	
}

function validaLetrasENumeros(data) {
	
	var regExp = /^([a-zA-Z0-9])/;
	
	return !regExp.test(data);
	
}

function horasTrabalhadas(hora){
	
	return true; //!(hora >= 1 || hora <= 24);
	
}


