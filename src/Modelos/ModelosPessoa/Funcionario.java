package Modelos.ModelosPessoa;

import Utilitarios.Excecao;

public class Funcionario extends Pessoa implements IAtenderCliente {
	
	int matricula;

	public Funcionario(String nome, String CPF,int matricula) throws Excecao {
		super(nome, CPF);
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	

	@Override
	public void atenderCliente() {
		// TODO Auto-generated method stub
		
	}

}
