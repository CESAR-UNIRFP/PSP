import java.io.IOException;
public class Principal {
    public static void main(String[] args) {
        ProcessBuilder proceso;
        proceso = new ProcessBuilder("C:/Windows/System32/calc.exe");
        try {
            proceso.start();
            System.out.println("Proceso lanzado con éxito");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

