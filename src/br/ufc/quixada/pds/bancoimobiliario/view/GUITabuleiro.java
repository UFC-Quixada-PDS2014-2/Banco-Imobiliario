package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUITabuleiro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITabuleiro frame = new GUITabuleiro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUITabuleiro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 900,552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon background = new ImageIcon(this.getClass().getResource("img/background.png"));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(190, 0, 89, 89);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(619, 0, 89, 89);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(283, 0, 50, 78);
		contentPane.add(btnNewButton_1);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(339, 0, 50, 78);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(395, 0, 50, 78);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(451, 0, 50, 78);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(507, 0, 50, 78);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(562, 0, 50, 78);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(190, 431, 89, 89);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(283, 442, 50, 78);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(339, 442, 50, 78);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("New button");
		button_9.setBounds(395, 442, 50, 78);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("New button");
		button_10.setBounds(451, 442, 50, 78);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("New button");
		button_11.setBounds(507, 442, 50, 78);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("New button");
		button_12.setBounds(562, 442, 50, 78);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("New button");
		button_13.setBounds(619, 431, 89, 89);
		contentPane.add(button_13);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(190, 92, 73, 53);
		contentPane.add(btnNewButton_2);
		
		JButton button_14 = new JButton("New button");
		button_14.setBounds(190, 148, 73, 53);
		contentPane.add(button_14);
		
		JButton button_15 = new JButton("New button");
		button_15.setBounds(190, 206, 73, 53);
		contentPane.add(button_15);
		
		JButton button_16 = new JButton("New button");
		button_16.setBounds(190, 260, 73, 53);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("New button");
		button_17.setBounds(190, 317, 73, 53);
		contentPane.add(button_17);
		
		JButton button_18 = new JButton("New button");
		button_18.setBounds(190, 370, 73, 53);
		contentPane.add(button_18);
		
		JButton button_19 = new JButton("New button");
		button_19.setBounds(629, 148, 79, 53);
		contentPane.add(button_19);
		
		JButton button_20 = new JButton("New button");
		button_20.setBounds(629, 206, 79, 53);
		contentPane.add(button_20);
		
		JButton button_21 = new JButton("New button");
		button_21.setBounds(629, 92, 79, 53);
		contentPane.add(button_21);
		
		JButton button_22 = new JButton("New button");
		button_22.setBounds(629, 260, 79, 53);
		contentPane.add(button_22);
		
		JButton button_23 = new JButton("New button");
		button_23.setBounds(629, 317, 79, 53);
		contentPane.add(button_23);
		
		JButton button_24 = new JButton("New button");
		button_24.setBounds(629, 370, 79, 53);
		contentPane.add(button_24);
		
		JButton btnNewButton_3 = new JButton("Help");
		btnNewButton_3.setBounds(562, 89, 50, 53);
		contentPane.add(btnNewButton_3);
		
		JLabel labelBackground = new JLabel(background);
		labelBackground.setBounds(0,0, 900,520);
		
		contentPane.add(labelBackground);
		this.setVisible(true);
	}
}
