import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
public class Principal {
    public static void main(String[] args) {
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Persona.class);
        } catch (JAXBException e) {
            System.out.println("Error creando el contexto");
            System.out.println(e.getMessage());
            return;
        }
        Marshaller m;
        try {
            m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Persona p = new Persona(1, "Homer", "Simpson", 48);
            m.marshal(p, System.out);
            m.marshal(p, new File("Homer.xml"));
        } catch (JAXBException e) {
            System.out.println("Error convertiendo el objeto a formato XML");
            System.out.println(e.getMessage());
        }
    }
}
