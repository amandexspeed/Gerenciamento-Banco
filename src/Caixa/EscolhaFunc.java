package Caixa;

import Modelos.ModeloLista.*;
import Modelos.ModelosPessoa.*;
import RH.GestaoFuncionarios;

public class EscolhaFunc {
	
	public static Funcionario funcEsc;
	
	public static void escolherFuncionario(int matricula) {
		
		No<Lista> listaDeps = GestaoFuncionarios.ListaDepartamento.listar();
		
        while(listaDeps != null) {

            No<Funcionario> listaFunc = listaDeps.getAtual().buscar(matricula);
            if(listaFunc != null) {
                funcEsc =  listaFunc.getAtual();
                break;
            }
        }
		
	}
	

}
