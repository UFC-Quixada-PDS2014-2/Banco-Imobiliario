package br.ufc.quixada.pds.bancoimobiliario.view.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.Normalizer;

import javax.swing.ImageIcon;

import br.ufc.quixada.pds.bancoimobiliario.controller.ControladorTabuleiro;
import br.ufc.quixada.pds.bancoimobiliario.view.ILogradouro;
import br.ufc.quixada.pds.bancoimobiliario.view.enumeration.CaminhoImagensEnum;

public class ActionHoverCasaListener extends MouseAdapter{

	private ILogradouro iLogradouro;
	
	public ActionHoverCasaListener(ILogradouro iLogradouro){
		this.iLogradouro = iLogradouro;
	}

	@Override
	public void mouseEntered(MouseEvent evt) {
		super.mouseEntered(evt);
		String nomeImagem = iLogradouro.getNome().replaceAll("\\s","").toLowerCase();
		nomeImagem = Normalizer.normalize(nomeImagem, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		
		URL pathImagem = ActionHoverCasaListener.class.getResource(CaminhoImagensEnum.PASTA_CASAS_OPACAS.getValor() + nomeImagem  +"-opaca.png");
		ImageIcon imageIcon = new ImageIcon(pathImagem);
		iLogradouro.getCasa().setIcon(imageIcon);
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		super.mouseExited(e);
		String nomeImagem = iLogradouro.getNome().replaceAll("\\s","").toLowerCase();
		nomeImagem = Normalizer.normalize(nomeImagem, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		
		URL pathImagem = ActionHoverCasaListener.class.getResource(CaminhoImagensEnum.PASTA_CASAS.getValor() + nomeImagem  +".png");
		
		ImageIcon imageIcon = new ImageIcon(pathImagem);
		iLogradouro.getCasa().setIcon(imageIcon);
	}

	
}
