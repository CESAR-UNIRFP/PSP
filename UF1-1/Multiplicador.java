import java.time.LocalDateTime;

public class Multiplicador {
    public static void main(String[] args) {
        System.out.println("Fecha y hora de inicio: " + LocalDateTime.now());
        if (args.length < 2) {
            System.out.println("Se requieren dos argumentos");
            return;
        }
        try {
            // Convertir los argumentos a enteros
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            // Realizar la multiplicación
            int resultado = num1 * num2;

            // Mostrar el resultado
            System.out.println("Resultado de la multiplicación: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Error: Los argumentos deben ser números enteros.");
        }
    }
}



/*



 */