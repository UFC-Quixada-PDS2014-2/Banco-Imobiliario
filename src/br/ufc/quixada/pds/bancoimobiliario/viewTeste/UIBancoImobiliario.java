/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.quixada.pds.bancoimobiliario.viewTeste;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;

/**
 *
 * @author sandro
 */
public class UIBancoImobiliario extends javax.swing.JFrame {

	private BancoImobiliario bancoImobiliario;
	private List<ILogradouro> iLogradouros;
	private static final int largura_tela = 701;
	private static final int altura_tela = 730;
	
	
	/**
	 * Creates new form UIBancoImobiliario
	 */
	public UIBancoImobiliario(BancoImobiliario bancoImobiliario) {
		this.bancoImobiliario = bancoImobiliario;
		initComponents();
		initialize();
	}

	private void initialize() {
		setVisible(true);
		//setResizable(false);
		setSize(largura_tela,altura_tela);
		configurarTabuleiro();
	}

	private void configurarTabuleiro() {

		final double weightx = 3;
		final double weighty = 3;		

		final double weightxDefault = 1;
		final double weightyDefault = 1;
		
		iLogradouros = new ArrayList<ILogradouro>();
		Iterator<Logradouro> logradouros = this.bancoImobiliario
				.getCasasDoTabuleiro();

		while (logradouros.hasNext()) {
			ILogradouro iLogradouro = new ILogradouro(logradouros.next());
			iLogradouros.add(iLogradouro);
		}

		// Piso da divisão do número de casas por 4 mais 1
		int tamanhoLadoTabuleiro = (ConfiguracoesEnum.NUMERO_CASAS.getValor() / 4) + 1;


		int gridx, gridy;

		int indexListaLogradouro = 0;

		gridy = 0;
		for (gridx = 0; gridx < (tamanhoLadoTabuleiro); gridx++) {
			GridBagConstraints posicaoLogradouroLayout = new GridBagConstraints();
			posicaoLogradouroLayout.fill = GridBagConstraints.BOTH;

			if((gridx == 0)){
				posicaoLogradouroLayout.weightx = weightx;
				posicaoLogradouroLayout.weighty = weighty;
			}else{
				posicaoLogradouroLayout.weightx = weightxDefault;
				posicaoLogradouroLayout.weighty = weightyDefault;
				
			}
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;

			ILogradouro iLogradouro = iLogradouros.get(indexListaLogradouro);
			iLogradouro.setX(gridx);
			iLogradouro.setY(gridy);
			
			panelTabuleiro.add(iLogradouro.getCasa(),posicaoLogradouroLayout);
			iLogradouro.addObjetoDireita(new JLabel(gridx + " " + gridy));
			
			indexListaLogradouro++;
		}

		gridx = tamanhoLadoTabuleiro - 1;
		for (gridy = 1; gridy < (tamanhoLadoTabuleiro - 1); gridy++) {
			GridBagConstraints posicaoLogradouroLayout = new GridBagConstraints();
			posicaoLogradouroLayout.fill = GridBagConstraints.BOTH;

			posicaoLogradouroLayout.weightx = weightxDefault;
			posicaoLogradouroLayout.weighty = weightyDefault;
			
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;

			ILogradouro iLogradouro = iLogradouros.get(indexListaLogradouro);
			iLogradouro.setX(gridx);
			iLogradouro.setY(gridy);


			panelTabuleiro.add(iLogradouro.getCasa(),posicaoLogradouroLayout);
			iLogradouro.addObjetoDireita(new JLabel(gridx + " " + gridy));
			

			indexListaLogradouro++;
		}

		gridy = tamanhoLadoTabuleiro - 1;
		for (gridx = (tamanhoLadoTabuleiro - 1); gridx >= 0; gridx--) {

			GridBagConstraints posicaoLogradouroLayout = new GridBagConstraints();
			posicaoLogradouroLayout.fill = GridBagConstraints.BOTH;
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;
			if(gridx == 0){
				posicaoLogradouroLayout.weightx = weightx;
				posicaoLogradouroLayout.weighty = weighty;
			}else{
				posicaoLogradouroLayout.weightx = weightxDefault;
				posicaoLogradouroLayout.weighty = weightyDefault;
			}
			
			
			ILogradouro iLogradouro = iLogradouros.get(indexListaLogradouro);
			iLogradouro.setX(gridx);
			iLogradouro.setY(gridy);


			panelTabuleiro.add(iLogradouro.getCasa(),posicaoLogradouroLayout);
			iLogradouro.addObjetoDireita(new JLabel(gridx + " " + gridy));

			indexListaLogradouro++;

		}

		gridx = 0;
		for (gridy = (tamanhoLadoTabuleiro - 2); gridy >= 1; gridy--) {

			GridBagConstraints posicaoLogradouroLayout = new GridBagConstraints();
			posicaoLogradouroLayout.fill = GridBagConstraints.BOTH;
			posicaoLogradouroLayout.weightx = weightxDefault;
			posicaoLogradouroLayout.weighty = weightyDefault;
			
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;

			ILogradouro iLogradouro = iLogradouros.get(indexListaLogradouro);
			iLogradouro.setX(gridx);
			iLogradouro.setY(gridy);
			

			panelTabuleiro.add(iLogradouro.getCasa(), posicaoLogradouroLayout);
			iLogradouro.addObjetoDireita(new JLabel(gridx + " " + gridy));

			indexListaLogradouro++;

		}

		GridBagConstraints posicaoLogradouroLayout = new GridBagConstraints();
		posicaoLogradouroLayout.fill = GridBagConstraints.BOTH;
		posicaoLogradouroLayout.weightx = 1;
		posicaoLogradouroLayout.weighty = 1;
		
		posicaoLogradouroLayout.gridwidth = tamanhoLadoTabuleiro - 4;
		posicaoLogradouroLayout.gridheight = tamanhoLadoTabuleiro - 4;
		posicaoLogradouroLayout.gridx = 2;
		posicaoLogradouroLayout.gridy = 2;

		//panelInformacoes = new PanelInformacoes(bancoImobiliario);
		JPanel panel = new JPanel();
		panelTabuleiro.add(panel, posicaoLogradouroLayout);
		panel.setOpaque(false);
		
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

		panelTabuleiro = new PanelTabuleiro();

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
	private PanelTabuleiro panelTabuleiro;
	// End of variables declaration//GEN-END:variables
}
