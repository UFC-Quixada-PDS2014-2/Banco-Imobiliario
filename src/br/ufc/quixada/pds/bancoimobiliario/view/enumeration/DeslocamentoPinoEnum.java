package br.ufc.quixada.pds.bancoimobiliario.view.enumeration;

public enum DeslocamentoPinoEnum {

	
	PINO_SUPERIOR_ESQUERDA(0), PINO_INFERIOR_DIREITA(1);
	
	private int deslocamento;

	DeslocamentoPinoEnum(int deslocamento){
		this.deslocamento = deslocamento;
	}
	
	public int getDeslocamento() {
		return deslocamento;
	}

	
}
