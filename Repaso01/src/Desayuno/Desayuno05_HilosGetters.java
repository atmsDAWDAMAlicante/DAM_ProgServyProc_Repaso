package Desayuno;

public class Desayuno05_HilosGetters {
    public static void main(String[] args) {

        Thread p = new Thread(new OtroHilo());
        p.setPriority(Thread.MAX_PRIORITY);

        Thread t = new Thread (()->{
            try{
                // tt recoge el propio hilo
                Thread tt = Thread.currentThread();
                // Le doy la mínima prioridad
                tt.setPriority(Thread.MIN_PRIORITY);
                // Arranco el segundo hilo
                p.start();
                System.out.println("++Dentro del lambda:");
                Thread.sleep(300);
                System.out.println("++Id de t: " + tt.getId());
                tt.setName("HiloDelLambda");
                System.out.println("++Nombre de t: " + tt.getName());
                Thread.sleep(300);
                System.out.println("++El hilo t está en: " + tt.getState());
                System.out.println("++El hilo t está: " + tt.isAlive());
                Thread.sleep(300);

            }
            catch (InterruptedException e){
                System.out.println("La interrupcion e");
            }

        });
        t.start();
        while(t.getState() != Thread.State.TERMINATED){
            try {
             Thread.sleep(100);
            } catch (Exception e){
                System.out.println("La vacia");
            }
        }
    }
}


class OtroHilo implements Runnable
{

    //Thread pp = new Thread(this);
    @Override
    public void run(){
        try{
            Thread esteHilo = Thread.currentThread();
            System.out.println("---Dentro del segundo hilo: " + esteHilo.getId());
            Thread.sleep(300);
            esteHilo.setName("Hilo de Segunda Generación");
            System.out.println("---Este nuevo hilo se llama: " + esteHilo.getName());
            Thread.sleep(300);
            System.out.println("---El hilo " + esteHilo.getName() + " ahora mismo está " + esteHilo.getState());
            Thread.sleep(300);
            System.out.println("---El hilo " + esteHilo.getName() + " tiene una prioridad " + esteHilo.getPriority());
            Thread.sleep(300);

        } catch (InterruptedException e){
            System.out.println("La interrupcion e");
        }
    }
}
