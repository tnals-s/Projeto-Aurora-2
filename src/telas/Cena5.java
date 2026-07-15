package telas;

import javax.swing.*;
import java.awt.*;

import principal.Janela;
import dados.Som;

public class Cena5 extends JPanel {

    private final Janela janela;
    private Image fundo;

    public Cena5(Janela janela) {
        
        this.janela = janela;
        fundo = new ImageIcon(getClass().getResource("/imagens/Policiais.gif")).getImage();

        setLayout(null);
        
        JTextArea texto = new JTextArea("Central, localizamos o endereço da vítima.");
        texto.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        texto.setForeground(Color.WHITE);
        texto.setOpaque(false);
        texto.setEditable(false);
        texto.setFocusable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        // Subimos um pouco e demos mais espaço para quebras de linha
        texto.setBounds(70, 120, 600, 150); 
        add(texto);
        
        JButton botao = new JButton("RESGATAR AURORA"); 
        // Subimos o botão verticalmente para não ficar cortado (y = 500)
        botao.setBounds(70, 680, 250, 60); 
        botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(40, 40, 40));
        botao.setBorder(BorderFactory.createLineBorder(new Color(120, 80, 180), 3)); 
        botao.setFocusPainted(false);
        botao.addActionListener(e -> {
            Som.pararRadio(); 
            janela.trocarTela("MAPA3"); 
        });
        add(botao);
    }
    
    public void iniciarCena() { 
        Som.tocarRadio(); 
    }
     
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);
    }
}