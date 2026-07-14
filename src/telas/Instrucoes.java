package telas;

import javax.swing.*;
import java.awt.*;
import principal.*;

public class Instrucoes extends JPanel{
		
	private Janela janela;
	private Image fundoInstrucoes;
	
	public Instrucoes(Janela janela) {
		this.janela = janela;
			
		fundoInstrucoes = new ImageIcon(getClass().getResource("/imagens/FundoInstrucoes.jpeg")).getImage();
			
		setLayout(null);
			
		JTextArea texto = new JTextArea();
	       texto.setText("""
	               Você é um atendente da central de monitoramento da Polícia Militar.
	               Durante uma ligação, uma mulher vítima de violência doméstica tentará pedir ajuda.

	               Suas escolhas podem:
	               • Revelar pistas;
	               • Economizar ou perder tempo;
	               • Ganhar ou perder pontos;
	               
	               A cada missão, você reconstruirá parte do trajeto percorrido por Aurora e encontrará peças de um quebra-cabeça. 
	               Ao final, monte-o para descobrir a pista decisiva e localizar a vítima.

	               Escolha com atenção. O tempo é limitado.
	               """);

	       texto.setFont(new Font("Arial", Font.BOLD, 25));
	       texto.setBounds(325, 225, 600, 450);
	       texto.setEditable(false);
	       texto.setOpaque(false);
	       texto.setForeground(Color.WHITE);
	       texto.setLineWrap(true);
	       texto.setWrapStyleWord(true);
	       texto.setBorder(null);
	       texto.setFocusable(false);
	       add(texto);
	        
	       JButton voltar = new JButton();
	       voltar.setBounds(450, 700, 330, 80);
	       voltar.setOpaque(false);
	       voltar.setContentAreaFilled(false);
	       voltar.setBorderPainted(false);
	       voltar.setFocusPainted(false);
	       add(voltar);
	       voltar.addActionListener(e -> {
	            janela.trocarTela("MENU");
	        });
	        
		}
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(fundoInstrucoes, 0, 0, getWidth(), getHeight(), this);

		}

	}
