package telas;

import javax.swing.*;
import java.awt.*;

import principal.Janela;
import dados.Som;

public class Encerramento extends JPanel {

    private final Janela janela;
    private Image fundo;

    public Encerramento(Janela janela) {
    	
        this.janela = janela;
        fundo = new ImageIcon(getClass().getResource("/imagens/Policiais.gif")).getImage();

        setLayout(null);
        
        JLabel texto = new JLabel("""
                <html><center>
                Toda denúncia pode salvar uma vida.<br>
                Em caso de violência contra a mulher, denuncie.<br>
                Ligue 190 em situações de emergência ou 180 para orientação e denúncia.
                </center></html>
                """);
        texto.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        texto.setForeground(Color.WHITE);
        texto.setBounds(70, 40, 600, 600);
        add(texto);
        
        JButton botao = new JButton("CONTINUAR");
        botao.setBounds(310, 700, 200, 70);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(40, 40, 40));
        botao.setBorder(BorderFactory.createLineBorder(new Color(120, 80, 180), 3));
        botao.setFocusPainted(false);
        botao.addActionListener(e -> {
        	Som.pararSirene();
            janela.trocarTela("FIMDEJOGO");
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

