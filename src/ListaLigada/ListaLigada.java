package ListaLigada;

public class ListaLigada {

	private Celula primeira = null;
	private Celula ultima = null;
	private int total = 0;
	
	public Celula pegaUltimo;
	
	public void adicionaNoComeco(Object elemento) {
		
		Celula nova = new Celula(elemento, primeira);
		this.primeira = nova;
		
		if(this.total == 0) {
			this.ultima = this.primeira;
		}
		total++;
	}
	
	public void adicionaNoFinal(Object elemento) {
		
		if(this.total == 0) {
			adicionaNoComeco(elemento);
		}
		
		Celula nova = new Celula(elemento, null);
		this.ultima.setProximo(nova);
		this.ultima = nova;
		this.total++;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.total;
	}
	
	private Celula pegaCelula(int posicao) {
		
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inexistente!");
		}
		
		Celula atual = this.primeira;
		
		for(int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		
		return atual;
	}
	
	public void adiciona(int posicao, Object elemento) {
		
		if(posicao == 0) {
			adicionaNoComeco(elemento);
		}else if(posicao == this.total) {
			adicionaNoFinal(elemento);
		}else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula nova = new Celula(elemento, anterior.getProximo());
			anterior.setProximo(nova);
			this.total++;
		}
	}
	
	public Object pega(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}
	
	public void remove(int posicao) {
		
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inexistente!");
		}
		
		if(posicao == 0) {
			removeDoComeco();
		}else if(posicao == total) {
			removeDoFinal();
		}
		
		Celula anterior = this.pegaCelula(posicao - 1);
		Celula proximoRemover = anterior.getProximo(); //elemento a ser removido
		
		Celula proximo = proximoRemover.getProximo();
		anterior.setProximo(proximo);
		
		Celula atual = proximo;
		
		for(int i = posicao+1; i < total; i++) {
			atual = atual.getProximo();
		}
		
		total--;		
	}
	
	public void removeDoComeco() {
		
		if(this.total == 0) {
			throw new IllegalArgumentException("Lista Vazia");
		}
		
		if(this.total == 1) {
			this.removeDoComeco();
		}else {
			this.primeira = this.primeira.getProximo();
			this.total--;
		}
	}
	
	public void removeDoFinal() {
		
		if(this.total == 0) {
			throw new IllegalArgumentException("Lista Vazia");
		}
		
		Celula penultima = pegaCelula(total-1);
		penultima.setProximo(null);
		this.ultima = penultima;
		this.total--;
	}

	public Object pegaUltimo() {
		
		if(this.total == 0) {
			throw new IllegalArgumentException("Lista Vazia");
		}
		
		return this.ultima.getElemento();
	}
	
	public Object pegaPrimeiro() {
		
		if(this.total == 0) {
			throw new IllegalArgumentException("Lista Vazia");
		}
		
		return this.primeira.getElemento();
	}
	
	public int tamanho() {
		return this.total;
	}
	
	//TODO
	public boolean contem(Object elemento) {
		return true;
	}
	
	@Override
	public String toString() {
		
		if(this.total == 0)
			return "[]";
		
		Celula atual = this.primeira;
		
		StringBuilder builder = new StringBuilder("[");
		
		for(int i=0; i < total; i++) {
			builder.append(atual.getElemento());
			builder.append(",");
			
			atual = atual.getProximo();
		}
		
		builder.append("]");
		
		return builder.toString();
	}
}
