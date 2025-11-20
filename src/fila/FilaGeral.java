package fila;

import lixos.Lixos;

import java.util.LinkedList;
import java.util.Queue;

public class FilaGeral {
    Queue<Lixos> lixeiraGeral = new LinkedList<>();
    private static FilaGeral instance;

    private FilaGeral() {
    }

    public static FilaGeral getInstance() {
        if (instance == null) {
            instance = new FilaGeral();
        }
        return instance;
    }

    public synchronized void pegarLixo(Lixos lixo) {
        lixeiraGeral.add(lixo);
    }

    public synchronized Lixos retiraLixo() {
        return lixeiraGeral.poll();
    }

    public void getLixeira() {
        for (Lixos el : lixeiraGeral) System.out.print(el.toString() + " | ");
    }
}