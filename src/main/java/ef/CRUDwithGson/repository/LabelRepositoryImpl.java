package ef.CRUDwithGson.repository;

import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.model.PostStatus;
import ef.CRUDwithGson.util.LabelGsonUtil;

import java.util.ArrayList;
import java.util.List;

public class LabelRepositoryImpl implements LabelRepository {
    LabelGsonUtil labelGsonUtil = new LabelGsonUtil();

    @Override
    public Label save(Label label) {
        List<Label> labelList = new ArrayList<>();
        labelList = labelGsonUtil.deserializingToObjects();
        Label label1 = label;
        labelList.add(label1);
        labelGsonUtil.serializingToJson(labelList);
        return label;
    }


    @Override
    public Label getById(Integer id) {
        try {
            return labelGsonUtil.deserializingToObjects().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Label update(Label label) {
        List<Label> labelList;
        labelList = labelGsonUtil.deserializingToObjects();
        labelList.get(label.getId()).setName(label.getName());
        labelGsonUtil.serializingToJson(labelList);
        return label;
    }

    @Override
    public void deleteById(Integer id) {
        List<Label> labelList = null;
        labelList = labelGsonUtil.deserializingToObjects();
        labelList.stream().filter(c -> c.getId() == id).findFirst().orElse(null).setStatus(PostStatus.DELETED);
        labelGsonUtil.serializingToJson(labelList);
    }

    @Override
    public List<Label> getAll() {
        return labelGsonUtil.deserializingToObjects();
    }

    public Label findLabelByName(String name) {
        return labelGsonUtil.deserializingToObjects().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }


}


