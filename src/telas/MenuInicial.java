package telas;

import javax.swing.*; //Componentes Swing
import java.awt.*; //Classes gráficas do Java
import principal.*;
import dados.*;

public class MenuInicial extends JPanel{ //É um painel
	
	// Referência para a janela principal.
	// Permite que este painel solicite a troca de telas.
	private Janela janela;
	private Image fundo; //Variável que vai guardar a imagem de fundo
		
		public MenuInicial(Janela janela) {
			// Guarda a referência da janela recebida
			this.janela = janela;
		
			fundo = new ImageIcon(getClass().getResource("/imagens/FundoMenuInicial.jpeg")).getImage(); //Coloca a imagem dentro da variável
			/* getClass pega a classe atual
			   getResource procura um arquivo dentro do projeto
			   new ImageIcon transforma o arquivo em um ícone/imagem que o Swing entende
			   getImage converte para o tipo Image
			*/
			setLayout(null); //Desliga o gerenciador automático de posição
	
	        JButton jogar = new JButton();
			jogar.setBounds(500, 325, 290, 80); 
			jogar.setOpaque(false);
			jogar.setContentAreaFilled(false);
			jogar.setBorderPainted(false);
			jogar.setFocusPainted(false);
			add(jogar);
			jogar.addActionListener(e -> {
	            janela.trocarTela("INTRODUCAO");
	        });
	
	        JButton instrucoes = new JButton();
	        instrucoes.setBounds(500, 425, 290, 80);
	        instrucoes.setOpaque(false);
			instrucoes.setContentAreaFilled(false);
			instrucoes.setBorderPainted(false);
			instrucoes.setFocusPainted(false);
	        add(instrucoes);
	        instrucoes.addActionListener(e -> {
	        	// Solicita à janela principal que exiba a tela de instruções
	            janela.trocarTela("INSTRUCOES");
	        });
	        
	        JButton sair = new JButton();
	        sair.setBounds(500, 515, 290, 80);
	        sair.setOpaque(false);
			sair.setContentAreaFilled(false);
			sair.setBorderPainted(false);
			sair.setFocusPainted(false);
	        add(sair);
	        sair.addActionListener(e -> System.exit(0));    
	    }
        @Override //(substituir) painel padrão
        protected void paintComponent(Graphics g) { //Trocar o painel original pelo que estou criando
            super.paintComponent(g); //(super) chama desenho original do JPanel
            g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this); //Imagem que será desenhada, posição, largura, altura, painel que está desenhando
        }
}
