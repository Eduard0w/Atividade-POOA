package principal;

import threads.CriadorDeLixo1;
import threads.CriadorDeLixo2;
import threads.CriadorDeLixo3;

public class Main {
	public static void main(String[] args) {
		//Começar a criar o lixo
		CriadorDeLixo1 cl = new CriadorDeLixo1();
		
		
		cl.start();		
		
		//Começar a coletar o lixo
	}
}
