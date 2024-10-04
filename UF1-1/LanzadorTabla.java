import java.io.File;
import java.io.IOException;

public class LanzadorTabla
{
    public static void main(String[] args)
    {
        String classpath = System.getProperty("java.class.path");
        ProcessBuilder proceso = new ProcessBuilder("java", "-cp", classpath, "Tabla");
        // ProcessBuilder proceso = new ProcessBuilder("java", "Tabla");
        proceso.redirectError(new File("errores.txt"));
        proceso.redirectOutput(new File("salida.txt"));
        proceso.redirectInput(new File("entrada.txt"));
        try
        {
            proceso.start().waitFor();
            System.out.println("El proceso ha sido lanzado con éxito");
            System.out.println("Examina los archivos errores.txt y salida.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}


        //ProcessBuilder proceso = new ProcessBuilder("java", "-cp", ".", "Tabla");

       /*
        String classpath = System.getProperty("java.class.path");
        ProcessBuilder proceso = new ProcessBuilder("java", "-cp", classpath, "Tabla");
       */


/*
        File inputFile = new File("entrada.txt");
        try {
            if (inputFile.createNewFile()) {
                System.out.println("El archivo 'entrada.txt' ha sido creado.");
            } else {
                System.out.println("El archivo 'entrada.txt' ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 */


