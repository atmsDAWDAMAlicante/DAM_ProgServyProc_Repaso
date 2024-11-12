package Desayuno;

public class Desayuno03conHilos_01ClasesAnonimas {
    // Clase Anonima: no tiene nombre
    // Tiene que implementar una interfaz
    // Ventaja: evita crear la clase en un archivo diferente
    // Se puede crear e instanciar en la clase Main
    public static void main(String[] args) {
        // 1º paso crear una ¿instancia? de Runnable
        // NOOOO No se crea ninguna instancia de una interfaz
        //  Java entiende que se está creando una clase anónima que se instancia (la clase, no la interfaz)
        Runnable r = new Runnable() {
            @Override
            public void run() { // se rescribe el método run
                // Aquí se introduce el código de
                // dentro del bloque try-catch
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
            } // CIERRE MÉTODO RUN()
        }; // hay que cerrar el runnable - CIERRE INTERFAZ

        // En este bloque se crean los hilos
        Thread tCafe = new Thread(r);
        tCafe.start();
        Thread tTostadas = new Thread(new Tostadora0301());
        tTostadas.start();


    } // CIERRE DEL MÉTODO MAIN
}

// AQUÍ ABAJO SE METE LA CLASE TOSTADORA

// Tostadora02 es otra clase
// se implementa la interfaz Runnable
// Sobreescribe el método run @Override
// no se le puede poner el throw
// el código de dentro se mete dentro del try-catch
class Tostadora0301 implements Runnable {
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
