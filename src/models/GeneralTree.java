package models;

import java.util.ArrayList;
import java.util.List;

//Arvore generica responsavel por alocar todos os dados obtidos pelos logs;
public class GeneralTree {
	private String data;
	int frequencia = 0;
	private Device filhoDevice;
	private Http filhoHttp;
	private Logon filhoLogon;
	
	public GeneralTree(){
		super();
		filhoDevice = new Device();
		filhoHttp = new Http();
		filhoLogon = new Logon();
	}
	
	public GeneralTree(String data){
		this();
		frequencia = 1;
		setData(data);
		
	}
		
	/*public List<Atividade> getFilho() {
		return filho;
	}*/

	
	public Device getFilhoDevice() {
		return filhoDevice;
	}

	public void setFilhoDevice(Device filhoDevice) {
		this.filhoDevice = filhoDevice;
	}

	public Http getFilhoHttp() {
		return filhoHttp;
	}

	public void setFilhoHttp(Http filhoHttp) {
		this.filhoHttp = filhoHttp;
	}

	public Logon getFilhoLogon() {
		return filhoLogon;
	}

	public void setFilhoLogon(Logon filhoLogon) {
		this.filhoLogon = filhoLogon;
	}

	/*public int getNumeroDeFilho(){
		return getFilho().size();
	}*/
	
/*	public boolean hasFilho(){
		return (getNumeroDeFilho() > 0);
	}*/
	/*
	public void setFilho(List<Atividade> filho) {
		this.filho = filho;
	}
	*/
	
	public void addFilho(Atividade newFilho){
		if(newFilho instanceof Device)
			filhoDevice.addAtividade(((Device) newFilho).getActivity());
		
		if(newFilho instanceof Http)
			filhoHttp.addAtividade(((Http) newFilho).getUrl());
		
		if(newFilho instanceof Logon)
			filhoLogon.addAtividade(((Logon) newFilho).getActivity());
	}
	
	/*public void removerFilho(){
		this.filho = new ArrayList<Atividade>();
	}*/
	
	/*public void removerFilhoAt(int index) throws IndexOutOfBoundsException{
		filho.remove(index);
	}*/
	
	/*public Atividade getFilhoAt(int index) throws IndexOutOfBoundsException {
		return filho.get(index);
	}*/
	
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