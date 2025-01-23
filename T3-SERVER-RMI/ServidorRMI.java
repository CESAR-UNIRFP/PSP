import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ServidorRMI {
    public static void main(String[] args) {
        String host;
        int puerto = 5055;
        try {
            //averiguamos la IP local
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("No se ha podido obtener la dirección IP");
            System.out.println(e.getMessage());
            return;
        }
        try {
            // creamos registro de objetos remotos
            Registry registro = LocateRegistry.createRegistry(puerto);
            //crea un objeto
            MusicaRMI musica = new MusicaRMI();
            //Inscripción del stub en el registro y puesto a disposición de los clientes bajo el nombre "miMusica".
            registro.rebind("miMusica", musica);
            System.out.println("Servicio registrado en host " + host + " y puerto " + puerto);
        } catch (RemoteException e) {
            System.out.println("No se ha podido registrar el servicio");
            System.out.println(e.getMessage());
        }
    }
}
//  podriamos forzar el cierre
//UnicastRemoteObject.unexportObject(musica, true);
