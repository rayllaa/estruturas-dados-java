package ListaDuplamenteLigada;

public class ListaDuplamenteLigada {

	private Celula primeira = null;
	private Celula ultima = null;
	private int total = 0;
	
	public void adicionaNoComeco(Object elemento) {
		
		if(this.total == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		}else {
			Celula nova = new Celula(elemento, this.primeira);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		total++;
	}
	
	public void adicionaNoFinal(Object elemento) {
		
		if(this.total == 0) {
			adicionaNoComeco(elemento);
		}
		
		Celula nova = new Celula(elemento);
		this.ultima.setProximo(nova);
		nova.setAnterior(this.ultima);
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
			Celula proxima = anterior.getProximo();
			
			Celula nova = new Celula(elemento, anterior.getProximo());
			nova.setAnterior(anterior);
			anterior.setProximo(nova);
			proxima.setAnterior(nova);
			
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
		}else if(posicao == this.total) {
			removeDoFinal();
		}
		
		Celula anterior = this.pegaCelula(posicao - 1);
		Celula atual = anterior.getProximo(); //elemento a ser removido
		Celula proximo = atual.getProximo();
		
		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);
		
		total--;		
	}
	
	public void removeDoComeco() {
		
		if(this.total == 0) {
			throw new IllegalArgumentException("Lista Vazia");
		}
		
		this.primeira = this.primeira.getProximo();
		this.total--;
	}
	
	public void removeDoFinal() {
		
		if(this.total == 0) {
			throw new IllegalArgumentException("Lista vazia!");
		}
		if(this.total == 1) {
			this.removeDoComeco();
		}else {
			Celula penultima = this.ultima.getAnterior();
			penultima.setProximo(null);
			this.ultima = penultima;
			this.total--;
		}
	}
	
	public int tamanho() {
		return this.total;
	}
	
	public boolean contem(Object elemento) {
		Celula atual = this.primeira;
		
		while(atual != null) {
			if(atual.getElemento().equals(elemento)) {
				return true;
			}
			
			atual = atual.getProximo();
		}
		return false;
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
