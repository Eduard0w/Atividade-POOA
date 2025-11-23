package threads;

import fila.FilaGeral;
import lixos.Lixos;
import util.Temporizador;

import java.util.ArrayList;
import java.util.List;

public class ColetaLixo extends Thread {

    private FilaGeral filaGeral = FilaGeral.getInstance();
    private List<Lixos> reciclavel = new ArrayList<>();
    private List<Lixos> naoReciclavel = new ArrayList<>();

    private boolean run = true;
    private long tempoInicioColeta;
    private long tempoFimColeta;
    private long tempoTotalColeta;

    public synchronized void pararColeta() {
        run = false;
        this.interrupt();
    }

    public void separarLixos() {
        Lixos lixoColetado = filaGeral.retiraLixo();
        if (lixoColetado != null) {
            if (lixoColetado.eReciclavel()) {
                reciclavel.add(lixoColetado);
                System.out.println("Coleta separou: " + lixoColetado + " para a lista reciclável");
            } else {
                naoReciclavel.add(lixoColetado);
                System.out.println("Coleta separou: " + lixoColetado + " para a lista não reciclável");
            }
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
        System.out.println("=== Analise: ===");
        System.out.println("Coleta separou: " + reciclavel.size() + " lixos reciclaveis");
        System.out.println("Coleta separou: " + naoReciclavel.size() + " lixos nao reciclaveis");
        int coletados = reciclavel.size() + naoReciclavel.size();
        int naoColetados = filaGeral.getTamanho();
        System.out.println("Lixo restante na fila geral: " + naoColetados);
        int total = coletados + naoColetados;
        if (total > 0) {
            double perc = ((double) coletados / total) * 100;
            String sustentavel = perc >= 50.0 ? "SUSTENTÁVEL (maioria foi coletada)" : "NÃO SUSTENTÁVEL (maioria não foi coletada)";
            System.out.println("Resultado: " + sustentavel);
        }
        System.out.println("Tempo total de coleta: " + tempoTotalColeta + " ms (" + (tempoTotalColeta / 1000.0) + " segundos)");
    }

    @Override
    public void run() {
        tempoInicioColeta = System.currentTimeMillis();

        while (!Temporizador.acabou()) {
            try {
                separarLixos();
                Thread.sleep(500);
                if (filaGeral.estaVazio()) {
                    System.out.println("Não há mais lixos. Finalizando a coleta");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        tempoFimColeta = System.currentTimeMillis();
        tempoTotalColeta = tempoFimColeta - tempoInicioColeta;

        System.out.println("Tempo do programa expirou. Finalizando a Coleta de Lixo - " + Thread.currentThread().getName());
        mostraResultado();
    }
}
