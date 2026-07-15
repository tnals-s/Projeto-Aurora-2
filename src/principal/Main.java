package principal;

import dados.*;

public class Main {

	public static void main(String[] args) {
		// força o Java 2D a renderizar tudo em escala 1:1 (100%), ignorando a escala do Windows
        System.setProperty("sun.java2d.uiScale", "1.0");
		Som.carregarSons();
		new Janela();

	}

}