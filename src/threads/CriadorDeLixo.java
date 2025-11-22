package threads;

import fila.FilaGeral;
import lixos.Lixos;
import util.Temporizador;

public class CriadorDeLixo extends Thread{
    FilaGeral lixeira = FilaGeral.getInstance();

	public void run() {
		while(!Temporizador.acabou()) {
			try {
                Lixos lixoGerado = Lixos.getLixoAleatorio();
                lixeira.pegarLixo(lixoGerado);
                System.out.println("Criando um lixo " + lixoGerado);
				Thread.sleep(1000);
			} catch(Exception e) {
				e.getStackTrace();
			}
		}
		System.out.println("Tempo do programa expirou. Finalizando o Criador de Lixo - " + Thread.currentThread().getName());
	}
}