package Modelos.ModelosPessoa;

import Utilitarios.Excecao;
import Utilitarios.Regex;

public abstract class Pessoa{

	private String nome;
	private String CPF;
	
	public Pessoa(String nome ,String CPF) throws Excecao {
		
		setNome(nome); 
		setCPF(CPF);
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Excecao {
			
			Regex regex = new Regex("[^a-zA-Z0-9 ]");
        	if(regex.teste(nome)) {
        		
        		Excecao exc = new Excecao("Nome inválido. Caracteres inválidos detectados");
        		throw exc;
    			
        		
        	}else {
        		
        		this.nome = nome;

        	}
				
	}

	public String getCPF() {
		return CPF;
		
	}

	public void setCPF(String CPF) throws Excecao {

		Excecao exc = null;
		if (CPF.length() !=11) {
			exc = new Excecao("Cpf inválido. Quantidade de caracteres inválida");
			throw(exc);
        } else {
        	Regex regex = new Regex("\"[^0-9]\"");
        	if(regex.teste(CPF)) {
        		
        		exc = new Excecao("Cpf inválido. Caracteres inválidos detectados");
    			throw(exc);
        		
        	}else {
        		this.CPF = CPF;
        		
        	}
        }
	}
}
