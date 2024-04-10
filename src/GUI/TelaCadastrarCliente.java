package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Modelos.ModelosPessoa.*;
import Recepcao.GerenciarFila;
import Utilitarios.Excecao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class TelaCadastrarCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNome;
	private JTextField campoCPF;
	private JButton botaoVoltar;
	private Boolean prioridade = false;

    public TelaCadastrarCliente() {
        setSize(1280, 720);
        setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel titulo = new JLabel("Mai-ly Bank ");
        titulo.setBounds(545, 77, 239, 80);
        titulo.setFont(new Font("Tahoma", Font.ITALIC, 44));
        add(titulo);
        
        String[] opcoes = {"Caixa", "Gerente"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
  
        JLabel lblPrioridade = new JLabel("Tem prioridade?");
        lblPrioridade.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblPrioridade.setBounds(564, 391, 200, 32);
        add(lblPrioridade);
        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(607, 579, 124, 57);
        add(botaoVoltar);
        
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(607, 496, 124, 57);
        add(botaoCadastrar);
        
        JToggleButton botaoSim = new JToggleButton("Sim");  
        botaoSim.setFont(new Font("Tahoma", Font.BOLD, 16));
        botaoSim.setBounds(545, 446, 115, 21);
        add(botaoSim);

        JToggleButton botaoNao = new JToggleButton("Não");
        botaoNao.setFont(new Font("Tahoma", Font.BOLD, 16));
        botaoNao.setBounds(692, 446, 115, 21);
        add(botaoNao);
        
        botaoSim.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		prioridade = true;
                botaoSim.setEnabled(false);
                botaoNao.setEnabled(true);
        	}
        });
        
        botaoNao.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		prioridade = false;
                botaoSim.setEnabled(true);
                botaoNao.setEnabled(false);
        	}
        });

        botaoCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		String escolha = (String) comboBox.getSelectedItem();
				
                try {
                    Cliente cliente = new Cliente(campoNome.getText(), campoCPF.getText(), prioridade);
                    if (escolha.equals("Caixa")) {	            
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso! ");
                        if(prioridade) {
                            GerenciarFila.filaPreferencial.inserirFim(cliente);
                        } else {
                            GerenciarFila.filaNormal.inserirFim(cliente);
                            }
                    } else {     
                            
                        JOptionPane.showMessageDialog(null, "Cliente VIP cadastrado com sucesso! ");
                        GerenciarFila.filaVIP.inserirFim(cliente);
                    }
                } catch (Excecao e1) {
                    e1.printStackTrace();
                }
				
                campoNome.setText("");
                campoCPF.setText("");
                botaoSim.setEnabled(true);
                botaoNao.setEnabled(true);
						
        	}
        });

    }
    
    public JButton getBotaoVoltar() {
    	return botaoVoltar;
    }
}
