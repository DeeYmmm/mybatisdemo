package ym.mybatis.domain;

import java.io.Serializable;

public class Person implements Serializable {

    private int id;
    private String name;
    private String sex;
    private PersonClass personClass;

    public Person() {
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Person(String name, String sex, PersonClass personClass) {
        this.name = name;
        this.sex = sex;
        this.personClass = personClass;
    }

    public PersonClass getPersonClass() {
        return personClass;
    }

    public void setPersonClass(PersonClass personClass) {
        this.personClass = personClass;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
