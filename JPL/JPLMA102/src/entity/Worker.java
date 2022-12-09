package entity;

public class Worker extends Mission{
    private int id;
    private String name;

    public Worker() {}

    public Worker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Worker(int id, String name, String nameWorker, int id1, String name1) {
        super(id, name, nameWorker);
        this.id = id1;
        this.name = name1;
    }

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
}
