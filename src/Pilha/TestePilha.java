package Pilha;
import java.util.Stack;

public class TestePilha {

	public static void main(String[] args) {
		
		Pilha pilha = new Pilha();
		
		pilha.push("maria");
		pilha.push("joana");
		pilha.push("lucas");
		pilha.push("marcos");
		pilha.push("ana");
		
		System.out.println(pilha);
		
		pilha.pop();
		pilha.pop();
		
		System.out.println(pilha);
		System.out.println(pilha.vazio());
		
		System.out.println(pilha.peek());
		
		Stack<String> stack = new Stack<String>(); //implementacao pilha em java
		stack.add("Jessica");
		stack.add("Jonas");
		stack.add("Maurício");
		
		System.out.println(stack);
		
		stack.pop();
		
		System.out.println(stack);

	}
}
