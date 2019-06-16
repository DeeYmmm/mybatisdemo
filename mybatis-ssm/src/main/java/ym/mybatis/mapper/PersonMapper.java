package ym.mybatis.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ym.mybatis.domain.Person;

import java.util.List;
import java.util.Map;

public interface PersonMapper {

    Person getPersonById(int id);

    List<Person> getPersons();

    boolean insertPerson(Person person);

    @MapKey("name")
    Map<String,Person> getPersonWithNameReturnMap(String name);

    Map<String,Object> getPersonByIdReturnMap(int id);

    List<Person> getPersonWithNameLike(String name);

    Person getPersonByMap(Map<String, Object> map);

    Person getPersonByIdAndName(@Param("id") int id, @Param("name") String name);
}
