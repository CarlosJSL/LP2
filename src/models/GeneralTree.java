package models;
//Arvore generica responsavel por alocar todos os dados obtidos pelos logs;
public class GeneralTree {
	private No root;
	private GeneralTree filho;
	private GeneralTree irmao;
	
	public GeneralTree(){
		//construtor vazio
	}
	
	public No getRoot() {
		return root;
	}

	public void setRoot(No root) {
		this.root = root;
	}

	public GeneralTree getFilho() {
		return filho;
	}

	public void setFilho(GeneralTree filho) {
		this.filho = filho;
	}

	public GeneralTree getIrmao() {
		return irmao;
	}

	public void setIrmao(GeneralTree irmao) {
		this.irmao = irmao;
	}

	public void inserirFilho(No no){
		if(this.root == null){
			this.root = no;
		}else if(this.getFilho() == null){
			this.filho = new GeneralTree();
			this.filho.root = no;
		}else{
			this.filho.inserirIrmao(no);
		}
	}
	
	public void inserirIrmao(No no){
		if(this.getRoot() == null){
			this.root = no;
		}else if(this.getRoot().getDado().equals(no.getDado())){
			this.root.upFrequencia();
		}else{
			if(this.getIrmao() == null){
				this.irmao = new GeneralTree();
			}
			this.irmao.inserirIrmao(no);
		}
	}
	
	public void listarTree(){
		System.out.print( this.getRoot().getDado() + " - Frequencia: " + this.getRoot().getFrequencia() );
		if(this.getIrmao() == null){
			System.out.println("/");
			if(this.getFilho() == null){
				return;
			}
			this.getFilho().listarTree();
		}else{
			System.out.print("/");
			this.getIrmao().listarTree();
			if(this.getFilho() == null){
				System.out.println("");
				return;
			}
			this.getFilho().listarTree();
		}
	}
}
