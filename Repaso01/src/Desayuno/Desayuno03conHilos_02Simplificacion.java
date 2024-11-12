package Desayuno;

public class Desayuno03conHilos_02Simplificacion {

        // Clase Anonima: no tiene nombre
        // Tiene que implementar una interfaz
        // Ventaja: evita crear la clase en un archivo diferente
        // Se puede crear e instanciar en la clase Main

    // VARIABLE PÚBLICA DE LA CLASE MAIN
    public static int x = 1;
        public static void main(String[] args) {
            // Variable del método main
            String saludo = "Hola";

            // 1º paso crear una ¿instancia? de Runnable
            // NOOOO No se crea ninguna instancia de una interfaz
            //  Java entiende que se está creando una clase anónima que se instancia (la clase, no la interfaz)

            // AQUÍ VIENE LA SIMPLIFICACIÓN: DESDE EL NEW RUNNABLE HASTA
            // EL CIERRE DE LA INTERFAZ }; SE METE DENTRO DE LOS PARÉNTESIS DE
            // NEW THREAD(XXXX AQUÍ XXX)

            //Runnable r = ... todo esto se va dentro de new Thread (xxxx)

            // En este bloque se crean los hilos
            // Thread tCafe = new Thread(r SE CAMBIA LA R POR EL RUNNABLE

            // DESDE LA CLASE ANÓNIMA SE PUEDE OBTENER EL VALOR DE VARIABLES LOCALES
            // DEL MÉTODO DONDE SE ENCUENTRA LA CLASE ANÓNIMA
            // PERO NO LOS PUEDE MODFICAR
            // SI PUEDE ACCEDER A LOS MÉTODOS Y PROPIEDADES DE LA CLASE PADRE


            Thread tCafe = new Thread(
            // inicio de lo que se envía desde el new Runnable
                    new Runnable() {
                        @Override
                        public void run() { // se rescribe el método run
                            // Aquí se introduce el código de
                            // dentro del bloque try-catch
                            try {
                                System.out.println(saludo + "Cafetera: Peparar café: " + x);
                                Thread.sleep(1000);
                                //saludo = "Adios"; ERROR
                                incrementar();
                                System.out.println("Cafetera: Calentando el café: " + x);
                                Thread.sleep(1000);
                                incrementar();
                                System.out.println("Cafetera: Se sale el café: " + x);
                                Thread.sleep(1000);
                                incrementar();
                                System.out.println("Cafetera: Sirvo el café: " + x);
                            } catch (InterruptedException e) {
                                System.out.println("Interrupcion");
                            }
                        } // CIERRE MÉTODO RUN()
                    }
                    // CIERRE INTERFAZ
                    // OJO AQUÍ
                    // NO SE PONE EL ;
                    // EL CIERRE SERÍA ASÍ });

                    // fin de lo que se envía
            );// cierre del Thread tCafe = new Thread(
            tCafe.start();
            Thread tTostadas = new Thread(new Desayuno.Tostadora0302());
            tTostadas.start();


        } // CIERRE DEL MÉTODO MAIN

    // METODO DE LA CLASE PADRE (MAIN) PARA PROBAR
    // COMO LA CLASE ANÓNIMA ACCEDE AL ÉL
    public static void incrementar() {
            ++x;
    }

    }// CIERRE DE LA CLASE MAIN

// AQUÍ ABAJO SE METE LA CLASE TOSTADORA

    // Tostadora02 es otra clase
// se implementa la interfaz Runnable
// Sobreescribe el método run @Override
// no se le puede poner el throw
// el código de dentro se mete dentro del try-catch
    class Tostadora0302 implements Runnable {
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

