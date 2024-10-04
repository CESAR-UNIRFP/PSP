import java.io.File;
import java.io.IOException;

public class RedirigirSalida {
    public static void main(String[] args) {
        try {
            // Crear el ProcessBuilder para el Bloc de Notas (notepad.exe)
            //ProcessBuilder pb = new ProcessBuilder("notepad.exe");
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");

            // Redirigir la salida y errores a un archivo llamado "salida.txt"
            pb.redirectOutput(new File("salida.txt")); // Salida estándar redirigida a "salida.txt"
            pb.redirectErrorStream(true); // Redirigir también los errores al archivo "salida.txt"

            // Iniciar el proceso (Bloc de Notas)
            pb.start().waitFor();
            System.out.println("Proceso terminado. Revisa el archivo salida.txt.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");