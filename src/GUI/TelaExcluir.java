package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelos.ModelosPessoa.*;
import Modelos.ModeloLista.*;
import RH.GestaoFuncionarios;
import Utilitarios.Excecao;

import java.awt.GridLayout;
import javax.swing.JComboBox;

public class TelaExcluir extends JPanel {
	

			private static final long serialVersionUID = 1L;
			private JTextField campoMatricula;
			private JButton botaoVoltar;
			private static JTable caixaTable;
		    private static JTable gerenteTable;
		    
		    public TelaExcluir() {
		        setSize(1280, 720);
		        setBackground(Color.WHITE);
		        setLayout(null);

		        
		        JLabel titulo = new JLabel("RH");
		        titulo.setBounds(615, 23, 64, 80);
		        titulo.setFont(new Font("Tahoma", Font.PLAIN, 44));
		        add(titulo);
		        
		        campoMatricula = new JTextField();
		        campoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 24));
		        campoMatricula.setBounds(672, 506, 200, 30);
		        add(campoMatricula);
		        campoMatricula.setColumns(10);
		        
		        JLabel lblMatricula = new JLabel("Matrícula");
		        lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 24));
		        lblMatricula.setBounds(708, 464, 118, 32);
		        add(lblMatricula);

				JLabel lblTipo = new JLabel("Tipo de funcionário");
		        lblTipo.setFont(new Font("Tahoma", Font.BOLD, 24));
		        lblTipo.setBounds(383, 464, 238, 32);
		        add(lblTipo);
		        
		        botaoVoltar = new JButton("Voltar");
		        botaoVoltar.setBounds(678, 588, 124, 57);
		        add(botaoVoltar);
		        
		        String[] opcoes = {"caixa", "gerentes"};
		        JComboBox<String> comboTipoFunc = new JComboBox<String>(opcoes);
		        comboTipoFunc.setToolTipText("");
		        comboTipoFunc.setBounds(405, 506, 200, 21);
		        add(comboTipoFunc);
		        
		        JButton botaoExcluir = new JButton("Excluir");
		        botaoExcluir.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		GestaoFuncionarios.removerFuncionario((String)comboTipoFunc.getSelectedItem(),Integer.parseInt(campoMatricula.getText()));
						GestaoFuncionarios.iniciarLista();
                		GestaoFuncionarios.atualizarTabelas();
						
					}
		        });
		        botaoExcluir.setBounds(527, 588, 124, 57);
		        add(botaoExcluir);
		        
		        JLabel lblTextoInformativo = new JLabel("Digite a matrícula e tipo de funcionário que irá ser excluído");
		        lblTextoInformativo.setFont(new Font("Tahoma", Font.BOLD, 12));
		        lblTextoInformativo.setBounds(490, 546, 336, 32);
		        add(lblTextoInformativo);
		        
		        JPanel tabelaPanel = new JPanel(new GridLayout(1, 2));
		        tabelaPanel.removeAll();
		        
		        caixaTable = new JTable();
		        gerenteTable = new JTable();

				try {
					preencherTabelas();
				} catch (Excecao e1) {
					e1.printStackTrace();
				}

		        JScrollPane caixaScrollPane = new JScrollPane(caixaTable);
		        JScrollPane gerenteScrollPane = new JScrollPane(gerenteTable); 
		        
		        tabelaPanel.setBounds(10, 113, 1260, 322);
		        
		        tabelaPanel.add(caixaScrollPane);
		        tabelaPanel.add(gerenteScrollPane);
		        add(tabelaPanel);
		        tabelaPanel.setLayout(new GridLayout(1, 0, 0, 0));
		        
		        
		    }
		    
		    public JButton getBotaoVoltar() {
		    	return botaoVoltar;
		    }

			public static void preencherTabelas() throws Excecao {

				caixaTable.removeAll();
				gerenteTable.removeAll();
		
				DefaultTableModel caixaModel = new DefaultTableModel();
				DefaultTableModel gerenteModel = new DefaultTableModel();
		
				caixaModel.addColumn("Nome");
				caixaModel.addColumn("CPF");
				caixaModel.addColumn("Matrícula");
		
				gerenteModel.addColumn("Nome");
				gerenteModel.addColumn("CPF");
				gerenteModel.addColumn("Matrícula");
		
				No<Caixa> caixa = GestaoFuncionarios.ListaCaixa.listar();
				while (caixa != null) {
					caixaModel.addRow(new Object[]{caixa.getAtual().getNome(), caixa.getAtual().getCPF(), caixa.getAtual().getMatricula()});
					caixa = caixa.getProximo();
				}
		
				No<GerenteNegocios> gerente = GestaoFuncionarios.ListaGerente.listar();
				while (gerente != null) {
					gerenteModel.addRow(new Object[]{gerente.getAtual().getNome(), gerente.getAtual().getCPF(), gerente.getAtual().getMatricula()});
					gerente = gerente.getProximo();
				}
		
				caixaTable.setModel(caixaModel);
				gerenteTable.setModel(gerenteModel);
			}
		}

