package br.ufc.quixada.pds.bancoimobiliario.main;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.config.guice.TabuleiroModule;
import br.ufc.quixada.pds.bancoimobiliario.controller.Controlador;
import br.ufc.quixada.pds.bancoimobiliario.controller.ControladorBancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.exception.MontadorTabuleiroException;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Copo;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.Peca;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.TabuleiroDirector;
import br.ufc.quixada.pds.bancoimobiliario.view.GUIBancoImobiliario;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class BootstraperBancoImobiliario {

	public static void main(String[] args) {
		try {

			/*Iniciando objetos de domínio*/
			Injector injectorBI = Guice.createInjector(new TabuleiroModule());
			TabuleiroDirector tabuleiroDirector = injectorBI.getInstance(TabuleiroDirector.class);
			tabuleiroDirector.construirTabuleiro();
			Tabuleiro tabuleiro = tabuleiroDirector.getTabuleiro();	
			
			Copo copo = new Copo();
			
			List<Jogador> jogadores = new ArrayList<>();
			for (int i = 0; i < ConfiguracoesEnum.NUMERO_JOGADORES.getValor(); i++) {
				Jogador jogador = new Jogador();
				jogador.setNome("Jogador " + (i + 1));
				jogador.setSaldo(ConfiguracoesEnum.SALDO_INICIAL.getValor());
				jogador.setTabuleiro(tabuleiro);
				Peca peca = new Peca();
				jogador.setPeca(peca);
				jogadores.add(jogador);
			}
			
			BancoImobiliario bancoImobiliario = new BancoImobiliario(jogadores, tabuleiro, copo);
			
			Controlador controlador = new ControladorBancoImobiliario(bancoImobiliario);
			
			GUIBancoImobiliario gui = new GUIBancoImobiliario(controlador);
			gui.initialize();
			
		
		} catch (ErroArquivoConfiguracoesException e) {
			mensagemErro(e.getMessage());
			e.printStackTrace();
		} catch (MontadorTabuleiroException e2) {
			
			e2.printStackTrace();
		}
		
	}
	
	public static void mensagemErro(String mensagem){
		
	}
	
}
