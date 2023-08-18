package ef.CRUDwithGson.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ef.CRUDwithGson.model.Writer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class WriterGsonUtil implements UtilIO<List<Writer>> {

    @Override
    public List<Writer> deserializingToObjects() {
        List<Writer> writers = new ArrayList<>();
        try (FileReader fileReader = new FileReader("src/main/resources/writers.json")) {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Writer>>() {
            }.getType();
            writers = gson.fromJson(fileReader, listType);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return writers;
    }

    @Override
    public void serializingToJson(List<Writer> writers) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/writers.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            gson.toJson(writers, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getIdForObject(List<Writer> writers) {
        return writers.stream().mapToInt(Writer::getId).max().orElse(0) + 1;
    }
}

