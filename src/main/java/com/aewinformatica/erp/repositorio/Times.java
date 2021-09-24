package com.aewinformatica.erp.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.aewinformatica.erp.model.Equipe;

public class Times implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
    public List<Equipe> todos(){
    	
    	return manager.createQuery("from Equipe",Equipe.class).getResultList();
	}
    
    
	
	public Equipe porID(Long id){	
	return	manager.find(Equipe.class,id);
	}
	
	public void salvar(Equipe equipe){
		
		manager.merge(equipe);
	}
	
	public void excluir(Equipe equipe){
		porID(equipe.getId());
		
		manager.remove(equipe);
		
	}
	

}
