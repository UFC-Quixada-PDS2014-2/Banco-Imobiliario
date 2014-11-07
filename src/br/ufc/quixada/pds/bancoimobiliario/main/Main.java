package br.ufc.quixada.pds.bancoimobiliario.main;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroDirector;
import br.ufc.quixada.pds.bancoimobiliario.controller.ControladorTabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.guice.TabuleiroModule;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliarioImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Jogador;
import br.ufc.quixada.pds.bancoimobiliario.model.JogadorImpl;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.MontadorTabuleiroException;
import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaInicial;
import br.ufc.quixada.pds.bancoimobiliario.view.IJogador;

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

			Jogador jogador1 = new JogadorImpl("Jogador 1 ",
					ConfiguracoesEnum.SALDO_INICIAL.getValor());	
			Jogador jogador2 = new JogadorImpl("Jogador 2 ",
					ConfiguracoesEnum.SALDO_INICIAL.getValor());
			
			List<Jogador> jogadores = new ArrayList<>();
			jogadores.add(jogador1);
			jogadores.add(jogador2);

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
						GUITelaInicial.class.getName()).log(
						java.util.logging.Level.SEVERE, null, ex);
			} catch (InstantiationException ex) {
				java.util.logging.Logger.getLogger(
						GUITelaInicial.class.getName()).log(
						java.util.logging.Level.SEVERE, null, ex);
			} catch (IllegalAccessException ex) {
				java.util.logging.Logger.getLogger(
						GUITelaInicial.class.getName()).log(
						java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
				java.util.logging.Logger.getLogger(
						GUITelaInicial.class.getName()).log(
						java.util.logging.Level.SEVERE, null, ex);
			}

			//UIBancoImobiliario gui = new UIBancoImobiliario(bancoImobiliario);
			IJogador iJogador1 = new IJogador(jogador1);
			iJogador1.setImagemPersonagem("/br/ufc/quixada/pds/bancoimobiliario/view/img/luxemburgo.jpg");
			IJogador iJogador2 = new IJogador(jogador2);
			iJogador2.setImagemPersonagem("/br/ufc/quixada/pds/bancoimobiliario/view/img/luxemburgo.jpg");
			
			ControladorTabuleiro controladorTabuleiro = new ControladorTabuleiro(bancoImobiliario, iJogador1, iJogador2);
			
			
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
