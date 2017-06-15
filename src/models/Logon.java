package models;

import java.util.ArrayList;
import java.util.List;

public class Logon extends Atividade {
	List<Atividade> atividade;
	
	public Logon(){
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
