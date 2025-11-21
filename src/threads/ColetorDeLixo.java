package threads;

import fila.FilaGeral;
import lixos.Lixos;

import java.util.ArrayList;
import java.util.List;

public class ColetorDeLixo extends Thread {
    FilaGeral lixeira = FilaGeral.getInstance();

    List<Lixos> reciclaveis = new ArrayList<>(); //tem que virar um singleton externo
    List<Lixos> naoReciclaveis = new ArrayList<>(); //tem que virar um singleton externo

    @Override
    public void run() {
        if (lixeira.verificarLixo() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (lixeira.verificarLixo() != Lixos.NAO_RECICLAVEL) {
                reciclaveis.add(lixeira.retirarLixo());
            } else {
                naoReciclaveis.add(lixeira.retirarLixo());
            }
        }
    }

    public void printListaReciclaveis() {
        System.out.println("\nLista Recicláveis");
        for (Lixos l : reciclaveis) {
            System.out.print(l.toString() + "|");
        }
    }

    public void printListaNaoReciclaveis() {
        System.out.println("\nLista Não Recicláveis");
        for (Lixos l : naoReciclaveis) {
            System.out.print(l.toString() + "|");
        }
    }
}
