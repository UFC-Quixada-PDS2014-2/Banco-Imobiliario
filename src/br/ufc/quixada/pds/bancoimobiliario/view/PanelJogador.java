package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class PanelJogador extends JPanel {

	private IJogador iJogador;
	private JLabel lblSaldo;
	private JLabel lblNomeJogador;
	private JLabel lblIconJogador;
	
	/**
	 * Create the panel.
	 */
	public PanelJogador(IJogador jogador) {
		setOpaque(false);
		this.iJogador = jogador;
		lblNomeJogador = new JLabel(jogador.getNomeJogador());
		lblNomeJogador.setForeground(Color.WHITE);
		lblNomeJogador.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeJogador.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblIconJogador = new JLabel("");
		lblIconJogador.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconJogador.setIcon(jogador.getImagemPersonagem());
		
		lblSaldo = new JLabel("Saldo : R$ " + jogador.getSaldoJogador());
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setForeground(Color.WHITE);
		lblSaldo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSaldo, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(lblNomeJogador, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(lblIconJogador, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNomeJogador, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIconJogador)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSaldo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(215, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void atualizar(){
		
		lblSaldo.setText("Saldo : R$ " + iJogador.getSaldoJogador());
		//TODO Atualizar lista de propriedades
		
	}
	
	public void atualizarBordaJogadorDaVez(IJogador iJogador){
		if(this.iJogador.equals(iJogador)){
			
			Border bordaPanel = new LineBorder(Color.RED, 8);
			this.setBorder(bordaPanel);
			
		}else{

			Border bordaPanel = new LineBorder(Color.white, 0);
			this.setBorder(bordaPanel);
		}
	}
	
	
}
