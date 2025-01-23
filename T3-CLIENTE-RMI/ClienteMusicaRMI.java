import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class ClienteMusicaRMI {
    public static void main(String[] args) {
        Registry registry;
        Scanner lector = new Scanner(System.in);
        try {
            //La parte importante del código, que permite al cliente obtener el stub para comunicarse con el
            //objeto remoto,
            //obtener el acceso al registro de objetos remotos a través de la misma dirección IP y puerto suministrado
            //acordaos de cambiar la IP
            registry = LocateRegistry.getRegistry("192.168.1.104", 5055);
            System.out.println("Hemos obtenido el registro");
            //stub a partir del identificador del objeto suministrado en el programa servidor
            MusicaInterfaceRMI canciones = (MusicaInterfaceRMI) registry.lookup("miMusica");
            System.out.println("Hemos obtenido el objeto remoto");
            System.out.println(); // Retorno de carro.
            String buscado;
            String opcion;
            do {
                escribirMenu();
                opcion = lector.nextLine().toUpperCase();
                switch (opcion) {
                    case "T":
                        System.out.println("Escribe título canción: ");
                        buscado = lector.nextLine();
                        System.out.println(canciones.buscarTitulo(buscado));
                        break;
                    case "B":
                        System.out.println("Escribe nombre banda: ");
                        buscado = lector.nextLine();
                        System.out.println(canciones.buscarBanda(buscado));
                        break;
                    case "A":
                        System.out.println("Escribe nombre álbum: ");
                        buscado = lector.nextLine();
                        System.out.println(canciones.buscarAlbum(buscado));
                        break;
                    case "P":
                        System.out.println("Escribe año de producción: ");
                        buscado = lector.nextLine();
                        int a = Integer.parseInt(buscado);
                        System.out.println(canciones.buscarProducido(a));
                        break;
                    case "F":
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            } while (!opcion.equals("F"));
        } catch (RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
        }
        lector.close();
    }
    private static void escribirMenu() {
        System.out.println();
        System.out.println("Búsqueda de canciones");
        System.out.println("--------------------------");
        System.out.println("T = Título");
        System.out.println("B = Banda");
        System.out.println("A = Álbum");
        System.out.println("P = Año producción");
        System.out.println("F = Terminar programa");
        System.out.println("--------------------------");
        System.out.println("¿Qué opción eliges?");
    }
}
