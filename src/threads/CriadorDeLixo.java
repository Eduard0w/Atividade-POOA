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
                lixeira.addLixo(lixoGerado);
                System.out.println(Thread.currentThread().getName() + " Criando um lixo " + lixoGerado);
				Thread.sleep(500);
			} catch(Exception e) {
				e.getStackTrace();
			}
			cont++;
		}
        Thread.currentThread().interrupt();
//        System.out.println(lixeira);
	}
}