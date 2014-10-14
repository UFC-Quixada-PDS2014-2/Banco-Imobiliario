package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import br.ufc.quixada.pds.bancoimobiliario.controller.BancoImobiliarioControlador;
import br.ufc.quixada.pds.bancoimobiliario.controller.Controlador;

import java.awt.GridBagConstraints;

public class GUIBancoImobiliario {

	private JFrame frame;
	private Controlador controlador;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIBancoImobiliario window = new GUIBancoImobiliario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIBancoImobiliario() {
		// TODO Usar injeção de dependências
		this.controlador = new BancoImobiliarioControlador(); 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelPortfolioJogador1 = new JPanel();
		frame.getContentPane().add(panelPortfolioJogador1, BorderLayout.WEST);
		
		JPanel panelPortfolioJogador2 = new JPanel();
		frame.getContentPane().add(panelPortfolioJogador2, BorderLayout.EAST);
		
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
