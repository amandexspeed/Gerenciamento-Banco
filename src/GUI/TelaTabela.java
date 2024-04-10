package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelos.ModeloLista.No;
import Modelos.ModelosPessoa.Caixa;
import Modelos.ModelosPessoa.GerenteNegocios;
import RH.GestaoFuncionarios;
import Utilitarios.Excecao;

import java.awt.*;
import javax.swing.JButton;

public class TelaTabela extends JPanel {

    private static JTable caixaTable;
    private static JTable gerenteTable;
    private JButton botaoVoltar;

    public TelaTabela() throws Excecao {

        JPanel tabelaPanel = new JPanel(new GridLayout(1, 2));
        tabelaPanel.removeAll(); // Remove todos os componentes do JPanel

        caixaTable = new JTable();
        gerenteTable = new JTable();

        JScrollPane caixaScrollPane = new JScrollPane(caixaTable);
        JScrollPane gerenteScrollPane = new JScrollPane(gerenteTable);  

        preencherTabelas();

        setPreferredSize(new Dimension(1280, 720));
        setLayout(new BorderLayout());

        
        tabelaPanel.add(caixaScrollPane);
        tabelaPanel.add(gerenteScrollPane);

        add(tabelaPanel, BorderLayout.CENTER);

        botaoVoltar = new JButton("Voltar");

        add(botaoVoltar, BorderLayout.SOUTH);
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

    public JButton getBotaoVoltar() {
        return botaoVoltar;
    }
}