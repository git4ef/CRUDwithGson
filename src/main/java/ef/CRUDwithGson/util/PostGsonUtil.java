package ef.CRUDwithGson.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ef.CRUDwithGson.model.Post;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PostGsonUtil implements UtilIO<List<Post>> {

    @Override
    public List<Post> deserializingToObjects() throws IOException {
        List<Post> posts;
        FileReader fileReader = new FileReader("src/main/resources/posts.json");
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Post>>() {
        }.getType();
        posts = gson.fromJson(fileReader, listType);
        fileReader.close();
        return posts;
    }

    @Override
    public void serializingToJson(List<Post> posts) throws IOException {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/posts.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            gson.toJson(posts, fileWriter);
        }
    }
}