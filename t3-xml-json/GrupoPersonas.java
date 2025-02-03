import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//import jakarta.xml.bind.annotation.XmlElement;
//import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "grupo")
public class GrupoPersonas {
    private ArrayList<Persona> personas;
    public GrupoPersonas() {
        personas = new ArrayList<Persona>();
    }
    @XmlElement(name = "persona")
    public ArrayList<Persona> getPersonas() {
        return personas;
    }
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}
