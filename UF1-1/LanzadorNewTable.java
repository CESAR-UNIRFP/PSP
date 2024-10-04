import java.io.File;
import java.io.IOException;

public class LanzadorNewTable {
    public static void main(String[] args) {
        ProcessBuilder proceso1, proceso2;

        String classpath = System.getProperty("java.class.path");

        proceso1 = new ProcessBuilder("java", "-cp", classpath,"NewTable");
        proceso2 = new ProcessBuilder("java", "-cp", classpath,"NewTable");

        proceso1.redirectError(new File("errores1.txt"));
        proceso1.redirectOutput(new File("salida1.txt"));
        proceso1.redirectInput(new File("entrada1.txt"));
        proceso2.redirectError(new File("errores2.txt"));
        proceso2.redirectOutput(new File("salida2.txt"));
        proceso2.redirectInput(new File("entrada2.txt"));
        try {
            proceso1.start().waitFor();
            proceso2.start();
            System.out.println("Los procesos se han lanzado");
            System.out.println("Examina los archivos de salida");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}




/*
        String classpath = System.getProperty("java.class.path");

        proceso1 = new ProcessBuilder("java", "-cp", classpath,"NewTime");
        proceso2 = new ProcessBuilder("java", "-cp", classpath,"NewTime");

 */


/*
proceso1.start().waitFor();
proceso2.start().waitFor();
 */