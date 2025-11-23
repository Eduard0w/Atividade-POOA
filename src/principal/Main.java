package principal;

import threads.ColetaLixo;
import threads.CriadorDeLixo;
import util.Temporizador;

public class Main {
    public static void main(String[] args) {
        int duracaoSegundos = 180;
        Temporizador.iniciar(duracaoSegundos * 1000);

        // Começar a criar o lixo
        CriadorDeLixo cl1 = new CriadorDeLixo();
        CriadorDeLixo cl2 = new CriadorDeLixo();
        CriadorDeLixo cl3 = new CriadorDeLixo();
        ColetaLixo coletor = new ColetaLixo();

        cl1.start();
        cl2.start();
        cl3.start();
        coletor.start();

        try {
            cl1.join();
            cl2.join();
            cl3.join();
            coletor.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}