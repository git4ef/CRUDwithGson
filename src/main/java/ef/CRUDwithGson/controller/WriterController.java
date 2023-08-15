package ef.CRUDwithGson.controller;

import ef.CRUDwithGson.model.Post;
import ef.CRUDwithGson.model.Writer;
import ef.CRUDwithGson.repository.WriterRepository;
import ef.CRUDwithGson.repository.WriterRepositoryImpl;
import ef.CRUDwithGson.util.WriterGsonUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WriterController {
    WriterRepository writerRepository = new WriterRepositoryImpl();
    PostController postController = new PostController();
    LabelController labelController = new LabelController();

    public Writer findWriterById(int id) throws IOException {
        return writerRepository.getById(id);
    }

    public void deleteWriter(int id) throws IOException {
        writerRepository.deleteById(id);

    }

    public List<Writer> getAllWriters() throws IOException {
        return writerRepository.getAll();
    }

    public Writer updateWriter(int id, String firstName, String lastName) throws IOException {
        return writerRepository.update(new Writer(id, firstName, lastName));
    }

    public void saveWriter(String firstName, String lastName, String post, String labels) throws IOException {
        writerRepository.save(new Writer(firstName, lastName, Collections.singletonList(postController.savePost(post, labelController.findOrCreateLabelsByString(labels)))));
    }
}



