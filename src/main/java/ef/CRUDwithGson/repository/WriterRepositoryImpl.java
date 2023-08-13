package ef.CRUDwithGson.repository;

import ef.CRUDwithGson.model.PostStatus;
import ef.CRUDwithGson.model.Writer;
import ef.CRUDwithGson.util.WriterGsonUtil;
import java.util.ArrayList;
import java.util.List;

public class WriterRepositoryImpl implements WriterRepository{

    WriterGsonUtil writerGsonUtil = new WriterGsonUtil();
    @Override
    public Writer save(Writer writer) {
        List<Writer> writers = new ArrayList<>();
        writers = writerGsonUtil.deserializingToObjects();
        writers.add(writer);
        writerGsonUtil.serializingToJson(writers);
        return writer;
    }

    @Override
    public Writer getById(Integer integer) {
        return writerGsonUtil.deserializingToObjects().stream().filter(s -> s.getId() == integer).findFirst().orElse(null);
    }

    @Override
    public Writer update(Writer writer) {
        List<Writer> writers = new ArrayList<>();
        writers = writerGsonUtil.deserializingToObjects();
        writers.get(writer.getId()).setFirstName(writer.getFirstName());
        writers.get(writer.getId()).setLastName(writer.getLastName());
        writers.get(writer.getId()).setPostList(writer.getPostList());
        writerGsonUtil.serializingToJson(writers);
        return null;
    }

    @Override
    public void deleteById(Integer integer) {
        List<Writer> writers = new ArrayList<>();
        writers = writerGsonUtil.deserializingToObjects();
        writers.stream().filter(s -> s.getId() == integer)
                .findFirst()
                .orElse(null).setStatus(PostStatus.DELETED);
        writerGsonUtil.serializingToJson(writers);
    }

    @Override
    public List<Writer> getAll() {
        return writerGsonUtil.deserializingToObjects();
    }
}
