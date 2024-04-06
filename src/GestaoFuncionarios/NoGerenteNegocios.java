package GestaoFuncionarios;

import Modelos.GerenteNegocios;

public class NoGerenteNegocios {

	NoGerenteNegocios anterior;
	GerenteNegocios atual;
	NoGerenteNegocios proximo;

	public NoGerenteNegocios() {
		
		this.anterior = null;
		this.atual = null;
		this.proximo = null;
		
	}

	 public void adicionar(GerenteNegocios gerente) {
	
		NoGerenteNegocios novo = new NoGerenteNegocios();
		novo.atual = gerente;
		novo.proximo = null;
		novo.anterior = this;
		this.proximo = novo;

	}

	public void remover(GerenteNegocios gerente) {
		
		if(this.proximo != null) {
			
			this.proximo.anterior = this.anterior;
			this.anterior.proximo = this.proximo;
			
		} 
		
	}

}
