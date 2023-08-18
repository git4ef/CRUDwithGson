package ef.CRUDwithGson.repository.gson;

import ef.CRUDwithGson.model.Status;
import ef.CRUDwithGson.model.Writer;
import ef.CRUDwithGson.repository.WriterRepository;
import ef.CRUDwithGson.util.WriterGsonUtil;
import java.util.ArrayList;
import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {

    private final WriterGsonUtil writerGsonUtil = new WriterGsonUtil();

    @Override
    public Writer save(Writer writer) {
        List<Writer> writers = new ArrayList<>();
        writers = writerGsonUtil.deserializingToObjects();
        if ((writers.stream().filter(c -> (c.getFirstName().equals(writer.getFirstName())) && c.getLastName().equals(writer.getLastName())).findFirst().orElse(null) != null)) {
            int id = writers.stream().filter(c -> (c.getFirstName().equals(writer.getFirstName())) && c.getLastName().equals(writer.getLastName())).findFirst().orElse(null).getId();
            writers.get(id).getPostList().addAll(writer.getPostList());
            writerGsonUtil.serializingToJson(writers);
        } else {
            writer.setId(writerGsonUtil.getIdForObject(writers));
            writers.add(writer);
            writerGsonUtil.serializingToJson(writers);
        }
        return writer;
    }

    @Override
    public Writer getById(Integer id) {
        return writerGsonUtil.deserializingToObjects().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Writer update(Writer writerToUpdate) {
        List<Writer> writerList = new ArrayList<>();
        writerList = writerGsonUtil.deserializingToObjects();
        List<Writer> updatedWriterList = writerList.stream().
                map(currentWriter -> {
                    if (currentWriter.getId() == currentWriter.getId()) {
                        writerToUpdate.setId(currentWriter.getId());
                        writerToUpdate.setPostList(currentWriter.getPostList());
                        writerToUpdate.setStatus(currentWriter.getStatus());
                        return writerToUpdate;
                    }
                    return currentWriter;
                }).toList();
        writerGsonUtil.serializingToJson(updatedWriterList);
        return writerToUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        List<Writer> writerList = new ArrayList<>();
        writerList = writerGsonUtil.deserializingToObjects();
        List<Writer> updatedWriterList = writerList.stream().
                map(currentWriter -> {
                    if (currentWriter.getId() == id) {
                        currentWriter.setStatus(Status.DELETED);
                    }
                    return currentWriter;
                }).toList();
        writerGsonUtil.serializingToJson(updatedWriterList);
    }

    @Override
    public List<Writer> getAll() {
        return writerGsonUtil.deserializingToObjects();
    }
}
