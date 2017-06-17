package interfaceDoPrograma;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.ArvoreBinaria;

public class TreeGUI extends JFrame {
	private JPanel contentPane;
	public ArvoreBinaria tree;
	public DrawTree drawer;

	public TreeGUI(ArvoreBinaria tree) {
		setBounds(100, 100, 500, 500);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		drawer = new DrawTree(tree);

		contentPane.add(drawer);
		setContentPane(contentPane);
		this.tree = tree;
		setVisible(true);
		
	}
}

class DrawTree extends JPanel {

	public ArvoreBinaria tree;

	public DrawTree(ArvoreBinaria tree) {
		this.tree = tree;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setFont(new Font("Tahoma", Font.BOLD, 20));
		DrawTree(g, 0, getWidth(), 0, getHeight() / tree.getAltura(tree), tree);
		
	}

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
