package GestionMultiplesHilos;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorNewFixedThreadPool {

    public static int contadorHilos = 0;
// Permite crear un pool
    public static void main(String[] args) {
        // Los métodos de esta clase son estáticos
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 10; i++) {
            Contador c = new Contador(contadorHilos);
            executor.execute(c);
            contadorHilos++;
        }
        // Para que espere a la finalización
        executor.shutdown();
    }
}
