package Data.GerenciarArquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Modelos.ModelosPessoa.Caixa;
import Modelos.ModelosPessoa.Funcionario;


public class GerenciarArquivos {

	
	public static <T> void escreverArquivo(T objeto, String nomeArquivo) {
        try (FileWriter fw = new FileWriter(nomeArquivo, true);
             PrintWriter writer = new PrintWriter(fw)) {

            if (objeto instanceof Funcionario) {
                Funcionario funcionario = (Modelos.ModelosPessoa.Funcionario) objeto;
                writer.println(funcionario.getNome() + "," + funcionario.getCPF() + "," + funcionario.getMatricula());
            } else if (objeto instanceof Caixa) {
            	Caixa caixa = (Caixa) objeto;
                writer.println(caixa.getNome() + "," + caixa.getCPF() + "," + caixa.getMatricula());
            } else {
            	System.out.println("Tipo de objeto não suportado.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
	
	
}	
