package telas;

import javax.swing.*;
import java.awt.*;

import principal.Janela;
import dados.Som;

public class Viatura2 extends JPanel {

    private final Janela janela;
    private Image fundo;

    public Viatura2(Janela janela) {
    	
        this.janela = janela;
        fundo = new ImageIcon(getClass().getResource("/imagens/Viatura.gif")).getImage();

        setLayout(null);
        
        JLabel texto = new JLabel("""
                <html>
                Novas informações foram registradas.<br>
                Continue auxiliando a equipe.<br>
                MISSÃO 2 - DISPONÍVEL!
                </html>
                """);
        texto.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        texto.setForeground(Color.WHITE);
        texto.setBounds(70, 40, 600, 300);
        add(texto);
        
        JButton botao = new JButton("CONTINUAR");
        botao.setBounds(310, 680, 200, 60);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botao.setForeground(new Color(240, 220, 255));
        botao.setBackground(new Color(55, 35, 80));
        botao.setBorder(BorderFactory.createLineBorder(new Color(120, 80, 180), 3));
        botao.setFocusPainted(false);
        botao.addActionListener(e -> {
        	Som.pararSirene();
            janela.trocarTela("MAPA2");
        });
        add(botao);
    	}
    
        public void iniciarCena() { 
            Som.tocarSirene();
        }
     
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);
    }
}


