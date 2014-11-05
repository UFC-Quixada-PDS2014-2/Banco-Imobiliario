/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.quixada.pds.bancoimobiliario.viewTeste;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;

/**
 * 
 * @author sandro
 */
public class ILogradouro {

	private Logradouro logradouro;
	private JPanel casa;
	private int x;
	private int y;

	public ILogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
		casa = new JPanel();
		casa.setLayout(new BorderLayout());
		casa.setOpaque(false);
	}

	/**
	 * @return the logradouro
	 */
	public Logradouro getLogradouro() {
		return logradouro;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	public void addObjetoDireita(Component component) {
		casa.add(component, BorderLayout.EAST);
	}

	public void addObjetoEsquerda(Component component) {
		casa.add(component, BorderLayout.WEST);
	}

	public JPanel getCasa() {
		return casa;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ILogradouro other = (ILogradouro) obj;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		return true;
	}

}
