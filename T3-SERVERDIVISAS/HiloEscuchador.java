import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
public class HiloEscuchador implements Runnable {
    private Thread hilo;
    private static int numCliente = 0;
    private Socket enchufeAlCliente;
    public HiloEscuchador(Socket cliente) {
        numCliente++;
        hilo = new Thread(this, "Cliente"+numCliente);
        this.enchufeAlCliente = cliente;
        hilo.start();
    }
    @Override
    public void run() {
        System.out.println("Estableciendo comunicación con " + hilo.getName());
        try {
            InputStream entrada = enchufeAlCliente.getInputStream();
            OutputStream salida = enchufeAlCliente.getOutputStream();
            String texto = "";
            while (!texto.trim().equals("FIN")) {byte[] mensaje = new byte[100];
                entrada.read(mensaje);
                texto = new String(mensaje).trim();  //añadimos trim()
                if (texto.trim().equals("FIN")) {
                    System.out.println(hilo.getName()+" ha cerrado la comunicación");
                } else {
                    System.out.println(hilo.getName() + " dice: " + texto);
                    texto = calcularCambioDivisa(texto.trim());
                    salida.write(texto.getBytes());
                }
            }
            entrada.close();
            salida.close();
            enchufeAlCliente.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private String calcularCambioDivisa(String texto) {
// Usamos un objeto Scanner para dividir el mensaje del cliente en tres partes.
        Scanner lectorPeticion = new Scanner(texto);
        lectorPeticion.useDelimiter(";");
        double cantidad = Double.parseDouble(lectorPeticion.next());
        String divisa = lectorPeticion.next();
        String cambio = lectorPeticion.next();
        if (divisa.equalsIgnoreCase("E") && cambio.equalsIgnoreCase("E")) {
            // SUSTITUIMOS equals por equalsIgnoreCase
            return cantidad + " Euros = " + cantidad + " Euros";
        }
        else if (divisa.equalsIgnoreCase("E") && cambio.equalsIgnoreCase("D")) {
            return cantidad + " Euros = " + (cantidad*1.16) + " Dólares";
        }
        else if (divisa.equalsIgnoreCase("E") && cambio.equalsIgnoreCase("L")) {
            return cantidad + " Euros = " + (cantidad*0.90) + " Libras";
        }
        else if (divisa.equalsIgnoreCase("D") && cambio.equalsIgnoreCase("D")) {
            return cantidad + " Dólares = " + cantidad + " Dólares";
        }
        else if (divisa.equalsIgnoreCase("D") && cambio.equalsIgnoreCase("E")) {
            return cantidad + " Dólares = " + cantidad*0.86 + " Euros";
        }
        else if (divisa.equalsIgnoreCase("D") && cambio.equalsIgnoreCase("L")) {
            return cantidad + " Dólares = " + cantidad*0.78 + " Libras";
        }
        else if (divisa.equalsIgnoreCase("L") && cambio.equalsIgnoreCase("L")) {
            return cantidad + " Libras = " + cantidad + " Libras";
        }
        else if (divisa.equalsIgnoreCase("L") && cambio.equalsIgnoreCase("E")) {
            return cantidad + " Libras = " + cantidad*1.11 + " Euros";
        }
        else if (divisa.equalsIgnoreCase("L") && cambio.equalsIgnoreCase("D")) {
            return cantidad + " Libras = " + cantidad*1.29 + " Dólares";
        }
        else {
            return "Divisas incorrectas, no se ha podido calcular";
        }
    }
}