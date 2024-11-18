package Suspensiones;
import java.util.concurrent.TimeUnit;
public class SuspensionesVarias {
    public static void main(String[] args) {
        System.out.println("NUEVA SECCIÓN: SUSPENSIÓN DE HILOS");
        // Suspensión de hilos
        // 1º Tipo: Thread.sleep(xxx);
        System.out.println("1º Tipo: Thread.sleep(xxx)");

        // 2º Tipo: TimeUnit ES UNA CLASE INDEPENDIENTE
        try {
            System.out.println("2º Tipo: TimeUnit");
            TimeUnit.MILLISECONDS.sleep(1);
            System.out.println("- se le puede indicar una medida de tiempo.");
        } catch (InterruptedException e1){
            System.out.println("La interrupción");
        }

        // 3º Tipo: yield() MÉTODO ESTÁTICO DE LA CLASE THREAD
        //try {
            System.out.println("3º Tipo: método estático yiedl()");
            Thread.yield();
            System.out.println("Ah, no se ha detenido");
        //} catch (InterruptedException e){
        System.out.println("yield() no necesita un try-catch");
        //}


    }
}
