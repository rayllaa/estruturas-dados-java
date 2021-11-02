package Fila;
import java.util.LinkedList;
import java.util.Queue;

public class TesteFila {

	public static void main(String[] args) {
		
		Fila fila = new Fila();
		
		fila.adicionar("fernando");
		fila.adicionar("maria");
		fila.adicionar("josé");
		
		System.out.println(fila);
		
		fila.remover();
		
		System.out.println(fila);
		
		Object x1 = fila.poll();
		System.out.println(fila);
		System.out.println(x1);
		
		Queue<String> filaJava = new LinkedList<String>(); //fila em java
		
		filaJava.add("joaooo");
		filaJava.add("mariaa");
		
		System.out.println(filaJava);

	}
}
