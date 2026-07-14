package dados;

import javax.swing.*;

public class Cronometro {

    private static long inicio;
    private static Timer timer;
    private static JLabel label;

    public static void iniciar(JLabel lbl) {
        if(timer != null) {
            timer.stop();
        }

        label = lbl;
        inicio = System.currentTimeMillis();
        timer = new Timer(1000, e -> atualizar());
        timer.start();
    }

    private static void atualizar() {
        if(label == null) {
            return;
        }

        long tempo = (System.currentTimeMillis() - inicio) / 1000;
        long minutos = tempo / 60;
        long segundos = tempo % 60;

        label.setText(String.format("Tempo: %02d:%02d", minutos, segundos));
    }

    public static long finalizar() {
        if(timer != null) {
            timer.stop();
            timer = null;
        }

        return
        (System.currentTimeMillis() - inicio) / 1000;
    }

}