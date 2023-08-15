package ef.CRUDwithGson.repository;

import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.model.Status;
import ef.CRUDwithGson.util.LabelGsonUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LabelRepositoryImpl implements LabelRepository {
    LabelGsonUtil labelGsonUtil = new LabelGsonUtil();

    @Override
    public Label save(Label label) throws IOException {
        List<Label> labelList = new ArrayList<>();
        try {
            labelList = labelGsonUtil.deserializingToObjects();
        } catch (FileNotFoundException e) {
            System.out.println("first record, label.json file created..");
            labelGsonUtil.serializingToJson(labelList);
        }
        label.setId(labelGsonUtil.getIdForObject(labelList.size()));
        labelList.add(label);
        labelGsonUtil.serializingToJson(labelList);
        return label;
    }

    @Override
    public Label getById(Integer id) throws IOException {
        return labelGsonUtil.deserializingToObjects().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Label update(Label label) throws IOException {
        List<Label> labelList;
        labelList = labelGsonUtil.deserializingToObjects();
        labelList.stream().filter(c -> c.getId() == label.getId()).findFirst().orElse(null).setName(label.getName());
        labelGsonUtil.serializingToJson(labelList);
        return label;
    }

    @Override
    public void deleteById(Integer id) throws IOException {
        List<Label> labelList = null;
        labelList = labelGsonUtil.deserializingToObjects();
        labelList.stream().filter(c -> c.getId() == id).findFirst().orElse(null).setStatus(Status.DELETED);
        labelGsonUtil.serializingToJson(labelList);
    }

    @Override
    public List<Label> getAll() throws IOException {
        return labelGsonUtil.deserializingToObjects();
    }

    public Label findLabelByName(String name) throws IOException {
        return labelGsonUtil.deserializingToObjects().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }


}


