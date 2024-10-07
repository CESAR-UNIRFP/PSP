public class Corredor extends Thread {
    public Corredor(String nombre, int prioridad) {
        super(nombre);
        this.setPriority(prioridad);
        this.start();
    }
    @Override
    public void run() {
        for (int i=1; i<=10; i++) {
            System.out.println(this.getName() + " va por el kilómetro "
                    + i);
        }
        System.out.println(this.getName() + " ha llegado a la meta");
    }
}
