import com.google.gson.Gson;
public class CREAoBJETO {
    public static void main(String[] args) {
        String json = "{'idPersona':5,'nombre':'Montgomery','apellido':' Burns','edad':80}";
        Gson gson = new Gson();
        Persona p = gson.fromJson(json, Persona.class);
        System.out.println(p);
    }
}