package Desayuno;

public class Desayuno04_InfoHilos03_Ejemplo {
    public static void main(String[] args) {
        System.out.println();
        Thread t = new Thread(()->{
            try{
                for (int i = 0; i < 5; i++){
                    Thread.sleep(300);
                    System.out.println("Hola, soy el hilo nº " + i);
                }
            }
            catch (InterruptedException e){
                System.out.println("Interrupción");
                }
        });
        t.start(); // Recordamos que t lanza el run que es el lambda

        // Mientras se ejecuta el hilo , el programa llega aquí
        // y, como no está TERMINADO no lo muestra
        //if (t.getState() == Thread.State.TERMINATED){
        //    System.out.println("Terminó el hilo");
        //}
        // Esto realiza comprobaciones frecuentes
        // No es muy óptimo
        while (t.getState() != Thread.State.TERMINATED){
            // while (t.isAlive())
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        System.out.println("Terminó el hilo");
    }
}
