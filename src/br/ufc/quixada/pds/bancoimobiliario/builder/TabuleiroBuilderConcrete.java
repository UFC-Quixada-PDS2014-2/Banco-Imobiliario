package br.ufc.quixada.pds.bancoimobiliario.builder;

import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.PontoDePartida;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.MontadorTabuleiroException;


public class TabuleiroBuilderConcrete implements TabuleiroBuilder{

	private TabuleiroImpl tabuleiroImpl;
	private boolean first,last;
	private int qtdCasas;
	
	
	public TabuleiroBuilderConcrete(){
		this.tabuleiroImpl = new TabuleiroImpl();
		this.first = false;
		this.last = false;
		this.qtdCasas = 0;
	}
	
	@Override
	public void montarPontoPartida(PontoDePartida pontoDePartida) throws MontadorTabuleiroException {
		if(first == false){
			tabuleiroImpl.addLogradouro(pontoDePartida);
			first = true;
			this.qtdCasas++;
		}else{
			throw new MontadorTabuleiroException("Ponto de partida já adicionado");
		}
	}

	@Override
	public void montarCasaIntermediaria(Logradouro logradouro) throws MontadorTabuleiroException {
		int casasRestantes = ConfiguracoesEnum.NUMERO_CASAS.getValor() - qtdCasas;
		if(first && (casasRestantes > 1)){
			tabuleiroImpl.addLogradouro(logradouro);
			this.qtdCasas++;
		}else{
			String mensagem = "";
			if(first == false){
				mensagem = "Necessário adicionar ponto inicial";
			}else{
				mensagem = "Já foram adicionadas muitas casas, adicione a última";
			}
			throw new MontadorTabuleiroException(mensagem);
		}
	}

	@Override
	public void montarUltimaCasa(Logradouro logradouro) throws MontadorTabuleiroException {
		int casasRestantes = ConfiguracoesEnum.NUMERO_CASAS.getValor() - qtdCasas;
		if(casasRestantes == 1){
			tabuleiroImpl.addLogradouro(logradouro);
			this.qtdCasas++;
			last = true;
		}else{
			throw new MontadorTabuleiroException("Faltam adicionar " + (casasRestantes - 1) +" casa(s)");
		}
		
	}
	
	@Override
	public Tabuleiro getTabuleiro() throws MontadorTabuleiroException{
		if(first && last){
			return this.tabuleiroImpl;
		}else{
			throw new MontadorTabuleiroException("Tabuleiro não montado");
		}
	}

}
