package testes;

import java.util.Stack;

import interfaceDoPrograma.TreeGUI;
import models.ArquivoCSV;
import models.ArvoreBinaria;
import models.Atividade;
import models.GeneralTree;
import models.NoArvoreBinaria;
//import models.GeneralTree;
//import models.No;
import models.Usuario;

public class testarTree {

	public static void main(String[] args) {


		Stack informacao = new Stack();

		ArvoreBinaria arvore = new ArvoreBinaria();


		ArquivoCSV arquivo = new ArquivoCSV();


		informacao = arquivo.lerCSV("logUsuario.csv");
		arquivo.gravarCSV(informacao);
		
		informacao = arquivo.lerCSV("device2.csv");
		arquivo.gravarCSV(informacao);
		
		informacao = arquivo.lerCSV("http2.csv");
		arquivo.gravarCSV(informacao);
		
		informacao = arquivo.lerCSV("logon2.csv");
		arquivo.gravarCSV(informacao);
		
		arvore = arquivo.recuperarEstadoAnterior("backup/usuarios.csv", "backup/device.csv", "backup/http.csv",
				"backup/logon.csv");
		
		System.out.println(arvore.busca("KEE0997").getTree().getNumeroLogon());
//		TreeGUI tree = new TreeGUI(arvore);

	}

}
