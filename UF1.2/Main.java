public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Vamos a obtener información sobre hilo principal");
        Thread hilo = Thread.currentThread();
        System.out.println(hilo.toString());
// Hacemos un retardo de un segundo.
        Thread.sleep(1000);
// Cambiamos nombre y prioridad.
        hilo.setPriority(3);
        hilo.setName("HiloPrincipal");
        System.out.println(hilo.toString());
    }
}