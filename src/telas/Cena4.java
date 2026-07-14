package telas;

import javax.swing.*;
import java.awt.*;

import dados.*;
import principal.Janela;

public class Cena4 extends JPanel {

    private Janela janela;
    private Image fundoCenas;
    private JTextArea dialogo2;
    private JButton op1;
    private JButton op2;
    private JButton op3;

    private final String falaAurora = """
    		Oi... eu me chamo Aurora, eu preciso de ajuda.
    		Nos últimos anos, o comportamento do meu marido 
    		mudou completamente.
    		Ele controla tudo o que eu faço, decide com quem posso 
    		conversar e fica agressivo quando o desagrado. 
    		Eu não sei mais o que fazer.
            """;

    public Cena4(Janela janela) {

        this.janela = janela;

        fundoCenas = new ImageIcon(getClass().getResource("/imagens/FundoCenas.jpeg")).getImage();

        setLayout(null);

        JLabel dialogo1 = new JLabel("Polícia Militar, emergência.");
        dialogo1.setForeground(Color.WHITE);
        dialogo1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        dialogo1.setBounds(400, 280, 650, 40);
        add(dialogo1);

        dialogo2 = new JTextArea();
        dialogo2.setBounds(400, 450, 650, 220);
        dialogo2.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        dialogo2.setForeground(Color.WHITE);
        dialogo2.setOpaque(false);
        dialogo2.setEditable(false);
        dialogo2.setFocusable(false);
        dialogo2.setBorder(null);
        dialogo2.setLineWrap(true);
        dialogo2.setWrapStyleWord(true);

        add(dialogo2);
    }

    public void iniciarCena() {

        dialogo2.setText("");

        EfeitoDigitacao.digitar(
                dialogo2,
                falaAurora,
                40,
                () -> {
                    Timer timer = new Timer(2500, e -> {
                        janela.trocarTela("PERGUNTA4");
                    });

                    timer.setRepeats(false);
                    timer.start();
                }
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fundoCenas, 0, 0, getWidth(), getHeight(), this);
    }
}
