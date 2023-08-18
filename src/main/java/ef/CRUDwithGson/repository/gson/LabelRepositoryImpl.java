package ef.CRUDwithGson.repository.gson;

import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.model.Status;
import ef.CRUDwithGson.repository.LabelRepository;
import ef.CRUDwithGson.util.LabelGsonUtil;
import java.util.ArrayList;
import java.util.List;

public class LabelRepositoryImpl implements LabelRepository {
    private final LabelGsonUtil labelGsonUtil = new LabelGsonUtil();

    @Override
    public Label save(Label labelToSave) {
        List<Label> labels = new ArrayList<>();
        labels = labelGsonUtil.deserializingToObjects();
        labelToSave.setId(labelGsonUtil.getIdForObject(labels));
        labels.add(labelToSave);
        labelGsonUtil.serializingToJson(labels);
        return labelToSave;
    }

    @Override
    public Label getById(Integer id) {
        return labelGsonUtil.deserializingToObjects().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Label update(Label labelToUpdate) {
        List<Label> labelList = new ArrayList<>();
        labelList = labelGsonUtil.deserializingToObjects();
        List<Label> updatedLabelList = labelList.stream().
                map(currentLabel -> {
                    if (currentLabel.getId() == labelToUpdate.getId()) {
                        return labelToUpdate;
                    }
                    return currentLabel;
                }).toList();
        labelGsonUtil.serializingToJson(updatedLabelList);
        return labelToUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        List<Label> labelList = new ArrayList<>();
        labelList = labelGsonUtil.deserializingToObjects();
        List<Label> updatedLabelList = labelList.stream().
                map(currentLabel -> {
                    if (currentLabel.getId() == id) {
                        currentLabel.setStatus(Status.DELETED);
                    }
                    return currentLabel;
                }).toList();
        labelGsonUtil.serializingToJson(updatedLabelList);
    }

    @Override
    public List<Label> getAll() {
        return labelGsonUtil.deserializingToObjects();
    }

    public Label findLabelByName(String name) {
        return labelGsonUtil.deserializingToObjects().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }
}


