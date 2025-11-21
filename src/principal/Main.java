package principal;

import fila.FilaGeral;
import threads.ColetaLixo;
import threads.CriadorDeLixo;

public class Main {
    public static void main(String[] args) {
        //Começar a criar o lixo
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