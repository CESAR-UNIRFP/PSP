/*import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        ProcessBuilder proceso;
        proceso = new ProcessBuilder("c:/Windows/System32/calc.exe");
        try
        {
            proceso.start();
            System.out.println("proceso lanzado");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
*/



public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la clase ProcesoLanzador
        LanzadorProceso lanzador = new LanzadorProceso();

        // Lanzar el proceso 3 veces
        for (int i = 1; i <= 3; i++) {
            lanzador.lanzarProceso();
            System.out.println("Instancia " + i + " del proceso lanzada");
        }
    }
}
