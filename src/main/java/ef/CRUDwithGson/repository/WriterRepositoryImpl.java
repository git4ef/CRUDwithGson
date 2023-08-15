package ef.CRUDwithGson.repository;

import ef.CRUDwithGson.model.Post;
import ef.CRUDwithGson.model.Status;
import ef.CRUDwithGson.model.Writer;
import ef.CRUDwithGson.util.WriterGsonUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {

    WriterGsonUtil writerGsonUtil = new WriterGsonUtil();

    @Override
    public Writer save(Writer writer) throws IOException {
        List<Writer> writers = new ArrayList<>();
        try {
            writers = writerGsonUtil.deserializingToObjects();
        } catch (FileNotFoundException e) {
            System.out.println("first record, writer.json file created..");
        }
        try {

            if ((writers.stream().filter(c -> (c.getFirstName().equals(writer.getFirstName())) && c.getLastName().equals(writer.getLastName())).findFirst().orElse(null) != null)) {
                int id = writers.stream().filter(c -> (c.getFirstName().equals(writer.getFirstName())) && c.getLastName().equals(writer.getLastName())).findFirst().orElse(null).getId();
                writers.get(id - 1).getPostList().addAll(writer.getPostList());
            } else {
                writer.setId(writerGsonUtil.getIdForObject(writers.size()));
                writers.add(writer);
            }
        }catch (NullPointerException e){

        };
        writerGsonUtil.serializingToJson(writers);
        return writer;
    }

    @Override
    public Writer getById(Integer id) throws IOException {
        return writerGsonUtil.deserializingToObjects().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Writer update(Writer writer) throws IOException {
        List<Writer> writerList;
        writerList = writerGsonUtil.deserializingToObjects();
        writerList.get(writer.getId() - 1).setFirstName(writer.getFirstName());
        writerList.get(writer.getId() - 1).setLastName(writer.getLastName());
        writerGsonUtil.serializingToJson(writerList);
        return writer;
    }

    @Override
    public void deleteById(Integer id) throws IOException {
        List<Writer> writerList;
        writerList = writerGsonUtil.deserializingToObjects();
        writerList.stream().filter(c -> c.getId() == id).findFirst().orElse(null).setStatus(Status.DELETED);
        writerGsonUtil.serializingToJson(writerList);
    }

    @Override
    public List<Writer> getAll() throws IOException {
        return writerGsonUtil.deserializingToObjects();
    }
}
