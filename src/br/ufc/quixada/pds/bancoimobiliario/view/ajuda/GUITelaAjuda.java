package br.ufc.quixada.pds.bancoimobiliario.view.ajuda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;

import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.ufc.quixada.pds.bancoimobiliario.config.LeitorArquivo;
import br.ufc.quixada.pds.bancoimobiliario.view.enumeration.CaminhoImagensEnum;

public class GUITelaAjuda extends JFrame {

	private LeitorArquivo leitorArquivo;
	
	@Inject
	public GUITelaAjuda(LeitorArquivo leitorArquivo) {
		this.leitorArquivo = leitorArquivo;
	}

	public void inicializar() {
		getContentPane().setLayout(null);

		JLabel labelBackground = new JLabel();
		labelBackground.setBounds(0, 0, 600, 400);
		labelBackground.setIcon(new ImageIcon(GUITelaAjuda.class
				.getResource(CaminhoImagensEnum.PASTA_IMAGENS.getValor()
						+ "ajuda.png")));
		getContentPane().add(labelBackground);

		JLabel tituloTela = new JLabel("Ajuda - Banco Imobiliário");
		tituloTela.setBounds(150, 0, 300, 25);
		tituloTela.setForeground(Color.WHITE);
		tituloTela.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
		labelBackground.add(tituloTela);

		URL caminhoArquivo = this.getClass().getResource("ajuda.txt");

		String textoAjuda = "";
		try {
			textoAjuda = leitorArquivo.lerArquivo(caminhoArquivo.getPath());
		} catch (IOException e) {
			textoAjuda = "Ops, ocorreu um erro ao carregar os dados da aplicação";
		}

		JTextArea textAreaAjuda = new JTextArea(textoAjuda);
		textAreaAjuda.setEditable(false);
		textAreaAjuda.setOpaque(false);
		textAreaAjuda.setLineWrap(true);
		textAreaAjuda.setWrapStyleWord(true);
		textAreaAjuda.setMargin(new Insets(10, 10, 10, 10));

		JScrollPane scrollbar = new JScrollPane(textAreaAjuda);
		scrollbar.setBounds(50, 40, 500, 320);
		scrollbar.setOpaque(false);
		scrollbar.setBackground(Color.WHITE);
		scrollbar.getViewport().setOpaque(false);

		labelBackground.add(scrollbar, BorderLayout.CENTER);

		this.setBounds(300, 100, 600, 400);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
