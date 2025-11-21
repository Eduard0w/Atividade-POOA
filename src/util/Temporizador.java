package util;

public class Temporizador {

	private static long fim;

	public static void iniciar(long duracao) {
		fim = System.currentTimeMillis() + duracao;
	}

	public static boolean acabou() {
		return System.currentTimeMillis() >= fim;
	}

}
