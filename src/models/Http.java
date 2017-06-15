package models;

import java.util.ArrayList;
import java.util.List;

public class Http extends Atividade {
	List<String> atividade;
	
	public Http(){
		super();
		atividade = new ArrayList<String>();
	}
	
	public List<String> getAtividade() {
		return atividade;
	}

	public void setAtividade(List<String> activity) {
		this.atividade = activity;
	}

	public void addAtividade(String newAtividade){
		this.atividade.add(newAtividade);
	}
	
	public int getTamanho() {
		return atividade.size();
	}

}
