package Modelos.Main;

import GUI.ExcecaoPainel;
import GUI.JanelaPrincipal;
import RH.GestaoFuncionarios;
import Utilitarios.Excecao;

public class Main {

	public static void main(String[] args) {

		GestaoFuncionarios.iniciarLista();
		JanelaPrincipal telaPrincipal;
		try {
			telaPrincipal = new JanelaPrincipal();
			telaPrincipal.setVisible(true);
		} catch (Excecao e) {
			ExcecaoPainel.exibirExcecao(e.getMessage());;
		}

	}

}
