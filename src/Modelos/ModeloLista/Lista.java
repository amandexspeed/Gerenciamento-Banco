package Modelos.ModeloLista;

import Utilitarios.Excecao;

public class Lista<t> extends Fila<t> {


	public Lista() throws Excecao {
	
		super();
		
	}

	public Lista(No<t> inicio) throws Excecao {

		super(inicio);

	}

	/* public void inserirFim(t info){


		No<t> novo = new No<t>();
		novo.atual = info;
		novo.proximo = null;
		novo.anterior = this.fim;
		this.fim.proximo = novo;
		this.fim = novo;

	} */

	public void inserirInicio(t info){

		No<t> novo = new No<t>();
		novo.atual = info;
		novo.proximo = this.inicio;
		novo.anterior = null;
		if(this.inicio != null){
			this.inicio.anterior = novo;
		}else{
			this.fim = novo;
		}
		this.inicio = novo;
		

	}

	public void inserirPosicao(t info, int posicao) throws Excecao{

		if(posicao == 0) {

			this.inserirInicio(info);

		}if(posicao == tamanho){

			super.inserirFim(fim);

		}else{

			No<t> aux = this.inicio;

			for(int i = 0; i < posicao; i++) {

				aux = aux.proximo;

			}

			aux.adicionarMeio(info);

		}

	}

	public void remover(t info){

		No<t> aux = this.inicio;
		
		while(aux != null) {
			
			if(aux.atual.equals(info)) {
				
				aux.remover();
				this.tamanho--;
				
			}
			
			aux = aux.proximo;
			
		}

	}

	public void remover(int posicao){

		No<t> aux = this.inicio;

		for(int i = 0; i < posicao; i++) {

			aux = aux.proximo;

		}

		aux.remover();
		this.tamanho--;

	} 

	

}

