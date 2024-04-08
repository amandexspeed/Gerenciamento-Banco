package Modelos.ModelosPessoa;

import javax.swing.JOptionPane;

import Recepcao.GerenciarFila;
import Utilitarios.Excecao;

public class Caixa extends Funcionario implements IAtenderCliente {
	
	int contPref = 0;

	public Caixa(String nome, String CPF, int matricula) throws Excecao {
		super(nome, CPF, matricula);
	}

	@Override
	public void atenderCliente() {

		if(GerenciarFila.filaPreferencial.getInicio() != null) {
			
			if(contPref<2) {
			
				JOptionPane.showMessageDialog(null, "Nao ha clientes na fila");
				return;
	
			}else{
				Cliente cliente = GerenciarFila.filaPreferencial.getInicio().getAtual();
				JOptionPane.showMessageDialog(null, cliente.getNome()+" - "+cliente.getCPF());
				GerenciarFila.filaPreferencial.removerInicio();
				contPref++;
			}
		}else {
			if(GerenciarFila.filaNormal.getInicio() == null) {
			
				JOptionPane.showMessageDialog(null, "Não ha clientes na fila");
				return;
	
			}else{
				Cliente cliente = GerenciarFila.filaNormal.getInicio().getAtual();
				JOptionPane.showMessageDialog(null, cliente.getNome()+" - "+cliente.getCPF());
				GerenciarFila.filaNormal.removerInicio();
				contPref=0;
			}
		}

	}

}
