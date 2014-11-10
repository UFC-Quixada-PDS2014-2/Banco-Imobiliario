package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.view.enumeration.CaminhoImagensEnum;
import br.ufc.quixada.pds.bancoimobiliario.view.enumeration.DeslocamentoPinoEnum;
import br.ufc.quixada.pds.bancoimobiliario.view.exception.LogradourosInsuficientesException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUITabuleiro extends JFrame {

	private JPanel contentPane;
	private BancoImobiliario bancoImobiliario;
	private List<ILogradouro> iLogradouros;
	private IJogador iJogador1;
	private IJogador iJogador2;
	private JComboBox<Integer> comboBoxDado2;
	private JComboBox<Integer> comboBoxDado1;
	private JButton btnJogar;
	private JLabel pinoJogador1;
	private JLabel pinoJogador2;
	private PanelJogador panelJogador1;
	private PanelJogador panelJogador2;

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

		try {
			inicializar();
		} catch (LogradourosInsuficientesException e) {
			JOptionPane.showMessageDialog(this,
					"Erro no arquivo de configuração do jogo.");
			System.exit(0);
		}
	}

	private void inicializar() throws LogradourosInsuficientesException {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 900, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inicializarPinosJogadores();
		inicializarBotoesTabuleiro();
		inicializarPanelJogadores();
		
		ImageIcon background = new ImageIcon(this.getClass().getResource(
				"img/background.png"));

				JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(GUITabuleiro.class.getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/background.png")));
		lblBackground.setBounds(0, 0, 910, 550);
		contentPane.add(lblBackground);

	}

	private void inicializarPinosJogadores(){
		pinoJogador1 = new JLabel();
		pinoJogador1.setIcon(new ImageIcon(GUITabuleiro.class.getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/jogador1.png")));
		pinoJogador2 = new JLabel();
		pinoJogador2.setIcon(new ImageIcon(GUITabuleiro.class.getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/jogador2.png")));
		
		contentPane.add(pinoJogador1);
		iJogador1.setPino(pinoJogador1);
		iJogador1.setDeslocamentoPino(DeslocamentoPinoEnum.PINO_SUPERIOR_ESQUERDA);
		contentPane.add(pinoJogador2);
		iJogador2.setPino(pinoJogador2);
		iJogador2.setDeslocamentoPino(DeslocamentoPinoEnum.PINO_INFERIOR_DIREITA);
		
		
	}
	
	private void inicializarPanelJogadores(){
		panelJogador1 = new PanelJogador(iJogador1);
		panelJogador1.setBackground(Color.WHITE);
		panelJogador1.setBounds(10, 147, 170, 358);
		contentPane.add(panelJogador1);

		panelJogador2 = new PanelJogador(iJogador2);
		panelJogador2.setOpaque(false);
		panelJogador2.setBounds(718, 147, 170, 358);
		contentPane.add(panelJogador2);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelCentral.setBounds(290, 89, 339, 342);
		contentPane.add(panelCentral);
		
				JButton btnHelp = new JButton("Help");
				
				comboBoxDado1 = new JComboBox<Integer>();
				comboBoxDado1.setModel(new DefaultComboBoxModel(new Integer[] {1, 2, 3, 4, 5, 6}));
				
				comboBoxDado2 = new JComboBox();
				comboBoxDado2.setModel(new DefaultComboBoxModel(new Integer[] {1, 2, 3, 4, 5, 6}));
								
				btnJogar = new JButton();
			    btnJogar.setBackground(Color.WHITE);
			    btnJogar.setIcon(new ImageIcon(GUITelaInicial.class.getResource(CaminhoImagensEnum.PASTA_IMAGENS.getValor()+"Bola.png")));
			    btnJogar.setOpaque(false);
			    btnJogar.setContentAreaFilled(false);
			    btnJogar.setBorderPainted(false);
			    btnJogar.setBorder(null);
			    btnJogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    btnJogar.setToolTipText("Clique para realizar jogada");
				
				GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
				gl_panelCentral.setHorizontalGroup(
					gl_panelCentral.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelCentral.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(comboBoxDado2, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBoxDado1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnJogar)
							.addContainerGap(148, Short.MAX_VALUE))
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addContainerGap(261, Short.MAX_VALUE)
							.addComponent(btnHelp)
							.addContainerGap())
				);
				gl_panelCentral.setVerticalGroup(
					gl_panelCentral.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
								.addComponent(btnJogar)
								.addGroup(gl_panelCentral.createSequentialGroup()
									.addComponent(comboBoxDado1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxDado2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(56))
				);
				
				btnJogar.setBounds(530, 430, 70, 70);
				panelCentral.setLayout(gl_panelCentral);
				
				JLabel realizarJogadaLabel = new JLabel("Jogar");
				realizarJogadaLabel.setBounds(145, 285, 200, 20);
				panelCentral.add(realizarJogadaLabel);

	}

	private List<JButton> botoesCasas;

	private void inicializarBotoesTabuleiro() throws LogradourosInsuficientesException{
		adicionarBotoesNoTabuleiro();
		
		for (JButton botaoCasa : botoesCasas) {
			contentPane.add(botaoCasa);
		}
		
		iLogradouros = new ArrayList<>();
		Iterator<Logradouro> logradouros = bancoImobiliario
				.getCasasDoTabuleiro();
		for (int index = 0; index < botoesCasas.size(); index++) {
			if (logradouros.hasNext()) {
				ILogradouro iLogradouro = new ILogradouro(logradouros.next(),
						botoesCasas.get(index));
				iLogradouros.add(iLogradouro);
			} else {
				throw new LogradourosInsuficientesException();
			}
		}

	}
	
	private void adicionarBotoesNoTabuleiro(){
		botoesCasas = new ArrayList<>();

		JButton btnCasa1 = new JButton();
		btnCasa1.setBounds(192, 0, 89, 89);

		JButton btnCasa8 = new JButton();
		btnCasa8.setBounds(621, 0, 89, 89);

		JButton btnCasa2 = new JButton();
		btnCasa2.setBounds(285, 0, 50, 78);

		JButton btnCasa3 = new JButton();
		btnCasa3.setBounds(341, 0, 50, 78);

		JButton btnCasa4 = new JButton();
		btnCasa4.setBounds(397, 0, 50, 78);

		JButton btnCasa5 = new JButton();
		btnCasa5.setBounds(453, 0, 50, 78);

		JButton btnCasa6 = new JButton();
		btnCasa6.setBounds(509, 0, 50, 78);

		JButton btnCasa7 = new JButton();
		btnCasa7.setBounds(564, 0, 50, 78);

		JButton btnCasa22 = new JButton();
		btnCasa22.setBounds(192, 431, 89, 89);

		JButton btnCasa21 = new JButton();
		btnCasa21.setBounds(285, 442, 50, 78);

		JButton btnCasa20 = new JButton();
		btnCasa20.setBounds(341, 442, 50, 78);

		JButton btnCasa19 = new JButton();
		btnCasa19.setBounds(397, 442, 50, 78);

		JButton btnCasa18 = new JButton();
		btnCasa18.setBounds(453, 442, 50, 78);

		JButton btnCasa17 = new JButton();
		btnCasa17.setBounds(509, 442, 50, 78);

		JButton btnCasa16 = new JButton();
		btnCasa16.setBounds(564, 442, 50, 78);

		JButton btnCasa15 = new JButton();
		btnCasa15.setBounds(621, 431, 89, 89);

		JButton btnCasa28 = new JButton();
		btnCasa28.setBounds(192, 92, 73, 53);

		JButton btnCasa27 = new JButton();
		btnCasa27.setBounds(192, 148, 73, 53);

		JButton btnCasa26 = new JButton();
		btnCasa26.setBounds(192, 206, 73, 53);

		JButton btnCasa25 = new JButton();
		btnCasa25.setBounds(192, 260, 73, 53);

		JButton btnCasa24 = new JButton();
		btnCasa24.setBounds(192, 317, 73, 53);

		JButton btnCasa23 = new JButton();
		btnCasa23.setBounds(192, 375, 73, 53);

		JButton btnCasa10 = new JButton();
		btnCasa10.setBounds(631, 148, 79, 53);

		JButton btnCasa11 = new JButton();
		btnCasa11.setBounds(631, 206, 79, 53);

		JButton btnCasa9 = new JButton();
		btnCasa9.setBounds(631, 92, 79, 53);

		JButton btnCasa12 = new JButton();
		btnCasa12.setBounds(631, 260, 79, 53);

		JButton btnCasa13 = new JButton();
		btnCasa13.setBounds(631, 317, 79, 53);

		JButton btnCasa14 = new JButton();
		btnCasa14.setBounds(631, 375, 79, 53);

		botoesCasas.add(btnCasa1);
		botoesCasas.add(btnCasa2);
		botoesCasas.add(btnCasa3);
		botoesCasas.add(btnCasa4);
		botoesCasas.add(btnCasa5);
		botoesCasas.add(btnCasa6);
		botoesCasas.add(btnCasa7);
		botoesCasas.add(btnCasa8);
		botoesCasas.add(btnCasa9);
		botoesCasas.add(btnCasa10);
		botoesCasas.add(btnCasa11);
		botoesCasas.add(btnCasa12);
		botoesCasas.add(btnCasa13);
		botoesCasas.add(btnCasa14);
		botoesCasas.add(btnCasa15);
		botoesCasas.add(btnCasa16);
		botoesCasas.add(btnCasa17);
		botoesCasas.add(btnCasa18);
		botoesCasas.add(btnCasa19);
		botoesCasas.add(btnCasa20);
		botoesCasas.add(btnCasa21);
		botoesCasas.add(btnCasa22);
		botoesCasas.add(btnCasa23);
		botoesCasas.add(btnCasa24);
		botoesCasas.add(btnCasa25);
		botoesCasas.add(btnCasa26);
		botoesCasas.add(btnCasa27);
		botoesCasas.add(btnCasa28);

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

	public int getValorDados(){
		
		int dado1 = (Integer)comboBoxDado1.getSelectedItem();
		int dado2 = (Integer) comboBoxDado2.getSelectedItem();
		
		return dado1 + dado2;
	}
	
	public JButton getBtnJogar(){
		return this.btnJogar;
	}

	public PanelJogador getPanelJogador1(){
		return panelJogador1;
	}
	
	public PanelJogador getPanelJogador2(){
		return panelJogador2;
	}
	
	public void atualizarJogadorDaVez(IJogador jogadorDaVez){
		panelJogador1.atualizarBordaJogadorDaVez(jogadorDaVez);
		panelJogador2.atualizarBordaJogadorDaVez(jogadorDaVez);
	}

	public void atualizarPortfolios(){
		panelJogador1.atualizar();
		panelJogador2.atualizar();
	}
	
}
