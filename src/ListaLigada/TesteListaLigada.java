package ListaLigada;

public class TesteListaLigada {

	public static void main(String[] args) {
		
		ListaLigada lista = new ListaLigada();
		lista.adicionaNoComeco("fernando");
		lista.adicionaNoComeco("joana");
		lista.adicionaNoFinal("bruna");
		lista.adicionaNoComeco("lucas");
		lista.adicionaNoFinal("debora");
		
		System.out.println(lista);
		lista.adiciona(2, "higor");
		System.out.println(lista);

		lista.remove(4);
		lista.removeDoFinal();
		System.out.println(lista);
	}

}
