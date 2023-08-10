package ef.CRUDwithGson.repository;

import ef.CRUDwithGson.model.Label;

public interface LabelRepository extends GenericRepository <Label,Integer> {

    Label create(Label label);
}
