import java.io.IOException;
import java.lang.runtime.*;
public class Ej2
{
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("C:/Windows/System32/calc.exe");
            try {
                // Pausar el hilo por 10 segundos (10,000 milisegundos)
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // Si el hilo es interrumpido, capturamos la excepción
                e.printStackTrace();
            }
            process.destroy();
        }catch(IOException ex){
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }
    }
}
