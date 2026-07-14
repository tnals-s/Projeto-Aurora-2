package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import principal.Janela;
import dados.*;

public class Missao2 extends JPanel {

    private final Janela janela;

    private JLabel lblTempo;
    private ImageIcon[] pecas = new ImageIcon[9];

    private JPanel painelPuzzle;

    private int[] atual = {
            2, 3, 5,
            1, -1, 6,
            4, 7, 0
    };

    private int[] correto = {
            0, 1, 2,
            3, 4, 5,
            6, 7, -1
    };

    private int vazio = 4;

    public Missao2(Janela janela) {
        this.janela = janela;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1300, 800));
        setBackground(new Color(25, 25, 25));

        criarTopo();
        criarPuzzle();
    }

    public void iniciarMissao() {
        Cronometro.iniciar(lblTempo);
    }

    private void criarTopo() {

        JPanel topo = new JPanel(new BorderLayout());
        topo.setPreferredSize(new Dimension(1300, 180));
        topo.setBackground(new Color(25, 25, 25));

        // Linha superior
        JPanel linhaSuperior = new JPanel(new BorderLayout());
        linhaSuperior.setBackground(new Color(25, 25, 25));

        lblTempo = new JLabel("Tempo: 00:00", JLabel.LEFT);
        lblTempo.setForeground(Color.WHITE);
        lblTempo.setFont(new Font("Segoe UI", Font.BOLD, 20));

        linhaSuperior.add(lblTempo, BorderLayout.WEST);

        JLabel titulo = new JLabel("MISSÃO 5 - QUEBRA-CABEÇA 3x3", JLabel.CENTER);
        titulo.setForeground(new Color(180, 120, 255));
        titulo.setFont(new Font("Impact", Font.PLAIN, 36));

        linhaSuperior.add(titulo, BorderLayout.CENTER);

        topo.add(linhaSuperior, BorderLayout.NORTH);

        // Linha inferior
        JLabel instrucoes = new JLabel(
                """
                <html><center>
                Monte o quebra-cabeça para revelar a pista.<br>
                Clique nas peças ao lado do espaço vazio para mover.
                </center></html>
                """,
                JLabel.CENTER
        );

        instrucoes.setForeground(Color.WHITE);
        instrucoes.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        topo.add(instrucoes, BorderLayout.CENTER);

        add(topo, BorderLayout.NORTH);
    }

    private void criarPuzzle() {

        painelPuzzle = new JPanel(new GridLayout(3, 3, 0, 0));
        painelPuzzle.setBackground(new Color(25, 25, 25));
        painelPuzzle.setPreferredSize(new Dimension(600, 600));

        JPanel centro = new JPanel(new GridBagLayout());
        centro.setBackground(new Color(25, 25, 25));

        centro.add(painelPuzzle);

        add(centro, BorderLayout.CENTER);

        carregarImagem();
        desenhar();
    }

    private void carregarImagem() {
        try {
            BufferedImage img = ImageIO.read(getClass().getResource("/imagens/Cont.jpeg"));

            int largura = img.getWidth() / 3;
            int altura = img.getHeight() / 3;

            int indice = 0;

            for (int l = 0; l < 3; l++) {
                for (int c = 0; c < 3; c++) {

                    if (indice == 8) {
                        pecas[indice] = null;
                    } else {
                        BufferedImage parte = img.getSubimage(c * largura, l * altura, largura, altura);

                        Image imagemRedimensionada = parte.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

                        pecas[indice] = new ImageIcon(imagemRedimensionada);
                    }

                    indice++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void desenhar() {

        painelPuzzle.removeAll();

        for (int i = 0; i < 9; i++) {

            JLabel casa = new JLabel();
            casa.setHorizontalAlignment(SwingConstants.CENTER);
            casa.setVerticalAlignment(SwingConstants.CENTER);

            if (atual[i] != -1) {
                casa.setIcon(pecas[atual[i]]);
            }

            int posicao = i;

            casa.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mover(posicao);
                }
            });

            painelPuzzle.add(casa);
        }

        painelPuzzle.revalidate();
        painelPuzzle.repaint();
    }

    private void mover(int posicao) {

        if (!adjacente(posicao, vazio)) return;

        int temp = atual[posicao];
        atual[posicao] = atual[vazio];
        atual[vazio] = temp;

        vazio = posicao;

        desenhar();

        if (venceu()) {
            mostrarTelaFinal();
        }
    }

    private boolean adjacente(int a, int b) {

        int linhaA = a / 3;
        int colunaA = a % 3;

        int linhaB = b / 3;
        int colunaB = b % 3;

        return Math.abs(linhaA - linhaB) + Math.abs(colunaA - colunaB) == 1;
    }

    private boolean venceu() {

        for (int i = 0; i < 9; i++) {
            if (atual[i] != correto[i]) return false;
        }

        return true;
    }

    private void mostrarTelaFinal() {

        long tempo = Cronometro.finalizar();

        int pontosGanhos;

        if (tempo <= 60) {
            pontosGanhos = 50;
        } else if (tempo <= 180) {
            pontosGanhos = 30;
        } else {
            pontosGanhos = -10;
        }

        Pontuacao.adicionarPontos(pontosGanhos);

        removeAll();
        setLayout(new BorderLayout());

        JPanel painelTitulo = new JPanel();
        painelTitulo.setBackground(new Color(25, 25, 25));

        JLabel titulo = new JLabel("MISSÃO 5 - CONCLUÍDA", JLabel.CENTER);
        titulo.setForeground(new Color(180, 120, 255));
        titulo.setFont(new Font("Impact", Font.PLAIN, 36));

        painelTitulo.add(titulo);

        JPanel painelCentro = new JPanel(new GridBagLayout());
        painelCentro.setBackground(new Color(25, 25, 25));

        JLabel mensagem = new JLabel(
                "<html><center>"
                        + "Missão concluída!<br><br>"
                        + "Tempo: " + tempo + " segundos<br>"
                        + "Pontuação recebida: +" + pontosGanhos + "<br>"
                        + "Pontuação total: " + Pontuacao.getPontos()
                        + "</center></html>",
                JLabel.CENTER
        );

        mensagem.setForeground(Color.WHITE);
        mensagem.setFont(new Font("Segoe UI", Font.BOLD, 28));

        painelCentro.add(mensagem);

        JButton continuar = new JButton("CONTINUAR");
        continuar.setFont(new Font("Impact", Font.PLAIN, 26));
        continuar.setForeground(Color.WHITE);
        continuar.setBackground(new Color(40, 40, 40));
        continuar.setBorder(BorderFactory.createLineBorder(new Color(120, 80, 180), 3));
        continuar.setPreferredSize(new Dimension(260, 70));
        continuar.setFocusPainted(false);

        continuar.addActionListener(e -> janela.trocarTela("cena5"));

        JPanel painelBotao = new JPanel();
        painelBotao.setBackground(new Color(25, 25, 25));
        painelBotao.add(continuar);

        add(painelTitulo, BorderLayout.NORTH);
        add(painelCentro, BorderLayout.CENTER);
        add(painelBotao, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }
}
