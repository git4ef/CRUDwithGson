package ef.CRUDwithGson.repository;


import ef.CRUDwithGson.model.Label;

import java.io.IOException;
import java.util.List;

public interface GenericRepository <T,ID>{
    T save(T t) throws IOException;
    T getById(ID id) throws IOException;
    T update(T t) throws IOException;
    void deleteById(ID id) throws IOException;
    List<T> getAll() throws IOException;
}
