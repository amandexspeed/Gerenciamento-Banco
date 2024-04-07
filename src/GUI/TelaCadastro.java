package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnVoltar;
    public TelaCadastro() {
        setSize(1280, 720);
        setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel titulo = new JLabel("Mai-ly Bank ");
        titulo.setBounds(545, 77, 239, 80);
        titulo.setFont(new Font("Tahoma", Font.ITALIC, 44));
        add(titulo);
        
        String[] opcoes = {"Caixa", "Gerente de Negócios"};
        JComboBox comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(607, 192, 118, 20);
        add(comboBox);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
        textField.setBounds(564, 266, 200, 30);
        add(textField);
        textField.setColumns(10);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNome.setBounds(564, 223, 118, 32);
        add(lblNome);
        
        JLabel lblCPF = new JLabel("CPF");
        lblCPF.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblCPF.setBounds(564, 307, 118, 32);
        add(lblCPF);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        textField_1.setColumns(10);
        textField_1.setBounds(564, 350, 200, 30);
        add(textField_1);
        
        JLabel lblMatricula = new JLabel("Matrícula");
        lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblMatricula.setBounds(564, 391, 118, 32);
        add(lblMatricula);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
        textField_2.setColumns(10);
        textField_2.setBounds(564, 434, 200, 30);
        add(textField_2);
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(607, 507, 124, 57);
        add(btnVoltar);
    }
    
    public JButton getBotaoVoltar() {
    	return btnVoltar;
    }
}
