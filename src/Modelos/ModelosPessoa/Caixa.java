package Modelos.ModelosPessoa;

import Utilitarios.Excecao;

public class Caixa extends Funcionario implements IAtenderCliente {

	public Caixa(String nome, String CPF, int matricula) throws Excecao {
		super(nome, CPF, matricula);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void atenderCliente() {
		// TODO Auto-generated method stub

	}

}
