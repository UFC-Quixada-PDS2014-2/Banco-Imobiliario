package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.FimDeJogoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorComSaldoNegativoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.JogadorInvalidoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.PropriedadeJaVendidaException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.SaldoJogadorInsuficienteException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ValorInvalidoException;

public class BancoImobiliarioImpl implements BancoImobiliario {

	private List<Jogador> jogadores;
	private Jogador jogadorDaVez;
	private Tabuleiro tabuleiro;

	public BancoImobiliarioImpl(List<Jogador> jogadores, Tabuleiro tabuleiro) {
		this.jogadores = jogadores;
		this.tabuleiro = tabuleiro;
		this.jogadorDaVez = this.jogadores.get(0);
	}

	@Override
	public AcaoLogradouroEnum realizarTurnoJogador(int valorDosDados) throws FimDeJogoException,
			ErroArquivoConfiguracoesException {
		
		AcaoLogradouroEnum tipoDeAcao;

		jogadorDaVez.setValorDoUltimoDeslocamento(valorDosDados);

		try {

			Logradouro logradouro = this.tabuleiro.percorrerTabuleiro(
					this.jogadorDaVez, valorDosDados);
			
			int posicaoAntiga = jogadorDaVez.getPosicao();
			
			tipoDeAcao = logradouro.acaoLogradouro(jogadorDaVez);
			
			if (tipoDeAcao.equals(AcaoLogradouroEnum.AVANCA_POSICAO)) {
				tipoDeAcao = realizarPulo(jogadorDaVez, posicaoAntiga);
			} else if(tipoDeAcao.equals(AcaoLogradouroEnum.DISPONIVEL_PARA_COMPRA)){
				
				//TODO : Detectar POSSIvel Venda
			}
			
		} catch (JogadorComSaldoNegativoException e) {

			throw new FimDeJogoException();

		} catch (ValorInvalidoException e) {

			throw new ErroArquivoConfiguracoesException();
		}

		this.mudarJogadorDaVez();
		
		return tipoDeAcao;
	}

	private AcaoLogradouroEnum realizarPulo(Jogador jogador, int posicaoAntiga)
			throws JogadorComSaldoNegativoException, ValorInvalidoException {
		Logradouro logradouroParada = this.tabuleiro.pularPosicao(jogador,
				posicaoAntiga);
		posicaoAntiga = jogador.getPosicao();
		AcaoLogradouroEnum tipoDeAcao = logradouroParada
				.acaoLogradouro(jogador);
		if (tipoDeAcao.equals(AcaoLogradouroEnum.AVANCA_POSICAO)) {
			return realizarPulo(jogador, posicaoAntiga);
		} else {
			return tipoDeAcao;
		}

	}

	@Override
	public Iterator<Jogador> getJogadores() {
		return jogadores.iterator();
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
				jogadores.remove(jogadorDaVez);
				jogadores.add(jogadorDaVez);
				jogadorDaVez = jogadores.get(0);
	}

	@Override
	public void comprarPropriedade(Propriedade propriedade) throws SaldoJogadorInsuficienteException, PropriedadeJaVendidaException, JogadorInvalidoException, FimDeJogoException, ErroArquivoConfiguracoesException {
		
		try{
			propriedade.comprarPropriedade(this.jogadorDaVez);
		} catch(JogadorComSaldoNegativoException e){
			throw new FimDeJogoException();
		} catch(ValorInvalidoException e){
			throw new ErroArquivoConfiguracoesException();
		}
		
	}
	

}
