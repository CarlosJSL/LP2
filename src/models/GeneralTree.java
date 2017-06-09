package models;

import java.util.ArrayList;
import java.util.List;

//Arvore generica responsavel por alocar todos os dados obtidos pelos logs;
public class GeneralTree {
	private String data;
	int frequencia = 0;
	private List<Atividade> filho;
	
	public GeneralTree(){
		super();
		filho = new ArrayList<Atividade>();
		
		Atividade device = new Device();
		Atividade http = new Http();
		Atividade logon = new Logon();
		filho.add(device);
		filho.add(http);
		filho.add(logon);
		
	}
	
	public GeneralTree(String data){
		this();
		frequencia = 1;
		setData(data);
		
	}
		
	public List<Atividade> getFilho() {
		return filho;
	}

	
	public int getNumeroDeFilho(){
		return getFilho().size();
	}
	
	public boolean hasFilho(){
		return (getNumeroDeFilho() > 0);
	}
	
	public void setFilho(List<Atividade> filho) {
		this.filho = filho;
	}
	
	public void addFilho(Atividade newFilho){
		if(newFilho instanceof Device)
			filho.get(0).atividade.add(((Device) newFilho).activity);
		
		if(newFilho instanceof Http)
			filho.get(1).atividade.add(((Http) newFilho).url);
		
		if(newFilho instanceof Logon)
			filho.get(2).atividade.add(((Logon) newFilho).activity);
	}
	
	public void removerFilho(){
		this.filho = new ArrayList<Atividade>();
	}
	
	public void removerFilhoAt(int index) throws IndexOutOfBoundsException{
		filho.remove(index);
	}
	
	public Atividade getFilhoAt(int index) throws IndexOutOfBoundsException {
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