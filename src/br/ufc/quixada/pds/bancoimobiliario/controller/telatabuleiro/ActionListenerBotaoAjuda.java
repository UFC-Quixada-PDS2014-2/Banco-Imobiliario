package br.ufc.quixada.pds.bancoimobiliario.controller.telatabuleiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.quixada.pds.bancoimobiliario.guice.GuiTelaAjudaModule;
import br.ufc.quixada.pds.bancoimobiliario.view.ajuda.GUITelaAjuda;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ActionListenerBotaoAjuda implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Injector injectorGuiTelaAjuda = Guice.createInjector(new GuiTelaAjudaModule());
		GUITelaAjuda guiTelaAjuda = injectorGuiTelaAjuda
				.getInstance(GUITelaAjuda.class);
		guiTelaAjuda.inicializar();
	}

}
