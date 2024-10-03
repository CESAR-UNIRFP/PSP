import java.io.IOException;
public class Principal2 {
    public static void main(String[] args) {
        ProcessBuilder proceso;
        proceso = new ProcessBuilder("C:/Windows/System32/calc.exe");
        try {
            Process p = proceso.start();
            p.waitFor();
            System.out.println("Proceso lanzado con éxito");
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
