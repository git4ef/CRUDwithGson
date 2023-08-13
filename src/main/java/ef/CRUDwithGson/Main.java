package ef.CRUDwithGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.model.Post;
import ef.CRUDwithGson.model.Writer;
import ef.CRUDwithGson.repository.LabelRepositoryImpl;
import ef.CRUDwithGson.repository.PostRepository;
import ef.CRUDwithGson.repository.PostRepositoryImpl;
import ef.CRUDwithGson.repository.WriterRepositoryImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LabelRepositoryImpl labelRepository = new LabelRepositoryImpl();
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        WriterRepositoryImpl writerRepository = new WriterRepositoryImpl();
        labelRepository.save(new Label("ART"));
        postRepository.save(new Post("some content",labelRepository.getAll()));
        writerRepository.save(new Writer("John","Doe",postRepository.getAll()));


        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(writerRepository.getAll());
        System.out.println(json);


    }
}

