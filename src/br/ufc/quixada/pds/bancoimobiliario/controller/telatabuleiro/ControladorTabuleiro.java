package br.ufc.quixada.pds.bancoimobiliario.controller.telatabuleiro;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.Normalizer;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.ufc.quixada.pds.bancoimobiliario.controller.ControladorRestartGame;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.GameOverJogadorException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.LogradouroIndisponivelCompraException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.view.GUITabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.view.IJogador;
import br.ufc.quixada.pds.bancoimobiliario.view.ILogradouro;
import br.ufc.quixada.pds.bancoimobiliario.view.PanelJogador;
import br.ufc.quixada.pds.bancoimobiliario.view.enumeration.CaminhoImagensEnum;

public class ControladorTabuleiro implements Observer{
	
	private GUITabuleiro guiTabuleiro;
	private BancoImobiliario bancoImobiliario;
	private IJogador iJogador1;
	private IJogador iJogador2;
	private IJogador jogadorDaVez;
	private ControladorRestartGame restartGame;
	
	public ControladorTabuleiro(BancoImobiliario bancoImobiliario, IJogador iJogador1, IJogador iJogador2, ControladorRestartGame restartGame){
		this.bancoImobiliario = bancoImobiliario;
		this.bancoImobiliario.addObserver(this);
		this.iJogador1 = iJogador1;
		this.iJogador2 = iJogador2;
		this.guiTabuleiro = new GUITabuleiro(bancoImobiliario, iJogador1, iJogador2);
		this.restartGame = restartGame;
	}
	
	public void inicializar(){
		this.guiTabuleiro.setVisible(true);
		this.jogadorDaVez = detectarJogadorDaVez();
		this.guiTabuleiro.atualizarJogadorDaVez(jogadorDaVez);
		
		adicionarEventosBotoesCasas();
		
		JButton btnJogador = this.guiTabuleiro.getBtnJogar();
		btnJogador.addActionListener(new ActionRealizarRodada());
	
		PanelJogador panelJogador1 = guiTabuleiro.getPanelJogador1();
		JButton botaoPortfolioJogador1 = panelJogador1.getBotaoPortfolio();
		botaoPortfolioJogador1.addActionListener(new ActionListenerBotaoPortfolio(iJogador1));
		
		PanelJogador panelJogador2 = guiTabuleiro.getPanelJogador2();
		JButton botaoPortfolioJogador2 = panelJogador2.getBotaoPortfolio();
		botaoPortfolioJogador2.addActionListener(new ActionListenerBotaoPortfolio(iJogador2));
		
		atualizarPinoJogador(iJogador1);
		atualizarPinoJogador(iJogador2);
	}
	
	private void atualizarPinoJogador(IJogador iJogador){
		try {
		
			ILogradouro iLogradouroPosicaoJogador = buscarILogradouro(iJogador.getPosicao());
			Rectangle posicaoLogradouro = iLogradouroPosicaoJogador.getPosicao();
			
			if(posicaoLogradouro.height >= posicaoLogradouro.width){
				posicaoLogradouro.height = posicaoLogradouro.height/ 2;
				posicaoLogradouro.y = posicaoLogradouro.y + ((int)(posicaoLogradouro.height * iJogador.getDeslocamentoPino()));
			}else{
				posicaoLogradouro.width = posicaoLogradouro.width/ 2;
				posicaoLogradouro.x = posicaoLogradouro.x + ((int)(posicaoLogradouro.width * iJogador.getDeslocamentoPino()));				
			}
			iJogador.atualizarPosicao(posicaoLogradouro);
			
		} catch (ValorInvalidoException e) {
			JOptionPane.showMessageDialog(guiTabuleiro, "Erro no arquivo de configuração!");
			System.exit(1);
			e.printStackTrace();
		}	
	}
	
	private ILogradouro buscarILogradouro(int posicao) throws ValorInvalidoException{
		Logradouro logradouro = bancoImobiliario.getLogradouroPelaPosicao(posicao);
		ILogradouro iLogradouroPosicaoJogador = null;
		
		List<ILogradouro> iLogradouros = guiTabuleiro.getiLogradouros();
		for (ILogradouro iLogradouro : iLogradouros) {
			if(iLogradouro.getLogradouro().equals(logradouro)){
				iLogradouroPosicaoJogador = iLogradouro;
				break;
			}
		}

		if(iLogradouroPosicaoJogador != null){
			return iLogradouroPosicaoJogador;	
		}else{
			throw new ValorInvalidoException();
		}
	}
	
	private IJogador detectarJogadorDaVez(){
		Jogador jogador = bancoImobiliario.getJogadorDaVez();
		
		if(iJogador1.isJogador(jogador)){
			return iJogador1;
		}else{
			return iJogador2;
		}
	}
	
	
	private void adicionarEventosBotoesCasas(){
		
		List<ILogradouro> iLogradouros = guiTabuleiro.getiLogradouros();
		
		for (ILogradouro iLogradouro : iLogradouros) {
			
			JButton casa = iLogradouro.getCasa();
			casa.setToolTipText(iLogradouro.getNome());
			casa.setText(iLogradouro.getNome());
			
			String nomeImagem = iLogradouro.getNome().replaceAll("\\s","").toLowerCase();
			nomeImagem = Normalizer.normalize(nomeImagem, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			
			URL pathImagem = ControladorTabuleiro.class.getResource(CaminhoImagensEnum.PASTA_CASAS.getValor() + nomeImagem  +".png");
			
			ImageIcon imageIcon = new ImageIcon(pathImagem);
			casa.setIcon(imageIcon);
			casa.setText("");
			casa.addActionListener(new ActionListenerClickCasa(iLogradouro.getLogradouro()));
			casa.addMouseListener(new ActionHoverCasaListener(iLogradouro));
			
		}
		
	}
	
	private class ActionRealizarRodada implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			int valorDados = guiTabuleiro.getValorDados();

			try {
				AcaoLogradouroEnum acaoLogradouro = bancoImobiliario.realizarTurnoJogador(valorDados);
							
				//A movimentação proveniente do lancamento dos dados dados é feita pelo update do observer
				// Essa movimentação é proveniente da ação da casa
				ILogradouro logradouroParada = buscarILogradouro(jogadorDaVez.getPosicao());

				if(acaoLogradouro == AcaoLogradouroEnum.DISPONIVEL_PARA_COMPRA){

					int opcaoSelecionada = JOptionPane.showConfirmDialog(guiTabuleiro, "Você deseja comprar essa propriedade? \n " + logradouroParada.toString(), null ,JOptionPane.YES_NO_OPTION);
					
					if(opcaoSelecionada == JOptionPane.OK_OPTION){
							bancoImobiliario.comprarPropriedade(jogadorDaVez.getJogador(), logradouroParada.getLogradouro());
							JOptionPane.showMessageDialog(guiTabuleiro, logradouroParada.getNome() + " adquirido.");
					}
					
				}
				
			} catch (GameOverJogadorException e1) {
				Jogador jogadorVencedor = bancoImobiliario.detectarVencedor();
				JOptionPane.showMessageDialog(guiTabuleiro, jogadorVencedor.getNome() + " ganhou!!!");
				
				reiniciarJogo();
				
			} catch (ErroArquivoConfiguracoesException e1) {
				JOptionPane.showMessageDialog(guiTabuleiro, "Erro no arquivo de configuração do jogo!");
				System.exit(1);
			} catch (ValorInvalidoException e1) {
				JOptionPane.showMessageDialog(guiTabuleiro, "Erro no arquivo de configuração do jogo!");
				System.exit(1);
			} catch (LogradouroIndisponivelCompraException e1) {
				JOptionPane.showMessageDialog(guiTabuleiro, "Essa casa está indisponível!");
			} catch (SaldoJogadorInsuficienteException e1) {
				JOptionPane.showMessageDialog(guiTabuleiro, "Você não possui dinheiro suficiente!");
			}
			
			jogadorDaVez = detectarJogadorDaVez();
			guiTabuleiro.atualizarJogadorDaVez(jogadorDaVez);
			guiTabuleiro.atualizarPortfolios();

		}
		
	}

	@Override
	public void update(Observable o, Object mensagem) {
		atualizarPinoJogador(jogadorDaVez);
		guiTabuleiro.atualizarPortfolios();	
		
		JOptionPane.showMessageDialog(guiTabuleiro, mensagem);
	}

	public void reiniciarJogo(){
		int opcao = JOptionPane.showConfirmDialog(guiTabuleiro, "Você deseja reiniciar a partida ", null ,JOptionPane.YES_NO_OPTION);
		
		if(opcao == JOptionPane.OK_OPTION){
			guiTabuleiro.dispose();
			restartGame.reiniciarJogo();
		}else{
			guiTabuleiro.dispose();
		}
	}
	
}
