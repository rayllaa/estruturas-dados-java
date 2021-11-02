package ListaDuplamenteLigada;

public class TesteListaDuplamenteLigada {

	public static void main(String[] args) {
		
		ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
		lista.adicionaNoComeco("fernando");
		System.out.println(lista);
		lista.adicionaNoComeco("joana");
		lista.adicionaNoFinal("bruna");
		System.out.println(lista);
		
		//lista.removeDoFinal();
		
		System.out.println(lista);
		lista.remove(1);
		System.out.println(lista);
		
		System.out.println(lista.contem("joana"));

	}
}
