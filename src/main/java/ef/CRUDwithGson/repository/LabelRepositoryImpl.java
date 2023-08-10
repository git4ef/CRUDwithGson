package ef.CRUDwithGson.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.util.LabelGsonUtil;

import java.util.List;


public class LabelRepositoryImpl implements LabelRepository{

    LabelGsonUtil labelGsonUtil = new LabelGsonUtil();

    @Override
    public Label create(Label label) {
    List<Label> labelList = labelGsonUtil.deserializingToObjects();
    labelList.add(label);
    labelGsonUtil.serializingToJson(labelList);
    return label;
    }

    @Override
    public Label read() {
        return null;
    }

    @Override
    public Label update() {
        return null;
    }

    @Override
    public Label delete() {
        return null;
    }

    @Override
    public Label readAll() {
        return null;
    }
}
