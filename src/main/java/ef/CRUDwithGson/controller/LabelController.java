package ef.CRUDwithGson.controller;

import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.repository.LabelRepositoryImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LabelController {
    LabelRepositoryImpl labelRepository = new LabelRepositoryImpl();

    public Label saveLabel(String name) throws IOException {
       return labelRepository.save(new Label(name));
    }

    public Label findLabelById(int id) throws IOException {
        return labelRepository.getById(id);
    }


    public void deleteLabel(int id) throws IOException {
        labelRepository.deleteById(id);
    }

    public List<Label> getAllLabels() throws IOException {
        return labelRepository.getAll();
    }

    public Label findLabelByName(String name) throws IOException {
        return labelRepository.findLabelByName(name);
    }

    public Label updateLabel(int id, String name) throws IOException {
        return labelRepository.update(new Label(id,name));
    }

    public List <Label> findOrCreateLabelsByString(String labels) throws IOException {
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
