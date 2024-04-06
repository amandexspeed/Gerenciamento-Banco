package GestaoFuncionarios;

import Modelos.GerenteNegocios;

public class ListaGerenteNegocios {

	NoGerenteNegocios inicio;
	NoGerenteNegocios fim;
	int tamanho;

	public ListaGerenteNegocios() {
	
		inicio = null;
		fim = null;
		tamanho = 0;
		
	}

	public ListaGerenteNegocios(NoGerenteNegocios inicio, NoGerenteNegocios fim) {
		this.inicio = inicio;
		this.fim = fim;
		this.tamanho = 1;
	}

	public void inserir(GerenteNegocios gerente) {

		NoGerenteNegocios novo = new NoGerenteNegocios();
		novo.atual = gerente;
		novo.proximo = null;
		novo.anterior = this.fim;
		this.fim.proximo = novo;
		this.fim = novo;

	}

	public void remover(GerenteNegocios gerente) {
		
		NoGerenteNegocios aux = this.inicio;
		
		while(aux != null) {
			
			if(aux.atual.equals(gerente)) {
				
				aux.remover(gerente);
				this.tamanho--;
				
			}
			
			aux = aux.proximo;
			
		}
		
	}

	public void listar() {

		NoGerenteNegocios aux = this.inicio;

		while(aux != null) {

			System.out.println(aux.atual);
			aux = aux.proximo;

		}

	}

	public int getTamanho() {
		return this.tamanho;
	}

	public NoGerenteNegocios getInicio() {
		return this.inicio;
	}

	public NoGerenteNegocios getFim() {
		return this.fim;
	}

	public void setInicio(NoGerenteNegocios inicio) {
		this.inicio = inicio;
	}
	public void setFim(NoGerenteNegocios fim) {
		this.fim = fim;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void setTamanho(NoGerenteNegocios aux) {
		
		this.tamanho = 0;
		
		while(aux != null) {
			
			this.tamanho++;
			aux = aux.proximo;
			
		}
		
	}

}
