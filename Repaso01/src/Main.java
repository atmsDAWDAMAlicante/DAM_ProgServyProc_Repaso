import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.sql.SQLOutput;


public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hola");
        try {
            PrepararTostadas();
            PrepararCafe();
        } catch (InterruptedException laInterrupcion) {
            System.out.println("Se interrumpío");

        }
    }

    static void PrepararTostadas() throws InterruptedException {
        System.out.println("Tostadora: Preparar tostadas:");
        Thread.sleep(1000);
        System.out.println("Tostadora: Cortado el pan");
        Thread.sleep(1000);
        System.out.println("Tostadora: Lo meto en la tostadora");
        Thread.sleep(1000);
        System.out.println("Tostadora: Aceite y sal");
    }
    static void PrepararCafe() throws InterruptedException {
        System.out.println("Cafetera: Peparar café:");
        Thread.sleep(1000);
        System.out.println("Cafetera: Calentando el café");
        Thread.sleep(1000);
        System.out.println("Cafetera: Se sale el café");
        Thread.sleep(1000);
        System.out.println("Cafetera: Sirvo el café");
    }

}