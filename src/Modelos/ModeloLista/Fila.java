package Modelos.ModeloLista;

import Utilitarios.Excecao;

public class Fila<t> {

	No<t> inicio;
	No<t> fim;
	int tamanho;

	public Fila() {

		inicio = null;
		fim = null;
		tamanho = 0;

	}

	public Fila(No<t> inicio) {

		this.inicio = inicio;
		this.fim = inicio;
		this.tamanho = 1;

	}

	public void inserirFim(No<t> novo) throws Excecao {
		if (this.inicio == null) {

			this.inicio = novo;
			this.fim = novo;

		} else {

			this.fim.proximo = novo;
			this.fim = novo;

		}
		this.tamanho++;
	}

	public void removerInicio() {

		this.inicio.remover();
		this.tamanho--;

	}

	public void listar() {

		No<t> aux = this.inicio;

		while (aux != null) {

			System.out.println(aux.atual);
			aux = aux.proximo;

		}

	}

	public int getTamanho() {
		return this.tamanho;
	}

	public No<t> getInicio() {
		return this.inicio;
	}

	public No<t> getFim() {
		return this.fim;
	}

	public void setInicio(No<t> inicio) {
		this.inicio = inicio;
	}

	public void setFim(No<t> fim) {
		this.fim = fim;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void setTamanho(No<t> aux) {

		this.tamanho = 0;

		while (aux != null) {

			this.tamanho++;
			aux = aux.proximo;

		}

	}

}