package Modelos.ModelosPessoa;

import Utilitarios.Excecao;

public class Cliente extends Pessoa {

	private boolean prioridade;

	public Cliente(String nome, String CPF, boolean prioridade) throws Excecao {
		super(nome, CPF);
		this.prioridade = prioridade;
	}

	public boolean isPrioridade() {
		return prioridade;
	}
}