package interfaceDoPrograma;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

import models.ArvoreBinaria;

/**Classe que contém métodos responsáveis por desenhar uma árvore binária na tela
 * @author Carlos José
 * @author Judson Matheus
 */
class DrawTree extends JPanel {

	public ArvoreBinaria tree;
	
	/**
	  * Construtor que recebe uma árvore cuja será visualizada na tela
	  * 
	  * @param	tree ArvoreBinaria -  Árvore Binária cuja será visualizada na tela
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public DrawTree(ArvoreBinaria tree) {
		this.tree = tree;
	}
	
	/**
	  * Desenha a árvore na tela
	  * 
	  * @param	g Graphics - classe responsável por desenhar a visualização da árvore na tela
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	@Override
	protected void paintComponent(Graphics g) {
		g.setFont(new Font("Tahoma", Font.BOLD, 20));
		DrawTree(g, 0, getWidth(), 0, getHeight() / tree.getAltura(tree), tree);
		
	}
	
	/**
	  * Desenha o conteúdo da árvore no contexto gráfico especificado
	  * 
	  * @param	g Graphics- contexto gráfico
	  * @param	comprimento inicial int- comprimento inicial do componente que a árvore será desenhada
	  * @param	comprimentoFinal int - comprimento final do componente que a árvore será desenhada
	  * @param	alturaInicial int - altura inicial
	  * @param	nivelDaArvore int - tamanho da árvore na tela
	  * @param	node ArvoreBinaria - árvore binária que será desenhada
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void DrawTree(Graphics g, int comprimentoInicial, int comprimentoFinal, int alturaInicial, int nivelDaArvore, ArvoreBinaria node) {
		String data = String.valueOf(node.getRaiz().getUsuario().getUser_id());
		
		g.setFont(new Font("Tahoma", Font.BOLD, 10));
		FontMetrics fm = g.getFontMetrics();
		int dataWidth = fm.stringWidth(data);
		int height = fm.getHeight();
		
		int xSep = Math.min((comprimentoFinal - comprimentoInicial) / 8, 10);
		
		g.drawString(data, (comprimentoInicial + comprimentoFinal) / 2 - dataWidth / 2, alturaInicial + nivelDaArvore / 2);
		g.drawOval(((comprimentoInicial + comprimentoFinal) / 2) - (dataWidth / 2), alturaInicial - 17 + nivelDaArvore / 2, dataWidth, 30);

		if (node.getArvoreEsquerda() != null) {
			g.drawLine((comprimentoInicial + comprimentoFinal) / 2 - xSep, alturaInicial + nivelDaArvore / 2 + 5,
					(comprimentoInicial + (comprimentoInicial + comprimentoFinal) / 2) / 2, alturaInicial + nivelDaArvore + nivelDaArvore / 2 - height);
			DrawTree(g, comprimentoInicial, (comprimentoInicial + comprimentoFinal) / 2, alturaInicial + nivelDaArvore, nivelDaArvore, node.getArvoreEsquerda());
			
		}

		if (node.getArvoreDireita() != null) {
			g.drawLine((comprimentoInicial + comprimentoFinal) / 2 + xSep, alturaInicial + nivelDaArvore / 2 + 5,
					(comprimentoFinal + (comprimentoInicial + comprimentoFinal) / 2) / 2, alturaInicial + nivelDaArvore + nivelDaArvore / 2 - height);
			DrawTree(g, (comprimentoInicial + comprimentoFinal) / 2, comprimentoFinal, alturaInicial + nivelDaArvore,
					nivelDaArvore, node.getArvoreDireita());

		}
	}
}
