package ym.mybatis.mapper;

import ym.mybatis.domain.Person;

import java.util.List;

public interface PersonMapperPlus {

    Person getPersonAndClass(int id);
    Person getPersonByIdStep(int id);
    List<Person> getPersonByClassId(int classId);
}
