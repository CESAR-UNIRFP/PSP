import java.io.IOException;

public class LanzadorProceso {

    // Método que lanza el proceso (en este caso, la calculadora)
    public void lanzarProceso() {
        ProcessBuilder proceso = new ProcessBuilder("c:/Windows/System32/calc.exe");
        try {
            proceso.start();
            System.out.println("Proceso lanzado");
        } catch (IOException e) {
            System.out.println("Error al lanzar el proceso: " + e.getMessage());
        }
    }
}
