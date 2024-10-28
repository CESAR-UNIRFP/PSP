import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        System.out.println("APLICACIÓN DE SERVIDOR");
        System.out.println("----------------------------------");

        try {
            ServerSocket servidor = new ServerSocket();
            InetSocketAddress direccion = new InetSocketAddress("192.168.10.128", 2000);
            servidor.bind(direccion);
            System.out.println("Servidor creado y escuchando .... ");
            System.out.println("Dirección IP: " + direccion.getAddress());

            Socket enchufeAlCliente = servidor.accept();
            System.out.println("Comunicación entrante");

            InputStream entrada = enchufeAlCliente.getInputStream();
            OutputStream salida = enchufeAlCliente.getOutputStream();
            String texto = "";

            while (!texto.trim().equals("FIN")) {
                byte[] mensaje = new byte[100];
                int bytesLeidos = entrada.read(mensaje); // Leer solo los bytes recibidos
                texto = new String(mensaje, 0, bytesLeidos); // Convertir solo los bytes leídos a String

                if (texto.trim().equals("FIN")) {
                    salida.write("Hasta pronto, gracias por establecer conexión".getBytes());
                } else {
                    System.out.println("Cliente dice: " + texto);
                    salida.write(("Tu mensaje tiene " + texto.trim().length() + " caracteres").getBytes());
                }
            }

            entrada.close();
            salida.close();
            enchufeAlCliente.close();
            servidor.close();
            System.out.println("Comunicación cerrada");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

