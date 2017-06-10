package interfaceDoPrograma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

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
	
	JTextArea painelPrincipal;
	
	public Interface(){
		setTitle("Projeto LP2");
	    setSize(300,300);
	    this.setLayout(null);
	    // Cria uma barra de menu para o JFrame
	    JMenuBar menuBar = new JMenuBar();
	    // Adiciona a barra de menu ao  frame
	    setJMenuBar(menuBar);
	    
	    painelPrincipal = new JTextArea();
	    painelPrincipal.setEditable(false);
	    painelPrincipal.setLineWrap(true);
	    painelPrincipal.setSize(290, 290);
	    painelPrincipal.setBounds(10, 10, 260, 220);
	    this.add(painelPrincipal);
	    painelPrincipal.setText("Dados registrados no sistema \n" + 
	    "Usuarios: \n" + 
	    "Devices: " + "\n" +
	    "Http: " +  "\n" +
	    "Logon: " + "\n");
	    
	    
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
        mItem4 = new JMenuItem("Salvar e sair");
        
        logMenu.add(mItem1);
        arvMenu.add(mItem2);
        relaMenu.add(mItem3);
        sairMenu.add(mItem4);
        
        mItem1.addActionListener(this);
        mItem2.addActionListener(this);
        mItem3.addActionListener(this);
        mItem4.addActionListener(this);
	}

	

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		//Interface tela = new Interface();
		//tela.setVisible(true);
		
		if (evento.getSource() == mItem1){
			InterfaceAddLog addLog = new InterfaceAddLog();
			addLog.setVisible(true);
		}
		if (evento.getSource() == mItem2){
			
		}
		if (evento.getSource() == mItem3){
			
		}
		if (evento.getSource() == mItem4){
			//chamar função gravarCSV;
			System.exit(0);
		}
	}
}

