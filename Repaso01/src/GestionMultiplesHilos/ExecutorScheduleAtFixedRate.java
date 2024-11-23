package GestionMultiplesHilos;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ExecutorScheduleAtFixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        System.out.println("Código antes de lanzar la tarea");
        Contador c = new Contador(0);
        ses.scheduleAtFixedRate(c, 2, 2, TimeUnit.SECONDS);
        System.out.println("Código después de lanzar la tarea");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ses.shutdown();
    }
}
