package principal;

import javax.swing.*;
import java.awt.*;

import telas.*;
import dados.*;

public class Janela extends JFrame {

    private CardLayout trocador;
    private JPanel painel;

    private Introducao introducao;
    private TelefoneChamando telefone;
    private Cena1 cena1;
    private Cena2 cena2;
    private Viatura1 viatura1;
    private Missao1 missao1;
    private Cena3 cena3;
    private Cena4 cena4;
    private Viatura2 viatura2;
    private Missao2 missao2;
    private Cena5 cena5;
    private Encerramento encerramento;
    private FimDeJogo fimDeJogo;

    private JLabel Pontos;
    private JPanel painelPontos;

    public Janela() {

        Pontuacao.iniciar(this);
        setSize(1300, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        trocador = new CardLayout();
        painel = new JPanel(trocador);
        painel.setBackground(new Color(25,25,25));

        JPanel barraPontos = new JPanel();
        barraPontos.setBackground(new Color(25,25,25));
        Pontos = new JLabel("Pontos: 0");
        Pontos.setForeground(Color.WHITE);
        Pontos.setFont(new Font("Segoe UI", Font.BOLD, 18));
        barraPontos.add(Pontos);
        barraPontos.setVisible(false);

        painel.add(new MenuInicial(this), "MENU");
        painel.add(new Instrucoes(this), "INSTRUCOES");
        introducao = new Introducao(this);
        painel.add(introducao, "INTRODUCAO");
        telefone = new TelefoneChamando(this);
        painel.add(telefone, "TELEFONE");
        cena1 = new Cena1(this);
        painel.add(cena1, "cena1");
        painel.add(new Pergunta1(this), "PERGUNTA1");
        cena2 = new Cena2(this);
        painel.add(cena2, "cena2");
        painel.add(new Pergunta2(this), "PERGUNTA2");
        viatura1 = new Viatura1(this);
        painel.add(viatura1, "VIATURA1");
        painel.add(new Mapa1(this), "MAPA1");
        missao1 = new Missao1(this);
        painel.add(missao1, "MISSAO1");
        cena3 = new Cena3(this);
        painel.add(cena3, "cena3");
        painel.add(new Pergunta3(this), "PERGUNTA3");
        cena4 = new Cena4(this);
        painel.add(cena4, "cena4");
        painel.add(new Pergunta4(this), "PERGUNTA4");
        viatura2 = new Viatura2(this);
        painel.add(viatura2, "VIATURA2");
        missao2 = new Missao2(this);
        painel.add(missao2, "MISSAO2");
        painel.add(new Mapa2(this), "MAPA2");
        cena5 = new Cena5(this);
        painel.add(cena5, "cena5");
        painel.add(new Mapa3(this), "MAPA3");
        encerramento = new Encerramento(this);
        painel.add(encerramento, "ENCERRAMENTO");
        fimDeJogo = new FimDeJogo(this);
        painel.add(fimDeJogo, "FIMDEJOGO");

        painelPontos = new JPanel(new BorderLayout());
        painelPontos.add(barraPontos, BorderLayout.NORTH);
        painelPontos.add(painel, BorderLayout.CENTER);
        add(painelPontos);

        setVisible(true);
    }
    
    public void trocarTela(String nomeTela) {
        trocador.show(painel, nomeTela);

        if(nomeTela.equals("cena1") ||
           nomeTela.equals("PERGUNTA1") ||
           nomeTela.equals("cena2") ||
           nomeTela.equals("PERGUNTA2") ||
           nomeTela.equals("VIATURA1") ||
           nomeTela.equals("MAPA1") ||
           nomeTela.equals("MISSAO1") ||
           nomeTela.equals("cena3") ||
           nomeTela.equals("PERGUNTA3") ||
           nomeTela.equals("cena4") ||
           nomeTela.equals("PERGUNTA4") ||
           nomeTela.equals("VIATURA2") ||
           nomeTela.equals("MAPA2") ||
           nomeTela.equals("MISSAO2") ||
           nomeTela.equals("cena5") ||
           nomeTela.equals("MAPA3") ||
           nomeTela.equals("ENCERRAMENTO") ||
           nomeTela.equals("FIMDEJOGO")) {

           painelPontos.getComponent(0).setVisible(true);

        }
        else {
            painelPontos.getComponent(0).setVisible(false);
        }
        painelPontos.revalidate();
        painelPontos.repaint();

        if(nomeTela.equals("INTRODUCAO")) {
            introducao.iniciar();
        }

        if(nomeTela.equals("TELEFONE")) {
            telefone.iniciar();
        }
        
        if(nomeTela.equals("cena1")) {
            cena1.iniciarCena();
        }

        if(nomeTela.equals("cena2")) {
            cena2.iniciarCena();
        }

        if(nomeTela.equals("VIATURA1")) {
            viatura1.iniciarCena();
        }

        if(nomeTela.equals("MISSAO1")) {
            missao1.iniciarMissao();
        }

        if(nomeTela.equals("cena3")) {
            cena3.iniciarCena();
        }

        if(nomeTela.equals("cena4")) {
            cena4.iniciarCena();
        }

        if(nomeTela.equals("VIATURA2")) {
            viatura2.iniciarCena();
        }

        if(nomeTela.equals("MISSAO2")) {
            missao2.iniciarMissao();
        }

        if(nomeTela.equals("cena5")) {
            cena5.iniciarCena();
        }

        if(nomeTela.equals("ENCERRAMENTO")) {
            encerramento.iniciarCena();
        }
        
        if(nomeTela.equals("FIMDEJOGO")) {
            fimDeJogo.atualizarResultado();
        }
    }

    public void atualizarPontos() {
        Pontos.setText("Pontos: " + Pontuacao.getPontos());
    }
}