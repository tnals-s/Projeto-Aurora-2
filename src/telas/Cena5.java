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
        
        JLabel texto = new JLabel("Central, localizamos o endereço da vítima.");
        texto.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        texto.setForeground(Color.WHITE);
        texto.setBounds(70, 80, 600, 40);
        add(texto);
        
        JButton botao = new JButton("RESGATAR AURORA");
        botao.setBounds(310, 700, 200, 70);
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