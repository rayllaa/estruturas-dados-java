package Fila;
import java.util.LinkedList;

public class Fila {

	private LinkedList nomes = new LinkedList();
	
	public void adicionar(Object elemento) {
		nomes.addLast(elemento);
	}
	
	public void remover() {
		nomes.removeFirst();
	}
	
	public boolean vazio() {
		return nomes.size() == 0;
	}
	
	public Object poll() { //obtem elementos removidos
		
		if(nomes.size() == 0) {
			return null;
		}else {
			Object primeiro = nomes.getFirst();
			nomes.removeFirst();
			
			return primeiro;
		}
	}
	
	@Override
	public String toString() {
		return nomes.toString();
	}
}
