package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

import Caixa.EscolhaFunc;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtendimento extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JTextField campoNome;
	private JButton botaoVoltar;
    
    public TelaAtendimento() {
        setSize(1280, 720);
        setBackground(Color.WHITE);
        setLayout(null);
        
        campoNome = new JTextField();
        campoNome.setEditable(false);
        campoNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
        campoNome.setBounds(54, 79, 200, 30);
        campoNome.setText(EscolhaFunc.nome);
        add(campoNome);
        campoNome.setColumns(10);
        
        JLabel lblNome = new JLabel("Caixa Atual");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNome.setBounds(54, 37, 187, 32);
        add(lblNome);
        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Serif", Font.BOLD, 24));
        botaoVoltar.setBounds(468, 52, 124, 57);
        add(botaoVoltar);
        
        JButton botaoAtender = new JButton("Atender");
        botaoAtender.setFont(new Font("Serif", Font.BOLD, 24));
        botaoAtender.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
                EscolhaFunc.funcEsc.atenderCliente();
        	}
        });
        botaoAtender.setBounds(307, 52, 124, 57);
        add(botaoAtender);
        mudarTexto();
    }
    
    static public void mudarTexto() {
    	
    	campoNome.setText(EscolhaFunc.nome);
    	
    }
    
    public JButton getBotaoVoltar() {
    	return botaoVoltar;
    }
	public JTextField getCampoNome() {
		return campoNome;
	}
}
