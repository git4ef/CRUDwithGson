package ef.CRUDwithGson.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Label {
    private int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    private String name;
    private PostStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostStatus getStatus() {
        return status;
    }

    public PostStatus setStatus(PostStatus status) {
        this.status = status;
        return status;
    }

    public Label(String name) {
        this.id = count.getAndIncrement();
        this.name = name;
        this.status = PostStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
