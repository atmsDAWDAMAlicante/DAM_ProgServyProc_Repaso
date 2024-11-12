package Desayuno;

public class Desayuno04_InfoHilos02_SeLlamanASiMismos {
    public static void main(String[] args) {
        // La primera línea tiene una llamada al método de la clase Thread
        // El método currentThread devuelve el propio hilo que se está ejecutando
        // en este caso, como no hay otro hilo, es el hilo principal
        //Thread.currentThread() devuelve un objeto que es el propio hilo
        Thread t = Thread.currentThread();
        // t es un objeto de tipo Thread que es el propio objeto
        // Dará como nombre el nombre main
        // Estado será RuNNABLE porque en este caso solo está ejecutándose el hilo principal

        System.out.println("Hola");

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
