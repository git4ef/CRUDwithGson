package ef.CRUDwithGson.util;

import com.google.gson.GsonBuilder;
import ef.CRUDwithGson.model.Label;

import java.io.FileNotFoundException;
import java.util.List;

public interface UtilIO <T> {

    T deserializingToObjects();

    void serializingToJson(T t);
}
