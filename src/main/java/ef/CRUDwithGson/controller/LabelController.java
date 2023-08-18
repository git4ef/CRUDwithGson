package ef.CRUDwithGson.controller;

import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.repository.LabelRepository;
import ef.CRUDwithGson.repository.gson.LabelRepositoryImpl;
import java.util.ArrayList;
import java.util.List;

public class LabelController {
    private LabelRepository labelRepository = new LabelRepositoryImpl();

    public Label saveLabel(String name) {
        return labelRepository.save(new Label(name));
    }

    public Label findLabelById(Integer id) {
        return labelRepository.getById(id);
    }

    public void deleteLabel(Integer id) {
        labelRepository.deleteById(id);
    }

    public List<Label> getAllLabels() {
        return labelRepository.getAll();
    }

    public Label findLabelByName(String name) {
        return labelRepository.findLabelByName(name);
    }

    public Label updateLabel(Integer id, String name) {
        return labelRepository.update(new Label(id, name));
    }

    public List <Label> findOrCreateLabelsByString(String labels) {
        List<Label> resultLabels = new ArrayList<>();
        String[] labelsName = labels.split(" ");
        for (String lbl : labelsName) {
            if (labelRepository.findLabelByName(lbl) != null) {
                resultLabels.add(labelRepository.findLabelByName(lbl));
            } else {
                resultLabels.add(labelRepository.save(new Label(lbl)));
            }
        }
        return resultLabels;
    }
}
