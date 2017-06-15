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

	/**
	 * Create the frame.
	 */
	public TreeGUI(ArvoreBinaria tree) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		// g.drawString(String.valueOf(tree.root.data), this.getWidth()/2, 30);

		// DrawNode(g, tree,100, 50,2);

		DrawTree(g, 0, getWidth(), 0, getHeight() / tree.getHeight(tree), tree);
	}

	// public void DrawNode(Graphics g,ArvoreBinaria n,int w,int h,int q){
	// g.setFont(new Font("Tahoma", Font.BOLD, 20));
	//
	// if(n!=null){
	//
	// g.drawString(String.valueOf(n.getRaiz().getUsuario().getUser_id()),
	// (this.getWidth()/q)+w, h);
	// if(n.getArvoreEsquerda() !=null)
	// DrawNode(g, n.getArvoreEsquerda(), -w, h*2, q);
	// //DrawNode(g, n.left, -w, h*2, q);
	// //g.drawString(String.valueOf(n.left.data), (this.getWidth()/q)-w, h+50);
	// if(n.getArvoreDireita() !=null)
	// DrawNode(g, n.getArvoreDireita(), w*2, h*2, q);
	// //g.drawString(String.valueOf(n.right.data), (this.getWidth()/q)+w,
	// h+50);
	// }
	//
	//
	//
	//
	// }

	public void DrawTree(Graphics g, int StartWidth, int EndWidth, int StartHeight, int Level, ArvoreBinaria node) {

		String data = String.valueOf(node.getRaiz().getUsuario().getUser_id());
		g.setFont(new Font("Tahoma", Font.BOLD, 10));
		FontMetrics fm = g.getFontMetrics();
		int dataWidth = fm.stringWidth(data);
		int height = fm.getHeight();
		int xSep = Math.min((EndWidth - StartWidth) / 8, 10);
		g.drawString(data, (StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);

		g.drawOval(((StartWidth + EndWidth) / 2) - (dataWidth / 2), StartHeight - 17 + Level / 2, dataWidth, 30);

		if (node.getArvoreEsquerda() != null) {

			g.drawLine((StartWidth + EndWidth) / 2 - xSep, StartHeight + Level / 2 + 5,
					(StartWidth + (StartWidth + EndWidth) / 2) / 2, StartHeight + Level + Level / 2 - height);
			DrawTree(g, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, node.getArvoreEsquerda());
		}

		if (node.getArvoreDireita() != null) {
			g.drawLine((StartWidth + EndWidth) / 2 + xSep, StartHeight + Level / 2 + 5,
					(EndWidth + (StartWidth + EndWidth) / 2) / 2, StartHeight + Level + Level / 2 - height);
			DrawTree(g, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, node.getArvoreDireita());
		}
	}

}
