
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
public class RecibeSD {
        public static void main(String[] args) {
            try {
                InetSocketAddress direccion = new InetSocketAddress("192.168.1.104",5000);
                DatagramSocket ds = new DatagramSocket(direccion);
                System.out.println("Preparado para recibir");
                String texto = "";
                while (!texto.equals("FIN")) {
                    byte[] mensaje = new byte[100];
                    DatagramPacket carta = new DatagramPacket(mensaje, 100);
                    ds.receive(carta);
                    texto = new String(mensaje).trim();
                    System.out.println("RECIBIDO: " + texto);
                }
                ds.close();
                System.out.println("Socket Datagram cerrado");
            } catch (SocketException | UnknownHostException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
}