/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.ufc.quixada.pds.bancoimobiliario.model.Logradouro;

/**
 * 
 * @author sandro
 */
public class ILogradouro {

	private Logradouro logradouro;
	private JButton casa;

	public ILogradouro(Logradouro logradouro, JButton casa) {
		this.logradouro = logradouro;
		this.casa = casa;
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
		return this.casa.getX();
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return this.casa.getY();
	}

	public void addObjetoDireita(Component component) {
		casa.add(component, BorderLayout.EAST);
	}

	public void addObjetoEsquerda(Component component) {
		casa.add(component, BorderLayout.WEST);
	}

	public JButton getCasa() {
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
