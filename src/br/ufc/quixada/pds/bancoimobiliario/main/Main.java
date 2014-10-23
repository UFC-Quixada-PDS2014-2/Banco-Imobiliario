package br.ufc.quixada.pds.bancoimobiliario.main;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.config.guice.TabuleiroModule;
import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.exception.MontadorTabuleiroException;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliarioImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroDirector;
import br.ufc.quixada.pds.bancoimobiliario.view.GUIBancoImobiliario;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) {
		try {

			/*Iniciando objetos de domínio*/
			Injector injectorBI = Guice.createInjector(new TabuleiroModule());
			TabuleiroDirector tabuleiroDirector = injectorBI.getInstance(TabuleiroDirector.class);
			tabuleiroDirector.construirTabuleiro();
			Tabuleiro tabuleiro = tabuleiroDirector.getTabuleiro();	
			
			
			List<Jogador> jogadores = new ArrayList<>();
			for (int i = 0; i < ConfiguracoesEnum.NUMERO_JOGADORES.getValor(); i++) {
				JogadorImpl jogadorImpl = new JogadorImpl("Jogador 1 ", ConfiguracoesEnum.SALDO_INICIAL.getValor());
				jogadores.add(jogadorImpl);
			}
			
			BancoImobiliario bancoImobiliario = new BancoImobiliarioImpl(jogadores, tabuleiro);
			
			
			GUIBancoImobiliario gui = new GUIBancoImobiliario(bancoImobiliario);
			gui.initialize();
			
		
		} catch (ErroArquivoConfiguracoesException e) {
			//TODO
			e.printStackTrace();
		} catch (MontadorTabuleiroException e2) {
			//TODO
			e2.printStackTrace();
		}
		
	}
	
}
