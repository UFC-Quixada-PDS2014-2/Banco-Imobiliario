package br.ufc.quixada.pds.bancoimobiliario.controller.telaintroducao;

import br.ufc.quixada.pds.bancoimobiliario.view.GUITelaIntroducao;

public class ControladorTelaIntroducao {
	private GUITelaIntroducao guiTelaIntroducao;
	
	public ControladorTelaIntroducao(){
		this.guiTelaIntroducao = new GUITelaIntroducao();
		inicializar();
	}
	
	private void inicializar(){
		this.guiTelaIntroducao.setVisible(true);
		adicionarEventoSkip();
	}
	
	private void adicionarEventoSkip(){
		this.guiTelaIntroducao.addKeyListener(new KeyListenerAdicionarSkip(this.guiTelaIntroducao));
	}
}
