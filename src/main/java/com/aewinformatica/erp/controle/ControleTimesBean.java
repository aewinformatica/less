package com.aewinformatica.erp.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.aewinformatica.erp.model.Equipe;
import com.aewinformatica.erp.repositorio.Times;
import com.aewinformatica.erp.servico.CadastroTimeServico;

@Named
@ViewScoped
public class ControleTimesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroTimeServico cadastroTime;
	
	private List<Equipe>todosTimes;
	public  List<Equipe> getTodosTimes() {
		return todosTimes;
	}

	@Inject
	private Times times;
	
	public void consultar(){
	
		todosTimes = times.todos();
	}
	
	private Equipe timeSelecionado;
	public Equipe getTimeSelecionado() {
		return timeSelecionado;
	}

	public void setTimeSelecionado(Equipe timeSelecionado) {
		this.timeSelecionado = timeSelecionado;
	}

	private Equipe timeEdicao = new Equipe();
	
	public Equipe getTimeEdicao() {
		return timeEdicao;
	}

	public void setTimeEdicao(Equipe timeEdicao) {
		this.timeEdicao = timeEdicao;
	}

	public void prepararCadastro(){
		timeEdicao = new Equipe();
	}
	
	public void salvar(){
		cadastroTime.salvar(timeEdicao);
		consultar();
	}
	
	public void excluir(){
		cadastroTime.excluir(timeSelecionado);
		timeSelecionado = null;
		consultar();
		
	}

}
