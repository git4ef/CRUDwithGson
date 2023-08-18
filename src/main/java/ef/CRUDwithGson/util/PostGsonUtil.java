package ef.CRUDwithGson.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ef.CRUDwithGson.model.Post;
import ef.CRUDwithGson.model.Writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostGsonUtil implements UtilIO<List<Post>> {
    @Override
    public List<Post> deserializingToObjects() {
        List<Post> posts = new ArrayList<>();
        try (FileReader fileReader = new FileReader("src/main/resources/posts.json")) {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Post>>() {
            }.getType();
            posts = gson.fromJson(fileReader, listType);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }

    @Override
    public void serializingToJson(List<Post> posts) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/posts.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            gson.toJson(posts, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getIdForObject(List<Post> posts) {
        return posts.stream().mapToInt(Post::getId).max().orElse(0) + 1;
    }
}

