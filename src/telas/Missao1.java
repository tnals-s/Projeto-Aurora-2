package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import principal.Janela;
import dados.*;

public class Missao1 extends JPanel implements ActionListener {

    private Janela janela;

    private JLabel lblTempo;
    private JLabel lblTitulo;
    private JLabel lblDica;
    private JLabel lblVidas;
    private JLabel lblTentadas;
    private JLabel lblPalavra;

    private JTextField txtLetra;
    private JButton btnChutar;

    private final String[] PALAVRAS = {
            "AUTOESTIMA",
            "MANIPULAÇÃO",
            "CONSCIENTIZAÇÃO"
    };

    private final String[] DICAS = {
            "O amor próprio que a violência tenta destruir, mas que a rede de apoio ajuda a reconstruir.",
            "Forma de abuso psicológico onde o agressor distorce os fatos para fazer a vítima duvidar de sua própria sanidade mental.",
            "A chave para quebrar ciclos de violência: entender sinais, apoiar vítimas e promover informação."
    };

    private int indiceAtual = 0;

    private List<Integer> pendentes = new ArrayList<>();
    private List<Integer> resolvidas = new ArrayList<>();

    private String palavraSecreta;
    private String dicaAtual;

    private char[] palavraMascarada;
    private int vidas = 6;

    private StringBuilder letrasTentadas = new StringBuilder();


    public Missao1(Janela janela) {
        this.janela = janela;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1300, 800));
        setBackground(new Color(25, 25, 25));

        carregarPalavra();
        criarTopo();
        criarCentro();
        criarInferior();
    }

    public void iniciarMissao() {
        Cronometro.iniciar(lblTempo);
    }


    private void carregarPalavra() {
        palavraSecreta = PALAVRAS[indiceAtual];
        dicaAtual = DICAS[indiceAtual];

        palavraMascarada = new char[palavraSecreta.length()];
        for (int i = 0; i < palavraMascarada.length; i++) {
            palavraMascarada[i] = '_';
        }

        vidas = 6;
        letrasTentadas.setLength(0);
    }


    private void criarTopo() {

        JPanel topo = new JPanel(new BorderLayout());
        topo.setPreferredSize(new Dimension(1300, 150));
        topo.setBackground(new Color(25, 25, 25));

        // Linha superior
        JPanel linhaSuperior = new JPanel(new GridLayout(1, 3));
        linhaSuperior.setBackground(new Color(25, 25, 25));

        lblTempo = new JLabel("Tempo: 00:00", JLabel.LEFT);
        lblTempo.setForeground(Color.WHITE);
        lblTempo.setFont(new Font("Segoe UI", Font.BOLD, 20));

        lblTitulo = new JLabel("MISSÃO 3 - JOGO DA FORCA", JLabel.CENTER);
        lblTitulo.setForeground(new Color(180, 120, 255));
        lblTitulo.setFont(new Font("Impact", Font.PLAIN, 36));

        lblVidas = new JLabel("Vidas restantes: " + vidas, JLabel.RIGHT);
        lblVidas.setForeground(Color.WHITE);
        lblVidas.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        linhaSuperior.add(lblTempo);
        linhaSuperior.add(lblTitulo);
        linhaSuperior.add(lblVidas);

        // Linha inferior
        JPanel linhaInferior = new JPanel(new GridLayout(2, 1));
        linhaInferior.setBackground(new Color(25, 25, 25));

        lblDica = new JLabel("<html><center>Dica:<br>" + dicaAtual + "</center></html>", JLabel.CENTER);
        lblDica.setForeground(Color.WHITE);
        lblDica.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        lblTentadas = new JLabel("Letras tentadas: ", JLabel.CENTER);
        lblTentadas.setForeground(Color.WHITE);
        lblTentadas.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        linhaInferior.add(lblDica);
        linhaInferior.add(lblTentadas);

        topo.add(linhaSuperior, BorderLayout.NORTH);
        topo.add(linhaInferior, BorderLayout.SOUTH);

        add(topo, BorderLayout.NORTH);
    }


    private void criarCentro() {

        JPanel centro = new JPanel();
        centro.setBackground(new Color(25, 25, 25));
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));

        lblPalavra = new JLabel(getPalavraExibicao(), JLabel.CENTER);
        lblPalavra.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPalavra.setForeground(Color.WHITE);
        lblPalavra.setFont(new Font("Monospaced", Font.BOLD, 60));

        centro.add(Box.createVerticalStrut(120));
        centro.add(lblPalavra);
        centro.add(Box.createVerticalGlue());

        add(centro, BorderLayout.CENTER);
    }


    private void criarInferior() {

        JPanel inferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
        inferior.setPreferredSize(new Dimension(1300, 150));
        inferior.setBackground(new Color(25, 25, 25));

        txtLetra = new JTextField(2);
        txtLetra.setFont(new Font("Segoe UI", Font.BOLD, 32));
        txtLetra.setHorizontalAlignment(JTextField.CENTER);
        txtLetra.addActionListener(this);

        btnChutar = new JButton("CHUTAR");
        btnChutar.setFont(new Font("Impact", Font.PLAIN, 30));
        btnChutar.setForeground(Color.WHITE);
        btnChutar.setBackground(new Color(40, 40, 40));
        btnChutar.setBorder(BorderFactory.createLineBorder(new Color(180, 120, 255), 3));
        btnChutar.setPreferredSize(new Dimension(260, 80));
        btnChutar.setFocusPainted(false);
        btnChutar.addActionListener(this);

        inferior.add(txtLetra);
        inferior.add(btnChutar);

        add(inferior, BorderLayout.SOUTH);
    }


    private String removerAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }


    private String getPalavraExibicao() {
        StringBuilder sb = new StringBuilder();
        for (char c : palavraMascarada) sb.append(c).append(" ");
        return sb.toString().trim();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String input = txtLetra.getText().trim().toUpperCase();
        txtLetra.setText("");

        if (input.isEmpty() || input.length() > 1 || !Character.isLetter(input.charAt(0))) {
            JOptionPane.showMessageDialog(this, "Digite apenas UMA letra válida.");
            txtLetra.requestFocusInWindow();
            return;
        }

        char letraDigitada = input.charAt(0);

        if (letrasTentadas.toString().contains(String.valueOf(letraDigitada))) {
            JOptionPane.showMessageDialog(this, "Você já tentou essa letra.");
            txtLetra.requestFocusInWindow();
            return;
        }

        letrasTentadas.append(letraDigitada).append(" ");
        lblTentadas.setText("Letras tentadas: " + letrasTentadas);

        String letraSemAcento = removerAcentos(String.valueOf(letraDigitada));
        String palavraSemAcento = removerAcentos(palavraSecreta);

        boolean acertou = false;

        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSemAcento.charAt(i) == letraSemAcento.charAt(0)) {
                palavraMascarada[i] = palavraSecreta.charAt(i);
                acertou = true;
            }
        }

        if (acertou) {
            lblPalavra.setText(getPalavraExibicao());
            verificarVitoria();
        } else {
            vidas--;
            lblVidas.setText("Vidas restantes: " + vidas);

            if (vidas <= 0) {
                avancarParaProximaPalavra();
            }
        }

        txtLetra.requestFocusInWindow();
    }


    private void avancarParaProximaPalavra() {

        if (!resolvidas.contains(indiceAtual)) {
            pendentes.add(indiceAtual);
        }

        indiceAtual++;

        while (indiceAtual < PALAVRAS.length && resolvidas.contains(indiceAtual)) {
            indiceAtual++;
        }

        if (indiceAtual < PALAVRAS.length) {
            carregarPalavra();
            atualizarInterface();
            return;
        }

        while (!pendentes.isEmpty() && resolvidas.contains(pendentes.get(0))) {
            pendentes.remove(0);
        }

        if (!pendentes.isEmpty()) {
            indiceAtual = pendentes.remove(0);
            carregarPalavra();
            atualizarInterface();
            return;
        }

        mostrarTelaFinal();
    }


    private void verificarVitoria() {

        if (!getPalavraExibicao().contains("_")) {

            if (!resolvidas.contains(indiceAtual)) {
                resolvidas.add(indiceAtual);
            }

            pendentes.remove(Integer.valueOf(indiceAtual));

            indiceAtual++;

            while (indiceAtual < PALAVRAS.length && resolvidas.contains(indiceAtual)) {
                indiceAtual++;
            }

            if (indiceAtual < PALAVRAS.length) {
                carregarPalavra();
                atualizarInterface();
                return;
            }

            while (!pendentes.isEmpty() && resolvidas.contains(pendentes.get(0))) {
                pendentes.remove(0);
            }

            if (!pendentes.isEmpty()) {
                indiceAtual = pendentes.remove(0);
                carregarPalavra();
                atualizarInterface();
                return;
            }

            mostrarTelaFinal();
        }
    }


    private void atualizarInterface() {
        lblDica.setText("<html><center>Dica:<br>" + dicaAtual + "</center></html>");
        lblPalavra.setText(getPalavraExibicao());
        lblVidas.setText("Vidas restantes: " + vidas);
        lblTentadas.setText("Letras tentadas: ");
        txtLetra.requestFocusInWindow();
    }


    private void mostrarTelaFinal() {

        Timer t = new Timer(1000, e -> exibirTelaFinal());
        t.setRepeats(false);
        t.start();
    }


    private void exibirTelaFinal() {

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

        JPanel painelFinal = new JPanel(new GridBagLayout());
        painelFinal.setBackground(new Color(25, 25, 25));

        JLabel lblFinal = new JLabel(
                "<html><center>"
                        + "Missão concluída!<br><br>"
                        + "Tempo: " + tempo + " segundos<br>"
                        + "Pontuação recebida: +" + pontosGanhos + "<br>"
                        + "Pontuação total: " + Pontuacao.getPontos()
                        + "</center></html>",
                JLabel.CENTER
        );

        lblFinal.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblFinal.setForeground(Color.WHITE);

        painelFinal.add(lblFinal);

        add(painelFinal, BorderLayout.CENTER);

        JButton btnContinuar = new JButton("CONTINUAR");
        btnContinuar.setFont(new Font("Impact", Font.PLAIN, 28));
        btnContinuar.addActionListener(e -> janela.trocarTela("cena3"));

        JPanel painelBotao = new JPanel();
        painelBotao.setBackground(new Color(25, 25, 25));
        painelBotao.add(btnContinuar);

        add(painelBotao, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }
}
