package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Interface extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenu logMenu;
	JMenu relaMenu;
	JMenu arvMenu;
	JMenu sairMenu;
	
	JMenuItem mItem1;
	JMenuItem mItem2;
	JMenuItem mItem3;
	JMenuItem mItem4;
	
	public Interface(){
		setTitle("Projeto LP2");
	    setSize(500,500);
	     
	    // Cria uma barra de menu para o JFrame
	    JMenuBar menuBar = new JMenuBar();
	        
	    // Adiciona a barra de menu ao  frame
	    setJMenuBar(menuBar);
	    
	    logMenu = new JMenu("Cadastrar Logs");
		relaMenu = new JMenu("Relatorios");
		arvMenu = new JMenu("Visualizar");
		sairMenu = new JMenu("Sair");
        
        menuBar.add(logMenu);
        menuBar.add(relaMenu);
        menuBar.add(arvMenu);
        menuBar.add(sairMenu);
        
        // definindo os itens de menu
        mItem1 = new JMenuItem("Logs", 69);
        mItem2 = new JMenuItem("Arvore", 70);
        mItem3 = new JMenuItem("Geral");
        
        logMenu.add(mItem1);
        arvMenu.add(mItem2);
        relaMenu.add(mItem3);
        
        mItem1.addActionListener(this);
        mItem2.addActionListener(this);
        mItem3.addActionListener(this);
	}

	

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		Interface tela = new Interface();
		tela.setVisible(true);
		
		if (evento.getSource() == mItem1){
			tela.setTitle("Clientes");
		}
		if (evento.getSource() == mItem2){
			tela.setTitle("Fornecedores");
		}
		if (evento.getSource() == mItem3){
			tela.setTitle("Produtos");
		}
	}
}

