package ef.CRUDwithGson.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ef.CRUDwithGson.model.Label;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LabelGsonUtil implements UtilIO<List<Label>, String> {

    private final String pathToJson = "src/main/resources/label.json";


    @Override
    public List<Label> deserializingToObjects() {
        Type labelList = new TypeToken<ArrayList<Label>>() {
        }.getType();
        List<Label> labels = null;
        try {
            labels = new Gson().fromJson(new FileReader(pathToJson), labelList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return labels;
    }

    @Override
    public List<Label> serializingToJson(List<Label> labels) {
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter(pathToJson)) {
            gson.toJson(labels, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return labels;
    }
}

