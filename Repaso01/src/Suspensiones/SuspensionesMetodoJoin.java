package Suspensiones;

import java.util.Random;

public class SuspensionesMetodoJoin {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Suspensiones - método join()");
        // Hilo que cuenta de 0 a 9

        Thread t = new Thread(()->{
            try{
                Random r = new Random();
                for (int i = 0; i < 10; i++) {
                    int tiempo = r.nextInt(500);
                    Thread.sleep(tiempo);
                    System.out.println("Numero: " + i + " - Tiempo: " + tiempo);
                }
            } catch (InterruptedException ex){
                System.out.println("La interrupción");
            }
        });
        t.start();
        t.join(); // LLAMADA BLOQUEANTE

        // Espera a que finalice el hilo ejemplo primitivo
       /* while(t.isAlive()){

        }*/


        System.out.println("El hilo ha finalizado");

    }
}
