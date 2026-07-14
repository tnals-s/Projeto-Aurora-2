package telas;

import javax.swing.*;
import java.awt.*;
import principal.Janela;

public class Mapa3 extends JPanel {

    private final Janela janela;
    private Image fundo;

    public Mapa3(Janela janela) {
        this.janela = janela;
        fundo = new ImageIcon(getClass().getResource("/imagens/Mapa.jpeg")).getImage();
        setLayout(null);
        
        JButton casa = new JButton();
        casa.setBounds(122, 387, 120, 120);
        configurarBotao(casa);
        casa.addActionListener(e -> janela.trocarTela("ENCERRAMENTO"));
        add(casa);
        
        //INVÁLIDOS
        
        JButton delegacia = new JButton();
        delegacia.setBounds(825, 36, 120, 120);
        configurarBotao(delegacia);
        delegacia.addActionListener(e ->
        JOptionPane.showMessageDialog(this, "A viatura já foi enviada."));
        add(delegacia);

        JButton igreja = new JButton();
        igreja.setBounds(1036, 297, 120, 120);
        configurarBotao(igreja);
        igreja.addActionListener(e ->
        JOptionPane.showMessageDialog(this, "Missão concluída."));
        add(igreja);
        
        JButton restaurante = new JButton();
        restaurante.setBounds(517, 405, 120, 120);
        configurarBotao(restaurante);
        restaurante.addActionListener(e ->
        JOptionPane.showMessageDialog(this, "Missão concluída."));
        add(restaurante);
    }

    private void configurarBotao(JButton botao) {
        botao.setOpaque(false);
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);
        botao.setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);
    }
}


