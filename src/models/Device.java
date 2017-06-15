package models;

import java.util.ArrayList;
import java.util.List;

public class Device extends Atividade {
	List<Atividade> atividade;
	
	public Device(){
		super();
		atividade = new ArrayList<Atividade>();
	}
	
	public List<Atividade> getAtividade() {
		return atividade;
	}

	public void setAtividade(List<Atividade> activity) {
		this.atividade = activity;
	}

	public void addAtividade(Atividade newAtividade){
		this.atividade.add(newAtividade);
	}

	public int getTamanho() {
		return atividade.size();
	}





}
