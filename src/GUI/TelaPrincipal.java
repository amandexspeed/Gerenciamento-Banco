package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton botaoCadastrar;
	
    public TelaPrincipal() {
        setSize(1280, 720);
        setLayout(null);
        setBackground(Color.WHITE);
        
        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(556, 202, 203, 65);
        add(botaoCadastrar);
 
        JLabel titulo = new JLabel("Mai-ly Bank ");
        titulo.setFont(new Font("Tahoma", Font.ITALIC, 44));
        titulo.setBounds(545, 77, 239, 80);
        add(titulo);
    }
    
    public JButton getBotaoCadastrar() {
    	return botaoCadastrar;
    }
}
