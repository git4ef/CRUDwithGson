package ef.CRUDwithGson.controller;

import ef.CRUDwithGson.model.Writer;
import ef.CRUDwithGson.repository.WriterRepository;
import ef.CRUDwithGson.repository.gson.WriterRepositoryImpl;
import java.util.Collections;
import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository = new WriterRepositoryImpl();
    private final PostController postController = new PostController();
    private final LabelController labelController = new LabelController();

    public Writer findWriterById(int id) {
        return writerRepository.getById(id);
    }

    public void deleteWriter(int id) {
        writerRepository.deleteById(id);
    }

    public List<Writer> getAllWriters() {
        return writerRepository.getAll();
    }

    public Writer updateWriter(int idWriter, String firstName, String lastName) {
        return writerRepository.update(new Writer(idWriter,firstName,lastName));
    }

    public void saveWriter(String firstName, String lastName, String post, String labels) {
        writerRepository.save(new Writer(firstName, lastName, Collections.singletonList(postController.savePost(post, labels))));
    }
}



