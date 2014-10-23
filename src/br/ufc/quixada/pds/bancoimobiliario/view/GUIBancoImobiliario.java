package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;

public class GUIBancoImobiliario {

	private JFrame frame;
	private BancoImobiliario bancoImobiliario;

	/**
	 * Create the application.
	 */
	public GUIBancoImobiliario(BancoImobiliario bancoImobiliario) {
		this.bancoImobiliario = bancoImobiliario;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(){
		initializeComponents();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIBancoImobiliario.this.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}													
			}
		});
	}

	private JPanel panelTabuleiro;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeComponents() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelPortfolioJogador1 = new JPanel();
		frame.getContentPane().add(panelPortfolioJogador1, BorderLayout.WEST);
		
		JLabel labelJogador1Nome = new JLabel("Jogador 1");
		panelPortfolioJogador1.add(labelJogador1Nome);
		
		
		JPanel panelPortfolioJogador2 = new JPanel();
		frame.getContentPane().add(panelPortfolioJogador2, BorderLayout.EAST);
		
		JLabel labelJogador2Nome = new JLabel("Jogador 2");
		panelPortfolioJogador2.add(labelJogador2Nome);
		
		panelTabuleiro = new JPanel();
		frame.getContentPane().add(panelTabuleiro, BorderLayout.CENTER);
		
		GridBagLayout gbl_panelTabuleiro = new GridBagLayout();
		gbl_panelTabuleiro.columnWidths = new int[]{0, 0};
		gbl_panelTabuleiro.rowHeights = new int[]{0, 0};
		gbl_panelTabuleiro.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelTabuleiro.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTabuleiro.setLayout(gbl_panelTabuleiro);
		
		//TODO refatorar
		configurarTabuleiro();

	}

	public void configurarTabuleiro(){
		List<JLabel> iLogradouros = new ArrayList<>();
	    List<Logradouro> logradouros = this.bancoImobiliario.getCasasDoTabuleiro();
		
		for (int i = 0; i < ConfiguracoesEnum.NUMERO_CASAS.getValor(); i++) {
			iLogradouros.add(new JLabel(logradouros.get(i).obterNome()));
		}
		// Piso da divisão do número de casas por 4 mais 1
		int tamanhoLadoTabuleiro = (ConfiguracoesEnum.NUMERO_CASAS.getValor() / 4) + 1; 
		
		GridBagConstraints posicaoLogradouroLayout = new GridBagConstraints();
		posicaoLogradouroLayout.weightx = 1;
		posicaoLogradouroLayout.weighty = 1;
		int indexLogradouro = 0;
		
		int gridx,gridy;
		
		gridy = 0;
		for (gridx = 0; gridx < (tamanhoLadoTabuleiro); gridx++) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;
			panelTabuleiro.add(iLogradouros.get(indexLogradouro),posicaoLogradouroLayout);
			indexLogradouro++;
		}

		gridx = tamanhoLadoTabuleiro - 1;
		for (gridy = 1; gridy < (tamanhoLadoTabuleiro - 1); gridy++) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;
			panelTabuleiro.add(iLogradouros.get(indexLogradouro),posicaoLogradouroLayout);
			indexLogradouro++;
		}
		
		
		gridy = tamanhoLadoTabuleiro - 1;
		for (gridx = (tamanhoLadoTabuleiro - 1); gridx  >= 0; gridx--) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;
			panelTabuleiro.add(iLogradouros.get(indexLogradouro),posicaoLogradouroLayout);
			indexLogradouro++;
		}

		gridx = 0;
		for (gridy = (tamanhoLadoTabuleiro - 2); gridy >= 1 ; gridy--) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;
			panelTabuleiro.add(iLogradouros.get(indexLogradouro),posicaoLogradouroLayout);
			indexLogradouro++;
		}
		
		posicaoLogradouroLayout.gridx = 0;
		posicaoLogradouroLayout.gridy = 0;
		panelTabuleiro.add(new JLabel("Teste"), posicaoLogradouroLayout);
		
	}
	
}
