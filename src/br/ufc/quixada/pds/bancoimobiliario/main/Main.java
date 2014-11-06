package br.ufc.quixada.pds.bancoimobiliario.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroDirector;
import br.ufc.quixada.pds.bancoimobiliario.guice.TabuleiroModule;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliarioImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.FimDeJogoException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.MontadorTabuleiroException;
import br.ufc.quixada.pds.bancoimobiliario.view.GUITabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.viewTeste.UIBancoImobiliario;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) {
		try {

			/* Iniciando objetos de domínio */
			Injector injectorBI = Guice.createInjector(new TabuleiroModule());
			TabuleiroDirector tabuleiroDirector = injectorBI
					.getInstance(TabuleiroDirector.class);
			tabuleiroDirector.construirTabuleiro();
			Tabuleiro tabuleiro = tabuleiroDirector.getTabuleiro();

			List<Jogador> jogadores = new ArrayList<>();
			for (int i = 0; i < ConfiguracoesEnum.NUMERO_JOGADORES.getValor(); i++) {
				JogadorImpl jogadorImpl = new JogadorImpl("Jogador 1 ",
						ConfiguracoesEnum.SALDO_INICIAL.getValor());
				jogadores.add(jogadorImpl);
			}

			BancoImobiliario bancoImobiliario = new BancoImobiliarioImpl(
					jogadores, tabuleiro);

			//Estilo da Janela
			try {
				for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
						.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						javax.swing.UIManager.setLookAndFeel(info
								.getClassName());
						break;
					}
				}
			} catch (ClassNotFoundException ex) {
				java.util.logging.Logger.getLogger(
						UIBancoImobiliario.class.getName()).log(
						java.util.logging.Level.SEVERE, null, ex);
			} catch (InstantiationException ex) {
				java.util.logging.Logger.getLogger(
						UIBancoImobiliario.class.getName()).log(
						java.util.logging.Level.SEVERE, null, ex);
			} catch (IllegalAccessException ex) {
				java.util.logging.Logger.getLogger(
						UIBancoImobiliario.class.getName()).log(
						java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
				java.util.logging.Logger.getLogger(
						UIBancoImobiliario.class.getName()).log(
						java.util.logging.Level.SEVERE, null, ex);
			}

			//UIBancoImobiliario gui = new UIBancoImobiliario(bancoImobiliario);
			GUITabuleiro gui = new GUITabuleiro();
			/*while (true) {

				Scanner scan = new Scanner(System.in);
				int dados = scan.nextInt();

				bancoImobiliario.realizarTurnoJogador(dados);
				System.out.println("Turno Realizado");
				System.out.println(bancoImobiliario.pegarJogadorDaVez()
						.getPosicao());

			}*/

		} catch (ErroArquivoConfiguracoesException e) {
			// TODO
			e.printStackTrace();
		} catch (MontadorTabuleiroException e2) {
			// TODO
			e2.printStackTrace();
		} 
	}

}
