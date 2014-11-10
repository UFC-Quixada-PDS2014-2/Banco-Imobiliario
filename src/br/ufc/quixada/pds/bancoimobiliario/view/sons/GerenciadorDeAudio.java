package br.ufc.quixada.pds.bancoimobiliario.view.sons;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
 
public class GerenciadorDeAudio extends Thread { 
 
    private String nomeDoArquivo;
 
    private Posicao curPosition;
    
    private static final int TAMANHO_BUFFER_EXTERNO = 524288; // 128Kb 
 
    enum Posicao { 
        ESQUERDA, DIREITA, NORMAL
    };
 
    public GerenciadorDeAudio(String arquivoWAV) { 
        nomeDoArquivo = arquivoWAV;
        curPosition = Posicao.NORMAL;
    } 
 
    public GerenciadorDeAudio(String wavfile, Posicao p) { 
        nomeDoArquivo = wavfile;
        curPosition = p;
    } 
 
    public void run() { 
 
        File arquivoDeAudio = new File(nomeDoArquivo);
        if (!arquivoDeAudio.exists()) { 
            return;
        } 
 
        AudioInputStream audioInputStream = null;
        try { 
            audioInputStream = AudioSystem.getAudioInputStream(arquivoDeAudio);
        } catch (UnsupportedAudioFileException e1) { 
            return;
        } catch (IOException e1) { 
            return;
        } 
 
        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
 
        try { 
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
        } catch (LineUnavailableException e) { 
            return;
        } catch (Exception e) { 
            return;
        } 
 
        if (auline.isControlSupported(FloatControl.Type.PAN)) { 
            FloatControl pan = (FloatControl) auline
                    .getControl(FloatControl.Type.PAN);
            if (curPosition == Posicao.DIREITA) 
                pan.setValue(1.0f);
            else if (curPosition == Posicao.ESQUERDA) 
                pan.setValue(-1.0f);
        } 
 
        auline.start();
        int nBytesRead = 0;
        byte[] abData = new byte[TAMANHO_BUFFER_EXTERNO];
 
        try { 
            while (nBytesRead != -1) { 
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) 
                    auline.write(abData, 0, nBytesRead);
            } 
        } catch (IOException e) {
            return;
        } finally { 
            auline.drain();
            auline.close();
        } 
 
    } 
} 