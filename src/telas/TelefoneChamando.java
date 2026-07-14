package telas;

import javax.swing.*;
import java.awt.*;

import principal.Janela;
import dados.*;

public class TelefoneChamando extends JPanel {

    private Janela janela;
    private Image fundo;

    public TelefoneChamando(Janela janela) {

        this.janela = janela;
        
        setLayout(null);
    	
    	fundo = new ImageIcon(getClass().getResource("/imagens/TelefoneChamando.gif")).getImage();
    }

    public void iniciar() {
        Som.tocarTelefone();
        Timer timer = new Timer(10000, e -> {
            Som.pararTelefone();
            janela.trocarTela("cena1");
        });

        timer.setRepeats(false);
        timer.start();
    }
    @Override //(substituir) painel padrão
    protected void paintComponent(Graphics g) { //Trocar o painel original pelo que estou criando
        super.paintComponent(g); //(super) chama desenho original do JPanel
        g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this); //Imagem que será desenhada, posição, largura, altura, painel que está desenhando
    }

}
