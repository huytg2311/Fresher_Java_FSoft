package entity;

public class Manager extends Mission{
    private int id;
    private static String name = "Truong Gia Huy";

    public Manager() {
    }

    public Manager(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Manager(int id, String nameWorker, int id1, String name1) {
        super(id, name, nameWorker);
        this.id = id1;
        this.name = name1;
    }

    public Manager(int id, String name, String nameWorker, int id1, String name1) {
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
