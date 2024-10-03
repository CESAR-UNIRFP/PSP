import java.io.IOException;

public class RuntimeTaskKill
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
                }

                // Forzar el cierre de la calculadora usando taskkill
                runtime.exec("taskkill /F /IM calc.exe");
                System.out.println("Proceso de la calculadora terminado.");

            } catch (IOException ex) {
                System.err.println("Excepción de E/S!!");
                System.exit(-1);
            }
        }
}
