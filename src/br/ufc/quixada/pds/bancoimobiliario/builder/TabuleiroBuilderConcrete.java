package br.ufc.quixada.pds.bancoimobiliario.builder;

import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;
import br.ufc.quixada.pds.bancoimobiliario.model.PontoDePartida;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.MontadorTabuleiroException;


public class TabuleiroBuilderConcrete implements TabuleiroBuilder{

	private TabuleiroImpl tabuleiroImpl;
	private boolean primeiro,ultimo;
	private int quantidadeDeCasas;
	
	
	public TabuleiroBuilderConcrete(){
		this.tabuleiroImpl = new TabuleiroImpl();
		this.primeiro = false;
		this.ultimo = false;
		this.quantidadeDeCasas = 0;
	}
	
	@Override
	public void montarPontoPartida(PontoDePartida pontoDePartida) throws MontadorTabuleiroException {
		if(primeiro == false){
			tabuleiroImpl.addLogradouro(pontoDePartida);
			primeiro = true;
			this.quantidadeDeCasas++;
		}else{
			throw new MontadorTabuleiroException("Ponto de partida já adicionado");
		}
	}

	@Override
	public void montarCasaIntermediaria(Logradouro logradouro) throws MontadorTabuleiroException {
		int casasRestantes = ConfiguracoesEnum.NUMERO_CASAS.getValor() - quantidadeDeCasas;
		if(primeiro && (casasRestantes > 1)){
			tabuleiroImpl.addLogradouro(logradouro);
			this.quantidadeDeCasas++;
		}else{
			String mensagem = "";
			if(primeiro == false){
				mensagem = "Necessário adicionar ponto inicial";
			}else{
				mensagem = "Já foram adicionadas muitas casas, adicione a última";
			}
			throw new MontadorTabuleiroException(mensagem);
		}
	}

	@Override
	public void montarUltimaCasa(Logradouro logradouro) throws MontadorTabuleiroException {
		int casasRestantes = ConfiguracoesEnum.NUMERO_CASAS.getValor() - quantidadeDeCasas;
		if(casasRestantes == 1){
			tabuleiroImpl.addLogradouro(logradouro);
			this.quantidadeDeCasas++;
			ultimo = true;
		}else{
			throw new MontadorTabuleiroException("Faltam adicionar " + (casasRestantes - 1) +" casa(s)");
		}
	}
	
	@Override
	public Tabuleiro getTabuleiro() throws MontadorTabuleiroException{
		if(primeiro && ultimo){
			return this.tabuleiroImpl;
		}else{
			throw new MontadorTabuleiroException("Tabuleiro não montado");
		}
	}
}