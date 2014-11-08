package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.GameOverJogadorException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.LogradouroIndisponivelCompraException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class BancoImobiliarioImpl extends BancoImobiliario {

	private List<Jogador> jogadoresAtivos;
	private List<Jogador> jogadoresInativos;
	
	private Jogador jogadorDaVez;
	private Tabuleiro tabuleiro;

	public BancoImobiliarioImpl(List<Jogador> jogadores, Tabuleiro tabuleiro) {
		this.jogadoresAtivos = jogadores;
		this.jogadoresInativos = new ArrayList<Jogador>();
		this.tabuleiro = tabuleiro;
		this.jogadorDaVez = this.jogadoresAtivos.get(0);
	}

	@Override
	public AcaoLogradouroEnum realizarTurnoJogador(int valorDosDados) throws GameOverJogadorException,
			ErroArquivoConfiguracoesException {
		
		AcaoLogradouroEnum tipoDeAcao;

		jogadorDaVez.setValorDoUltimoDeslocamento(valorDosDados);

		try {

			Logradouro logradouro = this.tabuleiro.percorrerTabuleiro(
					this.jogadorDaVez, valorDosDados);
			
			int posicaoAntiga = jogadorDaVez.getPosicao();
			
			//Notificar observadores
			setChanged();
			notifyObservers(logradouro);
			
			tipoDeAcao = logradouro.acaoLogradouro(jogadorDaVez);
			
			if (tipoDeAcao.equals(AcaoLogradouroEnum.AVANCA_POSICAO)) {
				tipoDeAcao = realizarPulo(jogadorDaVez, posicaoAntiga);
			} 
			
		} catch (JogadorComSaldoNegativoException e) {

			jogadoresInativos.add(jogadorDaVez);
			jogadoresAtivos.remove(jogadorDaVez);
				
			throw new GameOverJogadorException();
	
		} catch (ValorInvalidoException e) {

			throw new ErroArquivoConfiguracoesException();
		}

		this.mudarJogadorDaVez();
		
		return tipoDeAcao;
	}
	
	public Jogador detectarVencedor(){
		if(jogadoresAtivos.size() == 1){
			return jogadoresAtivos.get(0);
		} else {
			return null;
		}
	}

	private AcaoLogradouroEnum realizarPulo(Jogador jogador, int posicaoAntiga)
			throws JogadorComSaldoNegativoException, ValorInvalidoException {
		Logradouro logradouroParada = this.tabuleiro.pularPosicao(jogador,
				posicaoAntiga);
		posicaoAntiga = jogador.getPosicao();
		AcaoLogradouroEnum tipoDeAcao = logradouroParada
				.acaoLogradouro(jogador);
		setChanged();
		notifyObservers(tipoDeAcao);
		if (tipoDeAcao.equals(AcaoLogradouroEnum.AVANCA_POSICAO)) {
			return realizarPulo(jogador, posicaoAntiga);
		} else {
			return tipoDeAcao;
		}

	}

	@Override
	public Iterator<Jogador> getJogadores() {
		return jogadoresAtivos.iterator();
	}

	@Override
	public Iterator<Logradouro> getCasasDoTabuleiro() {
		return this.tabuleiro.getCasasDoTabuleiro();
	}

	@Override
	public Jogador getJogadorDaVez() {
		return this.jogadorDaVez;
	}
	
	private void mudarJogadorDaVez(){
		// TODO : Melhorar
				jogadoresAtivos.remove(jogadorDaVez);
				jogadoresAtivos.add(jogadorDaVez);
				jogadorDaVez = jogadoresAtivos.get(0);
	}

	@Override
	public void comprarPropriedade(Jogador jogador, Logradouro logradouro) throws LogradouroIndisponivelCompraException, JogadorInvalidoException, GameOverJogadorException, ErroArquivoConfiguracoesException, SaldoJogadorInsuficienteException {
		
		try{
			if(logradouro.isDisponivelParaCompra()){
				logradouro.comprarLogradouro(jogador);
			}else{
				throw new LogradouroIndisponivelCompraException();
			}
		} catch(JogadorComSaldoNegativoException e){
			throw new GameOverJogadorException();
		} catch(ValorInvalidoException e){
			throw new ErroArquivoConfiguracoesException();
		} catch (SaldoJogadorInsuficienteException e) {
			throw new SaldoJogadorInsuficienteException();
		}
		
	}

	@Override
	public Logradouro getLogradouroPelaPosicao(int posicao) throws ValorInvalidoException{
		return this.tabuleiro.getLogradouroPelaPosicao(posicao);
	}
	
}
