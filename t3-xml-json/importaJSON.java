import com.google.gson.Gson;
public class importaJSON {
    public static void main(String[] args) {
        GrupoPersonas grupo = new GrupoPersonas();
        grupo.getPersonas().add(new Persona(1, "Homer", "Simpson", 48));
        grupo.getPersonas().add(new Persona(2, "Lisa", "Simpson", 12));
        grupo.getPersonas().add(new Persona(3, "Bart", "Simpson", 13));
        grupo.getPersonas().add(new Persona(4, "Marge", "Simpson", 40));
        Gson gson = new Gson();
        String json = gson.toJson(grupo);
        System.out.println(json);
    }
}

