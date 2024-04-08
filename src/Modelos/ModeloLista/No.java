package Modelos.ModeloLista;

public class No<T> {

	public No<T> anterior;
	public T atual;
	public No<T> proximo;

	public No() {
		this.anterior = null;
		this.atual = null;
		this.proximo = null;
	}

	public No(No<T> anterior, T atual, No<T> proximo) {
		this.anterior = anterior;
		this.atual = atual;
		this.proximo = proximo;
	}

	public No(T atual) {
		this.atual = atual;
	}

	public void adicionar(T no) {

		No<T> novo = new No<T>();
		novo.atual = no;
		novo.proximo = null;
		novo.anterior = this;
		this.proximo = novo;

	}

	public void adicionarMeio(T no) {

		No<T> novo = new No<T>();
		novo.atual = no;
		novo.proximo = this.proximo;
		novo.anterior = this;
		this.proximo = novo;

	}

	public void adicionarInicio(T no) {

		No<T> novo = new No<T>();
		novo.atual = no;
		novo.proximo = this;
		novo.anterior = null;
		this.anterior = novo;

	}

	public void remover() {
		if (this.proximo != null) {
			this.anterior.proximo = this.proximo;
		} else {
			this.anterior.proximo = null;
		}

		if (this.anterior != null) {
			this.proximo.anterior = this.anterior;
		} else {
			this.proximo.anterior = null;
		}
	}
}