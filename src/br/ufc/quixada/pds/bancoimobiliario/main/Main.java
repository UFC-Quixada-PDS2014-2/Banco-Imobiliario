package br.ufc.quixada.pds.bancoimobiliario.main;

import java.util.Observable;
import java.util.Observer;

import javax.inject.Inject;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroDirector;
import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroDirectorImpl;
import br.ufc.quixada.pds.bancoimobiliario.controller.ControladorRestartGame;
import br.ufc.quixada.pds.bancoimobiliario.controller.telainicial.ControladorTelaInicial;
import br.ufc.quixada.pds.bancoimobiliario.guice.TabuleiroModule;
import br.ufc.quixada.pds.bancoimobiliario.model.Tabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.ErroArquivoConfiguracoesException;
import br.ufc.quixada.pds.bancoimobiliario.model.exception.MontadorTabuleiroException;
import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaInicial;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main implements Observer{

	public static void main(String[] args) {
		Injector injectorBancoImobiliario = Guice.createInjector(new TabuleiroModule());
		Main jogo = injectorBancoImobiliario
				.getInstance(Main.class);
		jogo.iniciarJogo();
	}
	
	private TabuleiroDirector tabuleiroDirector;
	
	@Inject
	public Main(TabuleiroDirector tabuleiroDirector){
		this.tabuleiroDirector = tabuleiroDirector;
	}
	 
	public void iniciarJogo(){
		
		try {

			/* Iniciando objetos de domínio */
			tabuleiroDirector.construirTabuleiro();
			Tabuleiro tabuleiro = tabuleiroDirector.getTabuleiro();

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
				
				UIManager.put("OptionPane.cancelButtonText", "Cancelar");
			    UIManager.put("OptionPane.noButtonText", "Não");
			    UIManager.put("OptionPane.okButtonText", "OK");
			    UIManager.put("OptionPane.yesButtonText", "Sim");
				
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

			
			ControladorRestartGame restartGame = new ControladorRestartGame();
			restartGame.addObserver(this);
			ControladorTelaInicial controladorTelaInicial = new ControladorTelaInicial(restartGame);
			controladorTelaInicial.inicializar();
			
		} catch (ErroArquivoConfiguracoesException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao carregar jogo :(");
		} catch (MontadorTabuleiroException e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao carregar jogo :(");
		} 
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		Runtime runtime = Runtime.getRuntime();
		runtime.runFinalization();
		runtime.gc();
		
		//Reinicio do jogo
		iniciarJogo();
	}
}