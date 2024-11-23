package GestionMultiplesHilos;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorNewScheduledThreadPool {
    public static int contadorHilos = 0;

    public static void main(String[] args) {
// Las tareas van de dos en dos
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);

        System.out.println("Código antes de lanzar las tareas");

        for (int i = 1; i <= 10; i++) {
            Contador c = new Contador(contadorHilos);
            // El método schedule recibe la tarea, el retraso y las unidades de tiempo de ese retraso
            // Dentro del bucle se lanzan 10 tareas
            // EL programa no mostrará nada hasta que pasen 5 segundos
            ses.schedule(c, 5, TimeUnit.SECONDS);
            contadorHilos++;
        }
        System.out.println("Código después de lanzar las tareas");
        ses.shutdown();
    }

}
