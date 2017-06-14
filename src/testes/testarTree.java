package testes;

import java.util.List;
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

		Stack informacao = new Stack();

		ArvoreBinaria arvore = new ArvoreBinaria();

		Atividade atividade = new Atividade();
		Usuario usuario = new Usuario();
		ArquivoCSV arquivo = new ArquivoCSV();
		NoArvoreBinaria no = new NoArvoreBinaria(usuario);

//		informacao = arquivo.lerCSV("logUsuario.csv");
//		arquivo.gravarCSV(informacao);
		
//		informacao = arquivo.lerCSV("device2.csv");
//		arquivo.gravarCSV(informacao);
//		
//		informacao = arquivo.lerCSV("http2.csv");
//		arquivo.gravarCSV(informacao);
//		
//		informacao = arquivo.lerCSV("logon2.csv");
//		arquivo.gravarCSV(informacao);
//		
		arvore = arquivo.recuperarEstadoAnterior("backup/usuarios.csv", "backup/device.csv", "backup/http.csv",
				"backup/logon.csv");
		arvore.percorrerInOrder();

	}

}
