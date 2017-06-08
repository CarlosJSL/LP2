package testes;

import java.util.Stack;

import models.ArquivoCSV;
import models.ArvoreBinaria;
import models.GeneralTree;

//import models.GeneralTree;
//import models.No;
import models.Usuario;

public class testarTree {

	public static void main(String[] args) {
		
		GeneralTree t = new GeneralTree();
		
		Stack <Usuario> usuarios = new Stack<Usuario>();
		
		ArvoreBinaria arvore = new ArvoreBinaria();

		Usuario usuario = new Usuario();
		ArquivoCSV arquivo = new ArquivoCSV();
		
		
		usuarios = arquivo.lerCSV("LogUsuarios/2019-09.csv");
		
		arvore = arquivo.gravarCSV(usuarios);
		
		arvore.percorrerInOrder();

		usuario = arvore.busca("AXB0007");
		
		
		t = usuario.getTree();
		GeneralTree raiz = new GeneralTree(usuario.getEmployee_name());
		raiz.addFilho(t);
		
		System.out.println(raiz.getData());
		

	}

}
