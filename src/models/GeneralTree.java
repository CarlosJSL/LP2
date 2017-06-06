package models;

import java.util.ArrayList;
import java.util.List;

//Arvore generica responsavel por alocar todos os dados obtidos pelos logs;
public class GeneralTree {
	private String data;
	int frequencia = 0;
	private List<GeneralTree> filho;
	
	public GeneralTree(){
		super();
		filho = new ArrayList<GeneralTree>();
		
	}
	
	public GeneralTree(String data){
		this();
		frequencia = 1;
		setData(data);
	}
		
	public List<GeneralTree> getFilho() {
		return filho;
	}

	
	public int getNumeroDeFilho(){
		return getFilho().size();
	}
	
	public boolean hasFilho(){
		return (getNumeroDeFilho() > 0);
	}
	
	public void setFilho(List<GeneralTree> filho) {
		this.filho = filho;
	}
	
	public void addFilho(GeneralTree newFilho){
		filho.add(newFilho);
	}
	
	public void removerFilho(){
		this.filho = new ArrayList<GeneralTree>();
	}
	
	public void removerFilhoAt(int index) throws IndexOutOfBoundsException{
		filho.remove(index);
	}
	
	public GeneralTree getFilhoAt(int index) throws IndexOutOfBoundsException {
		return filho.get(index);
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public boolean equals(GeneralTree node){
		return node.getData().equals(getData());
	}
	
	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	
	
}