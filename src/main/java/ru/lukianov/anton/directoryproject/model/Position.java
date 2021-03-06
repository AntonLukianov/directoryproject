package ru.lukianov.anton.directoryproject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Должность работника
 */
@Entity
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Название
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Конструктор для hibernate
     */
    public Position() {

    }

    public Position(String name) {
        this.name = name;
    }

    public Short getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(id, position.id) &&
                Objects.equals(version, position.version) &&
                Objects.equals(name, position.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, version, name);
    }
}
