import java.time.LocalDateTime;
import java.util.Scanner;
public class NewTable
{
        public static void main(String[] args) throws InterruptedException
        {
            Scanner lector = new Scanner(System.in);
            System.out.println("Tabla del número: ");
            int n = lector.nextInt();
            System.out.println(n);
            for (int i=1; i<=10; i++) {
                System.out.println(LocalDateTime.now() + " ----- " + n + " X " + i + " = " + (n*i));
                        Thread.sleep(250);
            }
            lector.close();
        }
}

