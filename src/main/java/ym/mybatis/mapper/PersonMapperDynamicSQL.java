package ym.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import ym.mybatis.domain.Person;

import java.util.List;

public interface PersonMapperDynamicSQL {
    List<Person> getPersonsByConditionIf(Person person);

    List<Person> getPersonsByConditionTrim(Person person);

    List<Person> getPersonsByConditionChoose(Person person);

    void updatePerson(Person person);

    List<Person> getPersonsByConditionForeach(@Param("ids")List<Integer> ids);

    void addPersonsBatch(@Param("persons") List<Person> persons);
}
