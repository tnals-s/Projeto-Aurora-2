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
        		PERGUNTA 4<br>
        		O que é uma "Medida Protetiva de Urgência"<br>
        		prevista na Lei Maria da Penha?
        		</center>
        		</html>
        		""");
        titulo.setBounds(140, 20, 1100, 200);
        titulo.setForeground(new Color(170, 120, 255));
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 34));
        add(titulo);
        
        titulo2 = new JLabel("RESPOSTA CORRETA!");
    	titulo2.setBounds(430, 40, 500, 50);
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
                1. Uma punição aplicada ao agressor somente após ele ser julgado e condenado pelo juiz.

                2. Uma ordem judicial rápida que proíbe o agressor de se aproximar ou fazer contato com a vítima, sob pena de prisão imediata se descumprida.

                3. Um documento que obriga o casal a fazer terapia ou mediação familiar para tentar salvar o casamento.
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
        op2.addActionListener(e -> Pontuacao.adicionarPontos(5));
        op2.addActionListener(e -> verificarResposta(2));
        add(op2);

        op3 = new JButton("OPÇÃO 3");
        configurarBotao(op3);
        op3.setBounds(820, 670, 180, 50);
        op3.addActionListener(e -> Pontuacao.removerPontos(5));
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
        botao.setForeground(new Color(240, 220, 255));
        botao.setBackground(new Color(55, 35, 80));
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
        	É fundamental ao identificar o abuso, que não é só agressão física, compreender a dificuldade da vítima no ciclo da violência e saber como agir (Ligue 180 ou 190 / acolhimento).
        	
        	Além disso, conhecer a proteção jurídica imediata (Medidas Protetivas).
        			
        	Isso pode salvar uma vida.
        	""");
        } 
        else {
            resposta.setText("""
                    A alternativa correta era:

                    Uma ordem judicial rápida que proíbe o agressor de se aproximar ou
                    fazer contato com a vítima, sob pena de prisão imediata se descumprida.

                    Uma denúncia não é apenas um papel assinado.
                    A ordem judicial protege as vítimas.
                    """);
        }

        resposta.setVisible(true);
        continuar.setVisible(true);
    }
}


