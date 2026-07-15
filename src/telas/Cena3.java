package telas;

import javax.swing.*;
import java.awt.*;

import dados.*;
import principal.Janela;

public class Cena3 extends JPanel {

    private Janela janela;
    private Image fundoCenas;
    private JTextArea dialogo2;
    private JButton op1;
    private JButton op2;
    private JButton op3;

    private final String falaAurora = """
            Depois que passamos por essa igreja amarela, 
            nós seguimos pela avenida principal e contornamos 
            uma grande rotatória que tem uma fonte de água 
            bem no meio dela.
            """;

    public Cena3(Janela janela) {

        this.janela = janela;

        fundoCenas = new ImageIcon(getClass().getResource("/imagens/FundoCenas.jpeg")).getImage();

        setLayout(null);

        JLabel dialogo1 = new JLabel("<html>Aurora, nossa equipe já está na região da praça.<br>"
                + "Você consegue se lembrar de mais algum ponto de<br>"
                + "referência após passar pela igreja?</html>");
        dialogo1.setForeground(Color.WHITE);
        dialogo1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        dialogo1.setVerticalAlignment(JLabel.TOP);
        dialogo1.setBounds(400, 240, 650, 150); 
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
                        janela.trocarTela("PERGUNTA3");
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