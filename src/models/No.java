package models;
//--Comentarios temporarios--
//Classe responsavel por representar cada informa��o da arvore. 
//Dado: se refere a informa��o que esta presente no n�.
//Frequencia: representa quantas vezes o mesmo dado foi incerido na arvore.
public class No {
	
	private String dado;
	private int frequencia;
	
	public No(String dado){
		this.dado =dado;
		this.frequencia = 1;
	}
	
	public String getDado() {
		return dado;
	}
	public void setDado(String dado) {
		this.dado = dado;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	
	public void upFrequencia(){
		this.frequencia++;
	}
	
	
}
