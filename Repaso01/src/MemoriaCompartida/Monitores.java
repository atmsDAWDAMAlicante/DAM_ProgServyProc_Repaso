package MemoriaCompartida;

public class Monitores {
    public static void main(String[] args) {

        // Se crea una única cuenta cuyo saldo inicial es de X €

        CuentaMonitores c = new CuentaMonitores(); // ESTE OBJETO SERÁ EL MONITOR
        // EL OBJETO C SERÁ EL MONITOR
        // REPRESENTACIÓN: TRES PARTES ENTRY SET-OWNER (quién posee el monitor)-WAIT SET

        // CUANDO UN HILO (HR) QUIERE EJECUTAR EL MÉTODO DEL OBJETO CUENTA
        // 1- HR ENTRA EN ENTRY SET
        // 2- EL OBJETO C LE DA PASO Y HR ENTRA EN OWNER-- AHORA HR "TIENE EL MONITOR" (ACQUIRE)
        // 3- AHORA LLEGA HI A ENTRY SET Y EL MONITOR OBJETO MIRA A VER SI HAY ALGUN OBJETO EN OWNER
        // 4- COMO ESTÁ HR EN OWNER C PONE A HI A ESPERAR. CUANDO HR TERMINA (RELEASE) LIBERA EL MONITOR
        // 5- C PERMITE A HI ENTRAR A SER OWNER PASA A SER POSEEDOR DEL MONITOR


        // Dos hilos uno para los ingresos y otro para los reintegros

        HiloIngresoMonitores hi = new HiloIngresoMonitores(c);
        HiloReintegroMonitores hr = new HiloReintegroMonitores(c);

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

class CuentaMonitores {

    private double saldo;
    public double getSaldo() {return saldo;}
    // Método para realizar los ingresos
    public void ingresar(double cantidad) {saldo += cantidad;}
    // Método para realizar los reintegros
    public void reintegrar(double cantidad) {saldo -= cantidad;}
}

class HiloIngresoMonitores implements Runnable {
    private CuentaMonitores cuenta;

    public HiloIngresoMonitores(CuentaMonitores cuenta) {this.cuenta = cuenta;}

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            // Ingresa 1000 veces 100 €
            cuenta.ingresar(100);
        }
    }
}

class HiloReintegroMonitores implements Runnable {
    private CuentaMonitores cuenta;

    public HiloReintegroMonitores(CuentaMonitores cuenta) {this.cuenta = cuenta;}

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            // Reintegra 1000 veces 100 €
            cuenta.reintegrar(100);
        }
    }
}


