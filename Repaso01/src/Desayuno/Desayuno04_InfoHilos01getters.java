package Desayuno;

public class Desayuno04_InfoHilos01getters {
    public static void main(String[] args) {
        // Lanzar un hilo que saluda 5 veces
        Thread t = new Thread(()->{
            // LAMBDA
            // SIN PARÁMETROS YA QUE ES EL MÉTODO RUN
            // COMO ES UN HILO HAY QUE METERLO EN UN TRY-CATCH
            try {
                for (int i = 1; i < 6; i++) {
                    Thread.sleep(300);
                    System.out.println("Hola, soy un hilo - " + i);
                }
            } catch (InterruptedException e) {
                System.out.println("La interrupción");
            }
        });
        t.start();
        // Getters y setters de la clase Thread
        // Estos métodos obtienen los atributos de la clase Thread
        // getId devuelve un id único: se genera cuando se crea el hilo
        // no se puede modificar
        System.out.println("ID: " + t.getId());
        // Devuelve el "nombre" del hilo
        // se puede modificar el nombre con un setName("Nombre")
        System.out.println("Nombre: " + t.getName());
        // Devuelve la prioridad de un hilo: un número del 1 al 10
        // 10 es la prioridad máxima
        // Se modifica con setPriority(4)
        // acepta constantes MAX_PRIORITY, MIN_PRIORITY, NORM_PRIORITY que vale 5
        // por defecto los hilos tienen un 5
        System.out.println("Prioridad: " + t.getPriority());
        // Devuelve un enum; no se puede modificar
        // Valores:
        // a) NEW: cuando el hilo no ha sido lanzado (antes del start)
        // b) RUNNABLE: cuando el hilo se está ejecutando en la CPU
        // c) BLOCKED: está bloqueado porque está intentando acceder a un recurso ocupado
        // d) WAITING: está en una espera indefinida hasta que se produzca un evento
        // este estado se produce cuando se ha llamado a un método wait o join
        // e) TIMED_WAITING: el hilo está esperando una determinada cantidad de tiempo
        // un hilo pasa a timewaiting por ejemplo cuando se ejecuta el método sleep, y wait y join
        // f) TERMINATED: el hilo ha terminado de ejcutar todas las instrucciones
        System.out.println("Estado: " + t.getState());
        // Devuelve un booleano que indica si el hilo ha terminado o no;
        // equivale a comprobar si su estado es "terminated"
        System.out.println("¿Está vivo?: " + t.isAlive());
    }




}
