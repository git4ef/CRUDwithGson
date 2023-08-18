package ef.CRUDwithGson.model;

import java.util.List;

public class Writer {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Post> postList;
    private Status status;

    public int getId() {
        return id = this.id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Writer(String firstName, String lastName, List<Post> postList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postList = postList;
        this.status = Status.NOT_DELETED;
    }

    public Writer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return ("\n* ********************************************************" +
                "\n*                          Writer" +
                "\n*                     ID: " + id +
                "\n*                     FIRSTNAME: " + firstName +
                "\n*                     LASTNAME: " + lastName +
                "\n*                     STATUS: " + status + ".") +
                "\n*                     " + postList;
    }
}
