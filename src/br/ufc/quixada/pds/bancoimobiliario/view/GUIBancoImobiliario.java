package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;

import java.awt.Color;
import java.awt.Toolkit;

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/sandro/git/Banco-Imobiliario/img/background.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelTabuleiro = new JPanel();
		frame.getContentPane().add(panelTabuleiro, BorderLayout.CENTER);
		
		GridBagLayout gbl_panelTabuleiro = new GridBagLayout();
		gbl_panelTabuleiro.columnWidths = new int[]{0, 0};
		gbl_panelTabuleiro.rowHeights = new int[]{0, 0};
		gbl_panelTabuleiro.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelTabuleiro.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTabuleiro.setLayout(gbl_panelTabuleiro);
		
		//TODO refatorar
		//configurarTabuleiro();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		posicaoLogradouroLayout.fill = GridBagConstraints.BOTH;
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
		
		posicaoLogradouroLayout.weightx = 1;
		posicaoLogradouroLayout.weighty = 1;
		
		posicaoLogradouroLayout.gridwidth = tamanhoLadoTabuleiro -2;
		posicaoLogradouroLayout.gridheight = tamanhoLadoTabuleiro -2;
		posicaoLogradouroLayout.gridx = 1;
		posicaoLogradouroLayout.gridy = 1;
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panelTabuleiro.add(panel,posicaoLogradouroLayout);
		
	}
	
	
}
