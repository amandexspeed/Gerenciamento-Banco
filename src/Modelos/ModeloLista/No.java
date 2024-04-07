package Modelos.ModeloLista;

public class No <t>{

    No<t> anterior;
	t atual;
	No<t> proximo;

	public No() {
		
		this.anterior = null;
		this.atual = null;
		this.proximo = null;
		
	}

    public No(No<t> anterior, t atual, No<t> proximo) {
        this.anterior = anterior;
        this.atual = atual;
        this.proximo = proximo;
    }

    public No(T atual) {
        this.atual = atual;
    }

	public void adicionar(t no) {
	
		No<t> novo = new No<t>();
		novo.atual = no;
		novo.proximo = null;
		novo.anterior = this;
		this.proximo = novo;

	}

	public void adicionarMeio(t no) {
	
		No<t> novo = new No<t>();
		novo.atual = no;
		novo.proximo = this.proximo;
		novo.anterior = this;
		this.proximo = novo;

	}

	public void adicionarInicio(t no) {

		No<t> novo = new No<t>();
		novo.atual = no;
		novo.proximo = this;
		novo.anterior = null;
		this.anterior = novo;

	}

	public void remover() {
		
		if(this.proximo != null) {
			
			this.anterior.proximo = this.proximo;
			
		}else {

			this.anterior.proximo = null;

		}
		
		if(this.anterior != null) {

			this.proximo.anterior = this.anterior;

		}else {

			this.proximo.anterior = null;

		}
		
	}

}
