import java.io.IOException;
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
