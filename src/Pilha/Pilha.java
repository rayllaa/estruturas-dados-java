package Pilha;
import java.util.LinkedList;

public class Pilha {

	private LinkedList nomes = new LinkedList(); //lista ligada
	
	public void push(Object elemento) { //add no topo
		nomes.addLast(elemento);
	}
	
	public void pop() { //remover do topo
		nomes.removeLast();
	}
	
	public Object peek() { //retorna útimo elemento da pilha
		return nomes.getLast();
	}
	
	public boolean vazio() {
		return nomes.size() == 0;
	}
	
	@Override
	public String toString() {
		return nomes.toString();
	}
}