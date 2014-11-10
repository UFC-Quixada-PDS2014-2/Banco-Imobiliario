package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.Propriedade;
import br.ufc.quixada.pds.bancoimobiliario.view.enumeration.CaminhoImagensEnum;

public class GUIPortfolioJogador extends JFrame{
	
	private JTable table;

	public GUIPortfolioJogador(IJogador iJogador) {
		getContentPane().setLayout(null);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JLabel labelBackground = new JLabel();
		labelBackground.setBounds(0,0,500,300);
		labelBackground.setIcon(new ImageIcon(GUIPortfolioJogador.class.getResource(CaminhoImagensEnum.PASTA_IMAGENS.getValor()+"portfolio.png")));
		getContentPane().add(labelBackground);
		
		String nome = "Nome: "+iJogador.getNomeJogador();
		JLabel labelNomeDoJogador = new JLabel(nome);
		labelNomeDoJogador.setBounds(23, 190, 144, 15);
		labelNomeDoJogador.setForeground(Color.WHITE);
		labelBackground.add(labelNomeDoJogador);
		
		JLabel labelIconeDoJogador = new JLabel(iJogador.getImagemPersonagem());
		labelIconeDoJogador.setBounds(25, 25, 117, 150);
		labelBackground.add(labelIconeDoJogador);
		
		String saldo = "Saldo : " + String.format("%.2f", iJogador.getSaldoJogador());
		JLabel labelSaldoDoJogador = new JLabel(saldo);
		labelSaldoDoJogador.setBounds(23, 210, 144, 15);
		labelSaldoDoJogador.setForeground(Color.WHITE);
		labelBackground.add(labelSaldoDoJogador);
		
		Jogador jogador = iJogador.getJogador();
		
		Iterator<Propriedade> iteratorPropriedades = jogador.getPropriedadesAdquiridas();
		Object[][] dados = new Object[jogador.getQuantidadePropriedades()][3];
		int index = 0;
		while(iteratorPropriedades.hasNext()){
			Propriedade propriedade = iteratorPropriedades.next();
			
			dados[index][0] = propriedade.getNome();
			dados[index][1] = propriedade.getValorDaPropriedade();
			dados[index][2] = propriedade.getTaxa();
			index++;
			
		}

		String[] colunas = {"Nome", "Valor", "Valor da Taxa"};
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(175, 13, 320, 228);
		
		
		table = new JTable(dados, colunas);
		table.setBounds(0, 0, 320, 228);
		
		JScrollPane scrollbar = new JScrollPane(table);
		scrollbar.setBounds(399, 32, 17, 225);
		panel.add(scrollbar, BorderLayout.CENTER);
		
		labelBackground.add(panel);
	}
	
}
