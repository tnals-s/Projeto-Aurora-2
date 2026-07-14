package telas;

import javax.swing.*;
import java.awt.*;

import principal.Janela;
import dados.*;

public class Introducao extends JPanel {

	private Image fundo;
	private Janela janela;
	private JTextArea texto;
	private JButton continuar;
	private String introducao = """
			Todos os dias, inúmeras vítimas de violência buscam ajuda.

			Aurora é uma dessas vítimas.
			
			Ela vem enfrentando o ciclo da violência doméstica:
			• Controle excessivo
			• Ameaças
			• Abusos
			• Manipulação

			Hoje não foi diferente.
			
			Mas, desta vez, Aurora decidiu romper o silêncio.
			""";

    public Introducao(Janela janela) {
    	
    	this.janela = janela;
    	
    	setLayout(null);
    	
    	fundo = new ImageIcon(getClass().getResource("/imagens/FundoIntroducao.jpeg")).getImage();
        
        texto = new JTextArea();
        texto.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        texto.setBounds(45, 90, 570, 500);
        texto.setOpaque(false);
        texto.setForeground(new Color(235, 235, 235));
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        texto.setBorder(null);
        add(texto);
        
        continuar = new JButton("CONTINUAR");
        continuar.setBounds(180, 600, 280, 90);
        continuar.setFont(new Font("Impact", Font.BOLD, 35));
        continuar.setForeground(Color.WHITE);
        continuar.setForeground(new Color(240, 220, 255));
        continuar.setBackground(new Color(55, 35, 80));
        continuar.setFocusPainted(false); 
        continuar.setBorder(BorderFactory.createLineBorder(new Color(170, 100, 255), 3));
        continuar.setVisible(false);
        add(continuar);
        continuar.addActionListener(e -> {
            janela.trocarTela("TELEFONE");
        });
        
    }
    public void iniciar() {
    	Som.tocarTeclado();
        EfeitoDigitacao.digitar(texto, introducao, 50,  
        	() -> {
            Som.pararTeclado();
            continuar.setVisible(true);
    }
    );
    }
        @Override //(substituir) painel padrão
        protected void paintComponent(Graphics g) { //Trocar o painel original pelo que estou criando
            super.paintComponent(g); //(super) chama desenho original do JPanel
            g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this); //Imagem que será desenhada, posição, largura, altura, painel que está desenhando
        
        }
}