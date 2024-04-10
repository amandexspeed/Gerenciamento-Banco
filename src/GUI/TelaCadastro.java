package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Data.GerenciarArquivos.GerenciarArquivos;
import Modelos.ModelosPessoa.*;
import RH.GestaoFuncionarios;
import Utilitarios.Excecao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNome;
	private JTextField campoCPF;
	private JTextField campoMatricula;
	private JButton botaoVoltar;

    public TelaCadastro() {
        setSize(1280, 720);
        setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel titulo = new JLabel("Mai-ly Bank ");
        titulo.setBounds(545, 77, 239, 80);
        titulo.setFont(new Font("Tahoma", Font.ITALIC, 44));
        add(titulo);
        
        String[] opcoes = {"Caixa", "Gerente de Negócios"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(607, 192, 118, 20);
        add(comboBox);
        
        campoNome = new JTextField();
        campoNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
        campoNome.setBounds(564, 266, 200, 30);
        add(campoNome);
        campoNome.setColumns(10);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNome.setBounds(564, 223, 118, 32);
        add(lblNome);
        
        JLabel lblCPF = new JLabel("CPF");
        lblCPF.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblCPF.setBounds(564, 307, 118, 32);
        add(lblCPF);
        
        campoCPF = new JTextField();
        campoCPF.setFont(new Font("Tahoma", Font.PLAIN, 24));
        campoCPF.setColumns(10);
        campoCPF.setBounds(564, 350, 200, 30);
        add(campoCPF);
        
        campoCPF.addKeyListener(new KeyAdapter() {     
            public void keyTyped(KeyEvent e) {
                if (campoCPF.getText().length() >= 11) {
                    e.consume(); // Consumir o evento para impedir que mais caracteres sejam digitados
                }
            }
        });
  
        JLabel lblMatricula = new JLabel("Matrícula");
        lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblMatricula.setBounds(564, 391, 118, 32);
        add(lblMatricula);
        
        campoMatricula = new JTextField();
        campoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 24));
        campoMatricula.setColumns(10);
        campoMatricula.setBounds(564, 434, 200, 30);
        add(campoMatricula);
        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(607, 579, 124, 57);
        add(botaoVoltar);
        
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String escolha = (String) comboBox.getSelectedItem();
				
				if (escolha.equals("Caixa")) {	            
		            try {
		            	Caixa caixa = new Caixa(campoNome.getText(), campoCPF.getText(), Integer.parseInt(campoMatricula.getText()));
		                GerenciarArquivos.escreverArquivo(caixa, "caixa");
		                JOptionPane.showMessageDialog(null, "Caixa cadastrado com sucesso!");
                        GestaoFuncionarios.ListaCaixa.inserirInicio(caixa);
		            } catch (Excecao ex) {
		                ex.printStackTrace();
		            }
		        } else if (escolha.equals("Gerente de Negócios")) {            
		            try {
		            	GerenteNegocios gerente = new GerenteNegocios(campoNome.getText(), campoCPF.getText(), Integer.parseInt(campoMatricula.getText()));
		            	GerenciarArquivos.escreverArquivo(gerente, "gerentes");	
		            	JOptionPane.showMessageDialog(null, "Gerente de Negócios cadastrado com sucesso!");
                        GestaoFuncionarios.ListaGerente.inserirInicio(gerente);
                        
		            } catch (Excecao ex) {
		                ex.printStackTrace();
		            }
		        }
                campoNome.setText("");
                campoCPF.setText("");
                campoMatricula.setText("");
                GestaoFuncionarios.iniciarLista();
                GestaoFuncionarios.atualizarTabelas();
                
						
        	}
        });
        botaoCadastrar.setBounds(607, 496, 124, 57);
        add(botaoCadastrar);
    }
    
    public JButton getBotaoVoltar() {
    	return botaoVoltar;
    }
}
