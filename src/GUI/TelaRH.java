package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaRH extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton botaoCadastrar;
	JButton botaoListar;
	JButton botaoVoltar;
	JButton botaoExcluir;
    public TelaRH() {
        setSize(1280, 720);
        setLayout(null);
        setBackground(Color.WHITE);
        
        botaoCadastrar = new JButton("Cadastrar Funcionários");
        botaoCadastrar.setFont(new Font("Tahoma", Font.BOLD, 24));
        botaoCadastrar.setBounds(136, 202, 314, 65);
        add(botaoCadastrar);
 
        JLabel titulo = new JLabel("Mai-ly Bank ");
        titulo.setFont(new Font("Tahoma", Font.ITALIC, 44));
        titulo.setBounds(545, 77, 239, 80);
        add(titulo);
        
        botaoListar = new JButton("Listar Funcionários");
        botaoListar.setFont(new Font("Tahoma", Font.BOLD, 24));
        botaoListar.setBounds(896, 202, 314, 65);
        add(botaoListar);
        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(596, 327, 124, 57);
        add(botaoVoltar);
        
        botaoExcluir = new JButton("Excluir Funcionários");
        botaoExcluir.setFont(new Font("Tahoma", Font.BOLD, 24));
        botaoExcluir.setBounds(515, 202, 314, 65);
        add(botaoExcluir);
    }
    
    public JButton getBotaoCadastrar() {
    	return botaoCadastrar;
    }
    
    public JButton getBotaoVoltar() {
    	return botaoVoltar;
    }
    
    public JButton getBotaoListar() {
    	return botaoListar;
    }
    
    public JButton getBotaoExcluir() {
    	return botaoExcluir;
    }
    	
}
