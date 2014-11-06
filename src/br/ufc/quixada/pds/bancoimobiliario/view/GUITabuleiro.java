package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.view.exception.LogradourosInsuficientesException;

public class GUITabuleiro extends JFrame {

	private JPanel contentPane;
	private BancoImobiliario bancoImobiliario;
	private List<ILogradouro> iLogradouros;
	private IJogador iJogador1;
	private IJogador iJogador2;
	private IJogador jogadorDaVez;

	/**
	 * Create the frame.
	 * 
	 * @throws LogradourosInsuficientesException
	 */
	public GUITabuleiro(BancoImobiliario bancoImobiliario, IJogador jogador1,
			IJogador jogador2) {
		this.bancoImobiliario = bancoImobiliario;
		this.iJogador1 = jogador1;
		this.iJogador2 = jogador2;

		if (jogador1.isJogador(this.bancoImobiliario.getJogadorDaVez())) {
			this.jogadorDaVez = this.iJogador1;
		} else {
			this.jogadorDaVez = this.iJogador2;
		}

		try {
			initialize();
		} catch (LogradourosInsuficientesException e) {
			JOptionPane.showMessageDialog(this,
					"Erro no arquivo de configuração do jogo.");
			System.exit(0);
		}
	}

	public void initialize() throws LogradourosInsuficientesException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 900, 559);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon background = new ImageIcon(this.getClass().getResource(
				"img/background.png"));
		List<JButton> buttons = new ArrayList<>();

		JButton btnCasa1 = new JButton("New button");
		btnCasa1.setBounds(190, 0, 89, 89);
		contentPane.add(btnCasa1);

		JButton btnCasa8 = new JButton("New button");
		btnCasa8.setBounds(619, 0, 89, 89);
		contentPane.add(btnCasa8);

		JButton btnCasa2 = new JButton("New button");
		btnCasa2.setBounds(283, 0, 50, 78);
		contentPane.add(btnCasa2);

		JButton btnCasa3 = new JButton("New button");
		btnCasa3.setBounds(339, 0, 50, 78);
		contentPane.add(btnCasa3);

		JButton btnCasa4 = new JButton("New button");
		btnCasa4.setBounds(395, 0, 50, 78);
		contentPane.add(btnCasa4);

		JButton btnCasa5 = new JButton("New button");
		btnCasa5.setBounds(451, 0, 50, 78);
		contentPane.add(btnCasa5);

		JButton btnCasa6 = new JButton("New button");
		btnCasa6.setBounds(507, 0, 50, 78);
		contentPane.add(btnCasa6);

		JButton btnCasa7 = new JButton("New button");
		btnCasa7.setBounds(562, 0, 50, 78);
		contentPane.add(btnCasa7);

		JButton btnCasa22 = new JButton("New button");
		btnCasa22.setBounds(190, 431, 89, 89);
		contentPane.add(btnCasa22);

		JButton btnCasa21 = new JButton("New button");
		btnCasa21.setBounds(283, 442, 50, 78);
		contentPane.add(btnCasa21);

		JButton btnCasa20 = new JButton("New button");
		btnCasa20.setBounds(339, 442, 50, 78);
		contentPane.add(btnCasa20);

		JButton btnCasa19 = new JButton("New button");
		btnCasa19.setBounds(395, 442, 50, 78);
		contentPane.add(btnCasa19);

		JButton btnCasa18 = new JButton("New button");
		btnCasa18.setBounds(451, 442, 50, 78);
		contentPane.add(btnCasa18);

		JButton btnCasa17 = new JButton("New button");
		btnCasa17.setBounds(507, 442, 50, 78);
		contentPane.add(btnCasa17);

		JButton btnCasa16 = new JButton("New button");
		btnCasa16.setBounds(562, 442, 50, 78);
		contentPane.add(btnCasa16);

		JButton btnCasa15 = new JButton("New button");
		btnCasa15.setBounds(619, 431, 89, 89);
		contentPane.add(btnCasa15);

		JButton btnCasa28 = new JButton("New button");
		btnCasa28.setBounds(190, 92, 73, 53);
		contentPane.add(btnCasa28);

		JButton btnCasa27 = new JButton("New button");
		btnCasa27.setBounds(190, 148, 73, 53);
		contentPane.add(btnCasa27);

		JButton btnCasa26 = new JButton("New button");
		btnCasa26.setBounds(190, 206, 73, 53);
		contentPane.add(btnCasa26);

		JButton btnCasa25 = new JButton("New button");
		btnCasa25.setBounds(190, 260, 73, 53);
		contentPane.add(btnCasa25);

		JButton btnCasa24 = new JButton("New button");
		btnCasa24.setBounds(190, 317, 73, 53);
		contentPane.add(btnCasa24);

		JButton btnCasa23 = new JButton("New button");
		btnCasa23.setBounds(190, 370, 73, 53);
		contentPane.add(btnCasa23);

		JButton btnCasa10 = new JButton("New button");
		btnCasa10.setBounds(629, 148, 79, 53);
		contentPane.add(btnCasa10);

		JButton btnCasa11 = new JButton("New button");
		btnCasa11.setBounds(629, 206, 79, 53);
		contentPane.add(btnCasa11);

		JButton btnCasa9 = new JButton("New button");
		btnCasa9.setBounds(629, 92, 79, 53);
		contentPane.add(btnCasa9);

		JButton btnCasa12 = new JButton("New button");
		btnCasa12.setBounds(629, 260, 79, 53);
		contentPane.add(btnCasa12);

		JButton btnCasa13 = new JButton("New button");
		btnCasa13.setBounds(629, 317, 79, 53);
		contentPane.add(btnCasa13);

		JButton btnCasa14 = new JButton("New button");
		btnCasa14.setBounds(629, 370, 79, 53);
		contentPane.add(btnCasa14);

		buttons.add(btnCasa1);
		buttons.add(btnCasa2);
		buttons.add(btnCasa3);
		buttons.add(btnCasa4);
		buttons.add(btnCasa5);
		buttons.add(btnCasa6);
		buttons.add(btnCasa7);
		buttons.add(btnCasa8);
		buttons.add(btnCasa9);
		buttons.add(btnCasa10);
		buttons.add(btnCasa11);
		buttons.add(btnCasa12);
		buttons.add(btnCasa13);
		buttons.add(btnCasa14);
		buttons.add(btnCasa15);
		buttons.add(btnCasa16);
		buttons.add(btnCasa17);
		buttons.add(btnCasa18);
		buttons.add(btnCasa19);
		buttons.add(btnCasa20);
		buttons.add(btnCasa21);
		buttons.add(btnCasa22);
		buttons.add(btnCasa23);
		buttons.add(btnCasa24);
		buttons.add(btnCasa25);
		buttons.add(btnCasa26);
		buttons.add(btnCasa27);
		buttons.add(btnCasa28);

		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(562, 89, 50, 53);
		contentPane.add(btnHelp);

		PanelJogador panelJogador1 = new PanelJogador(iJogador1);
		panelJogador1.setBackground(Color.WHITE);
		panelJogador1.setBounds(10, 11, 170, 358);
		contentPane.add(panelJogador1);

		PanelJogador panelJogador2 = new PanelJogador(iJogador2);
		panelJogador2.setOpaque(false);
		panelJogador2.setBounds(718, 12, 170, 358);
		contentPane.add(panelJogador2);

		JLabel labelBackground = new JLabel(background);
		labelBackground.setBounds(0, 0, 900, 520);

		contentPane.add(labelBackground);

		iLogradouros = new ArrayList<>();
		Iterator<Logradouro> logradouros = bancoImobiliario
				.getCasasDoTabuleiro();
		for (int index = 0; index < buttons.size(); index++) {
			if (logradouros.hasNext()) {
				ILogradouro iLogradouro = new ILogradouro(logradouros.next(),
						buttons.get(index));
				iLogradouros.add(iLogradouro);
			} else {
				throw new LogradourosInsuficientesException();
			}
		}
	}

	public BancoImobiliario getBancoImobiliario() {
		return bancoImobiliario;
	}

	public List<ILogradouro> getiLogradouros() {
		return iLogradouros;
	}

	public IJogador getJogador1() {
		return iJogador1;
	}

	public IJogador getJogador2() {
		return iJogador2;
	}

	public IJogador getJogadorDaVez() {
		return jogadorDaVez;
	}

}
