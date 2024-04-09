package RH;

import Modelos.ModeloLista.*;
import Modelos.ModelosPessoa.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Data.GerenciarArquivos.GerenciarArquivos;
import GUI.ExcecaoPainel;
import GUI.TelaCaixa;
import GUI.TelaExcluir;
import GUI.TelaTabela;
import Utilitarios.Excecao;

public class GestaoFuncionarios {

    public static Lista<Caixa> ListaCaixa;
    public static Lista<GerenteNegocios> ListaGerente;
    public static Lista<Lista> ListaDepartamento;

    public static void iniciarLista(){

        try {
            ListaCaixa = new Lista<Caixa>();
        } catch (Excecao e) {
            ExcecaoPainel.exibirExcecao(e.getMessage());
        }

        try {
            ListaGerente = new Lista<GerenteNegocios>();
        } catch (Excecao e) {
            ExcecaoPainel.exibirExcecao(e.getMessage());
        }

        List<Funcionario> caixas = new ArrayList<Funcionario>();
        caixas = GerenciarArquivos.lerArquivo("caixa");
        for (Funcionario funcionario : caixas) {
            Caixa caixa;
            try {
                caixa = new Caixa(funcionario.getNome(), funcionario.getCPF(),funcionario.getMatricula());
                ListaCaixa.inserirInicio(caixa);
            } catch (Excecao e) {
                e.printStackTrace();
            }
        }

        List<Funcionario> gerentes = new ArrayList<Funcionario>();
        gerentes = GerenciarArquivos.lerArquivo("gerentes");

        for (Funcionario funcionario : gerentes) {
           
            GerenteNegocios gerente;
            try {
                gerente = new GerenteNegocios(funcionario.getNome(), funcionario.getCPF(),funcionario.getMatricula());
                
                ListaGerente.inserirInicio(gerente);
            } catch (Excecao e) {
                e.printStackTrace();
            }    
            
        }

        try {
            ListaDepartamento = new Lista<Lista>();
        } catch (Excecao e) {
            ExcecaoPainel.exibirExcecao(e.getMessage());
        }

        ListaDepartamento.inserirInicio(ListaCaixa);
        ListaDepartamento.inserirInicio(ListaGerente);

    }


    static void cadastrarFuncionario(Funcionario funcionario) {
        if (funcionario instanceof Caixa) {
            ListaCaixa.inserirInicio((Caixa)funcionario);
        } else if (funcionario instanceof GerenteNegocios) {
            ListaGerente.inserirInicio((GerenteNegocios)funcionario);
        }
    }

    static void removerFuncionario(Funcionario funcionario) {
        if (funcionario instanceof Caixa) {
            ListaCaixa.remover((Caixa)funcionario);
        } else if (funcionario instanceof GerenteNegocios) {
            ListaGerente.remover((GerenteNegocios)funcionario);
        }
    }

    static void listarFuncionarios(String tipo) {
        if (tipo.equals("caixa")) {
            ListaCaixa.listar();
        } else if (tipo.equals("Gerente")) {
            ListaGerente.listar();
        }
    }

    public static void removerFuncionario(String tipo, int matricula) {
        if (tipo.equals("Caixa")) {
            ListaCaixa.remover(matricula);
        } else if (tipo.equals("Gerente")) {
            ListaGerente.remover(matricula);
        }
        GerenciarArquivos.removerFuncionario(tipo, matricula);
        JOptionPane.showMessageDialog(null, tipo+" foi removido com sucesso!");
    }

    public static void atualizarTabelas(){

        try {
            TelaTabela.preencherTabelas();
            TelaExcluir.preencherTabelas();
            TelaCaixa.preencherTabelas();
        } catch (Excecao e) {
            e.printStackTrace();
        }

    }
}