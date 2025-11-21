package principal;

import java.util.Scanner;

import threads.ColetaLixo;
import threads.CriadorDeLixo;
import util.Temporizador;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe a duração do programa (em segundos)");
		int duracao = sc.nextInt();
		duracao = duracao * 1000; // segundos para ms

		Temporizador.iniciar(duracao);

		// Começar a criar o lixo
		CriadorDeLixo cl1 = new CriadorDeLixo();
		CriadorDeLixo cl2 = new CriadorDeLixo();
		ColetaLixo coletor = new ColetaLixo();

		cl1.start();
		cl2.start();
		coletor.start();

		try {
			cl1.join();
			cl2.join();
			coletor.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}
}