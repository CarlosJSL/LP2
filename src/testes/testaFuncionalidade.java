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
		GeneralTree t = new GeneralTree();
		Atividade a = new Device();
		List<String> l = new ArrayList<String>();
		l.add("Judson");
		l.add("Matheus");
		l.add("Andrade");
		a.setAtividade(l);
		t.addFilho(a);
		System.out.println(t.getNumeroDevice());
	
	}

}
