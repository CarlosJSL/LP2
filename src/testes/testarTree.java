package testes;

import java.util.Stack;

import models.ArquivoCSV;
import models.ArvoreBinaria;
import models.Atividade;
import models.Device;
import models.GeneralTree;
import models.NoArvoreBinaria;
//import models.GeneralTree;
//import models.No;
import models.Usuario;

public class testarTree {

	public static void main(String[] args) {
		
		GeneralTree t = new GeneralTree();
		
		Stack informacao= new Stack();
		
		ArvoreBinaria arvore = new ArvoreBinaria();
		
		Atividade atividade = new Atividade();
		Usuario usuario = new Usuario();
		ArquivoCSV arquivo = new ArquivoCSV();
		NoArvoreBinaria no = new NoArvoreBinaria(usuario);
		
//		informacao = arquivo.lerCSVLogUsuario("LogUsuarios/2019-09.csv");
		informacao = arquivo.lerCSV("device2.csv");
//		atividade = (Atividade)informacao.pop();
		arquivo.gravarCSV(informacao);
		
//		arquivo.gravarCSV(informacao);
		
//		arvore = arquivo.gravarCSVLogUsuario(usuarios);
//		
//		arvore.percorrerInOrder();
//
//		usuario = arvore.busca("AXB0007");
//		
//		
//		t = usuario.getTree();
//		GeneralTree raiz = new GeneralTree(usuario.getEmployee_name());
//		raiz.addFilho(t);
//		
//		System.out.println(raiz.getData());
		

	}

}
