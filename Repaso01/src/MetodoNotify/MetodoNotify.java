package MetodoNotify;

public class MetodoNotify {

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

// SUPUESTO DE PARTIDA: SE QUIERE SACAR MÁS DINERO DE LA CUENTA DEL QUE HAY
        // BUCLE WHILE DENTRO DEL SYNCHRONIZED (VER ABAJO)
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
                cuenta.notify(); // Hilo ingreso avisa al hilo reintegro que ha llamado al método wait
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
            /*
            SOLUCIÓN INEFICIENTE PORQUE CONSUME MUCHA CPU
            synchronized(cuenta){
                while(cuenta.getSaldo()<100){
                    try{
                        Thread.sleep(100);

                    } catch (InterruptedException ex) {
                        System.out.println("La interrupción");
                    }
                }
                cuenta.reintegrar(100);
                System.out.println("Vuelta: Re-"+ i +" / Saldo:" + cuenta.getSaldo());
            }
            */

            // LOS MÉTODOS NOTIFY Y WAIT SON DE LOS MONITORES, cualquier instancia de cualquier clase
            // EL HILO QUE LLAME AL MÉTODO WAIT QUEDARÁ SUSPENDIDO HASTA QUE
            // EL MÉTODO NOTIFY DEL MISMO OBJETO
            // perro.wait(299) queda suspendido
            // hasta perro.notify();

            synchronized(cuenta){
                // HR entra en Entry set y pasa a Owner
                // Se quiere ejecutar HI y pide paso a Cuenta, pero está HR-- HI está a la espera en Entry set
                // HR sigue ejecutándose en Owner pero al ver que su saldo es inferior entonces pasa a
                // Wait set al hacer wait y se suspende, libera el monitor
                // HI entra en Owner, HI estaba bloqueado porque el Owner lo tenía HR
                // HI se ejecuta y notifica a HR (si hubiera varios en Wait set notificaría a un aleatorio)
                // para que sean todos hay que poner notifyAll
                // El hilo notificado sale de la espera y pasa al Owner, y vuelve a comprobar la condición del while
                // cada vez que se hace un ingreso se hace un notify, pero no significa que se vaya a ejecutar
                // pasa del wait set al Empty set, pero no al owner así que se producen más ingresos antes de ejecutarse

                // OBLIGATORIO: NOTIFI Y WAIT TIENEN QUE HACERSE DESDE BLOQUES O MÉTODOS SINCRONIZADOS

                // EL WAIT DEBE ESTAR DENTRO DE UN BUCLE WHILE PARA EVITAR UN EFECTO (... in inglisssss)
                // HR, aunque le hayan despertado vuelve a comprobar la condición el while no vaya a ser
                // que otro hilo haya dejado a 0 la cuenta.
                // notify avista a los hilos del Wait set pero no se pude saber a cual


                while(cuenta.getSaldo()<100){
                    try{
                        System.out.println("Saldo insuficiente. Entramos en espera");
                        cuenta.wait(); // En ingreso hay que poner el notify
                        // cuenta ha llamado a wait()
                        System.out.println("Se ha producido un ingreso suficiente");
                    } catch (InterruptedException ex) {
                        System.out.println("La interrupción");
                    }
                }
                cuenta.reintegrar(100);
                System.out.println("Vuelta: Re-"+ i +" / Saldo:" + cuenta.getSaldo());
            }



        }
    }
}

