package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.io.FileNotFoundException;

import models.ArquivoCSV;
import models.ArvoreBinaria;
import models.Atividade;
import models.Device;
import models.GeneralTree;

public class testaFuncionalidade {

	public static void main(String[] args) {
		ArquivoCSV arquivo = new ArquivoCSV();
		Stack t = new Stack();
		t = arquivo.lerCSV("http2.csv");
		arquivo.gravarCSV(t);
	}

}
