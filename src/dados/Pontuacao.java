package dados;

import principal.Janela;

public class Pontuacao {
	
    private static int pontos = 0;
    private static Janela janela;

    public static void iniciar(Janela j) {
        janela = j;
    }

    public static void adicionarPontos(int valor) {
        pontos += valor;
        if(pontos < 0) {
            pontos = 0;
        }
        atualizarTela();
    }

    public static void removerPontos(int valor) {
        pontos -= valor;
        if(pontos < 0) {
            pontos = 0;
        }
        atualizarTela();
    }

    private static void atualizarTela() {
        if(janela != null) {
            janela.atualizarPontos();
        }
    }

    public static int getPontos() {
        return pontos;
    }

    public static void resetar() {
        pontos = 0;
        atualizarTela();
    }

}