package Desayuno;

public class Desayuno02conHilos_01_HeredandoThread {
    public static void main(String[] args) {

        try{
            System.out.println("Heredando de la clase Thread");
            // A EFECTOS DE COMPARARLO CON EL OTRO EJEMPLO, EL DE LA INTERFAZ RUNNABLE
            // AQUÍ SE CREA UNA INSTANCIA DE LA CLASE QUE HEREDA DE LA CLASE THREAD
            // ES DECIR, TOSTADORA ES COMO UN THREAD AL HEREDAR
            Tostadora t = new Tostadora(); // instancia de la clase que hereda de Thread
            t.start(); // lanza el hilo
            PrepararCafe();
            // ESTO PRODUCIRÁ QUE LAS LÍNEAS DE CÓDIGO SE INTERCALEN LAS
            // LÍNEAS DE CÓDIGO; AL INTERCALARSE EL CÓDIGO ES MÁS RÁPIDO
        } catch (InterruptedException e) {
            System.out.println("Interrumpido");
        }

        // La cafetera está dentro de la clase principal como otro método
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


// Tostadora es otra clase
// hereda de Thread
// Sobreescribe el método run @Override
// como hereda no se le puede poner el throw
// el código de dentro se mete dentro del try-catch
class Tostadora extends Thread {
    @Override
    public void run() { // aquí no se puede añadir el throw porque hereda
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
