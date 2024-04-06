package GestaoFuncionarios;

import Modelos.Caixa;

public class ListaCaixa {

	NoCaixa inicio;
	NoCaixa fim;
	int tamanho;

	public ListaCaixa() {
	
		inicio = null;
		fim = null;
		tamanho = 0;
		
	}

	public ListaCaixa(NoCaixa inicio, NoCaixa fim) {
		this.inicio = inicio;
		this.fim = fim;
		this.tamanho = 1;
	}

	public void inserir(Caixa gerente) {

		NoCaixa novo = new NoCaixa();
		novo.atual = gerente;
		novo.proximo = null;
		novo.anterior = this.fim;
		this.fim.proximo = novo;
		this.fim = novo;

	}

	public void remover(Caixa gerente) {
		
		NoCaixa aux = this.inicio;
		
		while(aux != null) {
			
			if(aux.atual.equals(gerente)) {
				
				aux.remover(gerente);
				this.tamanho--;
				
			}
			
			aux = aux.proximo;
			
		}
		
	}

	public void listar() {

		NoCaixa aux = this.inicio;

		while(aux != null) {

			System.out.println(aux.atual);
			aux = aux.proximo;

		}

	}

	public int getTamanho() {
		return this.tamanho;
	}

	public NoCaixa getInicio() {
		return this.inicio;
	}

	public NoCaixa getFim() {
		return this.fim;
	}

	public void setInicio(NoCaixa inicio) {
		this.inicio = inicio;
	}
	public void setFim(NoCaixa fim) {
		this.fim = fim;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void setTamanho(NoCaixa aux) {
		
		this.tamanho = 0;
		
		while(aux != null) {
			
			this.tamanho++;
			aux = aux.proximo;
			
		}
		
	}

}
