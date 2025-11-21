package principal;

import fila.FilaGeral;
import threads.ColetorDeLixo;
import threads.CriadorDeLixo;
import fila.FilaGeral;
import threads.ColetorDeLixo;
import threads.CriadorDeLixo;

public class Main {
	public static void main(String[] args) {

		CriadorDeLixo cl1 = new CriadorDeLixo();
        CriadorDeLixo cl2 = new CriadorDeLixo();
        ColetorDeLixo cdl = new ColetorDeLixo();
        //falta configurar um timer e fazer as threads executarem enquanto o timer funcionar
		cl1.start();
        cl2.start();
        cdl.start();
        try {
            cl1.join();
            cl2.join();
            cdl.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        FilaGeral.getInstance().getLixeira();
        cdl.printListaReciclaveis(); //substituir por singletonExterno
        cdl.printListaNaoReciclaveis(); //substituir por singletonExterno
	}
}

