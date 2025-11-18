package lixos;

import java.util.Random;

public enum Lixos {
	PAPEL, PLASTICO, VIDRO, METAL, ORGANICO;
	
	public static Lixos getLixoAleatorio() {
		Lixos[] lixos = Lixos.values();
		
		int indice = new Random().nextInt(lixos.length);
		
		return lixos[indice];
	}
}
