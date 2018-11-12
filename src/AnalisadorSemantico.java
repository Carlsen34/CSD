import java.util.ArrayList;
import java.util.List;

public class AnalisadorSemantico {
	static List<TabelaSimbolos> simbolos = new ArrayList<TabelaSimbolos>();

	public static void inserirTabela(String identificador) {
		TabelaSimbolos ts = new TabelaSimbolos();
		ts.setIdentificador(identificador);
		simbolos.add(ts);

	}

	public static boolean procurarTabela(String identificadorAux) {
		for (int i = 0; i < simbolos.size(); i++) {
			if (simbolos.get(i).getIdentificador().equals(identificadorAux)) {
				return true;
			}
		}
		return false;

	}

	public static void printarTS() {
		for (int i = 0; i < simbolos.size(); i++) {
			System.out.println(simbolos.get(i).identificador);
		}
	}

}
