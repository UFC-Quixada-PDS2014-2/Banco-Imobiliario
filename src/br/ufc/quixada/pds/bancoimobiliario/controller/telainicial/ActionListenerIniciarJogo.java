package br.ufc.quixada.pds.bancoimobiliario.controller.telainicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.ufc.quixada.pds.bancoimobiliario.builder.TabuleiroDirector;
import br.ufc.quixada.pds.bancoimobiliario.controller.ControladorRestartGame;
import br.ufc.quixada.pds.bancoimobiliario.controller.telatabuleiro.ControladorTabuleiro;
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

public class ActionListenerIniciarJogo implements ActionListener{
	private JButton botaoInicial;
	private List<JTextField> nomeJogadores;
	private GUITelaInicial guiTelaInicial;
	private List<IJogador> iJogadores;
	private List<Jogador> jogadores;
	private List<JButton> tecnicosDosJogadores;
	private ControladorRestartGame restartGame;
	
	public ActionListenerIniciarJogo(JButton botaoInicial, List<JTextField> nomeJogadores, GUITelaInicial guiTelaInicial, List<JButton> tecnicosDosJogadores, ControladorRestartGame restartGame){
		this.botaoInicial = botaoInicial;
		this.nomeJogadores = nomeJogadores;
		this.guiTelaInicial = guiTelaInicial;
		this.iJogadores = new ArrayList<IJogador>();
		this.jogadores = new ArrayList<Jogador>();
		this.tecnicosDosJogadores = tecnicosDosJogadores;
		this.restartGame = restartGame;
	}
	
	private boolean tecnicosEscolhidos(){
		boolean tecnicosEscolhidos = true;
		for(JButton tecnico : this.tecnicosDosJogadores){
			if(tecnico.getIcon() == null){
				tecnicosEscolhidos = false;
				break;
			}
		}
		return tecnicosEscolhidos;
	}
	
	private boolean todosOsNomesSetados(){
		boolean todosOsNomesSetados = true;
		for(JTextField nomeJogador: this.nomeJogadores){
			String textoNomeJogador = nomeJogador.getText();
			
			if(textoNomeJogador.equals(null) || textoNomeJogador.trim().equals("")){
				todosOsNomesSetados = false;
				break;
			}
		}
		return todosOsNomesSetados;
	}
	
	private void criarJogadores(){
		for(int i=0; i<2; i++){
			JTextField jogadorTextField = this.nomeJogadores.get(i);
			
			String nome = jogadorTextField.getText().trim();
			
			Jogador jogador = new JogadorImpl(nome, ConfiguracoesEnum.SALDO_INICIAL.getValor());
			IJogador iJogador = new IJogador(jogador);
			
			JButton tecnicoDoJogador = this.tecnicosDosJogadores.get(i);
			Icon iconeTecnicoDoJogador = tecnicoDoJogador.getIcon();
			
			iJogador.setImagemPersonagem(iconeTecnicoDoJogador);
			iJogadores.add(iJogador);
			jogadores.add(jogador);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(todosOsNomesSetados() && tecnicosEscolhidos()){
			criarJogadores();
			try {
				Injector injectorBI = Guice.createInjector(new TabuleiroModule());
				TabuleiroDirector tabuleiroDirector = injectorBI
						.getInstance(TabuleiroDirector.class);
				tabuleiroDirector.construirTabuleiro();
				Tabuleiro tabuleiro = tabuleiroDirector.getTabuleiro();
				
				BancoImobiliario bancoImobiliario = new BancoImobiliarioImpl(jogadores, tabuleiro);
				
				IJogador iJogador1 = iJogadores.get(0);
				IJogador iJogador2 = iJogadores.get(1);
				
				ControladorTabuleiro controladorTabuleiro = new ControladorTabuleiro(bancoImobiliario, iJogador1, iJogador2, restartGame);
				controladorTabuleiro.inicializar();
				
				this.guiTelaInicial.pararMusica();
				this.guiTelaInicial.dispose();
			} catch (ErroArquivoConfiguracoesException e1) {
				JOptionPane.showMessageDialog(botaoInicial, "Erro no arquivo de configuração", "Erro!", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			} catch (MontadorTabuleiroException e1) {
				JOptionPane.showMessageDialog(botaoInicial, "Erro na configuração do tabuleiro", "Erro!", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}	
		}else if(!tecnicosEscolhidos() && !todosOsNomesSetados()){
			JOptionPane.showMessageDialog(botaoInicial, "Faltam nomes e técnicos", "Aviso!", JOptionPane.WARNING_MESSAGE);
		}else if(!tecnicosEscolhidos()){
			JOptionPane.showMessageDialog(botaoInicial, "Faltam os técnicos", "Aviso!", JOptionPane.WARNING_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(botaoInicial, "Faltam os nomes", "Aviso!", JOptionPane.WARNING_MESSAGE);
		}
		
	}

}
