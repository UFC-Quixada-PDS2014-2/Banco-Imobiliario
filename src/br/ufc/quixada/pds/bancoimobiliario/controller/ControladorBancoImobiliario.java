package br.ufc.quixada.pds.bancoimobiliario.controller;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.model.BancoImobiliario;
import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;

public class ControladorBancoImobiliario implements Controlador{

	private BancoImobiliario bancoImobiliario;
	
	public ControladorBancoImobiliario(BancoImobiliario bancoImobiliario){
		this.bancoImobiliario = bancoImobiliario;
	}
	
	public void configurar(JPanel panel){
		//TODO adicionar todos os tratadores de eventos aqui
		
		List<JLabel> iLogradouros = new ArrayList<>();
	    List<Logradouro> logradouros = this.bancoImobiliario.getCasasDoTabuleiro();
		
		for (int i = 0; i < ConfiguracoesEnum.NUMERO_CASAS.getValor(); i++) {
			iLogradouros.add(new JLabel(logradouros.get(i).obterNome()));
		}
		// Piso da divisão do número de casas por 4 mais 1
		int tamanhoLadoTabuleiro = (ConfiguracoesEnum.NUMERO_CASAS.getValor() / 4) + 1; 
		
		GridBagConstraints posicaoLogradouroLayout = new GridBagConstraints();
		posicaoLogradouroLayout.weightx = 1;
		posicaoLogradouroLayout.weighty = 1;
		int indexLogradouro = 0;
		
		int gridx,gridy;
		
		gridy = 0;
		for (gridx = 0; gridx < (tamanhoLadoTabuleiro); gridx++) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;
			panel.add(iLogradouros.get(indexLogradouro),posicaoLogradouroLayout);
			indexLogradouro++;
		}

		gridx = tamanhoLadoTabuleiro - 1;
		for (gridy = 1; gridy < (tamanhoLadoTabuleiro - 1); gridy++) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;
			panel.add(iLogradouros.get(indexLogradouro),posicaoLogradouroLayout);
			indexLogradouro++;
		}
		
		
		gridy = tamanhoLadoTabuleiro - 1;
		for (gridx = (tamanhoLadoTabuleiro - 1); gridx  >= 0; gridx--) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;
			panel.add(iLogradouros.get(indexLogradouro),posicaoLogradouroLayout);
			indexLogradouro++;
		}

		gridx = 0;
		for (gridy = (tamanhoLadoTabuleiro - 2); gridy >= 1 ; gridy--) {
			posicaoLogradouroLayout.gridx = gridx;
			posicaoLogradouroLayout.gridy = gridy;
			panel.add(iLogradouros.get(indexLogradouro),posicaoLogradouroLayout);
			indexLogradouro++;
		}

		
		
		
	}
	
	
}
