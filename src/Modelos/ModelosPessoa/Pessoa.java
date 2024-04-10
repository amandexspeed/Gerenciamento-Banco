package Modelos.ModelosPessoa;

import Utilitarios.Excecao;
import Utilitarios.Regex;

public abstract class Pessoa {

	private String nome;
	private String CPF;

	public Pessoa(String nome, String CPF) throws Excecao {
		setNome(nome);
		setCPF(CPF);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Excecao {
		Regex regex = new Regex("[^a-zA-Z0-9 ]");

		if (regex.teste(nome))
			throw new Excecao("Nome inválido. Caracteres inválidos detectados");

		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) throws Excecao {
		if (CPF.length() != 11)
			throw new Excecao("Cpf inválido. Quantidade de caracteres inválida");

		Regex regex = new Regex("\"[^0-9]\"");

		if (regex.teste(CPF))
			throw new Excecao("Cpf inválido. Caracteres inválidos detectados");

		this.CPF = CPF;
	}
}
