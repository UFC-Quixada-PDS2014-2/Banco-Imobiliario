package br.ufc.quixada.pds.bancoimobiliario.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.PathIterator;
import java.net.URL;
import java.text.Normalizer;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.FimDeJogoException;
import br.ufc.quixada.pds.bancoimobiliario.view.GUITabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.view.IJogador;
import br.ufc.quixada.pds.bancoimobiliario.view.ILogradouro;

public class ControladorTabuleiro implements Observer{
	
	private GUITabuleiro guiTabuleiro;
	private BancoImobiliario bancoImobiliario;
	private IJogador iJogador1;
	private IJogador iJogador2;
	private IJogador jogadorDaVez;
	
	public ControladorTabuleiro(BancoImobiliario bancoImobiliario, IJogador iJogador1, IJogador iJogador2){
		this.bancoImobiliario = bancoImobiliario;
		this.bancoImobiliario.addObserver(this);
		this.iJogador1 = iJogador1;
		this.iJogador2 = iJogador2;
		this.guiTabuleiro = new GUITabuleiro(bancoImobiliario, iJogador1, iJogador2);
		inicializar();
	}
	
	public void inicializar(){
		this.guiTabuleiro.setVisible(true);
		this.jogadorDaVez = detectarJogadorDaVez();
		this.guiTabuleiro.setJogadorDaVez(jogadorDaVez);
		adicionarEventosBotoesCasas();
		
		JButton btnJogador = this.guiTabuleiro.getBtnJogar();
		btnJogador.addActionListener(new ActionRealizarRodada());
		
	}
	
	private IJogador detectarJogadorDaVez(){
		Jogador jogador = bancoImobiliario.getJogadorDaVez();
		
		if(iJogador1.isJogador(jogador)){
			return iJogador1;
		}else{
			return iJogador2;
		}
	}
	
	private static final String caminhoImagens = "/br/ufc/quixada/pds/bancoimobiliario/view/img/";
	
	private void adicionarEventosBotoesCasas(){
		
		List<ILogradouro> iLogradouros = guiTabuleiro.getiLogradouros();
		
		for (ILogradouro iLogradouro : iLogradouros) {
			
			JButton casa = iLogradouro.getCasa();
			casa.setToolTipText(iLogradouro.getNome());
			casa.setText(iLogradouro.getNome());
			
			String nomeImagem = iLogradouro.getNome().replaceAll("\\s","").toLowerCase();
			nomeImagem = Normalizer.normalize(nomeImagem, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			
			URL pathImagem = ControladorTabuleiro.class.getResource(caminhoImagens  + "casas/" + nomeImagem  +".png");
			System.out.println(caminhoImagens  + "casas_opacas/" + nomeImagem  +"_opaca.png");
			System.out.println(pathImagem);
			
			ImageIcon imageIcon = new ImageIcon(pathImagem);
			casa.setIcon(imageIcon);
			
			casa.addActionListener(new ActionListenerCasa(iLogradouro.getLogradouro().getNome()));
			casa.addMouseListener(new ActionHoverListener(iLogradouro));
			
		}
		
	}
	
	private class ActionHoverListener extends MouseAdapter{
		
		private ILogradouro iLogradouro;
		
		public ActionHoverListener(ILogradouro iLogradouro){
			this.iLogradouro = iLogradouro;
		}
	
		@Override
		public void mouseEntered(MouseEvent evt) {
			super.mouseEntered(evt);
			String nomeImagem = iLogradouro.getNome().replaceAll("\\s","").toLowerCase();
			nomeImagem = Normalizer.normalize(nomeImagem, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			
			URL pathImagem = ControladorTabuleiro.class.getResource(caminhoImagens  + "casas_opacas/" + nomeImagem  +"-opaca.png");
			ImageIcon imageIcon = new ImageIcon(pathImagem);
			iLogradouro.getCasa().setIcon(imageIcon);
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
			String nomeImagem = iLogradouro.getNome().replaceAll("\\s","").toLowerCase();
			nomeImagem = Normalizer.normalize(nomeImagem, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			
			URL pathImagem = ControladorTabuleiro.class.getResource(caminhoImagens  + "casas/" + nomeImagem  +".png");
			
			ImageIcon imageIcon = new ImageIcon(pathImagem);
			iLogradouro.getCasa().setIcon(imageIcon);
		}
		
	}
	
	private class ActionListenerCasa implements ActionListener{
		
		private String mensagem;
		
		public ActionListenerCasa(String mensagem){
			this.mensagem = mensagem;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(ControladorTabuleiro.this.guiTabuleiro, mensagem);
		}
		
	}

	private class ActionRealizarRodada implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			int valorDados = guiTabuleiro.getValorDados();

			try {
				AcaoLogradouroEnum acaoLogradouro = bancoImobiliario.realizarTurnoJogador(valorDados);

				JOptionPane.showMessageDialog(guiTabuleiro, jogadorDaVez.getJogador().getPosicao() + 1);
				JOptionPane.showMessageDialog(guiTabuleiro, jogadorDaVez.getJogador().getSaldo());
				jogadorDaVez = detectarJogadorDaVez();
				guiTabuleiro.setJogadorDaVez(jogadorDaVez);
				
			} catch (FimDeJogoException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(guiTabuleiro, bancoImobiliario.getJogadorDaVez().getNome() + " perdeu!");
			} catch (ErroArquivoConfiguracoesException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(guiTabuleiro, "Erro no arquivo de configuração do jogo!");
				System.exit(1);
			}
			
		}
		
		
	}
	

	@Override
	public void update(Observable o, Object arg) {
		JOptionPane.showMessageDialog(guiTabuleiro, arg);
	}
	
	
}
