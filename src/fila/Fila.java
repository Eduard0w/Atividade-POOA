package fila;

import java.util.ArrayList;
import java.util.List;

public class Fila {
	List<String> rua;
	private static Fila instance;
	
	private Fila() {
		rua = new ArrayList<>();
	}
	
	public Fila getInstance() {
		if(instance == null) {
			instance = new Fila();
		}
		return instance;
	}
	
	public void pegarLixo() {
		rua.contains(Lixo);
	}
}