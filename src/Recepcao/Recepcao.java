package Recepcao;

import java.util.Scanner;

import Modelos.ModeloLista.Fila;
import Modelos.ModeloLista.No;
import Modelos.ModelosPessoa.Cliente;
import Modelos.ModelosPessoa.IAtenderCliente;
import Utilitarios.Excecao;

public class Recepcao implements IAtenderCliente {

    private Fila<Cliente> fila;
    private int atendidosPrioridade;

    public Recepcao() {
        fila = new Fila<Cliente>();
        atendidosPrioridade = 0;
    }

    private String lerNomeDoCliente() {
        System.out.println("Digite seu nome completo: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        scanner.close();
        return nome;
    }

    private String lerCpfDoCliente() {
        System.out.println("Digite seu CPF: ");
        Scanner scanner = new Scanner(System.in);
        String cpf = scanner.nextLine();
        scanner.close();
        return cpf;
    }

    private boolean lerClienteIsPreferencial() {
        System.out.println("O cliente é preferencial? (S/N)");
        Scanner scanner = new Scanner(System.in);
        String resposta = scanner.nextLine();
        scanner.close();
        if (resposta.equalsIgnoreCase("N")) {
            return false;
        }
        return true;
    }

    public Cliente cadastrarCliente() {
        String nome = lerNomeDoCliente();
        String cpf = lerCpfDoCliente();
        boolean prioridade = lerClienteIsPreferencial();

        try {
            Cliente cliente = new Cliente(nome, cpf, prioridade);
            No<Cliente> no = new No<Cliente>(cliente);
            fila.inserirFim(no);
            System.out.println("Cliente " + nome + " cadastrado na fila.");
            return cliente;
        } catch (Excecao e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void atenderCliente() {
        if (fila.getTamanho() == 0) {
            System.out.println("Fila vazia. Não há clientes para atender.");
            return;
        }

        if (atendidosPrioridade >= 2 && existeClienteNaoPrioridade()) {
            atenderClienteNaoPrioridade();
            return;
        }

        No<Cliente> noCliente = fila.getInicio();
        Cliente cliente = noCliente.atual;

        if (cliente.isPrioridade()) {
            atenderClientePrioritario();
        } else {
            atenderClienteNaoPrioridadeNoInicio();
        }
    }

    private void atenderClienteNaoPrioridade() {
        No<Cliente> noCliente = buscarClienteNaoPrioridade();
        Cliente cliente = noCliente.atual;
        //TODO: Implementar remover do meio da fila caso seja um cliente não prioritário e ele não esteja no início da fila;
        System.out.println("Atendendo cliente " + cliente.getNome() + " (CPF: " + cliente.getCPF() + ").");
        atendidosPrioridade = 0;
    }

    private void atenderClienteNaoPrioridadeNoInicio() {
        No<Cliente> noCliente = fila.getInicio();
        Cliente cliente = noCliente.atual;
        System.out.println("Atendendo cliente " + cliente.getNome() + " (CPF: " + cliente.getCPF() + ").");
        atendidosPrioridade = 0;
        fila.removerInicio();
    }

    private No<Cliente> buscarClienteNaoPrioridade() {
        No<Cliente> noAtual = fila.getInicio();
        while (noAtual != null) {
            if (!noAtual.atual.isPrioridade()) {
                return noAtual;
            }
            noAtual = noAtual.proximo;
        }
        return null;
    }

    private void atenderClientePrioritario() {
        No<Cliente> noCliente = fila.getInicio();
        Cliente cliente = noCliente.atual;
        System.out.println("Atendendo cliente " + cliente.getNome() + " (CPF: " + cliente.getCPF() + ") com prioridade.");
        fila.removerInicio();
        atendidosPrioridade++;
    }

    private boolean existeClienteNaoPrioridade() {
        No<Cliente> noAtual = fila.getInicio();
        while (noAtual != null) {
            if (!noAtual.atual.isPrioridade()) {
                return true;
            }
            noAtual = noAtual.proximo;
        }
        return false;
    }
}