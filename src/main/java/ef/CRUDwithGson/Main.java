package ef.CRUDwithGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.model.Writer;
import ef.CRUDwithGson.repository.LabelRepositoryImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        LabelRepositoryImpl labelRepository = new LabelRepositoryImpl();
        labelRepository.create(new Label(1010,"OOT"));

    }
}

