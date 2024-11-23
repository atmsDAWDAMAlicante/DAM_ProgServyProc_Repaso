package GestionMultiplesHilos;

public class Contador implements Runnable {
    private int id;
    public Contador(int id){this.id = id;}
    @Override
    public void run() {
        // Hace un for y muestra números, tiene su propio id que recibe en el constructor
        for (int i = 1; i<=5; i++){
            System.out.println("Tarea " + id + ": " + i);
        }
    }
}
