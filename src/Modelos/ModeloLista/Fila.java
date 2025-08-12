package Modelos.ModeloLista;

import Modelos.ModelosPessoa.Funcionario;
import Utilitarios.Excecao;

public class Fila<T> {

	No<T> inicio;
	No<T> fim;
	int tamanho;

	public Fila() {
		inicio = null;
		fim = null;
		tamanho = 0;
	}

	public Fila(No<T> inicio) {
		this.inicio = inicio;
		this.fim = inicio;
		this.tamanho = 1;
	}

	public void inserirFim(No<T> novo) throws Excecao {
		if (this.inicio == null) {
			this.inicio = novo;
			this.fim = novo;
		} else {
			this.fim.proximo = novo;
			this.fim = novo;
		}
		this.tamanho++;
	}

	public void inserirFim(T valor) throws Excecao {
		No<T> novo = new No<T>(valor);

		if (this.inicio == null) {
			this.inicio = novo;
			this.fim = novo;
		} else {
			novo.anterior = this.fim;
			this.fim.proximo = novo;
			this.fim = novo;
		}
		this.tamanho++;
	}

	public void removerInicio() {
		No<T> aux = this.inicio;
		this.inicio = this.inicio.proximo;

		aux.remover();
		this.tamanho--;
	}

	public No<T> buscar(T Valor) {
		No<T> aux = this.inicio;

		while (aux != null) {
			if (aux.atual == Valor) {
				return aux;
			}

			aux = aux.proximo;
		}
		return null;
	}

	public No<T> buscar(int valor) {
		No<T> aux = this.inicio;

		while (aux != null) {
			Funcionario func = (Funcionario) aux.atual;
			if (func.getMatricula() == valor) {
				return aux;
			}

			aux = aux.proximo;
		}
		return null;
	}

	public No<T> listar(No<T> no) {
		if (no.proximo == null) {
			return no;
		}

		no = no.proximo;
		listar(no);
		return no;
	}

	public No<T> listar() {
		No<T> no = this.inicio;

		if (no != null) {
			if (no.proximo == null) {
				return no;
			}
			listar(no);
			return no;

		}
		return null;

	}

	public boolean vazia() {
		return this.inicio == null;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public No<T> getInicio() {
		return this.inicio;
	}

	public No<T> getFim() {
		return this.fim;
	}

	public void setInicio(No<T> inicio) {
		this.inicio = inicio;
	}

	public void setFim(No<T> fim) {
		this.fim = fim;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void setTamanho(No<T> aux) {
		this.tamanho = 0;

		while (aux != null) {
			this.tamanho++;
			aux = aux.proximo;
		}
	}
}