package br.ufc.quixada.pds.bancoimobiliario.view;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;

public class PanelVideoAbertura extends JPanel{

	public PanelVideoAbertura(URL mediaURL) {
		
		setLayout( new BorderLayout() );
		Manager.setHint( Manager.LIGHTWEIGHT_RENDERER, true );
		
		try {
			Player mediaPlayer = Manager.createRealizedPlayer( mediaURL );
			
			Component video = mediaPlayer.getVisualComponent();
			Component controls = mediaPlayer.getControlPanelComponent();
			 
			if ( video != null )
				add( video, BorderLayout.CENTER );
			  	
			if ( controls != null )
				add( controls, BorderLayout.SOUTH ); 
				
			mediaPlayer.start();
			
		} catch (NoPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotRealizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
