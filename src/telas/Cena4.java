package telas;

import javax.swing.*;
import java.awt.*;

import dados.*;
import principal.Janela;

public class Cena4 extends JPanel {

    private Janela janela;
    private Image fundoCenas;
    private JTextArea dialogo2;
    private JLabel dialogo1; 

    private final String falaAurora = """
    		Saindo da rotatória, nós descemos a rua e passamos 
    		em frente a um restaurante com mesas do lado de fora 
    		e toldos listrados de vermelho e branco. 
    		Minha casa fica bem próxima dali...
            """;

    public Cena4(Janela janela) {

        this.janela = janela;

        fundoCenas = new ImageIcon(getClass().getResource("/imagens/FundoCenas.jpeg")).getImage(); 
        

        setLayout(null);

        dialogo1 = new JLabel("<html><center>"
                + "Compreendido, localizamos a rotatória central.<br>"
                + "Consegue se lembrar de mais algum comércio ou<br>"
                + "ponto de referência logo em seguida?"
                + "</center></html>");
        dialogo1.setForeground(Color.WHITE);
        dialogo1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        dialogo1.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza horizontalmente
        dialogo1.setVerticalAlignment(SwingConstants.CENTER);   // Centraliza verticalmente no balão
        dialogo1.setBounds (400, 260, 650, 150);
        add(dialogo1);

        dialogo2 = new JTextArea();
        // Aumentamos a coordenada Y e a altura para não esbarrar na borda inferior do balão
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