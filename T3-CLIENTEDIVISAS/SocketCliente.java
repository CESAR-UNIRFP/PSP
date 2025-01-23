import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {
    public static void main(String[] args) {
        System.out.println(" CALCULO DE CAMBIO DE DIVISA");
        System.out.println("-----------------------------------");
        String texto;
        Scanner lector = new Scanner(System.in);;
        try {
            Socket cliente = new Socket();
            InetSocketAddress direccionServidor = new InetSocketAddress("192.168.1.104",2222);  //ESPACIO
            System.out.println("Esperando a que el servidor acepte la conexión");
            cliente.connect(direccionServidor);
            System.out.println("Comunicación establecida con el servidor");
            InputStream entrada = cliente.getInputStream();
            OutputStream salida = cliente.getOutputStream();
            String continuar="S";
            while (continuar.equals("S")) {
                // Introducir cantidad hasta que sea un valor numérico correcto.
                texto = "";
                boolean ok = false;
                while (!ok) {
                    System.out.println("Escribe cantidad: ");
                    texto = lector.nextLine();
                    try {
                        Double.parseDouble(texto);
                        ok = true;
                    } catch (NumberFormatException e) {
                        System.out.println(texto + " no es un valor numérico");
                        ok = false;
                    }
                }
                // Introducir divisa hasta que sea E, D o L.
                ok = false;
                while (!ok) {
                    System.out.println("Escribe divisa (E = Euros, D = Dolares, L = Libras): ");
                    String divisa = lector.nextLine().toUpperCase();
                    // equalsIgnoreCase mejor que equals
                    if (divisa.equalsIgnoreCase("E") || divisa.equalsIgnoreCase("D") || divisa.equalsIgnoreCase("L")) { //ESPACIO
                            texto = texto + ";"+divisa;
                    ok = true;
                    }
                    else {
                    System.out.println("Debes introducir una E, D o L");
                    ok = false;
                    }
                }
                // Introducir divisa hasta que sea E, D o L.
                ok = false;
                while (!ok) {
                    System.out.println("Escribe segunda divisa (E = Euros, D = Dolares, L = Libras): ");
                    String divisa = lector.nextLine().toUpperCase();
                    // equalsIgnoreCase mejor que equals
                    if (divisa.equalsIgnoreCase("E") || divisa.equalsIgnoreCase("D") || divisa.equalsIgnoreCase(" L")) {
                        texto = texto + ";"+divisa;
                        ok = true;
                    }
                    else {
                        System.out.println("Debes introducir una E, D o L");
                        ok = false;
                    }
                }
                // Salida de la petición para el servidor.
                salida.write(texto.getBytes());
                // Recogida de la respuesta del servidor.
                byte[] mensaje = new byte[100];
                entrada.read(mensaje);
                System.out.println("Servidor responde: " + new String(mensaje).trim());  //añadimos .trim()
                System.out.println("¿Quieres realizar otro cambio de divisa (S/N)?");
                continuar = lector.nextLine().toUpperCase();
            }
            // Enviamos al servidor el texto FIN, así sabrá que el cliente
            // ha querido finalizar la comunicación.
            texto = "FIN";
            salida.write(texto.getBytes());
            entrada.close();
            salida.close();
            cliente.close();
            System.out.println("Comunicación cerrada");
        } catch (UnknownHostException e) {
            System.out.println("No se puede establecer comunicación con el servidor");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S");
            System.out.println(e.getMessage());
        }
    }
}