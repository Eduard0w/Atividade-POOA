package threads;

import fila.FilaGeral;
import lixos.Lixos;

public class CriadorDeLixo extends Thread{
	int cont = 0;
    FilaGeral lixeira = FilaGeral.getInstance();

	public void run() {
		while(cont < 10) {
			try {
                Lixos lixoGerado = Lixos.getLixoAleatorio();
                lixeira.pegarLixo(lixoGerado);
                System.out.println("Criando um lixo " + lixoGerado);
				Thread.sleep(100);
			} catch(Exception e) {
				e.getStackTrace();
			}
			cont++;
		}
//        System.out.println(lixeira);
	}
}