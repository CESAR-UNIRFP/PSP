import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeTaskKillID
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

                // Obtener el ID del proceso (PID)
                long pid = process.pid();
                System.out.println("PID del proceso: " + pid);

                // Forzar el cierre del proceso por su PID
                String taskKillCommand = "taskkill /F /PID " + pid;
                Process killProcess = runtime.exec(taskKillCommand);

                // Leer la salida de la ejecución de taskkill
                BufferedReader reader = new BufferedReader(new InputStreamReader(killProcess.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null)
                {
                    System.out.println(line);
                }
                killProcess.waitFor();  // Esperar a que se complete el comando taskkill
                System.out.println("Proceso de la calculadora terminado.");

            } catch (IOException | InterruptedException ex) {
                System.err.println("Error al intentar cerrar el proceso: " + ex.getMessage());
            }
        }
}
