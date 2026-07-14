package telas;

import javax.swing.*;
import java.awt.*;

import principal.Janela;
import dados.*;

public class Pergunta4 extends JPanel {

    private Janela janela;
    
    private JLabel titulo;
    private JTextArea pergunta;
    private JTextArea resposta;
    private JLabel titulo2;

    private JButton op1;
    private JButton op2;
    private JButton op3;
    private JButton continuar;

    public Pergunta4(Janela janela) {

        this.janela = janela;

        setLayout(null);
        setBackground(Color.BLACK);

        titulo = new JLabel("""
        		<html>
        		<center>
        		PERGUNTA 1<br>
        		Você sabe identificar padrões de abuso?<br>
        		Com base no relato de Aurora, qual alternativa está correta?
        		</center>
        		</html>
        		""");
        titulo.setBounds(140, 20, 1100, 200);
        titulo.setForeground(new Color(170, 120, 255));
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 34));
        add(titulo);
        
        titulo2 = new JLabel("RESPOSTA CORRETA!");
    	titulo2.setBounds(480, 40, 400, 50);
    	titulo2.setForeground(new Color(190, 140, 255));
    	titulo2.setFont(new Font("Segoe UI Black", Font.BOLD, 36));
    	titulo2.setVisible(false);
    	add(titulo2);

        pergunta = new JTextArea();
        pergunta.setBounds(220, 300, 900, 380);
        pergunta.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        pergunta.setForeground(Color.WHITE);
        pergunta.setOpaque(false);
        pergunta.setEditable(false);
        pergunta.setFocusable(false);
        pergunta.setBorder(null);
        pergunta.setLineWrap(true);
        pergunta.setWrapStyleWord(true);
        pergunta.setText("""
                1. Violência doméstica acontece apenas quando existe agressão física.

                2. Controle excessivo, ameaças e manipulação também são formas de violência doméstica.

                3. Isso é normal. Todo casal passa por situações assim.
                """);
        add(pergunta);

        resposta = new JTextArea();
        resposta.setBounds(180, 150, 900, 400);
        resposta.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        resposta.setForeground(Color.WHITE);
        resposta.setOpaque(false);
        resposta.setEditable(false);
        resposta.setFocusable(false);
        resposta.setBorder(null);
        resposta.setLineWrap(true);
        resposta.setWrapStyleWord(true);
        add(resposta);

        op1 = new JButton("OPÇÃO 1");
        configurarBotao(op1);
        op1.setBounds(260, 670, 180, 50);
        op1.addActionListener(e -> Pontuacao.removerPontos(5));
        op1.addActionListener(e -> verificarResposta(1));
        add(op1);

        op2 = new JButton("OPÇÃO 2");
        configurarBotao(op2);
        op2.setBounds(540, 670, 180, 50);
        op2.addActionListener(e -> Pontuacao.removerPontos(5));
        op2.addActionListener(e -> verificarResposta(2));
        add(op2);

        op3 = new JButton("OPÇÃO 3");
        configurarBotao(op3);
        op3.setBounds(820, 670, 180, 50);
        op3.addActionListener(e -> Pontuacao.adicionarPontos(5));
        op3.addActionListener(e -> verificarResposta(3));
        add(op3);

        continuar = new JButton("CONTINUAR");
        configurarBotao(continuar);
        continuar.setBounds(500, 680, 250, 55);
        continuar.setVisible(false);
        continuar.addActionListener(e -> janela.trocarTela("VIATURA2"));
        add(continuar);
        
    }

    private void configurarBotao(JButton botao) {
        botao.setFont(new Font("Segoe UI", Font.BOLD, 20));
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(40, 40, 40));
        botao.setBorder(BorderFactory.createLineBorder(new Color(120, 80, 180), 3));
        botao.setFocusPainted(false);
    }
    
    private void verificarResposta(int opcao) {
        responder(opcao);
    }
    
    private void responder(int r) {
    	
    	titulo.setVisible(false);
        pergunta.setVisible(false);
        op1.setVisible(false);
        op2.setVisible(false);
        op3.setVisible(false);

        if (r == 2) {
        	titulo2.setVisible(true);       	
        resposta.setText("""
			A violência doméstica pode ocorrer de diversas formas.
			
			Ela nem sempre deixa marcas físicas.
			
			Controle excessivo, ameaças e manipulação também caracterizam violência contra a mulher.
			
			Reconhecer esses sinais é o primeiro passo para buscar ajuda.
			
        	""");
        } 
        else {
            resposta.setText("""
                    A alternativa correta era:

                    Controle excessivo, ameaças e manipulação também
                    caracterizam violência doméstica.

                    Muitas vítimas demoram a perceber que esses comportamentos
                    também são formas de violência.
                    """);
        }

        resposta.setVisible(true);
        continuar.setVisible(true);
    }
}


