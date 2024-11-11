package Desayuno;

public class Desayuno02conHilos_02_InterfazRunnable {
    public static void main(String[] args) {
        try{
            // COMPARADO CON EL EJEMPLO QUE HEREDA DE LA CLASE THREAD
            System.out.println("Implementando la interfaz Runnable");
            // AQUÍ SE CREA UN OBJETO THREAD Y SE LE PASA POR PARÁMETRO
            // UN OBJETO QUE IMPLMEMENTE LA INTERFAZ RUNNABLE
            Thread t = new Thread(new Tostadora02());
            t.start(); // el método start es de THREAD
            PrepararCafe();
        } catch (InterruptedException e) {
            System.out.println("Interrumpido");
        }
    }
    // La cafetera está dentro de la clase principal como otro método
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


// Tostadora02 es otra clase
// se implementa la interfaz Runnable
// Sobreescribe el método run @Override
// no se le puede poner el throw
// el código de dentro se mete dentro del try-catch
class Tostadora02 implements Runnable {
    @Override
    public void run() { // aquí no se puede añadir el throw
        //super.run(); código por defecto
        try{
            System.out.println("Tostadora: Preparar tostadas:");
            Thread.sleep(1000);
            System.out.println("Tostadora: Cortado el pan");
            Thread.sleep(1000);
            System.out.println("Tostadora: Lo meto en la tostadora");
            Thread.sleep(1000);
            System.out.println("Tostadora: Aceite y sal");
        }
        catch (InterruptedException laInterrupcion)
        {
            System.out.println(laInterrupcion);
        }
    }
}

