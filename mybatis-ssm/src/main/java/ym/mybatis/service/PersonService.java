package ym.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ym.mybatis.domain.Person;
import ym.mybatis.mapper.PersonMapper;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public List<Person> getPersons(){
        return personMapper.getPersons();
    }
}
