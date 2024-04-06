package GestaoFuncionarios;

import Modelos.Caixa;

public class NoCaixa {

	NoCaixa anterior;
	Caixa atual;
	NoCaixa proximo;

	public NoCaixa() {
		
		this.anterior = null;
		this.atual = null;
		this.proximo = null;
		
	}

	 public void adicionar(Caixa gerente) {
	
		NoCaixa novo = new NoCaixa();
		novo.atual = gerente;
		novo.proximo = null;
		novo.anterior = this;
		this.proximo = novo;

	}

	public void remover(Caixa gerente) {
		
		if(this.proximo != null) {
			
			this.proximo.anterior = this.anterior;
			this.anterior.proximo = this.proximo;
			
		} 
		
	}

}
