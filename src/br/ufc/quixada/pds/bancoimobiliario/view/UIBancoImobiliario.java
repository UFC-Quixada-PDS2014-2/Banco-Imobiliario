/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;

/**
 *
 * @author sandro
 */
public class UIBancoImobiliario extends javax.swing.JFrame {

	private BancoImobiliario bancoImobiliario;
	private List<JLabel> labelsCasas;
	private List<ILogradouro> iLogradouros;
	private PanelInformacoes panelInformacoes;

	/**
	 * Creates new form UIBancoImobiliario
	 */
	public UIBancoImobiliario(BancoImobiliario bancoImobiliario) {
		this.bancoImobiliario = bancoImobiliario;
		initComponents();
		initialize();
	}

	private void initialize() {
		configurarTabuleiro();
		labelsCasas = new ArrayList<JLabel>();
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
		setResizable(false);
	}

	private void configurarTabuleiro() {

		iLogradouros = new ArrayList<ILogradouro>();
		Iterator<Logradouro> logradouros = this.bancoImobiliario
				.getCasasDoTabuleiro();

		while (logradouros.hasNext()) {
			ILogradouro iLogradouro = new ILogradouro(logradouros.next());
			iLogradouros.add(iLogradouro);
		}

		// Piso da divisão do número de casas por 4 mais 1
		int tamanhoLadoTabuleiro = (ConfiguracoesEnum.NUMERO_CASAS.getValor() / 4) + 1;

		GridBagConstraints posicaoLogradouroLayout = new GridBagConstraints();
		posicaoLogradouroLayout.fill = GridBagConstraints.BOTH;
		posicaoLogradouroLayout.weightx = 1;
		posicaoLogradouroLayout.weighty = 1;
		int indexListaLogradouro = 0;

		int gridx, gridy;

		boolean testeImagem = true;

		gridy = 0;
		for (gridx = 0; gridx < (tamanhoLadoTabuleiro); gridx++) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;

			ILogradouro iLogradouro = iLogradouros.get(indexListaLogradouro);
			iLogradouro.setX(gridx);
			iLogradouro.setY(gridy);

			ImageIcon icon = null;
			if (testeImagem) {
				icon = new ImageIcon("img/teste1.jpeg");
				testeImagem = !testeImagem;
			} else {
				icon = new ImageIcon("img/teste2.jpeg");
				testeImagem = !testeImagem;
			}
			JLabel casa = new JLabel(icon);

			panelTabuleiro.add(casa, posicaoLogradouroLayout);

			indexListaLogradouro++;
		}

		gridx = tamanhoLadoTabuleiro - 1;
		for (gridy = 1; gridy < (tamanhoLadoTabuleiro - 1); gridy++) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;

			ILogradouro iLogradouro = iLogradouros.get(indexListaLogradouro);
			iLogradouro.setX(gridx);
			iLogradouro.setY(gridy);

			ImageIcon icon = null;
			if (testeImagem) {
				icon = new ImageIcon("img/teste1.jpeg");
				testeImagem = !testeImagem;
			} else {
				icon = new ImageIcon("img/teste2.jpeg");
				testeImagem = !testeImagem;
			}
			JLabel casa = new JLabel(icon);

			panelTabuleiro.add(casa, posicaoLogradouroLayout);

			indexListaLogradouro++;
		}

		gridy = tamanhoLadoTabuleiro - 1;
		for (gridx = (tamanhoLadoTabuleiro - 1); gridx >= 0; gridx--) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;

			ILogradouro iLogradouro = iLogradouros.get(indexListaLogradouro);
			iLogradouro.setX(gridx);
			iLogradouro.setY(gridy);

			ImageIcon icon = null;
			if (testeImagem) {
				icon = new ImageIcon("img/teste1.jpeg");
				testeImagem = !testeImagem;
			} else {
				icon = new ImageIcon("img/teste2.jpeg");
				testeImagem = !testeImagem;
			}
			JLabel casa = new JLabel(icon);

			panelTabuleiro.add(casa, posicaoLogradouroLayout);

			indexListaLogradouro++;

		}

		gridx = 0;
		for (gridy = (tamanhoLadoTabuleiro - 2); gridy >= 1; gridy--) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;

			ILogradouro iLogradouro = iLogradouros.get(indexListaLogradouro);
			iLogradouro.setX(gridx);
			iLogradouro.setY(gridy);

			ImageIcon icon = null;
			if (testeImagem) {
				icon = new ImageIcon("img/teste1.jpeg");
				testeImagem = !testeImagem;
			} else {
				icon = new ImageIcon("img/teste2.jpeg");
				testeImagem = !testeImagem;
			}
			JLabel casa = new JLabel(icon);

			panelTabuleiro.add(casa, posicaoLogradouroLayout);

			indexListaLogradouro++;

		}

		posicaoLogradouroLayout.weightx = 1;
		posicaoLogradouroLayout.weighty = 1;

		posicaoLogradouroLayout.gridwidth = tamanhoLadoTabuleiro - 2;
		posicaoLogradouroLayout.gridheight = tamanhoLadoTabuleiro - 2;
		posicaoLogradouroLayout.gridx = 1;
		posicaoLogradouroLayout.gridy = 1;

		panelInformacoes = new PanelInformacoes(bancoImobiliario);
		panelTabuleiro.add(panelInformacoes, posicaoLogradouroLayout);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panelTabuleiro = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		GridBagLayout gbl_panelTabuleiro = new GridBagLayout();
		gbl_panelTabuleiro.columnWidths = new int[] { 0, 0 };
		gbl_panelTabuleiro.rowHeights = new int[] { 0, 0 };
		gbl_panelTabuleiro.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelTabuleiro.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelTabuleiro.setLayout(gbl_panelTabuleiro);

		getContentPane().add(panelTabuleiro, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel panelTabuleiro;
	// End of variables declaration//GEN-END:variables
}
