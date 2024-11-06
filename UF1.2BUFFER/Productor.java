public class Productor implements Runnable
{
    private BufferRadios buffer;
    private static int contador = 0;
    private Thread hilo;

    public Productor(BufferRadios buffer)
    {
        contador ++;
        this.buffer = buffer;
        hilo = new Thread(this, "Productor"+contador);
        hilo.start();
    }

    public void run()
    {
        int radio;
        radio = (int) (Math.random()*30+1);
        System.out.println(hilo.getName() + " va a generar un radio = " + radio);
        buffer.poner(radio);
    }
}