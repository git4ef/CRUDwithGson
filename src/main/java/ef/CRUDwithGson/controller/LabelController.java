package ef.CRUDwithGson.controller;

import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.repository.LabelRepositoryImpl;

import java.util.List;

public class LabelController {
    LabelRepositoryImpl labelRepository = new LabelRepositoryImpl();

    public Label saveLabel(String name) {
        if (labelRepository.findLabelByName(name) != null) {
            return labelRepository.findLabelByName(name);
        } else {
            return labelRepository.save(new Label(name));
        }
    }


    public Label findLabelById(int id) {
        return labelRepository.getById(id);
    }

    public void deleteLabel(int id) {
        labelRepository.deleteById(id);
    }

    public List<Label> getAllLabels() {
        return labelRepository.getAll();
    }
}
