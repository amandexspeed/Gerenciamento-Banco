package Modelos.ModelosPessoa;

import Utilitarios.Excecao;

public class GerenteNegocios extends Funcionario implements IAtenderCliente{

	public GerenteNegocios(String nome, String CPF, int matricula) throws Excecao {
		super(nome, CPF, matricula);
	}

	@Override
	public void atenderCliente() {

	}
}