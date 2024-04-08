package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelos.ModeloLista.Lista;
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
        setPreferredSize(new Dimension(1280, 720));
        setLayout(new BorderLayout());

        caixaTable = new JTable();
        gerenteTable = new JTable();

        JScrollPane caixaScrollPane = new JScrollPane(caixaTable);
        JScrollPane gerenteScrollPane = new JScrollPane(gerenteTable);

        JPanel tabelaPanel = new JPanel(new GridLayout(1, 2));
        tabelaPanel.add(caixaScrollPane);
        tabelaPanel.add(gerenteScrollPane);

        add(tabelaPanel, BorderLayout.CENTER);

        botaoVoltar = new JButton("Voltar");

        add(botaoVoltar, BorderLayout.SOUTH);
    }

    public static void preencherTabelas() throws Excecao {
        Lista<Caixa> funcionariosCaixa = GestaoFuncionarios.ListaCaixa;
        Lista<GerenteNegocios> funcionariosGerente = GestaoFuncionarios.ListaGerente;

        DefaultTableModel caixaModel = new DefaultTableModel();
        DefaultTableModel gerenteModel = new DefaultTableModel();

        caixaModel.addColumn("Nome");
        caixaModel.addColumn("CPF");
        caixaModel.addColumn("Matrícula");

        gerenteModel.addColumn("Nome");
        gerenteModel.addColumn("CPF");
        gerenteModel.addColumn("Matrícula");

        for (int i = 0; i < funcionariosCaixa.getTamanho(); i++) {
            Caixa funcionario = funcionariosCaixa.getElemento(i);
            caixaModel.addRow(new Object[]{funcionario.getNome(), funcionario.getCPF(), funcionario.getMatricula()});
        }
        for (int i = 0; i < funcionariosGerente.getTamanho(); i++) {
            GerenteNegocios funcionario = funcionariosGerente.getElemento(i);
            gerenteModel.addRow(new Object[]{funcionario.getNome(), funcionario.getCPF(), funcionario.getMatricula()});
        }

        caixaTable.setModel(caixaModel);
        gerenteTable.setModel(gerenteModel);
    }

    public JButton getBotaoVoltar() {
        return botaoVoltar;
    }
}