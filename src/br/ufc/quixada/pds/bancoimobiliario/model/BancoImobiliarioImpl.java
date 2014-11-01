package br.ufc.quixada.pds.bancoimobiliario.model;

import java.util.Iterator;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.AcaoLogradouroEnum;

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
	public void realizarTurnoJogador(int valorDados) throws FimDeJogoException,
			ErroArquivoConfiguracoesException {

		jogadorDaVez.atualizarValorDoUltimoDeslocamento(valorDados);

		try {

			Logradouro logradouro = this.tabuleiro.percorrerTabuleiro(
					this.jogadorDaVez, valorDados);
			
			int posicaoAntiga = jogadorDaVez.getPosicao();
			
			AcaoLogradouroEnum tipoDeAcao = logradouro
					.acaoLogradouro(jogadorDaVez);
			
			if (tipoDeAcao.equals(AcaoLogradouroEnum.AVANCA_POSICAO)) {
				realizarPulo(jogadorDaVez, posicaoAntiga);
			} else if(tipoDeAcao.equals(AcaoLogradouroEnum.DISPONIVEL_PARA_COMPRA)){
				
				//TODO : Detectar POSSIvel Venda
			}
			
		} catch (JogadorComSaldoNegativoException e) {

			throw new FimDeJogoException();

		} catch (ValorInvalidoException e) {

			throw new ErroArquivoConfiguracoesException();
		}

		this.mudarJogadorDaVez();
	}

	private void realizarPulo(Jogador jogador, int posicaoAntiga)
			throws JogadorComSaldoNegativoException, ValorInvalidoException {
		Logradouro logradouroParada = this.tabuleiro.pularPosicao(jogador,
				posicaoAntiga);
		posicaoAntiga = jogador.getPosicao();
		AcaoLogradouroEnum tipoDeAcao = logradouroParada
				.acaoLogradouro(jogador);
		if (tipoDeAcao.equals(AcaoLogradouroEnum.AVANCA_POSICAO)) {
			realizarPulo(jogador, posicaoAntiga);
		}

	}

	@Override
	public Iterator<Jogador> obterJogadores() {
		return jogadores.iterator();
	}

	@Override
	public Iterator<Logradouro> getCasasDoTabuleiro() {
		return this.tabuleiro.getCasasDoTabuleiro().iterator();
	}

	@Override
	public Jogador pegarJogadorDaVez() {
		return this.jogadorDaVez;
	}
	
	public void mudarJogadorDaVez(){
		// TODO : Melhorar
				jogadores.remove(jogadorDaVez);
				jogadores.add(jogadorDaVez);
				jogadorDaVez = jogadores.get(0);
	}

}
