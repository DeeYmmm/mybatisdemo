package ym.mybatis.domain;

import java.util.List;

public class PersonClass {

    private int id;
    private String name;
    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
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

    @Override
    public String toString() {
        return "PersonClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
