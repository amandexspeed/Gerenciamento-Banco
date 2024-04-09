package Modelos.ModelosPessoa;

import javax.swing.JOptionPane;

import Recepcao.GerenciarFila;
import Utilitarios.Excecao;

public class GerenteNegocios extends Funcionario{

	public GerenteNegocios(String nome, String CPF, int matricula) throws Excecao {
		super(nome, CPF, matricula);
	}

	@Override
	public void atenderCliente() {

		if(GerenciarFila.filaVIP.getInicio() == null) {
			
			JOptionPane.showMessageDialog(null, "Não há clientes na fila");
			return;

		}else{

			Cliente cliente = GerenciarFila.filaVIP.getInicio().getAtual();
			JOptionPane.showMessageDialog(null, cliente.getNome()+" - "+cliente.getCPF());
			GerenciarFila.filaVIP.removerInicio();

		}

	}
}