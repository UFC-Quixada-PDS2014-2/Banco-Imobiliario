package br.ufc.quixada.pds.bancoimobiliario.view.enumeration;

public enum CaminhoImagensEnum {

	PASTA_IMAGENS("/br/ufc/quixada/pds/bancoimobiliario/view/img/"), 
	PASTA_CASAS("/br/ufc/quixada/pds/bancoimobiliario/view/img/casas/"),
	PASTA_CASAS_OPACAS("/br/ufc/quixada/pds/bancoimobiliario/view/img/casas_opacas/"),
	PASTA_TECNICOS("/br/ufc/quixada/pds/bancoimobiliario/view/img/tecnicos/"),
	PASTA_SONS("/br/ufc/quixada/pds/bancoimobiliario/view/img/sons/");
	
	CaminhoImagensEnum(String valor){
		this.valor = valor;
	}
	
	private String valor;

	public String getValor() {
		return valor;
	}
	
}
