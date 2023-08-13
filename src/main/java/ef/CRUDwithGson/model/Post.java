package ef.CRUDwithGson.model;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Post {
    private int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labelList;
    private PostStatus status;

    public Post(String content, List <Label> labelList) {
        this.id = count.incrementAndGet();
        this.content = content;
        this.created = new Date();
        this.updated = updated;
        this.labelList = labelList;
        this.status = PostStatus.ACTIVE;
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
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", labelList=" + labelList +
                ", status=" + status +
                '}';
    }
}
