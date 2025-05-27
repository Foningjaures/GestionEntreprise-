
package eventsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class JsonSerializer {

    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void sauvegarder(Collection<Evenement> evenements, String filename) throws IOException {
        mapper.writeValue(new File(filename), evenements);
    }

    public static Evenement[] charger(String filename) throws IOException {
        return mapper.readValue(new File(filename), Evenement[].class);
    }
}
