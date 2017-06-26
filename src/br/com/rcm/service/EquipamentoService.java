package br.com.rcm.service;

import java.util.List;

import br.com.rcm.dao.EquipamentoDAO;
import br.com.rcm.model.Equipamento;

public class EquipamentoService {
	
	private EquipamentoDAO dao = new EquipamentoDAO();
	
	public void criar (Equipamento equi){
		dao.criar(equi);
	}
	
	public void alterar (Equipamento equi){
		dao.alterar(equi);
	}
	
	public void apagar (Equipamento equi){
		dao.apagar(equi);
	}
	
	public Equipamento carregar (int id){
		return dao.carregar(id);
	}
	
	public List <Equipamento> listar (){
		return dao.listar();
	}
	
	public List <Equipamento> buscar (String chave){
		return dao.buscar(chave.toUpperCase());
	}


	public int geraId(){
		List <Equipamento> equi;
		equi = this.listar();
		int cont = 0;
		for(int i =0; i < equi.size(); i++){
			cont++;
		}
		return cont+1;
	}

}
