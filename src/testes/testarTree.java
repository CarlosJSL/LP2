package testes;

import java.util.HashMap;

import models.GeneralTree;
import models.No;
import models.Usuario;

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
		//
		// t.listarTree();
		Usuario usuario = new Usuario();

		usuario.setUser_id("teste");

		HashMap<String, GeneralTree> hmap = new HashMap<String, GeneralTree>();

		hmap.put(usuario.getUser_id(), t);

		hmap.get(usuario).listarTree();

	}

}
