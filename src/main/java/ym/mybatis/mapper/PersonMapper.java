package ym.mybatis.mapper;

import ym.mybatis.domain.Person;

public interface PersonMapper {

    Person getPersonById(int id);

    boolean insertPerson(Person person);
}
