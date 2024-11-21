package MemoriaCompartida;

public class MemoriaCompartida01 {
    public static void main(String[] args) {
        Contador c = new Contador();
        for (int i = 0; i < 5; i++) {

            Thread t = new Thread(c);
            t.setName("Hilo " + i);
            t.start();
        }
    }

}

class Contador implements Runnable{
    private int contador = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            contador++;
        }

        System.out.println(
                "Finalizado el hilo " + Thread.currentThread().getName() +
                        ". El valor del contador es " + contador
        );
    }

}
