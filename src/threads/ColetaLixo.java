package threads;

import fila.FilaGeral;
import lixos.Lixos;

import java.util.ArrayList;
import java.util.List;

public class ColetaLixo extends Thread {
	private FilaGeral filaGeral = FilaGeral.getInstance();
	private List<Lixos> reciclavel = new ArrayList<>();
	private List<Lixos> naoReciclavel = new ArrayList<>();

	private boolean run = true;

	public synchronized void pararColeta() {
		run = false;
		this.interrupt();
	}

	public void separarLixos() {
		Lixos lixoColetado = filaGeral.retiraLixo();
		if (lixoColetado != null) {
			if (lixoColetado.eReciclavel()) {
				reciclavel.add(lixoColetado);

			} else {
				naoReciclavel.add(lixoColetado);
			}
			System.out.println("Coleta separou: " + lixoColetado
					+ (lixoColetado.eReciclavel() ? " RECICLAVEL" : " NÃO RECICLAVEL"));
		} else {
			try {
				Thread.sleep(1000 * 2);
			} catch (InterruptedException e) {
				synchronized (this) {
					run = false;
				}
				Thread.currentThread().interrupt();
			}
		}
	}

	public void mostraResultado() {
		System.out.println("Analise:");
		System.out.println("Coleta separou: " + reciclavel.size() + " lixos reciclaveis");
		System.out.println("Coleta separou: " + naoReciclavel.size() + " lixos nao reciclaveis");
		int total = reciclavel.size() + naoReciclavel.size();
		if (total > 0) {
			double perc = ((double) reciclavel.size() / total) * 100;
			String sustentavel = perc >= 50.0 ? "SUSTENTÁVEL" : "NÃO SUSTENTÁVEL";
			System.out.println("Resultado: " + sustentavel);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				separarLixos();
				Thread.sleep(1000);
				if (filaGeral.estaVazio()) {
					System.out.println("Coleta terminou");
					mostraResultado();
					break;
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}
