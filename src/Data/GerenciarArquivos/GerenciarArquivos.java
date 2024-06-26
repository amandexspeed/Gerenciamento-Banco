package Data.GerenciarArquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.io.File;
import GUI.ExcecaoPainel;
import Modelos.ModelosPessoa.Funcionario;
import Utilitarios.Excecao;

import java.io.FileReader;
import java.io.BufferedReader; 


public class GerenciarArquivos {

	public static void escreverArquivo(Funcionario objeto, String tipoFunc) {
	        try (FileWriter fw = new FileWriter("src"+File.separator+"Data"+File.separator+"Arquivos" + File.separator + tipoFunc + ".txt", true);
	             PrintWriter writer = new PrintWriter(fw)) {
	
	            if (objeto instanceof Funcionario) {
	                writer.println(objeto.getNome() + "," + objeto.getCPF() + "," + objeto.getMatricula());
	            } else {
	            	JOptionPane.showMessageDialog(null,"Tipo de objeto não suportado.");
	            }
	        } catch (IOException e) {
	            ExcecaoPainel.exibirExcecao("Erro ao escrever no arquivo: " + e.getMessage());
	        }
	    }

    public static List<Funcionario> lerArquivo(String tipoFunc) {
        try (FileReader fr = new FileReader("src/Data/Arquivos/"+tipoFunc+".txt");
             BufferedReader reader = new BufferedReader(fr)) {

            String linha;
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                String cpf = dados[1];
                int matricula = Integer.parseInt(dados[2]);

                try {
                    Funcionario func = new Funcionario(nome, cpf, matricula);
                    funcionarios.add(func);
                    
                } catch (Excecao e) {
                    ExcecaoPainel.exibirExcecao(e.getMessage());
                }

            }
            return funcionarios;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Erro ao ler o arquivo: " + e.getMessage());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Erro ao converter a matrícula para inteiro: " + e.getMessage());
        }
        return null;
    }

    public static void removerFuncionario(String tipoFunc, int matricula) {

        List<Funcionario> funcionarios = lerArquivo(tipoFunc);

        try (FileWriter fw = new FileWriter("src/Data/Arquivos/"+tipoFunc+".txt", false);
             PrintWriter writer = new PrintWriter(fw)) {

                for(Funcionario func:funcionarios){

                    if(func.getMatricula() != matricula){

                        writer.println(func.getNome() +","+func.getCPF()+ ","+func.getMatricula());

                    }

                }

        }catch (IOException e) {
            ExcecaoPainel.exibirExcecao("Erro ao escrever no arquivo: " + e.getMessage());
        }

                
            
    }
}

	
