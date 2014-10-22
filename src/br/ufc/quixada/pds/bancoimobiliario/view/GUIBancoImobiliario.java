package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.inject.Inject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufc.quixada.pds.bancoimobiliario.controller.Controlador;
import br.ufc.quixada.pds.bancoimobiliario.controller.ControladorBancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;

public class GUIBancoImobiliario {

	private JFrame frame;
	private Controlador controlador;
	
	/**
	 * Create the application.
	 */
	public GUIBancoImobiliario(Controlador controlador) {
		this.controlador = controlador;
	}
	
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
		
		JPanel panelTabuleiro = new JPanel();
		frame.getContentPane().add(panelTabuleiro, BorderLayout.CENTER);
		
		GridBagLayout gbl_panelTabuleiro = new GridBagLayout();
		gbl_panelTabuleiro.columnWidths = new int[]{0, 0};
		gbl_panelTabuleiro.rowHeights = new int[]{0, 0};
		gbl_panelTabuleiro.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelTabuleiro.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTabuleiro.setLayout(gbl_panelTabuleiro);

		//TODO		
		this.controlador.configurar(panelTabuleiro);
	}

}
