package ym.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ym.mybatis.domain.Person;
import ym.mybatis.service.PersonService;

import java.util.List;
import java.util.Map;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/persons")
    public String getPersons(Map<String ,Object> map){
        List<Person> persons = personService.getPersons();
        map.put("persons",persons);
        return "list";
    }

}
