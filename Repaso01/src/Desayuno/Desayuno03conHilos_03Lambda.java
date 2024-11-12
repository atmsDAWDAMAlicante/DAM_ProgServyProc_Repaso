package Desayuno;

public class Desayuno03conHilos_03Lambda {
    public static void main(String[] args) {

    // Lamda: para que los métodos reciban métodos por parámetros
    // un lambda no tiene un nombre y se puede definir donde sea necesario
    // Se usa lambda para llamar a un método que recibe como parámetro un
    // objeto que implementa una interfaz

    // En el ejemplo la clase Thread recibe por parámetro un objeto
    // que implementa la interfaz runnable

        // SÓLO SE PODRÁ IMPLEMENTAR UN LAMBDA CUANDO LA INTERFAZ SÓLO
        // TENGA UN MÉTODO
        // REPETIMOS: SÓLO SE PODRÁ IMPLEMENTAR UN LAMBDA CUANDO LA INTERFAZ SÓLO
        // TENGA UN MÉTODO

        // Creación del hilo con un lambda que irá donde está la r
        // Thread tCafe = new Thread(r);
        // Será así
        // Thread tCafe = new Thread(()-> ..... );
        Thread tCafe = new Thread (()-> // es con un guión
                {
                    // AQUÍ VENDRÁ EL CÓDIGO DEL MÉTODO RUN()
                    // EL CÓDIGO DE DENTRO DEL MÉTODO RUN

                    try {
                        System.out.println("Cafetera: Peparar café:");
                        Thread.sleep(1000);
                        System.out.println("Cafetera: Calentando el café");
                        Thread.sleep(1000);
                        System.out.println("Cafetera: Se sale el café");
                        Thread.sleep(1000);
                        System.out.println("Cafetera: Sirvo el café");
                    } catch (InterruptedException e) {
                        System.out.println("Interrupcion");
                    }

                });
        tCafe.start();


        // En este bloque se crea el segundo hilo

        Thread tTostadas = new Thread(new Tostadora0303());
        tTostadas.start();

    }
}

// AQUÍ ABAJO SE METE LA CLASE TOSTADORA

    // Tostadora02 es otra clase
// se implementa la interfaz Runnable
// Sobreescribe el método run @Override
// no se le puede poner el throw
// el código de dentro se mete dentro del try-catch
    class Tostadora0303 implements Runnable {
        @Override
        public void run() { // aquí no se puede añadir el throw
            //super.run(); código por defecto
            try {
                System.out.println("Tostadora: Preparar tostadas:");
                Thread.sleep(1000);
                System.out.println("Tostadora: Cortado el pan");
                Thread.sleep(1000);
                System.out.println("Tostadora: Lo meto en la tostadora");
                Thread.sleep(1000);
                System.out.println("Tostadora: Aceite y sal");
            } catch (InterruptedException laInterrupcion) {
                System.out.println(laInterrupcion);
            }
        }
    }
