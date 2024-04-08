package GUI;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Utilitarios.Excecao;

public class JanelaPrincipal extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel conteudoPainel;
    private CardLayout cardLayout;

    public JanelaPrincipal() throws Excecao {
        setTitle("Banco");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        conteudoPainel = new JPanel();
        cardLayout = new CardLayout();
        conteudoPainel.setLayout(cardLayout);
        setContentPane(conteudoPainel);
        
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        TelaCadastro telaCadastro = new TelaCadastro();
        TelaTabela telaTabela = new TelaTabela();
        TelaRH telaRH = new TelaRH();
        TelaCaixa telaCaixa = new TelaCaixa();
        TelaExcluir telaExcluir = new TelaExcluir();
        TelaAtendimento telaAtendimento = new TelaAtendimento();
        TelaCadastrarCliente telaCadastrarCliente = new TelaCadastrarCliente();
        
        conteudoPainel.add(telaPrincipal, "telaPrincipal");
        conteudoPainel.add(telaCadastro, "telaCadastro");
        conteudoPainel.add(telaTabela, "telaTabela");
        conteudoPainel.add(telaRH, "telaRH");
        conteudoPainel.add(telaCaixa, "telaCaixa");
        conteudoPainel.add(telaExcluir,"telaExcluir");
        conteudoPainel.add(telaAtendimento,"telaAtendimento");
        conteudoPainel.add(telaCadastrarCliente, "telaCadastrarCliente");
        
        telaPrincipal.getBotaoRH().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaRH");
            }
        });
        
        telaPrincipal.getBotaoCaixa().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaCaixa");
            }
        });

        telaPrincipal.getBotaoRecepcao().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaCadastrarCliente");
            }
        });
        
        telaCadastro.getBotaoVoltar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaRH");
            }
        });

        telaTabela.getBotaoVoltar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaRH");
            }
        });

        telaRH.getBotaoCadastrar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaCadastro");
            }
        });

        telaRH.getBotaoListar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaTabela");
            }
        });

        telaRH.getBotaoVoltar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaPrincipal");
            }
        });
        
        telaCaixa.getBotaoVoltar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaPrincipal");
            }
        });
        
        telaRH.getBotaoExcluir().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaExcluir");
            }
        });
        
        telaExcluir.getBotaoVoltar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaRH");
            }
        });
        
        telaAtendimento.getBotaoVoltar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaPrincipal");
            }
        });

        telaCaixa.getBotaoEntrar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(conteudoPainel, "telaAtendimento");
            }
        });

        telaCadastrarCliente.getBotaoVoltar().addActionListener(new ActionListener() {
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


