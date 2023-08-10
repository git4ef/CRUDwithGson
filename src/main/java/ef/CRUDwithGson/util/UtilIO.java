package ef.CRUDwithGson.util;

import com.google.gson.GsonBuilder;

import java.util.List;

public interface UtilIO <T, S> {

    T deserializingToObjects();
    T serializingToJson(T t);
}
