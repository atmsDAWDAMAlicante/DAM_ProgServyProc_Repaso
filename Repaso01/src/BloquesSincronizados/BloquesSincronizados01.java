package BloquesSincronizados;

public class BloquesSincronizados01 {

    public static void main(String[] args) {

        // Se crea una única cuenta cuyo saldo inicial es de X €

        Cuenta c = new Cuenta();


        // EL OBJETO C SERÁ EL MONITOR
        // REPRESENTACIÓN: TRES PARTES ENTRY SET-OWNER (quién posee el monitor)-WAIT SET

        // CUANDO UN HILO (HR) QUIERE EJECUTAR EL MÉTODO DEL OBJETO CUENTA
        // 1- HR ENTRA EN ENTRY SET
        // 2- EL OBJETO C LE DA PASO Y HR ENTRA EN OWNER-- AHORA HR "TIENE EL MONITOR" (ACQUIRE)
        // 3- AHORA LLEGA HI A ENTRY SET Y EL MONITOR OBJETO MIRA A VER SI HAY ALGUN OBJETO EN OWNER
        // 4- COMO ESTÁ HR EN OWNER C PONE A HI A ESPERAR. CUANDO HR TERMINA (RELEASE) LIBERA EL MONITOR
        // 5- C PERMITE A HI ENTRAR A SER OWNER PASA A SER POSEEDOR DEL MONITOR


        // AHORA SE SUPONE QUE NO SE PUEDE ACCEDER A LA CLASE
        // HAY QUE IR A LAS LLAMADAS A LOS MÉTODOS DENTRO DE LAS CLASES DE LOS HILOS
        // cuenta.reintegrar(100); y se modifica
        //synchronized(OBJETO QUE SE DESEA QUE ACTÚE COMO MONITOR)
        // CUALQUIER OBJETO PUEDE ACTUAR COMO MONITOR DE SUS PROPIOS MÉTODOS O DE OTROS OBJETOS
        // EL OBJETO TIENE QUE SER EL MISMO PARA LOS MÉTODOS QUE SE QUIERE CONTROLAR
        // EL OBJETO CUENTA CONTROLA LOS DOS MÉTODOS PERO TIENE QUE SER EL MISMO OBJETO CUENTA
        /*
            synchronized(cuenta){
                cuenta.ingresar(100);
            }
        *
         */

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
    public synchronized void ingresar(double cantidad) {saldo += cantidad;}
    // Método para realizar los reintegros
    public synchronized void reintegrar(double cantidad) {saldo -= cantidad;}
}

class HiloIngreso implements Runnable {
    private Cuenta cuenta;

    public HiloIngreso(Cuenta cuenta) {this.cuenta = cuenta;}

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            // Ingresa 1000 veces 100 €
            //cuenta.ingresar(100);
            synchronized(cuenta){
                cuenta.ingresar(100);
                System.out.println("Vuelta: In-"+ i +" / Saldo:" + cuenta.getSaldo());
            }
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
            //cuenta.reintegrar(100);
            synchronized(cuenta){
                cuenta.reintegrar(100);
                System.out.println("Vuelta: Re-"+ i +" / Saldo:" + cuenta.getSaldo());
            }
        }
    }
}



