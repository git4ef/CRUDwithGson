package ef.CRUDwithGson.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Writer {
    private int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    private String firstName;
    private String lastName;
    private List<Post> postList;
    private PostStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public Writer(String firstName, String lastName, List<Post> postList) {
        this.id = count.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.postList = postList;
        this.status = PostStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", postList=" + postList +
                ", status=" + status +
                '}';
    }
}
