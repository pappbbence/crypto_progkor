package hu.nye.progkor.crypto.model;

import java.util.Objects;

public class Crypto {


    private Long id;
    private String name;
    private String shortName;
    private int value;

    public Crypto() {

    }

    public Crypto(Long id, String name, String shortName, int value) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crypto crypto = (Crypto) o;
        return value == crypto.value && Objects.equals(id, crypto.id) && Objects.equals(name, crypto.name) && Objects.equals(shortName, crypto.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName, value);
    }

    @Override
    public String toString() {
        return "Crypto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", value=" + value +
                '}';
    }
}
