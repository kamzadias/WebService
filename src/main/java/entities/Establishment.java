package entities;

public class Establishment {
    private int id;
    private String name;
    private String country;
    private int rating;
    private String type;
    private String founder;
    private int desire_id;
    private Desire desire;

    public Establishment() {

    }
    public Establishment(int id,String name, String country, int rating, String type, String founder,int desire_id) {
        setName(name);
        setCountry(country);
        setRating(rating);
        setType(type);
        setFounder(founder);
        setDesire_id(desire_id);
    }
    public Establishment(String name, String country, int rating, String type, String founder,int desire_id) {
        setName(name);
        setCountry(country);
        setRating(rating);
        setType(type);
        setFounder(founder);
        setDesire_id(desire_id);
    }
    public Establishment(int id, String name, String country, int rating, String type, String founder,int desire_id, Desire desire) {
        this(name, country, rating, type ,founder ,desire_id);
        setId(id);
        setDesire(desire);
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public int getDesire_id() {
        return desire_id;
    }

    public void setDesire_id(int desire_id) {
        this.desire_id = desire_id;
    }

    public Desire getDesire() {
        return desire;
    }

    public void setDesire(Desire desire) {
        this.desire = desire;
    }

    @Override
    public String toString() {
        return "Establishment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", rating=" + rating +
                ", type='" + type + '\'' +
                ", founder='" + founder + '\'' +
                ", desire=" + desire +
                '}';
    }
}
