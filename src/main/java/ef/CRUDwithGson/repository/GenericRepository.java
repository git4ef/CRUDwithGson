package ef.CRUDwithGson.repository;

public interface GenericRepository <T,ID>{
    T create(T t);
    T read();
    T update();
    T delete();
    T readAll();
}
