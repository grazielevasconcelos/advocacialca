package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.Calendar;

	/**
	 * Classe de um titulo pago
	 * @author Pixel
	 */

public class TituloPagoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public TituloPagoBean(){}
	
	private TituloBean titulo;
	private Calendar dtPagamento;
    private double vlPago;

    
    /**
	 *  M�todo para retorno de um t�tulo
	 *  @param titulo C�digo do t�tulo
	 *  @return titulo Retorna o t�tulo
	 */
	
	public TituloBean getTitulo() {
		return titulo;
	}
	public void setTitulo(TituloBean titulo) {
		this.titulo = titulo;
	}
	
	/**
	 *  M�todo para retorno da data do pagamento
	 *  @param dtPagamento Data do pagamento
	 *  @return dtPagamento Retorna a data do pagamento 
	 */
	
	public Calendar getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(Calendar dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	
	/**
	 *  M�todo para retorno do valor pago
	 *  @param vlPago Valor pago
	 *  @return vlPago Retorna o valor pago
	 */
	
	public double getVlPago() {
		return vlPago;
	}
	public void setVlPago(double vlPago) {
		this.vlPago = vlPago;
	}
	
}
