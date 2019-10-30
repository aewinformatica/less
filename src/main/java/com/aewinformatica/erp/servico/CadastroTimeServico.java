package com.aewinformatica.erp.servico;

import java.io.Serializable;

import javax.inject.Inject;

import com.aewinformatica.erp.model.Equipe;
import com.aewinformatica.erp.repositorio.Times;
import com.aewinformatica.erp.util.Transacional;

public class CadastroTimeServico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Times times;
	
	@Transacional
	public void salvar(Equipe equipe){
		
		times.salvar(equipe);
	}
	

	@Transacional
	public void excluir(Equipe equipe){

	times.excluir(equipe);
	}
	
}