package models;

public class testarTree {

	public static void main(String[] args) {
		GeneralTree t = new GeneralTree();
		No a = new No("A");
		No b = new No("B");
		No c = new No("C");
		No d = new No("D");
		
		t.inserirFilho(a);
		t.inserirFilho(b);
		t.inserirFilho(b);
		t.getFilho().inserirFilho(d);
		t.getFilho().inserirFilho(a);
		
		t.listarTree();
	}

}
