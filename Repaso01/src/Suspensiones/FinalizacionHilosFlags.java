package Suspensiones;


import java.io.Serializable;
import java.util.Scanner;

public class FinalizacionHilosFlags {
    public static void main(String[] args) {
        Cafetera c = new Cafetera();
        Thread t =new Thread(c);
        t.start();

        // Cuando el usuario pulse enter se detiene el hilo
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // esto hace que el programa espere un salto de linea como en C# ReadLine()
        // Si se ejecuta la siguiente línea es porque el usuario ha pulsado intro
        c.Detener();

        // El método Detener de la clase Cafetera vuelve a false a la variable ejecutar
        // por lo que termina el bucle

        // Ahora se añade el método join para que no continúe la ejecución del hilo principal
        // hasta que haya finalizado el hilo de la cafetera... con c.Detener

        try{
            t.join();


        } catch (InterruptedException e) {
            System.out.println("La interrupción");
        }

        System.out.println("Han sido " + c.getContador() + " cafés, a 2 euros cada uno. Total " + (c.getContador()*2) + " €");
    }



}

class Cafetera implements Runnable{
    private int contador = 0;
    public int getContador() {return contador;}
    private boolean ejecutar = true;
    public void Detener() {ejecutar = false;}
    @Override

    public void run() {
    try{
        //while(true) {
        while(ejecutar) { // mientras ejecutar esté a true se ejecuta
            System.out.println("La Cafetera");
            Thread.sleep(100);
            System.out.println("1.- Cafetera al fuego");
            Thread.sleep(100);
            System.out.println("2.- La Cafetera hirviendo");
            Thread.sleep(100);
            System.out.println("3.- La Cafetera ¡se sale el café!");
            Thread.sleep(100);
            contador++;
            System.out.println("Café preparado nº " + contador);
        }

    } catch (InterruptedException ex){
        System.out.println("La interrupción");
    }
    }
}