package ef.CRUDwithGson.model;

import java.util.Date;
import java.util.List;

public class Post {
    private Integer id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labelList;
    private PostStatus postStatus;


    public Post(String content, List<Label> labelList) {
        this.content = content;
        this.created = new Date();
        this.updated = updated;
        this.labelList = labelList;
        this.postStatus = PostStatus.ACTIVE;
    }

    public Post(int id, String content, List<Label> labelList) {
        this.id = id;
        this.content = content;
        this.labelList = labelList;
        this.postStatus = PostStatus.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<Label> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<Label> labelList) {
        this.labelList = labelList;
    }

    public PostStatus getStatus() {
        return postStatus;
    }

    public void setStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }


    @Override
    public String toString() {
        return "\n* ********************************************************" +
                "\n*  Post id: " + id +
                "\n* ********************************************************" +
                "\n*   content: " + content +
                "\n*   created: " + created +
                "\n*   updated: " + updated +
                "\n*   status: " + postStatus +
                "\n*   labels: " + labelList +
                "\n* ********************************************************";

    }
}
