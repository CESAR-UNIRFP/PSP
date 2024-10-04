import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LanzadorMultiplicador {
    public static void main(String[] args) {
        // Pedir dos números al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer número entero: ");
        int num1 = scanner.nextInt();
        System.out.print("Introduce el segundo número entero: ");
        int num2 = scanner.nextInt();
        scanner.close();

        // Guardar los números en el archivo entrada.txt
        File inputFile = new File("entrada.txt");
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write(num1 + " " + num2);
            System.out.println("Números guardados en entrada.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Obtener el classpath actual del sistema
        String classpath = System.getProperty("java.class.path");

        // Crear el proceso para ejecutar la clase Multiplicador
        ProcessBuilder proceso = new ProcessBuilder("java", "-cp", classpath, "Multiplicador", String.valueOf(num1), String.valueOf(num2));
        proceso.redirectError(new File("errores.txt")); // Guardar errores
        proceso.redirectOutput(new File("salida.txt")); // Guardar la salida


        // Iniciar el proceso y manejar la salida
        try {
            // Iniciar el proceso y esperar que termine
            proceso.start().waitFor();

            System.out.println("El proceso ha sido lanzado con éxito");
            System.out.println("Examina los archivos salida.txt y errores.txt");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
