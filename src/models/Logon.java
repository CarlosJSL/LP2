package models;

import java.util.ArrayList;
import java.util.List;

public class Logon extends Atividade {
	List<Atividade> atividade;
	private int[] histograma = new int[24];
	
	public Logon(){
		super();
		atividade = new ArrayList<Atividade>();
		for(int i = 0; i < 24; i++){
			histograma[i] = 0;
		}	
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
	
	public void carregarHistograma(){
		for(int i = 0; i < this.atividade.size(); i++){
			String substring = atividade.get(i).getDate().substring(11, 13);
			histograma[Integer.parseInt(substring)]++;
		}
	}
	
	public void imprimirHistograma(){
		for(int i = 0; i<24;i++){
			System.out.println(i + " = " + histograma[i]);
		}
	}
	
	public int buscaPorIntervalo(int hora){
		return histograma[hora];
	}
}
