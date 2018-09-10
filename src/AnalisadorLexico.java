import java.util.Stack;

public class AnalisadorLexico {
	static Stack token = new Stack();

	public static Stack eliminarComentario(Stack caracter) {
		Stack aux = new Stack();

		for (int i = 0; i < caracter.size(); i++) {
			if (caracter.get(i).equals('{')) {
				do {
					i++;
				} while (!caracter.get(i).equals('}'));
			} else {
				aux.add(caracter.get(i));

			}
		}

		return aux;
	}
	
	
	
	public static Stack consumirEspaco(Stack caracter) {
	
		int i = 0;
		
		do {
		token.add(caracter.get(i));
		caracter.remove(i);
		}while(!caracter.get(i).equals(' '));
		
		if(caracter.get(i).equals(' ')) {
			do {
				caracter.remove(i);
			}while(caracter.get(i).equals(' '));
		}
		
		
		tratarToken(token);
		
		return caracter;
	}
	
	
	
	
	public static void tratarToken(Stack token) {
		
		Simbulo simbulos = new Simbulo();
		
		for(int i = 0; i < token.size();i++) {
			String aux = token.get(i).toString();
			if(isDigit(aux) == false) {
				i = tratarCaracter(token, i);
			}else {
				//i = tratarDigito(token, i);
				i = tratarCaracter(token, i);
			}
		}
		
		
		System.out.println("Tabela de Token = " + token);
		
	}

	public static int tratarDigito(Stack caracter, int i) {
		String aux = "";
		do {
			aux = aux + caracter.get(i).toString();
			i++;

		} while (isDigit(caracter.get(i).toString()) == true);

		token.add(Simbulo.snumero);
		return i - 1;

	}

	public static int tratarCaracter(Stack caracter, int i) {
		String aux = "";
		do {

			aux = aux + caracter.get(i).toString();
			i++;
		
			Boolean identificador = true;
			verificarPalavrasReservadas(aux);
			
			if(aux.equals("programa")) {
				token.add(Simbulo.sprograma);
				aux = "";
				identificador = false;
			}
			
			if(aux.equals("início")) {
				token.add(Simbulo.sinício);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("fim")) {
				token.add(Simbulo.sfim);
				aux = "";
				identificador = false;

			}
			if(aux.equals("procedimento")) {
				token.add(Simbulo.sprocedimento);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("funcao")) {
				token.add(Simbulo.sfuncao);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("se")) {
				token.add(Simbulo.sse);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("entao")) {
				token.add(Simbulo.sentao);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("senao")) {
				token.add(Simbulo.ssenao);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("enquanto")) {
				token.add(Simbulo.senquanto);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("faca")) {
				token.add(Simbulo.sfaca);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("início")) {
				token.add(Simbulo.sinício);
				aux = "";
				identificador = false;

			}
	
			if(aux.equals("fim")) {
				token.add(Simbulo.sfim);
				aux = "";
				identificador = false;

			}
	
			
			if(aux.equals("escreva")) {
				token.add(Simbulo.sescreva);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("leia")) {
				token.add(Simbulo.sleia);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("var")) {
				token.add(Simbulo.svar);
				aux = "";
				identificador = false;

			}
			
		
			if(aux.equals("inteiro")) {
				token.add(Simbulo.sinteiro);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("booleano")) {
				token.add(Simbulo.sbooleano);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("verdadeiro")) {
				token.add(Simbulo.sverdadeiro);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("falso")) {
				token.add(Simbulo.sfalso);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("div")) {
				token.add(Simbulo.sdiv);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("e")) {
				token.add(Simbulo.se);
				aux = "";
				identificador = false;

			}
	
			if(aux.equals("ou")) {
				token.add(Simbulo.sou);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("nao")) {
				token.add(Simbulo.snao);
				aux = "";
				identificador = false;

			}
			
			if(aux.equals("contador")) {
				token.add(Simbulo.sidentificador);
				aux = "";
				identificador = false;

			}
			
//			if(identificador == true) {
//				token.add(Simbulo.sidentificador);
//				aux = "";
//				identificador = false;
//			}

			

		}while(i<caracter.size() && isDigit(caracter.get(i).toString()) == false );


		return i - 1;
	}
	
	
	public static void verificarPalavrasReservadas(String aux) {
		
	}
	

	public static boolean isDigit(String aux) {
		if (aux.equals("0") || aux.equals("1") || aux.equals("2") || aux.equals("3") || aux.equals("4")
				|| aux.equals("5") || aux.equals("6") || aux.equals("7") || aux.equals("8") || aux.equals("9")) {
			return true;
		}
		return false;

	}

}