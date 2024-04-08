package Modelos.ModeloLista;
import GUI.ExcecaoPainel;
import Modelos.ModelosPessoa.Funcionario;
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

	public void inserirFim(t valor) throws Excecao {

		No<t> novo = new No<t>(valor);

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

		No<t> aux = this.inicio;
		this.inicio = this.inicio.proximo;
		aux.remover();
		this.tamanho--;

	}


	public No<t> buscar(t Valor){

		No<t> aux = this.inicio;

		while(aux != null) {

			if(aux.atual == Valor) {

				return aux;

			}

			aux = aux.proximo;

		}

		return null;

	}

	public No<t> buscar(int valor){

		No<t> aux = this.inicio;

		while (aux != null) {

			Funcionario func = (Funcionario) aux.atual;

			if(func.getMatricula() == valor) {

				return aux;

			}

			aux = aux.proximo;

		}

		return null;

	}

	public No<t> listar(No<t> no){

		if(no.proximo != null) {

			no = no.proximo;
			listar(no);
			return no;
		}else{

			return no;

		}


	}


	public No<t> listar(){

		No<t> no = this.inicio;
		if(no!=null)
			if(no.proximo != null) {
				listar(no);
				return no;
			}else{

				return no;

			}
		return null;

	}

	public boolean vazia() {

		if(this.inicio == null) {

			return true;

		}else{

			return false;

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