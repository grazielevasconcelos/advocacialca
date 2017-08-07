package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.HoraAdvogadoBean;

public interface IHoraAdvogadoDAO {
	public void cadastrar (HoraAdvogadoBean hrAdvBean);
	public void atualizar (HoraAdvogadoBean hrAdvBean);
	public void remover (int cdHistorico);
	public HoraAdvogadoBean consultar(int cdHistorico);
	public List<HoraAdvogadoBean> listar();
}
