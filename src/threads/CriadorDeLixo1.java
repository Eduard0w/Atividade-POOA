package threads;

import lixos.Lixos;

public class CriadorDeLixo1 extends Thread{
	int cont = 0;
//	String[] tiposLixo = {"plastico", "metal", "organico", "vidro", "papel"};
	public void run() {
		while(cont < 10) {
			System.out.println("Criando um lixo " + Lixos.getLixoAleatorio());
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.getStackTrace();
			}
			cont++;
		}
	}
}