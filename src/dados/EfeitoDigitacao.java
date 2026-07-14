package dados;

import javax.swing.*;

public class EfeitoDigitacao {
	
	public static void digitar(JTextArea area, String texto, int velocidade, Runnable aoTerminar) {
		
		area.setText(""); //Apaga tudo antes de começar
		
		final int[] indice = {0};
		
		Timer timer = new Timer(velocidade, e ->{ //Executa repetidamente
			if(indice [0] < texto.length()) { //Verifica se ainda existem letras para mostrar
				area.setText(texto.substring(0, indice[0] + 1)); //Nova String / copia sem alterar
				indice[0]++;
		
			}else {
				((Timer)e.getSource()).stop(); //Fim do texto parar
				if (aoTerminar != null) 
			        aoTerminar.run();
			}
		});
		
		timer.start();
			
	}

}