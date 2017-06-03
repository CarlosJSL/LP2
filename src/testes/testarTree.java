package testes;

import java.util.Stack;

import models.ArquivoCSV;
import models.ArvoreBinaria;
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
		Stack <Usuario> usuarios = new Stack<Usuario>();
//		t.inserirFilho(a);
//		t.inserirFilho(b);
//		t.inserirFilho(b);
//		t.getFilho().inserirFilho(d);
//		t.getFilho().inserirFilho(a);
		
		ArvoreBinaria arvore = new ArvoreBinaria();

		Usuario usuario = new Usuario();
		ArquivoCSV arquivo = new ArquivoCSV();
		
		
		usuarios = arquivo.lerCSV("LogUsuarios/2019-09.csv");
		
		arvore = arquivo.gravarCSV(usuarios);
		
		arvore.percorrerInOrder();


	}

}
