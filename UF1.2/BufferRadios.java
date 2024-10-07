import java.util.LinkedList;
import java.util.Queue;

public class BufferRadios

{
    private Queue<Integer> cola;
    public BufferRadios()
    {
        cola = new LinkedList<Integer>();
    }
    public void poner(Integer r)
    {
        cola.add(r);
    }
    public Integer sacar()
    {
        if (cola.isEmpty())
        {
            return null;
        }
        else
        {
            Integer radio = cola.remove();
            return radio;
        }
    }
}


/*    WAIT AND NOTIFY

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
        while (cola.isEmpty())
        {
            try
            {
                wait(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
        if (!cola.isEmpty())
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
*/


/* 20 ESPERAS

public class BufferRadios {
private Queue<Integer> cola;
public BufferRadios() {
cola = new LinkedList<Integer>();
}
public synchronized void poner(Integer r) {
cola.add(r);
notify();
}
public synchronized Integer sacar() {
int esperas = 0;
while (cola.isEmpty() && esperas<20) {
esperas ++;
try {
wait(10);
} catch (InterruptedException e) {
System.out.println(e.getMessage());
}
}
if (esperas<20) {
Integer radio = cola.remove();
return radio;
} else {
return null;
}
}
}
*/