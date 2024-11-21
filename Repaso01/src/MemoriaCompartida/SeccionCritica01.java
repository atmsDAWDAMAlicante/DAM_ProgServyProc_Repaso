package MemoriaCompartida;

public class SeccionCritica01 {
    public static void main(String[] args) {

        // Se crea una única cuenta cuyo saldo inicial es de X €

        Cuenta c = new Cuenta();

        // Dos hilos uno para los ingresos y otro para los reintegros

        HiloIngreso hi = new HiloIngreso(c);
        HiloReintegro hr = new HiloReintegro(c);

        Thread ti = new Thread(hi);
        Thread tr = new Thread(hr);

        ti.start();
        tr.start();


        // Espera a que los dos hilos terminen.
        try {
            ti.join();
            tr.join();
        } catch (InterruptedException ex){
            System.out.println("La Interrupción de los hilos");
        }

        // No está implementada la sincronización entre hilos
        // El resultado debería ser 0 pero a causa de las CONDICIONES DE CARRERA
        // será un resultado diferente cada vez
        System.out.println("El saldo final de la cuenta: " + c.getSaldo());

    }
}

class Cuenta {
    private double saldo;
    public double getSaldo() {return saldo;}
    // Método para realizar los ingresos
    public void ingresar(double cantidad) {saldo += cantidad;}
    // Método para realizar los reintegros
    public void reintegrar(double cantidad) {saldo -= cantidad;}
}

class HiloIngreso implements Runnable {
    private Cuenta cuenta;

    public HiloIngreso(Cuenta cuenta) {this.cuenta = cuenta;}

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            // Ingresa 1000 veces 100 €
            cuenta.ingresar(100);
        }
    }
}

class HiloReintegro implements Runnable {
    private Cuenta cuenta;

    public HiloReintegro(Cuenta cuenta) {this.cuenta = cuenta;}

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            // Reintegra 1000 veces 100 €
            cuenta.reintegrar(100);
        }
    }
}

