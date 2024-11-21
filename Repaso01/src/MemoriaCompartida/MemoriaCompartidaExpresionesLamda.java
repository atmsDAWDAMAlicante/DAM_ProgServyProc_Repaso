package MemoriaCompartida;

public class MemoriaCompartidaExpresionesLamda {

    public static int contador = 0;// Esto se saca del método main pero se pone static

    public static void main(String[] args) {
        //Contador c = new Contador();

        for (int i = 1; i <= 5; i++) {

            Thread t = new Thread(()->{ // expresión lambda

                for (int j = 0; j < 100; j++) {
                    contador++;
                }
                System.out.println( // el resultado es el mismo que el del ejemplo anterior
                        "Finalizado el hilo " + Thread.currentThread().getName() +
                                ". El valor del contador es " + contador
                );
            });
            t.start();
        }
    }
}
