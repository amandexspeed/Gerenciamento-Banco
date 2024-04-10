package Modelos.ModeloLista;

import Utilitarios.Excecao;

public class Lista<T> extends Fila<T> {

	public Lista() throws Excecao {
		super();
	}

	public Lista(No<T> inicio) throws Excecao {
		super(inicio);
	}

	public void inserirInicio(T info) {
		No<T> novo = new No<T>();
		novo.atual = info;
		novo.proximo = this.inicio;
		novo.anterior = null;
		if (this.inicio != null) {
			this.inicio.anterior = novo;
		} else {
			this.fim = novo;
		}
		this.inicio = novo;
	}

	public void inserirPosicao(T info, int posicao) throws Excecao {
		if (posicao == 0) {
			this.inserirInicio(info);
		} else if (posicao == tamanho) {
			super.inserirFim(fim);
		} else {
			No<T> aux = this.inicio;

			for (int i = 0; i < posicao; i++) {
				aux = aux.proximo;
			}

			aux.adicionar(info);
			aux.anterior.proximo = aux;
			aux.proximo.anterior = aux;
		}
		this.tamanho++;
	}

	public void remover(T info) {
		No<T> aux = this.inicio;

		while (aux != null) {
			if (aux.atual.equals(info)) {
				aux.remover();
				this.tamanho--;
			}

			aux = aux.proximo;
		}
	}

	public void removerPos(int posicao) {
		No<T> aux = this.inicio;

		for (int i = 0; i < posicao; i++) {
			aux = aux.proximo;
		}

		aux.remover();
		this.tamanho--;
	}

	public void remover(int matricula) {
		No<T> aux = this.inicio;

		while (aux != null) {
			if (aux.atual.equals(matricula)) {
				aux.remover();
				this.tamanho--;
			}

			aux = aux.proximo;
		}
	}
}