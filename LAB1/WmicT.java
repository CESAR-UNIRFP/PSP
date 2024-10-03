import java.io.IOException;

public class WmicT
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

                // Usar WMIC para forzar la terminación del proceso de la calculadora
                String wmicCommand = "wmic process where name='Calculator.exe' delete";
                Process wmicProcess = runtime.exec(wmicCommand);

                wmicProcess.waitFor(); // Esperar que el proceso se cierre

                System.out.println("Proceso de la calculadora terminado usando WMIC.");

            } catch (IOException | InterruptedException ex) {
                System.err.println("Error al intentar cerrar el proceso: " + ex.getMessage());
            }
        }
}

