package by.bstu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "WSREF")
public class WSRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "description")
    private String description;

    @Column(name = "minus")
    private Integer minus = 0;

    @Column(name = "plus")
    private Integer plus = 0;

    public WSRef() {
    }

    public WSRef(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public WSRef(String url, String description, Integer minus, Integer plus) {
        this.url = url;
        this.description = description;
        this.minus = minus;
        this.plus = plus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMinus() {
        return minus;
    }

    public void setMinus(Integer minus) {
        this.minus = minus;
    }

    public Integer getPlus() {
        return plus;
    }

    public void setPlus(Integer plus) {
        this.plus = plus;
    }

    @Override
    public String toString() {
        return "WSRef{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", minus=" + minus +
                ", plus=" + plus +
                '}';
    }
}

