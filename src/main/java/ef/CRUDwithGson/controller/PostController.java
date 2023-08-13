package ef.CRUDwithGson.controller;

import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.model.Post;
import ef.CRUDwithGson.repository.LabelRepositoryImpl;
import ef.CRUDwithGson.repository.PostRepository;
import ef.CRUDwithGson.repository.PostRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostController {
    PostRepositoryImpl postRepository = new PostRepositoryImpl();
    LabelRepositoryImpl labelRepository = new LabelRepositoryImpl();

    public void savePost(String content, String labels) {
        labelRepository.getAll();
        List<Label> resultLabels = new ArrayList<>();
        String[] labelsName = labels.split(" ");
        for (String lbl : labelsName) {
            if (labelRepository.findLabelByName(lbl) != null) {
                resultLabels.add(labelRepository.findLabelByName(lbl));
            } else {
                resultLabels.add(labelRepository.save(new Label(lbl)));
            }
        }
        postRepository.save(new Post(content, resultLabels));
    }

}


