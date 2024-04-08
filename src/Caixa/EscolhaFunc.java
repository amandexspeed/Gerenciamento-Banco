package Caixa;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelos.ModeloLista.*;
import Modelos.ModelosPessoa.*;
import RH.GestaoFuncionarios;

public class EscolhaFunc {
	
	public static Funcionario funcEsc;
    public static String nome = " ";
	
	public static void escolherFuncionario(int matricula) {
		
		No<Lista> listaDeps = GestaoFuncionarios.ListaDepartamento.listar();
		
        while(listaDeps != null) {

            No listaFunc = listaDeps.getAtual().buscar(matricula);
            if(listaFunc != null) {
                if(listaFunc.getAtual() instanceof GerenteNegocios){
                    funcEsc =  (GerenteNegocios) listaFunc.getAtual();
                    
                }else if(listaFunc.getAtual() instanceof Caixa){
                    funcEsc = (Caixa) listaFunc.getAtual();
                    
                }
                nome = funcEsc.getNome();
                break;

            }

            listaDeps = listaDeps.getProximo();

        }
        JOptionPane.showMessageDialog(null,"Não foi encontrada a matrícula digitada");
        
	}
	

}
