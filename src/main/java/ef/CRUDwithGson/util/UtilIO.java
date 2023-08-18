package ef.CRUDwithGson.util;

public interface UtilIO <T> {

    T deserializingToObjects();

    void serializingToJson(T t);

    Integer getIdForObject(T t);
}
