package fila;

import lixos.Lixos;

import java.util.LinkedList;
import java.util.Queue;

public class FilaGeral {
	Queue<Lixos> lixeiraGeral = new LinkedList<>();
	private static FilaGeral instance;
	
	private FilaGeral() {}
	
	public static FilaGeral getInstance() {
		if(instance == null) {
			instance = new FilaGeral();
		}
		return instance;
	}
	
	public synchronized void addLixo(Lixos lixo) {
        lixeiraGeral.add(lixo);
	}

    public void getLixeira(){
        System.out.println("Lixeira geral:");
        for (Lixos el : lixeiraGeral) System.out.print(el.toString() + " | ");
    }

    public synchronized Lixos retirarLixo(){
        return lixeiraGeral.poll();
    }

    public synchronized Lixos verificarLixo(){
        return lixeiraGeral.peek();
    }
}