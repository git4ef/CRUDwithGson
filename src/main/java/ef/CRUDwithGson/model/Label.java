package ef.CRUDwithGson.model;

public class Label {
    private int id;
    private String name;
    private Status status;

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

    public Status getStatus() {
        return status;
    }

    public Status setStatus(Status status) {
        this.status = status;
        return status;
    }

    public Label(String name) {
        this.name = name;
        this.status = Status.NOT_DELETED;
    }
    public Label(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = Status.NOT_DELETED;
    }

    @Override
    public String toString() {
        return "\n*            id: " + id +
                ", name: " + name +
                ", status: " + status;
    }
}
