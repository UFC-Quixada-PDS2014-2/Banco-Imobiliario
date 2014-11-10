package br.ufc.quixada.pds.bancoimobiliario.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import br.ufc.quixada.pds.bancoimobiliario.view.enumeration.CaminhoImagensEnum;

public class GUITelaAjuda extends JFrame{
	public GUITelaAjuda() {
		
		getContentPane().setLayout(null);
		
		JLabel labelBackground = new JLabel();
		labelBackground.setBounds(0,0,600,400);
		labelBackground.setIcon(new ImageIcon(GUITelaAjuda.class.getResource(CaminhoImagensEnum.PASTA_IMAGENS.getValor()+"ajuda.png")));
		getContentPane().add(labelBackground);
		
		JLabel tituloTela = new JLabel("Ajuda - Banco Imobiliário");
		tituloTela.setBounds(150,0, 300, 25);
		tituloTela.setForeground(Color.WHITE);
		tituloTela.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
		labelBackground.add(tituloTela);
		
		String textoAjuda = "Tipo de Jogo: Banco Imobiliário\n"+
							"Tema do Jogo: Liga dos Campeões da Europa\n" +
							"\n"+
							"O jogo tem 28 casas, onde existem 4 tipos de casas( ponto de partida, lugares especias, imóveis e empresas).\n" +
							"\n"+
							"Ponto de Partida:\n" +
							"É a casa inicial do tabuleiro, quando um jogador da uma volta no tabuleiro, " +
							"parando ou passando pelo ponto de partida, seu saldo será incrementando em R$200.\n" +
							"\n"+
							"Lugares Especiais:\n" +
							"Existem 4 tipos de lugares especiais:\n"+
							"-Lugar Especial Incrementa Saldo:\n" +
							"Parando nessa casa o saldo do jogador será incrementado em R$100.\n"+
							"-Lugar Especial Avança Posição:\n" +
							"Parando nessa casa o jogador terá de avançar 3 posições no tabuleiro.\n"+
							"-Lugar Especial Decrementa Saldo:\n" +
							"Parando nessa casa o jogador terá seu saldo decrementado de R$400.\n"+
							"-Lugar Especial Volta Posição:\n" +
							"Parando nessa casa o jogador terá de voltar 2 posições no tabuleiro.\n" +
							"\n"+
							"Empresas:\n" +
							"São casas que podem ser compradas pelo jogador, todas as empresas tem um valor fixo de R$ 350 " +
							"e um valor de de taxa de R$50, quando um jogador cai em uma empresa que pertença a outro jogador, " +
							"o valor que ele pagará será o valor da taxa multiplicado pelo número dos dados.\n" +
							"\n" +
							"Imóveis:\n" +
							"São casas que os jogadores podem comprar, elas tem um valor de venda que varia de" +
							"imóvel para imóvel, da mesma forma ocorre com seus alugueis.\n" +
							"\n" +
							"Fim do jogo:\n" +
							"O Fim do jogo ocorre quando o saldo de um dos jogadores é negativo ou quando o saldo dele não é" +
							"suficiente para pagar um aluguel, uma taxa ou uma punição.";
		
		
		
		JTextArea textAreaAjuda = new JTextArea(textoAjuda);
		textAreaAjuda.setEditable(false);
		textAreaAjuda.setOpaque(false);
		textAreaAjuda.setLineWrap(true);
		textAreaAjuda.setWrapStyleWord(true);
		textAreaAjuda.setMargin(new Insets(10,10,10,10));
		
		
		
		JScrollPane scrollbar = new JScrollPane(textAreaAjuda);
		scrollbar.setBounds(50, 40, 500, 320);
		scrollbar.setOpaque(false);
		scrollbar.setBackground(Color.WHITE);
		labelBackground.add(scrollbar, BorderLayout.CENTER);
		
		
		
		this.setBounds(300,100,600,400);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
