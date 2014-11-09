package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.BorderLayout;
import java.awt.Scrollbar;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.Propriedade;

public class GUIPortfolioJogador extends JFrame{
	
	private JTable table;

	public GUIPortfolioJogador(IJogador iJogador) {
		getContentPane().setLayout(null);
		this.setBounds(100,10,500,300);
		this.setResizable(false);
		
		String nome = "Nome: "+iJogador.getNomeJogador();
		JLabel lableNomeDoJogador = new JLabel(nome);
		lableNomeDoJogador.setBounds(23, 190, 144, 15);
		getContentPane().add(lableNomeDoJogador);
		
		JLabel lableIconeDoJogador = new JLabel(iJogador.getImagemPersonagem());
		lableIconeDoJogador.setBounds(25, 25, 117, 150);
		getContentPane().add(lableIconeDoJogador);
		
		String saldo = "Saldo : " + String.format("%.2f", iJogador.getSaldoJogador());
		JLabel lableSaldoDoJogador = new JLabel(saldo);
		lableSaldoDoJogador.setBounds(23, 210, 144, 15);
		getContentPane().add(lableSaldoDoJogador);
		
		Jogador jogador = iJogador.getJogador();
		
		Iterator<Propriedade> iteratorPropriedades = jogador.getPropriedadesAdquiridas();
		Object[][] dados = new Object[jogador.getQuantidadePropriedades()][2];
		int index = 0;
		while(iteratorPropriedades.hasNext()){
			Propriedade propriedade = iteratorPropriedades.next();
			
			dados[index][0] = propriedade.getNome();
			dados[index][1] = propriedade.getValorDaPropriedade();
			index++;
			
		}

		String[] colunas = {"Nome", "Valor da Propriedade"};
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(175, 32, 320, 228);
		
		
		table = new JTable(dados, colunas);
		table.setBounds(175, 32, 320, 228);
		
		JScrollPane scrollbar = new JScrollPane(table);
		scrollbar.setBounds(399, 32, 17, 225);
		panel.add(scrollbar, BorderLayout.CENTER);
		
		getContentPane().add(panel);
	}
	
}
