import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {
    public static void main(String[] args) {
        // Configuración de las propiedades del correo
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");

        /*  ORIGINAL
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.user", "miUsuario@gmail.com");
        */


        // Sesión con las propiedades configuradas

        Session sesion = Session.getInstance(propiedades);

        /*  ORIGINAL
        Session sesion = Session.getDefaultInstance(propiedades);
         */

        System.out.println("Hemos configurado la sesión con Gmail.");

        try {
            // Creando el mensaje de correo
            MimeMessage email = new MimeMessage(sesion);
            String destinatarios = "destinatario1@gmail.com,destinatario2@gmail.com";
            InternetAddress[] direccionesTo = InternetAddress.parse(destinatarios, true);
            email.setRecipients(Message.RecipientType.TO, direccionesTo);
            email.setSubject("Hola desde mi programa Java");
            email.setSentDate(new Date());
            email.setText("Hola mundo desde mi programa Java");
            System.out.println("Hemos configurado el email.");

            // Transportar el mensaje
            Transport transport = sesion.getTransport("smtp");

            // Conexión con el servidor de correo (usa contraseña de aplicación)
            String usuario = "miUsuario@gmail.com"; // Reemplaza con tu email

            // AQUI METERIAMOS LA CONTRASEÑA DE APLICACION
            String contrasena = "contraseñaDeAplicación"; // Generada en la configuración de seguridad de Google

            transport.connect(usuario, contrasena);
            System.out.println("Conexión establecida con el servidor de Gmail.");

            // Enviar el mensaje
            transport.sendMessage(email, email.getAllRecipients());
            transport.close();
            System.out.println("El mensaje ha sido enviado con éxito.");
        } catch (MessagingException e) {
            System.out.println("No se ha podido enviar el mensaje: " + e.getMessage());
        }
    }
}
