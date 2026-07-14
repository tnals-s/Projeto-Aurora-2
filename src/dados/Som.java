package dados;

import javax.sound.sampled.*;
import java.net.URL;

public class Som {
    
    private static Clip somTeclado;
    private static Clip somTelefone;
    private static Clip somRadio;
    private static Clip somSirene;

    // Carrega um arquivo WAV e retorna um Clip
    private static Clip carregar(String arquivo) {
        try {
            URL url = Som.class.getResource("/sons/" + arquivo);
            AudioInputStream audio = AudioSystem.getAudioInputStream(url);

            Clip clip = AudioSystem.getClip();
            clip.open(audio);

            return clip;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
  
    public static void carregarSons() {

        somTeclado = carregar("SomTeclado.wav");
        somTelefone = carregar("SomTelefone.wav");
        somRadio = carregar("SomRadio.wav");
        somSirene = carregar("SomSirene.wav");

    }

    private static void tocar(Clip clip) {

        if (clip == null)
            return;

        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    private static void parar(Clip clip) {

        if (clip == null)
            return;

        clip.stop();
        clip.setFramePosition(0);
    }

    public static void tocarTeclado() {
        tocar(somTeclado);
    }

    public static void pararTeclado() {
        parar(somTeclado);
    }
    
    public static void tocarTelefone() {
        tocar(somTelefone);
    }

    public static void pararTelefone() {
        parar(somTelefone);
    }
    
    public static void tocarRadio() {
        tocar(somRadio);
    }

    public static void pararRadio() {
        parar(somRadio);
    }
    
    public static void tocarSirene() {
        tocar(somSirene);
    }

    public static void pararSirene() {
        parar(somSirene);
    }
    
}
