package br.ufc.quixada.pds.bancoimobiliario.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import br.ufc.quixada.pds.bancoimobiliario.view.enumeration.CaminhoImagensEnum;

public class GUITelaAjuda extends JFrame{
	public GUITelaAjuda() {
		
		getContentPane().setLayout(null);
		
		JLabel labelBackground = new JLabel();
		labelBackground.setBounds(0,0,500,300);
		labelBackground.setIcon(new ImageIcon(GUITelaAjuda.class.getResource(CaminhoImagensEnum.PASTA_IMAGENS.getValor()+"ajuda.png")));
		getContentPane().add(labelBackground);
		
		JLabel tituloTela = new JLabel("Ajuda - Banco Imobiliário");
		tituloTela.setBounds(100,0, 300, 25);
		tituloTela.setForeground(Color.WHITE);
		tituloTela.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
		labelBackground.add(tituloTela);
		
		String textoAjuda = "";
		
		
		JTextArea textAreaAjuda = new JTextArea(textoAjuda);
		textAreaAjuda.setEditable(false);
		textAreaAjuda.setOpaque(false);
		textAreaAjuda.setBounds(50, 25, 400, 250);
		labelBackground.add(textAreaAjuda);
		
		
		
		
		this.setBounds(300,100,500,300);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
