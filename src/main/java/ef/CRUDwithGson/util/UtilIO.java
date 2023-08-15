package ef.CRUDwithGson.util;

import com.google.gson.GsonBuilder;
import ef.CRUDwithGson.model.Label;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UtilIO <T> {

    T deserializingToObjects() throws IOException;

    void serializingToJson(T t) throws IOException;

    default int getIdForObject(int id){
        return ++id;
    }
}
