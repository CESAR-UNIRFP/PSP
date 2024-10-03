import java.io.IOException;

public class Runtime2
{
    public static void main(String[] args)
    {
        Runtime runtime = Runtime.getRuntime();
        try
        {
            // Inicia el proceso de la calculadora
            Process process = runtime.exec("C:/Windows/System32/calc.exe");

            // Pausar el hilo por 10 segundos (10,000 milisegundos)
            try
            {
                Thread.sleep(10000); // Pausa el hilo durante 10 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            // Intenta destruir el proceso después de los 10 segundos
            process.destroy();

            // Esperar a que el proceso termine después de ser destruido
            process.waitFor(); // Esto espera que el proceso finalice
            System.out.println("Proceso terminado correctamente.");

        } catch (IOException ex) {
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        } catch (InterruptedException e) {
            System.err.println("El proceso fue interrumpido.");
            System.exit(-1);
        }
    }
}
