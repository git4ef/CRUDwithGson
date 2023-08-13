package ef.CRUDwithGson.repository;


import ef.CRUDwithGson.model.Label;

import java.util.List;

public interface GenericRepository <T,ID>{
    T save(T t);
    T getById(ID id);
    T update(T t);
    void deleteById(ID id);
    List<T> getAll();
}
