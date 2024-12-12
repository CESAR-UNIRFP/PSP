import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
    public class EnviaSD {
        public static void main(String[] args) {
            Scanner lector = new Scanner(System.in);
            try {
                DatagramSocket ds = new DatagramSocket();
                InetAddress destino = InetAddress.getByName("192.168.1.104");
                String mensaje = "";
                while (!mensaje.equals("FIN")) {
                    System.out.println("Escribe un mensaje: ");
                    mensaje = lector.nextLine();
                    int lon = mensaje.length();
                    DatagramPacket carta = new DatagramPacket(mensaje.getBytes(), lon, destino, 5000);
                    ds.send(carta);
                    System.out.println("Enviado");
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
