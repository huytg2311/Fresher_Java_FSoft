package entity;

public class Mission {
    private int id;
    private String name;
    private String nameWorker;


    public Mission() {
    }

    public Mission(int id, String name, String nameWorker) {
        this.id = id;
        this.name = name;
        this.nameWorker = nameWorker;
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

    public String getNameWorker() {
        return nameWorker;
    }

    public void setNameWorker(String nameWorker) {
        this.nameWorker = nameWorker;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameWorker='" + nameWorker + '\'' +
                '}';
    }
}
