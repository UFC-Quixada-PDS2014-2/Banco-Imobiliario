package br.ufc.quixada.pds.bancoimobiliario.controller.telainicial;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaInicial;
import br.ufc.quixada.pds.bancoimobiliario.view.enumeration.CaminhoImagensEnum;


public class ActionListenerPararMusica implements ActionListener{
	private JButton pararMusica;
	private GUITelaInicial guiTelaInicial;
	
	public ActionListenerPararMusica(JButton pararMusica, GUITelaInicial guiTelaInicial){
		this.pararMusica = pararMusica;
		this.guiTelaInicial = guiTelaInicial;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.guiTelaInicial.musicaAtiva()){
			this.guiTelaInicial.pararMusica();
			this.pararMusica.setIcon(new ImageIcon(ActionListenerPararMusica.class.getResource(CaminhoImagensEnum.PASTA_SONS.getValor() + "music_off.png")));
		}else{
			this.guiTelaInicial.iniciarMusica();
			this.pararMusica.setIcon(new ImageIcon(ActionListenerPararMusica.class.getResource(CaminhoImagensEnum.PASTA_SONS.getValor() + "music_on.png")));
		}
	}

}
