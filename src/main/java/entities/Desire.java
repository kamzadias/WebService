package entities;

public class Desire {
    private int id;
    private String name;
    private String description;

    public Desire(){

    }
    public Desire(int id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }
    public Desire(String name, String description) {
        setName(name);
        setDescription(description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Desire{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
