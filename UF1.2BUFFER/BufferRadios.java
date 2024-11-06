
import java.util.LinkedList;
import java.util.Queue;

public class BufferRadios
    {
    private Queue<Integer> cola;
    public BufferRadios()
        {
        cola = new LinkedList<Integer>();
        }
    public synchronized void poner(Integer r)
        {
        cola.add(r);
        notify();
        }
    public synchronized Integer sacar()
        {
        int esperas = 0;
        while (cola.isEmpty() && esperas<20)
            {
            esperas ++;
            try
                {
                wait(10);
                }
            catch (InterruptedException e)
                {
                System.out.println(e.getMessage());
                }
            }
        if (esperas<20)
            {
                Integer radio = cola.remove();
                return radio;
            }
            else
            {
                return null;
            }
        }
    }
