package GestionMultiplesHilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorNewCachedThreadPool {
    public static int contadorHilos = 0;
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        // newCachedThreadPool Adapta el número de hilos  disponibles al número de tareas a realizar
        // inicialmente estará vacío


        // getPoolSize es el tamaño
        // getActiveCount devuelve los hilos en uso


        // Si hay hilos que no se están utilizando los eliminará
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                " - Hilos activos: " + pool.getActiveCount());

        System.out.println("Lanzamos hilo 0 y 1"); // Se crean dos instancias de Contador y se ejecutan con execute
        Contador c = new Contador(contadorHilos);
        executor.execute(c);
        contadorHilos++;
        c = new Contador(contadorHilos);
        executor.execute(c);
        contadorHilos++;
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                " - Hilos activos: " + pool.getActiveCount()); // Se ve que se han creado dos hilos

        // Una espera de un segundo para que las dos primeras tareas se ejecuten
        System.out.println("Esperamos 1 segundo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("AAAAAA");
        }
// Ahora se muestra que hay dos hilos en el pool pero 0 están en activo porque ya han acabado
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                " - Hilos activos: " + pool.getActiveCount());

        // Se lanzan 3 hilos más

        System.out.println("Se lanza el hilo 2");
        c = new Contador(contadorHilos);
        contadorHilos++;
        executor.execute(c);

        System.out.println("Se lanza el hilo 3");
        c = new Contador(contadorHilos);
        contadorHilos++;
        executor.execute(c);

        System.out.println("Se lanza el hilo 4");
        c = new Contador(contadorHilos);
        contadorHilos++;
        executor.execute(c);


        // Muestra 3 hilos en el pool y que los tres están activos
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                " - Hilos activos: " + pool.getActiveCount());

        System.out.println("Esperamos 70 segundos"); // una espera larga para ver
        // como los hilos se eliminan; el tiempo es de 60 segundos
        try {
            Thread.sleep(70000);
        } catch (InterruptedException e) {
            System.out.println("AAAAAA");
        }

        // Tras 70 segundos ya no hay hilos activos
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                " - Hilos activos: " + pool.getActiveCount());


        System.out.println("Se lanza el hilo 5");
        c = new Contador(contadorHilos);
        contadorHilos++;
        executor.execute(c);

        // Al final se ejecuta el último
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                " - Hilos activos: " + pool.getActiveCount());

executor.shutdown();
    }
}
