import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ym.mybatis.domain.Person;
import ym.mybatis.domain.PersonClass;
import ym.mybatis.mapper.PersonMapperDynamicSQL;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MybatisTest4 {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testDynamicSQL() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
            Person person=new Person();
            person.setName("%a%");
            System.out.println(person);
            List<Person> persons = mapper.getPersonsByConditionIf(person);
            System.out.println(persons);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
            Person person=new Person();
            person.setName("_棍");
            List<Person> persons = mapper.getPersonsByConditionTrim(person);
            System.out.println(persons);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
            Person person=new Person();
            person.setId(3);
            person.setName("%a%");
            List<Person> persons = mapper.getPersonsByConditionChoose(person);
            System.out.println(persons);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
            Person person=new Person();
            person.setId(40);
            person.setName("电坤");
            person.setSex("男");
            mapper.updatePerson(person);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
            List<Integer> list=new ArrayList<>(Arrays.asList(40,43,44));
            List<Person> persons = mapper.getPersonsByConditionForeach(list);
            System.out.println(persons);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test5() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
            List<Person> list=new ArrayList<>();
            list.add(new Person("ak","men",new PersonClass(1)));
            list.add(new Person("m4a1","women",new PersonClass(2)));
            mapper.addPersonsBatch(list);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
