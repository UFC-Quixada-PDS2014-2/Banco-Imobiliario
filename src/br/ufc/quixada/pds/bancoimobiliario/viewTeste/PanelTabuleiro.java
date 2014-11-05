package br.ufc.quixada.pds.bancoimobiliario.viewTeste;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelTabuleiro extends JPanel {

	private Image background;
	private static final String imagem = "img/Tabuleiro.png";

	public PanelTabuleiro() {
		URL res = getClass().getResource(imagem);
		if (res == null) {
			throw new IllegalArgumentException("resource not found: " + imagem);
		}
		background = Toolkit.getDefaultToolkit().createImage(res);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (background != null) {
			int w = background.getWidth(this);
			int h = background.getHeight(this);
			if (w > 0 && h > 0) {
				for (int y = 0; y < getHeight(); y += h) {
					for (int x = 0; x < getWidth(); x += w) {
						g.drawImage(background, x, y, this);
					}
				}
			}
		}
	}

}
