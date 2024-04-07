package GUI;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel conteudoPainel;
    private CardLayout cardLayout;

    public JanelaPrincipal() {
        setTitle("SysAgroTech");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        conteudoPainel = new JPanel();
        cardLayout = new CardLayout();
        conteudoPainel.setLayout(cardLayout);
        setContentPane(conteudoPainel);
        
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        TelaCadastro telaCadastro = new TelaCadastro();
        
        conteudoPainel.add(telaPrincipal, "telaPrincipal");
        conteudoPainel.add(telaCadastro, "telaCadastro");
        
        telaPrincipal.getBotaoCadastrar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaCadastro");
            }
        });
        
        telaCadastro.getBotaoVoltar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaPrincipal");
            }
        });
    }

    public JPanel getConteudoPainel() {
        return conteudoPainel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

}


