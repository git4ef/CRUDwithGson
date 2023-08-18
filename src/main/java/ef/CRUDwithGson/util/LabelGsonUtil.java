package ef.CRUDwithGson.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ef.CRUDwithGson.model.Label;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LabelGsonUtil implements UtilIO<List<Label>> {

    @Override
    public List<Label> deserializingToObjects() {
        List<Label> labels = new ArrayList<>();
        try (FileReader fileReader = new FileReader("src/main/resources/labels.json")) {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Label>>() {
            }.getType();
            labels = gson.fromJson(fileReader, listType);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return labels;
    }

    @Override
    public void serializingToJson(List<Label> labels) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/labels.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            gson.toJson(labels, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getIdForObject(List<Label> labels) {
        return labels.stream().mapToInt(Label::getId).max().orElse(0) + 1;
    }
}


