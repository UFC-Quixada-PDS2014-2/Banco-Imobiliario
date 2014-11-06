package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class GUITelaInicial extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	
	public GUITelaInicial(){
		
		Rectangle dimensoesTela = new Rectangle(1150, 700);
	    this.setBounds(dimensoesTela);
	    initComponents();
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
	    
	    JLabel background = new JLabel();
	    background.setIcon(null);
	    background.setBounds(0, -28, 1150, 700);
	    //getContentPane().add(background);
	    
	    JButton tecnico1 = new JButton("");
	    tecnico1.setIcon(null);
	    tecnico1.setBackground(Color.WHITE);
	    tecnico1.setBounds(64, 28, 117, 150);
	    getContentPane().add(tecnico1);
	    
	    JButton tecnico2 = new JButton("");
	    tecnico2.setBackground(Color.WHITE);
	    tecnico2.setBounds(245, 28, 117, 150);
	    getContentPane().add(tecnico2);
	    
	    JButton tecnico3 = new JButton("");
	    tecnico3.setBackground(Color.WHITE);
	    tecnico3.setBounds(426, 28, 117, 150);
	    getContentPane().add(tecnico3);
	    
	    JButton tecnico4 = new JButton("");
	    tecnico4.setBackground(Color.WHITE);
	    tecnico4.setBounds(607, 28, 117, 150);
	    getContentPane().add(tecnico4);
	    
	    JButton tecnico5 = new JButton("");
	    tecnico5.setBackground(Color.WHITE);
	    tecnico5.setBounds(788, 28, 117, 150);
	    getContentPane().add(tecnico5);
	    
	    JButton tecnico6 = new JButton("");
	    tecnico6.setBackground(Color.WHITE);
	    tecnico6.setBounds(969, 28, 117, 150);
	    getContentPane().add(tecnico6);
	    
	    textField = new JTextField();
	    textField.setBounds(40, 440, 169, 33);
	    getContentPane().add(textField);
	    textField.setColumns(10);
	    
	    JButton button = new JButton("");
	    button.setBackground(Color.WHITE);
	    button.setBounds(40, 493, 117, 150);
	    getContentPane().add(button);
	    
	    JLabel lblNewLabel = new JLabel("Nome jogador 1:");
	    lblNewLabel.setBounds(40, 413, 119, 20);
	    getContentPane().add(lblNewLabel);
	    
	    JButton button_1 = new JButton("");
	    button_1.setBackground(Color.WHITE);
	    button_1.setBounds(993, 493, 117, 150);
	    getContentPane().add(button_1);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(941, 440, 169, 33);
	    getContentPane().add(textField_1);
	    
	    JLabel label = new JLabel("Nome jogador 2:");
	    label.setBounds(991, 413, 119, 20);
	    getContentPane().add(label);
	    this.setResizable(false);
	    this.setVisible(true);
	}
	
	public void initComponents(){
		
	   
	}
}
