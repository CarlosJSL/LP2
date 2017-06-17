package interfaceDoPrograma;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.ArvoreBinaria;

/**Classe que contém métodos responsáveis por criar o componente aonde a árvore será inserida
 * @author Carlos José
 * @author Judson Matheus
 */
public class TreeGUI extends JFrame {
	private JPanel contentPane;
	public ArvoreBinaria tree;
	public DrawTree drawer;
	
	/**
	  * Construtor que mostra a visualização de uma árvore binária
	  * que contém usuários 
	  * 
	  * @param	tree ArvoreBinaria - Árvore Binária que contem os usuários	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
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

