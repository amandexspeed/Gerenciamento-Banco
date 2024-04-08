package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import Caixa.EscolhaFunc;
import Utilitarios.Excecao;

import java.awt.GridLayout;

public class TelaCaixa extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNome;
	private JButton botaoVoltar;
	private static JTable caixaTable;
    private static JTable gerenteTable;
    
    public TelaCaixa() {
        setSize(1280, 720);
        setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel titulo = new JLabel("Caixa");
        titulo.setBounds(600, 11, 110, 80);
        titulo.setFont(new Font("Tahoma", Font.PLAIN, 44));
        add(titulo);
        
        campoNome = new JTextField();
        campoNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
        campoNome.setBounds(560, 506, 200, 30);
        add(campoNome);
        campoNome.setColumns(10);
        
        JLabel lblNome = new JLabel("Matrícula");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNome.setBounds(600, 464, 118, 32);
        add(lblNome);
        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(678, 588, 124, 57);
        add(botaoVoltar);
        
        JButton botaoEntrar = new JButton("Entrar");
        botaoEntrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EscolhaFunc.escolherFuncionario(Integer.parseInt(lblNome.getText()));
        	}
        });
        botaoEntrar.setBounds(527, 588, 124, 57);
        add(botaoEntrar);
        
        JLabel lblTextoInformativo = new JLabel("Digite a matrícula do funcionário que irá atender");
        lblTextoInformativo.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTextoInformativo.setBounds(517, 546, 300, 32);
        add(lblTextoInformativo);
        
        JPanel tabelaPanel = new JPanel(new GridLayout(1, 2));
        tabelaPanel.removeAll();
        
        caixaTable = new JTable();
        gerenteTable = new JTable();

        JScrollPane caixaScrollPane = new JScrollPane(caixaTable);
        JScrollPane gerenteScrollPane = new JScrollPane(gerenteTable); 
        
        

        
        
        try {
			TelaTabela.preencherTabelas();
		} catch (Excecao e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        tabelaPanel.setBounds(10, 113, 1260, 322);
        
        tabelaPanel.add(caixaScrollPane);
        tabelaPanel.add(gerenteScrollPane);
        add(tabelaPanel);
        tabelaPanel.setLayout(new GridLayout(1, 0, 0, 0));
    }
    
    public JButton getBotaoVoltar() {
    	return botaoVoltar;
    }
}
