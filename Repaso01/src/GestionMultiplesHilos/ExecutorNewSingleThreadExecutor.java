package GestionMultiplesHilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorNewSingleThreadExecutor {
    public static int contadorHilos = 0;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
// Se crea un Thread Pool con un único hilo
        for (int i = 1; i <= 10; i++) {
            Contador c = new Contador(contadorHilos);
            executor.execute(c);
            contadorHilos++;
        }

        executor.shutdown();
    }
}
