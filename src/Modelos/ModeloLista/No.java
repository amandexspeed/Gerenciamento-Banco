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
		novo.anterior = null;
		this.proximo = novo;

	}

	public void remover() {
		if (this.proximo != null) {
			if (this.anterior != null) {
				this.proximo.anterior = this.anterior;
			} else {
			this.proximo.anterior = null;
			}

		}else if(this.anterior != null) {
				this.anterior.proximo = null;
			}
	}


	public No<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}

	public T getAtual() {
		return atual;
	}

	public void setAtual(T atual) {
		this.atual = atual;
	}

	public No<T> getProximo() {
		return proximo;
	}

	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
}