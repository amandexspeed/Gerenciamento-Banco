package Modelos.ModelosPessoa;

import Utilitarios.Excecao;

public class Funcionario extends Pessoa {
	
	int matricula;

	public Funcionario(String nome, String CPF,int matricula) throws Excecao {
		super(nome, CPF);
		this.matricula = matricula;
		// TODO Auto-generated constructor stub
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}
