package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton botaoCaixa;
	JButton botaoRH;
	JButton botaoRecepcao;
	
    public TelaPrincipal() {
        setSize(1280, 720);
        setLayout(null);
        setBackground(Color.WHITE);
        
        ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));
        JLabel lblLogo = new JLabel(logo);
        lblLogo.setBounds(0, 8, 1280, 199);
        add(lblLogo);
        
        botaoCaixa = new JButton("Caixa");
        botaoCaixa.setFont(new Font("Tahoma", Font.BOLD, 24));
        botaoCaixa.setBounds(556, 202, 203, 65);
        add(botaoCaixa);
 
        JLabel titulo = new JLabel("Mai-ly Bank ");
        titulo.setFont(new Font("Tahoma", Font.ITALIC, 44));
        titulo.setBounds(545, 77, 239, 80);
        add(titulo);
        
        botaoRH = new JButton("RH");
        botaoRH.setFont(new Font("Tahoma", Font.BOLD, 24));
        botaoRH.setBounds(232, 202, 203, 65);
        add(botaoRH);
        
        botaoRecepcao = new JButton("Recepção");
        botaoRecepcao.setFont(new Font("Tahoma", Font.BOLD, 24));
        botaoRecepcao.setBounds(880, 202, 203, 65);
        add(botaoRecepcao);
    }
    
    public JButton getBotaoRH() {
    	return botaoRH;
    }
}
