package RH;

import Modelos.ModeloLista.*;
import Modelos.ModelosPessoa.*;

import java.util.ArrayList;
import java.util.List;

import Data.GerenciarArquivos.GerenciarArquivos;
import GUI.ExcecaoPainel;
import Utilitarios.Excecao;

public class GestaoFuncionarios {

    public static Lista<Caixa> ListaCaixa;
    public static Lista<GerenteNegocios> ListaGerente;
    public static Lista<Lista> ListaDepartamento;

    static void iniciarLista() {

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
            ListaCaixa.inserirInicio((Caixa)funcionario);
        }

        List<Funcionario> gerentes = new ArrayList<Funcionario>();
        gerentes = GerenciarArquivos.lerArquivo("gerentes");

        for (Funcionario funcionario : gerentes) {
            ListaGerente.inserirInicio((GerenteNegocios)funcionario);
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
        if (tipo.equals("Caixa")) {
            ListaCaixa.listar();
        } else if (tipo.equals("Gerente")) {
            ListaGerente.listar();
        }
    }

    static void listarFuncionarios() {
        ListaDepartamento.listar();

        try {
            Lista<Lista> aux = new Lista<Lista>();
        } catch (Excecao e) {
            ExcecaoPainel.exibirExcecao(e.getMessage());
        }

        for(int i = 0; i < ListaDepartamento.getTamanho(); i++) {
            


        }
    }



}
