package principal;

import fila.FilaGeral;
import threads.CriadorDeLixo;

public class Main {
	public static void main(String[] args) {
		//Começar a criar o lixo
		CriadorDeLixo cl1 = new CriadorDeLixo();
        CriadorDeLixo cl2 = new CriadorDeLixo();

		cl1.start();
        cl2.start();

        try {
            cl1.join();
            cl2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Lixeira geral:");
        FilaGeral.getInstance().getLixeira();
	}
}

